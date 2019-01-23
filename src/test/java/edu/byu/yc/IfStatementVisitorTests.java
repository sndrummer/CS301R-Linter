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
public class IfStatementVisitorTests {

    private final String root = System.getProperty("user.dir");

    private final File noClosingElseFile = new File(new File(root, "test-files"), "IfElseNoClosingElse.java");
    private final File closingElseFile = new File(new File(root, "test-files"), "IfElseClosingElse.java");
    private final File NoIfElseFile = new File(new File(root, "test-files"), "IfStatementsNoIfElse.java");
    private final String noClosingElse = TypeChecker.readFile(noClosingElseFile.getPath());
    private final String closingElse = TypeChecker.readFile(closingElseFile.getPath());
    private final String noIfElse = TypeChecker.readFile(NoIfElseFile.getPath());


    /**
     * Tests that no violations are added when there is no else statements
     */
    @Test
    public void ignoreIfStatementsWithNoElse() {
        assertTrue(TypeChecker.getElseIfStatementViolations(TypeChecker.parse(noIfElse)).isEmpty());
    }

    /**
     * Tests that no violations are added when there is there is a closing else statement i.e. the
     * code complies to the linting rule
     */
    @Test
    public void propertyHoldsTest() {
        assertTrue(TypeChecker.getElseIfStatementViolations(TypeChecker.parse(closingElse)).isEmpty());
    }

    /**
     * Tests when there is a missing else clause after an else if
     * Should report 2 errors since the test file includes 2 else if clauses with no closing else
     * clause
     */
    @Test
    public void propertyDoesNotHoldTest() {
        Set<String> v = TypeChecker.getElseIfStatementViolations(TypeChecker.parse(noClosingElse));
        assertFalse(v.isEmpty());
        assertEquals(2, v.size());
    }
}
