(ns kata.k04-string-calculator
  "KATA 4 — String Calculator (Roy Osherove's classic)

  Write `add`, which takes a string of numbers and returns their sum.
  Work through the steps in order — only read the next step once the
  current tests pass!

    1. \"\" => 0, \"1\" => 1, \"1,2\" => 3
    2. Any amount of numbers: \"1,2,3,4\" => 10
    3. Newlines are also separators: \"1\\n2,3\" => 6
    4. Custom delimiter on a first line of the form \"//<delim>\\n\":
         \"//;\\n1;2\" => 3
    5. Negative numbers throw an ex-info whose message is
         \"negatives not allowed: -1, -3\" (listing all negatives),
       and whose ex-data contains {:negatives [-1 -3]}.
    6. Numbers greater than 1000 are ignored: \"2,1001\" => 2
    7. Delimiters of any length: \"//[***]\\n1***2***3\" => 6

  Things to try:
    - `java.util.regex.Pattern/quote` for safely using user delimiters
    - `parse-long` (Clojure 1.11+)")

(defn add [s]
  (throw (ex-info "Not implemented yet" {:kata :string-calculator})))
