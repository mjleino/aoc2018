(defproject aoc2018 "0.1.0-SNAPSHOT"
  :description "Advent of Code 2018"
  :dependencies [
    [org.clojure/clojure "1.9.0"]
  ]
  :plugins [
    [jonase/eastwood "0.3.3"]
    [lein-auto "0.1.3"]
    [lein-cljfmt "0.6.2"]
    [lein-kibit "0.1.6"]
  ]
  :main ^:skip-aot aoc.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
