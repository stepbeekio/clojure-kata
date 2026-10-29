(ns kata.k03-word-count
  "KATA 3 — Word Count & Anagrams (sequences and maps)

  Part A: `word-count` takes a string and returns a map of lower-cased
  word -> number of occurrences. Words are runs of letters, digits or
  apostrophes inside a word (e.g. \"don't\"). Ignore all other punctuation.

    (word-count \"One fish, two fish!\")
    ;=> {\"one\" 1, \"fish\" 2, \"two\" 1}

  Part B: `anagrams-of` takes a word and a collection of candidates and
  returns the candidates that are anagrams of the word (case-insensitive),
  preserving their original order. A word is not an anagram of itself.

  Part C: `group-anagrams` takes a collection of words and returns a set
  of sets, each containing words that are anagrams of one another.

  Things to try:
    - `re-seq`, `frequencies`, `group-by`, `clojure.string/lower-case`
    - Can each part be a one-liner pipeline with `->>`?")

(defn word-count [s]
  (clojure.string/re-match)
  (throw (ex-info "Not implemented yet" {:kata :word-count})))

(defn anagrams-of [word candidates]
  (throw (ex-info "Not implemented yet" {:kata :word-count})))

(defn group-anagrams [words]
  (throw (ex-info "Not implemented yet" {:kata :word-count})))
