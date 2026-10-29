(ns kata.k07-bank-account
  "KATA 7 — Bank Account (state, atoms and event sourcing)

  Model a bank account as an immutable value built from a list of events.

  Part A — pure functions:
    `apply-event` takes an account map and an event, returning a new
    account. Accounts look like {:balance 0 :history []}. Events are maps:
      {:type :deposit    :amount 100}
      {:type :withdrawal :amount 30}
    Every applied event is appended to :history.
    A withdrawal larger than the balance throws an ex-info with
    ex-data {:error :insufficient-funds :balance <current balance>}.
    Non-positive amounts throw ex-info with {:error :invalid-amount}.

    `replay` takes a sequence of events and builds the account from
    `empty-account` (hint: `reduce`).

  Part B — mutable reference:
    `make-account!` returns an atom holding `empty-account`.
    `deposit!` and `withdraw!` take the atom and an amount, update it
    via `apply-event`, and return the new balance. A failed withdrawal
    must leave the atom unchanged.

  Part C — `statement` returns a vector of strings, one per event,
  showing a running balance:
    [\"deposit 100 => 100\" \"withdrawal 30 => 70\"]

  Things to try:
    - `swap!` retries — why does that mean `apply-event` must be pure?
    - Multimethods dispatching on :type, for adding new event types.")

(def empty-account {:balance 0 :history []})

(defn apply-event [account event]
  (throw (ex-info "Not implemented yet" {:kata :bank-account})))

(defn replay [events]
  (throw (ex-info "Not implemented yet" {:kata :bank-account})))

(defn make-account! []
  (throw (ex-info "Not implemented yet" {:kata :bank-account})))

(defn deposit! [account-atom amount]
  (throw (ex-info "Not implemented yet" {:kata :bank-account})))

(defn withdraw! [account-atom amount]
  (throw (ex-info "Not implemented yet" {:kata :bank-account})))

(defn statement [account]
  (throw (ex-info "Not implemented yet" {:kata :bank-account})))
