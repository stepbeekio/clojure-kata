(ns kata.k06-game-of-life-test
  (:require [clojure.test :refer [deftest is testing]]
            [kata.k06-game-of-life :refer [neighbours step parse render]]))

(deftest neighbours-test
  (is (= #{[0 0] [1 0] [2 0]
           [0 1]       [2 1]
           [0 2] [1 2] [2 2]}
         (neighbours [1 1])))
  (is (= 8 (count (neighbours [-5 100])))))

(deftest step-test
  (testing "empty board stays empty"
    (is (= #{} (step #{}))))
  (testing "a lone cell dies"
    (is (= #{} (step #{[0 0]}))))
  (testing "a block is stable"
    (let [block #{[0 0] [1 0] [0 1] [1 1]}]
      (is (= block (step block)))))
  (testing "a blinker oscillates"
    (let [horizontal #{[0 1] [1 1] [2 1]}
          vertical   #{[1 0] [1 1] [1 2]}]
      (is (= vertical (step horizontal)))
      (is (= horizontal (step vertical))))))

(deftest parse-test
  (is (= #{[1 0] [0 1] [2 2]}
         (parse [".#."
                 "#.."
                 "..#"]))))

(deftest render-test
  (is (= ["...."
          ".##."
          "...."]
         (render #{[1 1] [2 1]} 4 3))))

(deftest glider-test
  (testing "a glider moves one cell diagonally every 4 generations"
    (let [glider (parse [".#."
                         "..#"
                         "###"])
          moved  (set (map (fn [[x y]] [(inc x) (inc y)]) glider))]
      (is (= moved (nth (iterate step glider) 4))))))
