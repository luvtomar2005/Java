# Polymorphism in Java - Notes

## Definition

Polymorphism is the ability of the **same method call** to perform **different behaviors** depending on the **actual object** on which it is invoked.

In simple words:

> **One interface (or method call), many implementations.**

---

# Why Do We Need Polymorphism?

Without polymorphism:

```java
startHonda();
startTesla();
startBMW();
```

As the number of classes grows, the code becomes difficult to maintain.

With polymorphism:

```java
vehicle.start();
```

The same method call works for every type of vehicle.

---

# The Problem It Solves

Imagine a company manufactures:

* Honda
* Tesla
* BMW

Every vehicle can start.

Instead of writing different methods for every vehicle, Java allows one common method call:

```java
vehicle.start();
```

The JVM automatically calls the correct implementation.

---

# Prerequisites

To achieve runtime polymorphism, Java requires:

* Inheritance
* Method Overriding
* Parent Reference
* Child Object

Example:

```java
Vehicle vehicle = new Honda();
```

---

# Important Rule

Reference Type:

```java
Vehicle
```

Actual Object:

```java
Honda
```

When calling:

```java
vehicle.start();
```

The JVM executes:

```java
Honda.start();
```

because the object is a `Honda`.

---

# Compiler vs JVM

## Compiler

Checks:

* Does the reference type contain the called method?

Example:

```java
Vehicle vehicle;
vehicle.start();
```

Since `Vehicle` has a `start()` method, compilation succeeds.

---

## JVM

At runtime, the JVM checks:

> Which object does the reference actually point to?

Then it executes that object's overridden method.

This process is called **Dynamic Method Dispatch**.

---

# Memory Concept

```text
Vehicle vehicle;
```

Creates only a reference.

```text
STACK

vehicle

↓

null
```

After:

```java
vehicle = new Honda();
```

```text
STACK

vehicle
   |
   V

HEAP

Honda Object
```

The reference type is still `Vehicle`, but the actual object is `Honda`.

---

# Key Characteristics

* Achieved using method overriding.
* Decision is made at runtime.
* Promotes flexibility.
* Reduces duplicate code.
* Makes applications easy to extend.

---

# Real-World Examples

* Vehicle → Car, Bike, Truck
* Animal → Dog, Cat, Lion
* PaymentMethod → UPI, CreditCard, Wallet
* Notification → Email, SMS, Push Notification

---

# Backend Development Usage

Spring Boot uses polymorphism extensively.

Example:

```java
PaymentService paymentService;
paymentService.pay();
```

The implementation could be:

* UPI
* Credit Card
* Wallet
* Net Banking

The caller doesn't need to know the concrete type.

---

# Common Beginner Mistakes

## Mistake 1

```java
Honda h = new Honda();
h.start();
```

This uses overriding but doesn't demonstrate the power of polymorphism.

The more important pattern is:

```java
Vehicle vehicle = new Honda();
vehicle.start();
```

---

## Mistake 2

Thinking the reference type decides which method runs.

Wrong.

The **actual object** decides.

---

## Mistake 3

Thinking inheritance alone is polymorphism.

Inheritance enables polymorphism, but polymorphism happens when a parent reference refers to different child objects and overridden methods are invoked dynamically.

---

# Advantages

* Loose coupling
* Better code reuse
* Easy maintenance
* Easy extensibility
* Cleaner design
* Widely used in enterprise applications

---

# Disadvantages

* Runtime method resolution has a small overhead (usually negligible).
* Understanding reference type vs object type can confuse beginners.

---

# Interview Questions

### What is polymorphism?

The ability of the same method call to exhibit different behavior depending on the actual object.

### What are the types of polymorphism?

* Compile-time polymorphism (Method Overloading)
* Runtime polymorphism (Method Overriding)

### How is runtime polymorphism achieved?

Using:

* Inheritance
* Method Overriding
* Parent Reference
* Child Object

### Which method is selected?

The overridden method of the **actual object** at runtime.

### Can constructors be polymorphic?

No.

### Can static methods be polymorphic?

No. Static methods are resolved at compile time.

### Can private methods be overridden?

No.

---

# Summary

* Polymorphism means one method call can have multiple behaviors.
* Runtime polymorphism depends on the actual object, not the reference type.
* The compiler checks method availability; the JVM selects the implementation.
* It is one of the four pillars of OOP and is used extensively in backend frameworks such as Spring Boot.
