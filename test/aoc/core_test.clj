(ns aoc.core-test
  (:require [clojure.test :refer :all]
            [aoc.core :refer :all]))

(deftest task-1-1-test
  (testing "Day 1 (task 1)"
    (is (= 484 (task-1-1 "resources/1-1.txt")))))

(deftest task-1-2-test
  (testing "Day 1 (task 2)"
    (is (= 367 (task-1-2 "resources/1-1.txt")))))
