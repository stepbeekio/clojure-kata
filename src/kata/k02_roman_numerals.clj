(ns kata.k02-roman-numerals
  "KATA 2 — Roman Numerals

  Write `->roman`, converting a positive integer (1–3999) to a Roman
  numeral string, and `roman->int`, converting back.

    I = 1   V = 5   X = 10   L = 50   C = 100   D = 500   M = 1000

  Subtractive forms: IV = 4, IX = 9, XL = 40, XC = 90, CD = 400, CM = 900.

  Things to try:
    - A sorted table of [value symbol] pairs and `reduce` / `loop`
    - For `roman->int`: `partition` pairs of chars and compare neighbours
    - Property check: (= n (roman->int (->roman n))) for all 1..3999"
  (:require [clojure.string :as str]))

(def lookup-table [[1000 "M"]
                   [900 "CM"]
                   [500 "D"]
                   [400 "CD"]
                   [100 "C"]
                   [90 "XC"]
                   [50 "L"]
                   [40 "XL"]
                   [10 "X"]
                   [9 "IX"]
                   [5 "V"]
                   [4 "IV"]
                   [1 "I"]])

(defn ->roman [n]
  (loop [remaining n answer ""]
    (if (zero? remaining)
      answer
      (let [[value numeral] (first (filter (fn [[numeral _]] (>= remaining numeral)) lookup-table))]
        (recur (- remaining value) (str answer numeral))))))

(defn roman->int [s]
  (loop [remaining s answer 0]
    (if (str/blank? remaining)
      answer
      (let [[value numeral] (first (filter (fn [[_ numeral]] (str/starts-with? remaining numeral)) lookup-table))]
        (recur (str/replace-first remaining numeral "") (+ answer value))))))

(comment
  (->roman 1)
  (->roman 998)
  (roman->int "CMLXXIV"))

