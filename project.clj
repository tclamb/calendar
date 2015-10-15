(defproject calendar "0.1.0-SNAPSHOT"
  :description "A quick and derivative console calendar"
  :url "http://www.github.com/tclamb/calendar"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main ^:skip-aot calendar.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
