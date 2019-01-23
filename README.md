# Samuel Nuttall's Linter

For this assignment I chose to implement the following rules:
* An if statement that is the immediate child of an else statement must contain an else clause of its own.
* Switch statements may contain no more than six cases (not counting default).

These rules are implemented in the IfStatement visitor and the SwitchStatement Visitor.

## How I implemented the two rules
### IfStatement Visitor
To find else statements I use the node.getElseStatement() method in the IfStatement visit() method
to get the else Statement branch and then check if the immediate child of the else statement is an if 
statement by using: 
```(elseBranch instanceof IfStatement)```.
Then I simply check if  ```elseIfStatement.getElseStatement()``` is null or not to determine if there is a 
closing else clause of the elseIf statement.

### Switch Statement Visitor
For this visitor I get the child statements of the SwitchStatement ASTNode and then check that it has child statements,
if it does then I iterate through them and count each statement that is not a default statement, as soon as the case amount
exceeds six, an error is reported.

## Why I believe my tests are adequate
### IfStatementVisitor Tests
To test the 'if-else' linting rule that I implemented, I created 3 test files:
* test-files/IfElseNoClosingElse.java
    - This contains two methods which both violate the linting rule
* test-files/IfElseClosingElse.java
    - This file contains a method that complies to the linting rule
* test-files/IfStatementsNoIfElse.java
    - This file contains a method that has no else statements, only if and so 
    still does not violate the linting rule
 ------------------------------------------
Please refer to the IfStatementVisitorTests file to see how these files are tested.
I believe that the tests are adequate because both violations and compliance to the linting rule 
are tested, as well as methods that will access the IfStatement visitor but should not report anything
such as methods with no else statements.

### SwitchStatementVisitor Tests
To test the linting rule limiting the number of switch cases to six (not including the default case),
I used 3 files:
* test-files/SwitchExactlySix.java
    - As the name suggests this file contains methods with six switch cases. It tests 6 cases 
    both with and without a default. This makes sure that the edge case is working properly, 6 should 
    be the limit and default cases should not be included. This is arguably the most valuable 
    test because it ensures that the linting rule works according to the specs and covers the main edge cases. 
* test-files/SwitchLessThanSix.java
    - This file contains methods with less than six switch statement cases and therefore tests 
    compliance to the rule.
* test-files/SwitchMoreThanSix.java
    - This file contains methods with more than six switch statement cases and so it tests the violation
    of the linting rule.
    
## What was most valuable about this experience 
* First, I learned a lot about solving problems with project structure, changing settings with maven,
eclipse, intellij, etc. I believe this will come in handy in future projects.
* Second I learned more about how java code is/can be structured with a DOM tree such as the ASTNodes.
This was interesting and a useful exercise to understand more about how to interpret and analyze code 
effectively.
* Third, Experience with visitor pattern. I had used the visitor pattern before, but it was a good refresher to remember how useful it can be 
in situations where you are using complex tree structures that need to be traversed etc.   
