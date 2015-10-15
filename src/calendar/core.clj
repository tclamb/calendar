(ns calendar.core
  (:gen-class)
  (:require [clojure.string :as str])
  (:import java.time.LocalDate))

(defn- first-day-of-year
  "Returns the first day of a year."
  [year]
  (LocalDate/of year 1 1))

(defn- year
  "Returns all the days of a year as a lazy range of `LocalDate's. Returns the days of the current year when no year is provided."
  ([] (year (.getYear (LocalDate/now))))
  ([year]
   (->> (first-day-of-year year)
        (iterate #(.plusDays % 1))
        (take-while #(= year (.getYear %))))))

(defn- day-of-week [day]
  (-> day
      .getDayOfWeek
      .getValue
      (mod 7)))

(defn- week-of-year
  "Returns the week of the year into which a day falls. Weeks begin on Sunday."
  [date]
  (let [offset (-> date
                   .getYear
                   first-day-of-year
                   day-of-week)]
    (-> date
        .getDayOfYear
        (+ offset -1)
        (quot 7))))

(defn- ansi-aware-count
  "String length, sans ANSI control codes"
  [s]
  (count (str/replace s #"\033\[[0-9]+m" "")))

(defn- center
  "Center-pads a length of text, e.g. (center 5 \"a\") ; => \"  a  \"."
  [n s]
  (let [s (str s)
        c (- n (ansi-aware-count s))
        h (quot c 2)
        r (rem c 2)]
    (apply str (concat
                 (repeat (+ h r) \space)
                 [s]
                 (repeat h \space)))))

(defn- transpose [cs]
  (let [n (count cs)]
    (partition n (apply interleave cs))))

(defn- format-day
  [day]
  (format (if (= day (LocalDate/now))
            "\033[91m\033[1m%3d\033[0m" ; bold, bright red
            "%3d")
          (.getDayOfMonth day)))

(defn- pad-right [n s]
  (let [n (- n (ansi-aware-count s))]
    (apply str s (repeat n \space))))

(defn- format-week
  [week]
  (let [offset (day-of-week (first week))
        padding (repeat (* offset 3) \space)]
    (->> week
         (map format-day)
         (concat padding)
         (apply str)
         (pad-right 22))))

(defn- format-line
  [line]
  (->> line
       (interpose \space)
       (apply str)))

(def ^:const ^:private days-of-week-line
  (->> [\S \M \T \W \R \F \S]
       (map (partial str "  "))
       (apply str)
       (pad-right 22)))

(defn- format-month
  [month]
  (let [weeks (partition-by week-of-year month)]
    (concat [(center 22 (.getMonth (first month)))
             days-of-week-line]
            (map format-week weeks)
            (repeat (- 6 (count weeks)) (apply str (repeat 22 \space))))))

(defn -main
  "Prints out a calendar for the current year."
  [& args]
  (->> (year)
       (partition-by #(.getMonth %))
       (map format-month)
       (partition 3)
       (mapcat transpose)
       (map format-line)
       (map println)
       dorun))
