#!/bin/bash

mydir="`dirname $0`"
cfDir="${mydir}"/../checker-framework-inference
. "${cfDir}"/scripts/downstream-runtime-env-setup.sh

CHECKER=security.SecurityChecker

SOLVER=security.solver.SecuritySolverEngine
IS_HACK=true

# DEBUG_SOLVER=checkers.inference.solver.DebugSolver
# SOLVER="$DEBUG_SOLVER"
# IS_HACK=false
# DEBUG_CLASSPATH=""

SECURITYPATH=$ROOT/security-demo/build/classes/java/main
export CLASSPATH=$SECURITYPATH:$DEBUG_CLASSPATH:.
export external_checker_classpath=$SECURITYPATH

$CFI/scripts/inference-dev --checker "$CHECKER" --solver "$SOLVER" --solverArgs="collectStatistics=true" --hacks="$IS_HACK" -m ROUNDTRIP -afud ./annotated "$@"

# TYPE CHECKING
# $CFI/scripts/inference-dev --checker "$CHECKER" --solver "$SOLVER" --solverArgs="collectStatistics=true,solver=z3" --hacks="$IS_HACK" -m TYPECHECK "$@"
