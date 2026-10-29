(ns kata.k05-bowling
  "KATA 5 — Bowling Game (recursion / destructuring)

  Write `score`, which takes a sequence of rolls (pins knocked down per
  ball) for one complete game of ten-pin bowling and returns the total.

  Rules:
    - A game has 10 frames. Each frame normally has two rolls.
    - Open frame: score is the pins knocked down in the two rolls.
    - Spare (all 10 pins in two rolls): 10 + the next roll.
    - Strike (all 10 pins on the first roll — the frame ends):
      10 + the next two rolls.
    - In the 10th frame, a spare earns one bonus roll and a strike two.
      Those bonus rolls only count towards the 10th frame's bonus.

  Things to try:
    - `loop`/`recur` over frames with sequential destructuring:
        (let [[a b c & more] rolls] ...)
    - Alternatively, write `frames` that splits rolls into frames first,
      then sum them.")

(defn score [rolls]
  (throw (ex-info "Not implemented yet" {:kata :bowling})))
