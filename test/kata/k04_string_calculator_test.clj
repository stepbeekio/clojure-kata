(ns kata.k04-string-calculator-test
  (:require [clojure.test :refer [deftest is testing]]
            [kata.k04-string-calculator :refer [add]]))

(deftest step-1-basics
  (is (= 0 (add "")))
  (is (= 1 (add "1")))
  (is (= 3 (add "1,2"))))

(deftest step-2-many-numbers
  (is (= 10 (add "1,2,3,4")))
  (is (= 55 (add "1,2,3,4,5,6,7,8,9,10"))))

(deftest step-3-newlines
  (is (= 6 (add "1\n2,3"))))

(deftest step-4-custom-delimiter
  (is (= 3 (add "//;\n1;2")))
  (is (= 6 (add "//.\n1.2.3")) "regex metacharacters must be handled"))

(deftest step-5-negatives
  (let [e (try (add "1,-1,2,-3") nil
               (catch clojure.lang.ExceptionInfo e e))]
    (is (some? e) "should throw ex-info")
    (is (= "negatives not allowed: -1, -3" (ex-message e)))
    (is (= [-1 -3] (:negatives (ex-data e))))))

(deftest step-6-ignore-big-numbers
  (is (= 2 (add "2,1001")))
  (is (= 1002 (add "2,1000"))))

(deftest step-7-long-delimiters
  (is (= 6 (add "//[***]\n1***2***3")))
  (is (= 6 (add "//[ab]\n1ab2ab3"))))
