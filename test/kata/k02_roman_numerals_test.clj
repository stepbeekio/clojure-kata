(ns kata.k02-roman-numerals-test
  (:require [clojure.test :refer [deftest is are testing]]
            [kata.k02-roman-numerals :refer [->roman roman->int]]))

(def examples
  {1 "I", 2 "II", 3 "III", 4 "IV", 5 "V", 6 "VI", 9 "IX",
   14 "XIV", 40 "XL", 49 "XLIX", 90 "XC", 400 "CD", 900 "CM",
   1666 "MDCLXVI", 1990 "MCMXC", 2024 "MMXXIV", 3999 "MMMCMXCIX"})

(deftest to-roman-test
  (doseq [[n roman] examples]
    (is (= roman (->roman n)) (str n " -> " roman))))

(deftest from-roman-test
  (doseq [[n roman] examples]
    (is (= n (roman->int roman)) (str roman " -> " n))))

(deftest round-trip-test
  (testing "every number from 1 to 3999 survives a round trip"
    (is (every? #(= % (roman->int (->roman %))) (range 1 4000)))))
