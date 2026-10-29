(ns kata.k07-bank-account-test
  (:require [clojure.test :refer [deftest is testing]]
            [kata.k07-bank-account :as bank]))

(defn- error-of [f]
  (try (f) nil
       (catch clojure.lang.ExceptionInfo e (ex-data e))))

(deftest apply-event-test
  (testing "deposit"
    (let [acc (bank/apply-event bank/empty-account {:type :deposit :amount 100})]
      (is (= 100 (:balance acc)))
      (is (= [{:type :deposit :amount 100}] (:history acc)))))
  (testing "withdrawal"
    (let [acc (-> bank/empty-account
                  (bank/apply-event {:type :deposit :amount 100})
                  (bank/apply-event {:type :withdrawal :amount 30}))]
      (is (= 70 (:balance acc)))
      (is (= 2 (count (:history acc))))))
  (testing "insufficient funds"
    (is (= {:error :insufficient-funds :balance 0}
           (error-of #(bank/apply-event bank/empty-account
                                        {:type :withdrawal :amount 1})))))
  (testing "invalid amounts"
    (is (= :invalid-amount
           (:error (error-of #(bank/apply-event bank/empty-account
                                                {:type :deposit :amount 0})))))
    (is (= :invalid-amount
           (:error (error-of #(bank/apply-event bank/empty-account
                                                {:type :deposit :amount -5})))))))

(deftest replay-test
  (is (= bank/empty-account (bank/replay [])))
  (is (= 125 (:balance (bank/replay [{:type :deposit :amount 100}
                                     {:type :withdrawal :amount 25}
                                     {:type :deposit :amount 50}])))))

(deftest atom-test
  (let [acc (bank/make-account!)]
    (is (= 100 (bank/deposit! acc 100)))
    (is (= 60 (bank/withdraw! acc 40)))
    (testing "failed withdrawal leaves the account unchanged"
      (let [before @acc]
        (is (some? (error-of #(bank/withdraw! acc 1000))))
        (is (= before @acc))))))

(deftest concurrency-test
  (testing "concurrent deposits are not lost"
    (let [acc (bank/make-account!)]
      (dorun (pmap (fn [_] (bank/deposit! acc 1)) (range 1000)))
      (is (= 1000 (:balance @acc))))))

(deftest statement-test
  (is (= ["deposit 100 => 100" "withdrawal 30 => 70" "deposit 5 => 75"]
         (bank/statement (bank/replay [{:type :deposit :amount 100}
                                       {:type :withdrawal :amount 30}
                                       {:type :deposit :amount 5}])))))
