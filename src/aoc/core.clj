(ns aoc.core
  (:gen-class))

(defn parse-int [n] (Integer/parseInt n))

(defn read-numbers [filename]
  (with-open [rdr (clojure.java.io/reader filename)]
    (doall (map parse-int (line-seq rdr)))))

(defn task-1-1 [filename]
  (reduce + (read-numbers filename)))

(defn add-and-keep-track [[encountered-frequencies last-frequency] change]
  (let [new-frequency (+ last-frequency change)]
    (if (contains? encountered-frequencies new-frequency)
      (reduced new-frequency)
      [(conj encountered-frequencies new-frequency) new-frequency])))

(defn task-1-2 [filename]
  (reduce
   add-and-keep-track
   [(sorted-set 0), 0]
   (cycle (read-numbers filename))))

(defn -main []
  (println "Day 1 (task 1):" (task-1-1 "resources/1-1.txt"))
  (println "Day 1 (task 2):" (task-1-2 "resources/1-1.txt")))

