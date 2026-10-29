(ns user
  "Loaded automatically when a REPL starts with the :dev alias.

    (portal)                  ; open Portal and send every `tap>` to it
    (tap> x)                  ; inspect any value in Portal
    (clear)                   ; clear Portal
    (flowstorm)               ; open the FlowStorm debugger (or type :dbg in a plain REPL)
    (run-kata 1)              ; run the tests for kata 1 (reloading code)
    (run-all)                 ; run every kata's tests"
  (:require [clojure.java.io :as io]
            [clojure.test :as t]
            [portal.api :as p]))

(defn portal []
  (let [instance (p/open)]
    (add-tap #'p/submit)
    instance))

(defn clear [] (p/clear))

(defn flowstorm []
  ((requiring-resolve 'flow-storm.storm-api/start-debugger)))

(defn- test-namespaces []
  (->> (file-seq (io/file "test/kata"))
       (map #(.getName %))
       (keep #(re-matches #"(k\d+_.*_test)\.clj" %))
       (map #(symbol (str "kata." (.replace ^String (second %) "_" "-"))))
       sort))

(defn run-kata [n]
  (let [prefix (format "kata.k%02d-" n)
        test-ns (first (filter #(.startsWith (str %) prefix) (test-namespaces)))]
    (require test-ns :reload-all)
    (t/run-tests test-ns)))

(defn run-all []
  (let [nses (test-namespaces)]
    (run! #(require % :reload-all) nses)
    (apply t/run-tests nses)))

(comment (portal))
(comment (flowstorm))


