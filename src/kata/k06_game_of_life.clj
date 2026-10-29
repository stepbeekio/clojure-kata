(ns kata.k06-game-of-life
  "KATA 6 — Conway's Game of Life (sets as data)

  Represent the board as a SET of live cells, each cell an [x y] vector.
  The board is infinite — no edges.

  Part A: `neighbours` returns the 8 cells surrounding a cell, as a set.

  Part B: `step` takes a set of live cells and returns the next generation:
    - A live cell with 2 or 3 live neighbours survives.
    - A dead cell with exactly 3 live neighbours becomes alive.
    - Every other cell dies or stays dead.

  Part C: `parse` and `render` convert between the set representation and
  a vector of strings, where \"#\" is alive and \".\" is dead, row 0 at the
  top and x increasing to the right. `render` takes the board plus a
  width and height and draws the region from [0 0] to [(dec w) (dec h)].

  Things to try:
    - Christophe Grand's famous version uses `frequencies` + `mapcat`
      and fits in about 5 lines. Try it once your first version works!
    - `iterate` gives you an infinite lazy sequence of generations.")

(defn neighbours [[x y]]
  (throw (ex-info "Not implemented yet" {:kata :game-of-life})))

(defn step [cells]
  (throw (ex-info "Not implemented yet" {:kata :game-of-life})))

(defn parse [rows]
  (throw (ex-info "Not implemented yet" {:kata :game-of-life})))

(defn render [cells width height]
  (throw (ex-info "Not implemented yet" {:kata :game-of-life})))
