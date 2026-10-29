# Clojure Kata

Seven katas, roughly in order of difficulty. Each one has a source file in
`src/kata/` with the problem in its namespace docstring and stub functions
that throw "Not implemented yet", plus a test file in `test/kata/`.
Make the tests pass.

| # | Kata | Practises |
|---|------|-----------|
| 1 | FizzBuzz | `cond`, lazy sequences |
| 2 | Roman Numerals | `reduce`, `loop`/`recur`, lookup tables |
| 3 | Word Count & Anagrams | `re-seq`, `frequencies`, `group-by`, `->>` |
| 4 | String Calculator | strings, regex, `ex-info`, working step by step |
| 5 | Bowling Game | sequential destructuring, recursion |
| 6 | Game of Life | sets as data, `for`, `iterate` |
| 7 | Bank Account | pure functions, atoms, `swap!`, event sourcing |

## Running

```sh
just            # list the recipes
just list       # list the katas
just kata 3     # run the tests for kata 3
just test       # run every kata's tests
just watch 3    # re-run kata 3 on save (needs `brew install watchexec`)
```

## REPL + Portal

```sh
just repl       # plain REPL
just nrepl      # nREPL server for Calva / CIDER / Cursive
```

`dev/user.clj` loads automatically and gives you:

```clojure
(portal)        ; open the Portal inspector; every (tap> x) shows up there
(tap> (frequencies "mississippi"))
(clear)         ; clear Portal
(run-kata 3)    ; reload and run kata 3's tests
(run-all)       ; reload and run everything
```

## FlowStorm debugger

The `:dev` alias runs on [ClojureStorm](https://flow-storm.github.io/flow-storm-debugger/user_guide.html),
which records every call in the `kata.*` namespaces. Run `(flowstorm)` (or
type `:dbg` in a plain REPL), then call a function or `(run-kata 3)` and step
through the recorded execution in the debugger window.

Tip: `tap>` intermediate values inside your solutions while you work,
for example `(doto x tap>)` in the middle of a `->` pipeline.
