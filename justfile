# List available recipes
default:
    @just --list

# Run every kata's tests
test:
    clojure -M:test

# Run one kata's tests, e.g. `just kata 3`
kata n:
    #!/usr/bin/env bash
    set -euo pipefail
    ns=$(ls test/kata | grep -E "^k0*{{n}}_" | head -1 | sed -e 's/\.clj$//' -e 's/_/-/g')
    if [ -z "$ns" ]; then echo "No kata numbered {{n}}"; exit 1; fi
    clojure -M:test -n "kata.$ns"

# Re-run one kata's tests whenever a file changes (needs `watchexec`)
watch n:
    watchexec -e clj -- just kata {{n}}

# Start a plain REPL with Portal available — then run (portal)
repl:
    clj -M:dev

# Start an nREPL server for your editor (Conjure, Calva, CIDER...)
nrepl:
    clojure -M:dev:nrepl

# List the katas
list:
    @grep -h -A1 '^  "KATA' src/kata/*.clj | grep KATA | sed 's/^  "//'

# Remove caches
clean:
    rm -rf .cpcache .nrepl-port
