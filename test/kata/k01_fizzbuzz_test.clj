(ns kata.k01-fizzbuzz-test
  (:require [clojure.test :refer [deftest is testing]]
            [kata.k01-fizzbuzz :refer [fizzbuzz fizzbuzz-seq]]))

(deftest fizzbuzz-test
  (testing "plain numbers"
    (is (= "1" (fizzbuzz 1)))
    (is (= "2" (fizzbuzz 2)))
    (is (= "7" (fizzbuzz 7))))
  (testing "multiples of 3"
    (is (= "Fizz" (fizzbuzz 3)))
    (is (= "Fizz" (fizzbuzz 9))))
  (testing "multiples of 5"
    (is (= "Buzz" (fizzbuzz 5)))
    (is (= "Buzz" (fizzbuzz 20))))
  (testing "multiples of 15"
    (is (= "FizzBuzz" (fizzbuzz 15)))
    (is (= "FizzBuzz" (fizzbuzz 45)))))

(deftest fizzbuzz-seq-test
  (is (= ["1" "2" "Fizz" "4" "Buzz" "Fizz" "7" "8" "Fizz" "Buzz"
          "11" "Fizz" "13" "14" "FizzBuzz"]
         (fizzbuzz-seq 15)))
  (is (empty? (fizzbuzz-seq 0))))
