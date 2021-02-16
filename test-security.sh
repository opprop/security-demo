#!/bin/bash

# Failed the whole script if any command failed
set -e

echo "DUMMY_VAR: $DUMMY_VAR"

WORKING_DIR=$(pwd)

if [ -z "${JSR308}" ] ; then
    export JSR308=$(cd $(dirname "$0")/.. && pwd)
fi

# Pull DLJC if it doesn't exist
# This is for downstream travis test for CFI.
SLUGOWNER=${TRAVIS_REPO_SLUG%/*}
if [[ "$SLUGOWNER" == "" ]]; then
  SLUGOWNER=opprop
fi
if [ ! -d ../do-like-javac ] ; then
    (cd $JSR308 && git clone https://github.com/${SLUGOWNER}/do-like-javac.git)
fi

# Running test suite
./gradlew test --console=plain

CORPUSFILE="working-benchmarks.yml"

if [ -n "$1" ] && [ $1 = "travis" ]; then
    # Running Security on working benchmarks
    python3 run-security-on-corpus.py --corpus-file $CORPUSFILE --is-travis-build true
else
    # Running Ontology on working benchmarks
    python3 run-security-on-corpus.py --corpus-file $CORPUSFILE
fi

# Grep experiment outputs
echo ""
echo "Experiment status:"
find . -name "infer.log" | xargs grep -E "Inference (succeeded|failed)"
