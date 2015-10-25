# calendar

A quick and derivative console calendar written in Clojure,  
Inspired by Eric Niebler's CppCon 2015 talk, ["Ranges for the Standard Library"](https://www.youtube.com/watch?v=mFUXNMfaciE),  
Which was inspired by the D Programming Language community wiki's page, _[Component programming with ranges](http://wiki.dlang.org/Component_programming_with_ranges#Case_Study:_Formatting_a_Calendar)_.

## Example Output

```
$ lein run
        JANUARY               FEBRUARY                 MARCH
  S  M  T  W  R  F  S    S  M  T  W  R  F  S    S  M  T  W  R  F  S
              1  2  3    1  2  3  4  5  6  7    1  2  3  4  5  6  7
  4  5  6  7  8  9 10    8  9 10 11 12 13 14    8  9 10 11 12 13 14
 11 12 13 14 15 16 17   15 16 17 18 19 20 21   15 16 17 18 19 20 21
 18 19 20 21 22 23 24   22 23 24 25 26 27 28   22 23 24 25 26 27 28
 25 26 27 28 29 30 31                          29 30 31

         APRIL                   MAY                   JUNE
  S  M  T  W  R  F  S    S  M  T  W  R  F  S    S  M  T  W  R  F  S
           1  2  3  4                   1  2       1  2  3  4  5  6
  5  6  7  8  9 10 11    3  4  5  6  7  8  9    7  8  9 10 11 12 13
 12 13 14 15 16 17 18   10 11 12 13 14 15 16   14 15 16 17 18 19 20
 19 20 21 22 23 24 25   17 18 19 20 21 22 23   21 22 23 24 25 26 27
 26 27 28 29 30         24 25 26 27 28 29 30   28 29 30
                        31
         JULY                  AUGUST                SEPTEMBER
  S  M  T  W  R  F  S    S  M  T  W  R  F  S    S  M  T  W  R  F  S
           1  2  3  4                      1          1  2  3  4  5
  5  6  7  8  9 10 11    2  3  4  5  6  7  8    6  7  8  9 10 11 12
 12 13 14 15 16 17 18    9 10 11 12 13 14 15   13 14 15 16 17 18 19
 19 20 21 22 23 24 25   16 17 18 19 20 21 22   20 21 22 23 24 25 26
 26 27 28 29 30 31      23 24 25 26 27 28 29   27 28 29 30
                        30 31
        OCTOBER               NOVEMBER               DECEMBER
  S  M  T  W  R  F  S    S  M  T  W  R  F  S    S  M  T  W  R  F  S
              1  2  3    1  2  3  4  5  6  7          1  2  3  4  5
  4  5  6  7  8  9 10    8  9 10 11 12 13 14    6  7  8  9 10 11 12
 11 12 13 14 15 16 17   15 16 17 18 19 20 21   13 14 15 16 17 18 19
 18 19 20 21 22 23 24   22 23 24 25 26 27 28   20 21 22 23 24 25 26
 25 26 27 28 29 30 31   29 30                  27 28 29 30 31
```

## License

Copyright © 2015 Thomas Lamb

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
