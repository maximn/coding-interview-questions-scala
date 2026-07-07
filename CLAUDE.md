# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Scala coding interview questions repository with solutions and comprehensive tests. The codebase demonstrates various algorithmic approaches including recursive, iterative, and tail-recursive implementations.

## Build System

- **Build Tool**: sbt 1.11.5 (Scala Build Tool)
- **Scala Version**: 3.3.8 LTS
- **Test Framework**: Specs2 4.20.8 with ScalaCheck 1.19.0 for property-based testing

## Common Commands

### Building and Testing
```bash
# Clean build artifacts
sbt clean

# Compile the project
sbt compile

# Run all tests
sbt test

# Run tests with coverage
sbt clean coverage test

# Generate coverage report
sbt coverageReport

# Run continuous testing (watch mode)
sbt ~test
```

### Running Specific Tests
```bash
# Run a specific test class
sbt "testOnly org.questions.FibonacciTest"

# Run tests matching a pattern
sbt "testOnly *Fibonacci*"
```

## Code Architecture

### Package Structure
- `org.questions.fibonacci`: Fibonacci implementations (Recursive, Iterative, TailRecursion)
- `org.questions.arrays`: Array-based algorithms (TwoSum, LongestIncreasing, etc.)
- `org.questions.strings`: String algorithms (ParenthesesValidator, WildCardMatching)
- `org.questions.fill`: Canvas/bucket fill algorithms

### Testing Pattern
The project uses a trait-based testing approach:
- Base test traits define common test cases (e.g., `FibonacciTest`)
- Mixins add specialized tests (e.g., `BigN` trait for performance tests)
- Concrete test classes combine traits for specific implementations
- Property-based testing with ScalaCheck for mathematical properties

### Implementation Pattern
- Algorithm interfaces defined as traits (e.g., `Fibonacci` trait)
- Multiple implementation classes for different approaches
- Each implementation focuses on a specific algorithmic strategy

## Development Notes

- Tests include both unit tests and property-based tests
- Performance tests verify algorithms complete within time constraints
- Coverage reporting is configured via sbt-scoverage plugin
- All implementations should handle edge cases (negative inputs, empty collections)

## CI/CD

- GitHub Actions workflow runs on all pull requests to master
- Tests run on Java 25 (latest LTS) with Scala 3.3.8
- Code coverage reports are uploaded to Codecov
- Scalafmt formatting checks ensure consistent code style
- SBT dependencies are cached for faster builds