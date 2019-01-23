package edu.byu.yc;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Samuel Nuttall
 *
 * Assures that an if statement that is the immediate child of an else
 * statement must contain an else clause of its own.
 */
public class IfStatementVisitor extends ASTVisitor {
    private static Logger logger = LoggerFactory.getLogger(IfStatementVisitor.class);
    private Set<String> violations;

    public IfStatementVisitor() {
        violations = new HashSet<>();
    }

    /**
     * An if statement that is the immediate child of an else
     * statement must contain an else clause of its own.
     *
     * @param node An IfStatement AST to be analyzed
     * @return true after visit
     */
    @Override
    public boolean visit(IfStatement node) {
        Statement elseBranch = node.getElseStatement();
        if (elseBranch instanceof IfStatement) {
            IfStatement elseIfStatement = (IfStatement) elseBranch;
            Statement closingElseStatement = elseIfStatement.getElseStatement();
            if (closingElseStatement == null) {
                violations.add(node.toString());
                logger.error("No closing else clause!");
            }
        }
        return true;
    }


    /**
     * @return Statements that violate linting rule
     */
    public Set<String> getAllViolations() {
        return violations;
    }


}
