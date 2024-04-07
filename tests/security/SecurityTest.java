package security;

import checkers.inference.test.CFInferenceTest;
import org.plumelib.util.IPair;
import security.solver.SecuritySolverEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.framework.test.TestUtilities;
import org.junit.runners.Parameterized.Parameters;

public class SecurityTest extends CFInferenceTest {

    public SecurityTest(File testFile) {
        super(
                testFile,
                security.SecurityChecker.class,
                "testing",
                "-Anomsgtext",
                "-d",
                "tests/build/outputdir");
    }

    @Override
    public boolean useHacks() {
        return true;
    }

    @Override
    public IPair<String, List<String>> getSolverNameAndOptions() {
        final String solverName = SecuritySolverEngine.class.getCanonicalName();
        List<String> solverOptions = new ArrayList<>();
        // solverOptions.add("solver=Z3");
        return IPair.of(solverName, solverOptions);
    }

    @Parameters
    public static List<File> getTestFiles() {
        List<File> testfiles = new ArrayList<>();
        testfiles.addAll(TestUtilities.findRelativeNestedJavaFiles("testing", "infer", "typecheck"));
        return testfiles;
    }
}
