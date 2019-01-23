package edu.byu.yc;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Samuel Nuttall
 */
public class SwitchStatementVisitorTests {

    private final String root = System.getProperty("user.dir");

    private final File moreThanSixFile = new File(new File(root, "test-files"), "SwitchMoreThanSix.java");
    private final File lessThanSixFile = new File(new File(root, "test-files"), "SwitchLessThanSix.java");
    private final File sixCasesFile = new File(new File(root, "test-files"), "SwitchExactlySix.java");
    private final String moreThanSixCases = TypeChecker.readFile(moreThanSixFile.getPath());
    private final String lessThanSixCases = TypeChecker.readFile(lessThanSixFile.getPath());
    private final String sixCases = TypeChecker.readFile(sixCasesFile.getPath());


    /**
     * Tests switch statements with 1, 3, 5 cases.
     * Should not report a violation.
     */
    @Test
    public void lessThanSixCaseStatements(){
        assertTrue(TypeChecker.getSwitchStatementViolations(TypeChecker.parse(lessThanSixCases)).isEmpty());
    }


    /**
     * Tests switch statements with 7 and 8 cases, each have a default case as well (should'nt count)
     * Should report 2 violations.
     */
    @Test
    public void moreThanSixCaseStatements(){
        Set<String> res = TypeChecker.getSwitchStatementViolations(TypeChecker.parse(moreThanSixCases));
        assertFalse(res.isEmpty());
        assertEquals(2, res.size());
    }


    /**
     * Tests both six cases with a default case and no default case
     * They should both pass (not report an error), since default is not counted.
     */
    @Test
    public void sixCaseStatementsWithDefault(){
        assertTrue(TypeChecker.getSwitchStatementViolations(TypeChecker.parse(sixCases)).isEmpty());
    }

}
