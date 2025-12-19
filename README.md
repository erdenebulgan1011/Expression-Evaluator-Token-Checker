#  Expression Evaluator & Token Checker

A Java project demonstrating expression evaluation using the abstract syntax tree (AST) pattern and basic token validation for bracket matching.

## Overview

This project consists of two main components:

1. **Expression Evaluator**: A system for building and evaluating mathematical expressions using an object-oriented approach
2. **Token Order Checker**: A utility for validating the correct ordering of brackets and parentheses in simple C-like syntax

## Project Structure

```
project/
├── Expression.java          # Abstract base class for all expressions
├── IntValue.java           # Represents integer literal values
├── Variable.java           # Represents variables with mutable values
├── Binary.java             # Represents binary operations (+, -, *, /)
├── Assignment.java         # Represents variable assignments
├── VariableRef.java        # Abstract base class for variable references
├── TokenOrderChecker.java  # Token validation utility
└── main.java              # Demo/test file
```

## Features

### Expression Evaluator

- **Abstract Syntax Tree**: Build complex mathematical expressions using composition
- **Supported Operations**: Addition (+), Subtraction (-), Multiplication (*), Division (/)
- **Variables**: Create and assign values to variables
- **Evaluation**: Evaluate entire expression trees to compute results

### Token Order Checker

- Validates bracket and parenthesis matching
- Checks for proper nesting of `()` and `{}`
- Uses stack-based validation algorithm

## Usage

### Building Expressions

```java
// Create variables
Variable x = new Variable("x");
Variable y = new Variable("y");
Variable z = new Variable("z");

// Set values
x.setValue(5);
y.setValue(3);

// Build expression: z = x + (2 * y)
Expression term1 = x;
Expression term2a = new IntValue(2);
Expression term2b = y;
Binary multiply = new Binary("*", term2a, term2b);
Expression expression = new Binary("+", term1, multiply);

// Create assignment
Assignment assignment = new Assignment(z, expression);

// Evaluate
int result = assignment.evaluate(); // Returns 11 (5 + 2*3)
```

### Token Checking

```java
// Run the TokenOrderChecker
// Input: int main(){}
// Output: Token Zuv (Correct)
```

## Classes

### Expression (Abstract)
Base class for all expression types. Defines the `evaluate()` method.

### IntValue
Represents integer constants in expressions.

### Variable
Represents a variable that can hold and evaluate to an integer value.

### Binary
Represents binary operations between two expressions. Supports `+`, `-`, `*`, `/`.

### Assignment
Links a target variable to a source expression.

### TokenOrderChecker
Standalone utility for validating bracket matching in input strings.

## Requirements

- Java 8 or higher
- No external dependencies

## Running the Project

```bash
# Compile
javac lab3/*.java

# Run expression demo
java lab3.main

# Run token checker
java lab3.TokenOrderChecker
```

## Example Output

```
[op= '+', term1=x, term2=[op= '*', term1=2, term2=y]]
```

## License

Educational project - free to use and modify.

## Author
