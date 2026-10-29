(ns kata.k03-word-count-test
  (:require [clojure.test :refer [deftest is testing]]
            [kata.k03-word-count :refer [word-count anagrams-of group-anagrams]]))

(deftest word-count-test
  (testing "simple sentence"
    (is (= {"one" 1 "fish" 2 "two" 1}
           (word-count "One fish, two fish!"))))
  (testing "case is ignored"
    (is (= {"go" 3} (word-count "go Go GO"))))
  (testing "apostrophes inside words are kept"
    (is (= {"don't" 2 "stop" 1}
           (word-count "Don't stop, don't."))))
  (testing "numbers count as words"
    (is (= {"1" 1 "2" 1 "testing" 1}
           (word-count "testing, 1, 2"))))
  (testing "empty string"
    (is (= {} (word-count "")))))
;;
;; (deftest anagrams-of-test
;;   (is (= ["inlets"]
;;          (anagrams-of "listen" ["enlists" "google" "inlets" "banana"])))
;;   (testing "case-insensitive and order preserving"
;;     (is (= ["Carthorse" "Horsecart"]
;;            (anagrams-of "Orchestra" ["cashregister" "Carthorse" "radishes" "Horsecart"]))))
;;   (testing "a word is not its own anagram"
;;     (is (= [] (vec (anagrams-of "banana" ["Banana" "banana"]))))))
;;
;; (deftest group-anagrams-test
;;   (is (= #{#{"eat" "tea" "ate"} #{"tan" "nat"} #{"bat"}}
;;          (group-anagrams ["eat" "tea" "tan" "ate" "nat" "bat"]))))
