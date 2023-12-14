# Producer-Consumer Testing Project
## Description:
This project is an implementation and comprehensive testing of a Producer-Consumer system adhering to Test-Driven Development (TDD) principles. The task involves testing a "producer-consumer" program where a producer generates "Item" objects, and the consumer consumes these objects. The "Item" objects are stored in a "Buffer" object, and the consumer retrieves items from there. The producer and consumer classes are to be simulated, and only their interfaces are accessible. Both classes need to be simulated and implement the correct interfaces. The entire codebase is subject to testing, covering various aspects.

## Key Features:
Buffer Management: Implementation of a buffer for storing and managing "Item" objects.
Producer-Consumer Simulation: Accurate simulation of producer and consumer classes using mocks with correct interfaces.
Mocked Classes: Implementation of mock classes for simulating producer and consumer behavior.
Test-Driven Development (TDD): Comprehensive testing using JUnit.
Exception Handling: Robust testing for various exception scenarios to ensure graceful error handling.
Input/Output Testing: Rigorous validation of correctness in input and output operations.

## Important tests:
The "remove" method in the buffer class has a few different aspects that are important to test. For example what happens if you interrupt a thread that has been put in the state of waiting. The method will throw both InterruptedException and also the NoSuchElementException. 
It's also important to highlight the possibility to add an item with null-value to buffer.

## Challenges:
Simulating Producer-Consumer Classes: Simulating the behavior of producer and consumer classes solely based on their interfaces.
TDD Principles: Adhering to Test-Driven Development principles throughout the testing process.
Comprehensive Testing: Ensuring thorough testing coverage for various scenarios and edge cases.
