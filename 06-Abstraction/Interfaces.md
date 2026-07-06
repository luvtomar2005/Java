# Java Interfaces

## Overview

Interfaces are one of the most important concepts in Java and are used extensively in:

* Spring Boot
* Collections Framework
* JDBC
* Java Streams
* Multithreading
* Design Patterns
* Dependency Injection

Understanding interfaces is essential for Java backend development and technical interviews.

---

# Table of Contents

1. Why Do We Need Interfaces?
2. What is an Interface?
3. Interface vs Inheritance
4. Interface Syntax
5. Implementing an Interface
6. Rules of Interfaces
7. Interface Reference Variables
8. Multiple Interface Implementation
9. Interface Variables
10. Java 8 and Java 9 Interface Enhancements
11. Interface vs Abstract Class
12. Common Beginner Mistakes
13. Best Practices
14. Interview Questions
15. Summary

---

# 1. Why Do We Need Interfaces?

Before learning interfaces, remember the purpose of inheritance.

Inheritance models an **IS-A** relationship.

Example:

```text
Dog IS-A Animal
Car IS-A Vehicle
SavingsAccount IS-A Account
```

This works because the child class is a specialized version of the parent class.

However, not every real-world relationship is an IS-A relationship.

Example:

```text
Bird
Airplane
Drone
```

All three can fly.

But:

* Bird is an Animal.
* Airplane is a Vehicle.
* Drone is a Machine.

They are unrelated classes.

The only thing they have in common is:

```text
They CAN Fly
```

This is where inheritance fails.

Interfaces solve this problem.

---

# 2. What is an Interface?

An interface defines a **contract**.

It specifies:

> **What a class must do, but not how it should do it.**

An interface contains behaviors that implementing classes must provide.

Example:

```text
Flyable

↓

fly()
```

Every class implementing `Flyable` must provide its own implementation of `fly()`.

---

# Interview Definition

> An interface is a reference type in Java that defines a contract. It specifies what a class must do without specifying how it should do it. Classes implement interfaces by providing implementations for all abstract methods.

---

# 3. Interface vs Inheritance

Inheritance:

```text
Dog IS-A Animal
```

Interface:

```text
Bird CAN Fly
Airplane CAN Fly
Drone CAN Fly
```

Think of it like this:

* **Inheritance** describes identity.
* **Interface** describes capability.

---

# 4. Interface Syntax

Syntax:

```java
interface Flyable {

    void fly();

}
```

Important points:

* Use the keyword `interface`.
* Interface methods are automatically `public abstract`.
* You do not need to write `public abstract` explicitly.

The compiler treats:

```java
void fly();
```

as:

```java
public abstract void fly();
```

---

# 5. Implementing an Interface

Classes use the `implements` keyword.

Example:

```java
class Bird implements Flyable {

    @Override
    public void fly() {
        System.out.println("Bird flies using wings.");
    }
}
```

Notice:

* Classes extend classes.
* Classes implement interfaces.

---

# extends vs implements

```java
class Dog extends Animal
```

Means:

```text
Dog IS-A Animal
```

```java
class Bird implements Flyable
```

Means:

```text
Bird CAN Fly
```

---

# 6. Rules of Interfaces

## Rule 1

Interfaces cannot be instantiated.

Wrong:

```java
Flyable flyable = new Flyable();
```

Compile-time error.

---

## Rule 2

A concrete class implementing an interface must implement every abstract method.

Otherwise:

The class must also be declared abstract.

---

## Rule 3

When overriding interface methods,

the access modifier must remain `public`.

Wrong:

```java
void fly() {

}
```

Correct:

```java
public void fly() {

}
```

Reason:

The interface method is already `public`.

You cannot reduce visibility.

---

## Rule 4

Interfaces do not have constructors.

Reason:

Interfaces never create objects.

---

# 7. Interface Reference Variables

One of the most important concepts.

Example:

```java
Printer printer = new HPPrinter();
```

Reference type:

```text
Printer
```

Object type:

```text
HPPrinter
```

This is valid because:

```text
HPPrinter implements Printer
```

Benefits:

* Loose coupling
* Runtime polymorphism
* Flexible design

This concept is used heavily in Spring Boot.

Example:

```java
UserService service = new UserServiceImpl();
```

---

# 8. Multiple Interface Implementation

Java does not support multiple inheritance of classes.

Illegal:

```java
class Duck extends Animal, Vehicle
```

However,

a class may implement multiple interfaces.

Example:

```java
class Duck implements Flyable, Swimmable
```

This is one of the biggest advantages of interfaces.

---

# Why?

A duck:

* IS-A Animal
* CAN Fly
* CAN Swim

Capabilities are independent.

---

# 9. Interface Variables

Every field declared inside an interface is automatically:

```java
public static final
```

Example:

```java
interface Vehicle {

    int MAX_SPEED = 120;

}
```

Compiler treats it as:

```java
public static final int MAX_SPEED = 120;
```

Meaning:

* public → Accessible everywhere.
* static → One shared copy.
* final → Cannot be reassigned.

These are constants.

Interfaces cannot contain instance variables.

---

# 10. Java 8 and Java 9 Interface Enhancements

## Before Java 8

Interfaces could contain only:

* Abstract methods
* Constants

---

## Java 8

Added:

### Default Methods

Purpose:

Allow interfaces to evolve without breaking existing implementations.

Example use case:

Adding a new method to an existing interface without forcing every implementing class to change.

Default methods:

* Have implementations.
* Can be overridden.
* Use the `default` keyword.

---

### Static Methods

Static methods belong to the interface itself.

Characteristics:

* Have implementations.
* Cannot be overridden.
* Called using the interface name.

Example:

```text
Payment.validateCurrency();
```

---

## Java 9

Added:

### Private Methods

Purpose:

Remove duplicate code shared by multiple default methods.

Characteristics:

* Used only inside the interface.
* Cannot be accessed by implementing classes.

---

### Private Static Methods

Purpose:

Share helper logic among static methods.

---

# Java Version Timeline

| Version            | Features                                |
| ------------------ | --------------------------------------- |
| Java 7 and earlier | Abstract methods, constants             |
| Java 8             | Default methods, static methods         |
| Java 9             | Private methods, private static methods |

---

# 11. Interface vs Abstract Class

## Abstract Class

Use when classes:

* Share common state.
* Share common implementation.
* Have an IS-A relationship.

Example:

```text
Animal

↓

Dog

Cat

Horse
```

---

## Interface

Use when classes share only a capability.

Example:

```text
Bird

Airplane

Drone

↓

Flyable
```

---

# Comparison

| Abstract Class                         | Interface                                              |
| -------------------------------------- | ------------------------------------------------------ |
| IS-A relationship                      | CAN-DO capability                                      |
| Uses `extends`                         | Uses `implements`                                      |
| Constructors allowed                   | No constructors                                        |
| Instance variables allowed             | No instance variables                                  |
| Can have abstract and concrete methods | Can have abstract, default, static and private methods |
| Single inheritance                     | Multiple interfaces supported                          |
| Shares implementation and state        | Defines a contract                                     |

---

# 12. Common Beginner Mistakes

### Mistake 1

Using `extends` instead of `implements`.

Wrong:

```java
class Bird extends Flyable
```

Correct:

```java
class Bird implements Flyable
```

---

### Mistake 2

Trying to instantiate an interface.

Wrong:

```java
new Flyable();
```

---

### Mistake 3

Forgetting to implement every abstract method.

---

### Mistake 4

Using package-private methods while implementing an interface.

Interface methods must be implemented as `public`.

---

### Mistake 5

Thinking interfaces replace abstract classes.

They solve different design problems.

---

# 13. Best Practices

Use an interface when:

* Defining capabilities.
* Designing loosely coupled applications.
* Multiple unrelated classes share behavior.
* Building extensible APIs.
* Working with dependency injection frameworks like Spring.

Use an abstract class when:

* Classes share common fields.
* Classes share constructors.
* Significant implementation can be reused.
* The relationship is IS-A.

---

# 14. Interview Questions

### What is an interface?

A contract that specifies what a class must do.

---

### Why do we need interfaces?

Interfaces solve problems that inheritance cannot:

* Model capabilities instead of identity.
* Allow unrelated classes to share behavior.
* Enable multiple interface implementation.
* Promote loose coupling.

---

### Why not use inheritance everywhere?

Inheritance models only IS-A relationships.

Many real-world relationships are capabilities (CAN-DO).

Interfaces model those capabilities.

---

### Can an interface have constructors?

No.

---

### Can an interface contain variables?

Yes.

Only constants.

Every field is automatically:

```java
public static final
```

---

### Can a class implement multiple interfaces?

Yes.

---

### Can interfaces have method implementations?

Yes.

Since Java 8:

* Default methods
* Static methods

Since Java 9:

* Private methods
* Private static methods

---

### Why were default methods introduced?

To maintain backward compatibility when evolving existing interfaces.

---

### Can default methods be overridden?

Yes.

---

### Can interface static methods be overridden?

No.

---

### Can private interface methods be called by implementing classes?

No.

They are helper methods used internally by the interface.

---

### When should we choose an interface over an abstract class?

Choose an interface when defining a capability or contract.

Choose an abstract class when related classes share state and implementation.

---

# 15. Summary

* Interfaces define **contracts**, not implementations.
* They model **CAN-DO** relationships rather than **IS-A** relationships.
* Classes implement interfaces using the `implements` keyword.
* Interface methods are implicitly `public abstract`.
* Interface fields are implicitly `public static final`.
* A class can implement multiple interfaces.
* Java 8 introduced default and static methods.
* Java 9 introduced private methods.
* Interfaces are the foundation of loose coupling and are heavily used throughout Spring Boot and modern Java frameworks.

---

# Interview Revision (60 Seconds)

* **Interface** → A contract that defines what a class must do.
* **Relationship** → CAN-DO capability.
* **Keyword** → `implements`.
* **Methods** → `public abstract` by default.
* **Fields** → `public static final` by default.
* **Object Creation** → Interfaces cannot be instantiated.
* **Multiple Interfaces** → A class can implement multiple interfaces.
* **Java 8** → Default methods and static methods.
* **Java 9** → Private methods.
* **Use Interface** → When unrelated classes share capabilities.
* **Use Abstract Class** → When related classes share state and implementation.
