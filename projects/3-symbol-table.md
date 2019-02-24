# Intro

Your task is to write a visitor that assembles a symbol table for a given Java program. This is the first pass required for type checking. In particular, you must assemble information about the classes, fields, and methods declared in the program. The result should be a table that allows you to return a type when given an identifier.

# Requirements

Naturally, there are many language features in Java that are beyond the scope of this class. The language features that your type checker will need to support are:

* Variables
* Number literals
* String literas
* Binary operators
* Unary operators
* Function calls without virtual dispatch
* Casting (see below)
* Local variables
* Assignments
* Control flow statements (`if`, `for`, `while`, `switch`)

Most of these language features are not relevant to the symbol checker; however, they will be a crucial part of your type checker.

## Casting

Casting is difficult to reason about generally; however, one special case is tractable:

```java
if (x instanceof C) C y = (C) x;
```

# Interface

The **ISymbolTable** interface has been added to the `edu.byu.yc` package in the visitor skeleton. Your visitor must produce an implementation of this interface after visiting a Java file. The implementation may use stubs for `addLocal()` and `removeLocal()`.

# Testing

Use black-box testing to test your visitor. Since the symbol table does not validate programs, there are no "correct" or "incorrect" programs. Instead, consider which equivalence classes you can test. Explain your choice of tests in Javadoc comments or in a text file. In either case, your tests and your explanation of why they are sufficient must be a part of the patch you submit.

# Submission

Create a patch for a single commit with respect to the master branch of the visitor skeleton. Be sure to include Javadoc comments with an `@author` tag in each source file. If you work with a partner, make sure both names are in each `@author` tag. Submit your patch in Canvas.

If you work with a partner, only one of you needs to submit a patch. However, the other member of the group should submit a brief text file that indicates his/her partner's name. Something as simple as

    I worked with Jane Doe on this project and she submitted our patch.

is sufficient.

# Grading

* 10 points for implementing the existence functions (`classExists()`, etc.)
* 15 additional points for also collecting appropriate return types (`getFieldType()`, etc.)
* 5 additional points for also creating a suitable `toString()` function
* 15 points for sufficient black-box tests to test existence functions
* 15 points for black-box tests that also check return types
* 10 points for code style (passing SonarLint and legibility)
* 15 points for documentation of visitor code
* 15 points for documentation of black-box tests
