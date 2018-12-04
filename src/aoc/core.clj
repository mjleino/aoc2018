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

(defn has-exact-match [number collection]
  (some true? (map (partial = number) collection)))

(defn find-twos-threes [label]
  (let [freqs (vals (frequencies label))]
    [(has-exact-match 2 freqs)
     (has-exact-match 3 freqs)]))

(defn inc-if-true [n condition]
  (if condition (inc n) n))

(defn sum-twos-threes [[sum-twos sum-threes] [has-twos has-threes]]
  [(inc-if-true sum-twos has-twos)
   (inc-if-true sum-threes has-threes)])

(defn task-2-1 [filename]
  (reduce * (reduce
             sum-twos-threes
             [0 0]
             (map find-twos-threes (read-lines filename)))))

(defn -main []
  ; (println "Day 1 (task 1):" (task-1-1 "resources/1-1.txt"))
  ; (println "Day 1 (task 2):" (task-1-2 "resources/1-1.txt"))
  (println "Day 2 (task 1):" (task-2-1 "resources/2-1.txt")))

