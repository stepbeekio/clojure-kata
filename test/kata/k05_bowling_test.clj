(ns kata.k05-bowling-test
  (:require [clojure.test :refer [deftest is testing]]
            [kata.k05-bowling :refer [score]]))

(deftest gutter-game
  (is (= 0 (score (repeat 20 0)))))

(deftest all-ones
  (is (= 20 (score (repeat 20 1)))))

(deftest one-spare
  (is (= 16 (score (concat [5 5 3] (repeat 17 0))))))

(deftest one-strike
  (is (= 24 (score (concat [10 3 4] (repeat 16 0))))))

(deftest spare-in-last-frame
  (is (= 17 (score (concat (repeat 18 0) [3 7 7])))))

(deftest strike-in-last-frame
  (is (= 30 (score (concat (repeat 18 0) [10 10 10])))))

(deftest perfect-game
  (is (= 300 (score (repeat 12 10)))))

(deftest all-spares
  (is (= 150 (score (repeat 21 5)))))

(deftest realistic-game
  (is (= 133 (score [1 4 4 5 6 4 5 5 10 0 1 7 3 6 4 10 2 8 6]))))
