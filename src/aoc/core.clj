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

(defn read-lines [filename]
  (with-open [rdr (clojure.java.io/reader filename)]
    (doall (line-seq rdr))))

(defn count-twos-threes [label]
  (let [freqs (vals (frequencies label))]
    [(some true? (map #(= 2 %) freqs)) (some true? (map #(= 3 %) freqs))]))

(defn sum-twos-threes [[total-twos total-threes] [twos threes]]
  [(+ total-twos (if twos 1 0)) (+ total-threes (if threes 1 0))])

(defn task-2-1 [filename]
  (reduce sum-twos-threes [0 0] (map count-twos-threes (read-lines filename))))

(defn -main []
  ; (println "Day 1 (task 1):" (task-1-1 "resources/1-1.txt"))
  ; (println "Day 1 (task 2):" (task-1-2 "resources/1-1.txt"))
  (println "Day 2 (task 1):" (task-2-1 "resources/2-1.txt")))

