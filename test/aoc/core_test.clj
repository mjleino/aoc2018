(ns aoc.core-test
  (:require [clojure.test :refer :all]
            [aoc.core :refer :all]))

(deftest task-1-1-test
  (testing "Day 1 (task 1)"
    (is (= 484 (task-1-1 "resources/1-1.txt")))))

(deftest task-1-2-test
  (testing "Day 1 (task 2)"
    (is (= 367 (task-1-2 "resources/1-1.txt")))))

(deftest task-2-1-test
  (testing "Day 1 (task 1)"
    (is (= 5750 (task-2-1 "resources/2-1.txt")))))

(deftest task-2-2-test
  (testing "Day 1 (task 2)"
    (is (= "tzyvunogzariwkpcbdewmjhxi" (task-2-2 "resources/2-1.txt")))))

