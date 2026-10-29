(ns kata.k01-fizzbuzz
  "KATA 1 — FizzBuzz (warm-up)

  Write `fizzbuzz`, which takes a positive integer n and returns:
    - \"FizzBuzz\" if n is divisible by both 3 and 5
  - \"Fizz\"     if n is divisible by 3
    - \"Buzz\"     if n is divisible by 5
    - the number as a string otherwise

  Then write `fizzbuzz-seq`, which returns a sequence of the results
  for 1..n inclusive.

  Things to try:
    - `cond` vs `condp` vs `case` on a vector of remainders
    - Can you make `fizzbuzz-seq` lazy and work for any n?")

;; (defn fizzbuzz [n]
;;   (cond
;;     (= 0 (mod n 15)) "FizzBuzz"
;;     (= 0 (mod n 3)) "Fizz"
;;     (= 0 (mod n 5)) "Buzz"
;;     :else (str n)))

;; (defn fizzbuzz [n]
;;   (condp #(zero? (mod %2 %1)) n
;;     15 "FizzBuzz"
;;     5 "Buzz"
;;     3 "Fizz"
;;     (str n)))

(def rules [[3 "Fizz"] [5 "Buzz"] [7 "Fazz"]])

(defn fizzbuzz [n]
  (or (not-empty (apply str (for [[d s] rules :when (zero? (mod n d))] s)))
      (str n)))

(comment (fizzbuzz 105))

(defn fizzbuzz-seq [n]
  (->> (+ 1 n)
       (range 1)
       (map #(fizzbuzz %))))

(tap> (fizzbuzz-seq 20))

