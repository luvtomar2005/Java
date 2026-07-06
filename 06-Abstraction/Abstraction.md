# Java Abstraction

## Overview

**Abstraction** is one of the four fundamental principles of Object-Oriented Programming (OOP).

The four pillars of OOP are:

* Encapsulation
* Inheritance
* Polymorphism
* Abstraction

Abstraction focuses on **what an object does** rather than **how it does it**.

It hides implementation details and exposes only the essential behavior.

---

# Why Do We Need Abstraction?

Suppose we have different animals.

```text
Dog
Cat
Fish
Bird
```

Every animal can:

* Move
* Make Noise
* Eat
* Sleep

But **how** they move is different.

| Animal | Movement |
| ------ | -------- |
| Dog    | Runs     |
| Fish   | Swims    |
| Bird   | Flies    |
| Snake  | Crawls   |

If the parent class (`Animal`) tried to implement `move()`, there would be no single implementation that is correct for every animal.

Instead of guessing how every animal moves, the parent class simply says:

> "Every animal **must** know how to move."

Each child class is then responsible for providing its own implementation.

This is abstraction.

---

# Interview Definition

> Abstraction is the process of hiding implementation details while exposing only the essential behavior of an object. In Java, abstraction is achieved using **abstract classes** and **interfaces**.

---

# What is an Abstract Class?

An **abstract class** is an incomplete class that cannot be instantiated.

Syntax:

```java
abstract class Animal {

}
```

The keyword `abstract` tells the compiler:

> This class is intended to be extended and is not complete enough to create objects directly.

---

# Why Can't We Create Objects of an Abstract Class?

Suppose we write:

```java
Animal animal = new Animal();
```

Question:

How should this generic animal move?

* Run?
* Fly?
* Swim?
* Crawl?

Java doesn't know.

Therefore:

```java
Animal animal = new Animal();
```

produces a compile-time error.

Correct:

```java
Dog dog = new Dog();
Fish fish = new Fish();
```

---

# Abstract Method

An abstract method is a method that has **only a declaration** and **no implementation**.

Syntax:

```java
public abstract void move();
```

Notice:

* No method body
* No implementation

The parent class simply declares the behavior.

The child class must implement it.

---

# Why Do We Need Abstract Methods?

Suppose every animal makes a different sound.

The parent cannot implement:

```text
makeNoise()
```

because every animal behaves differently.

Instead, the parent declares:

```java
public abstract void makeNoise();
```

Each child class provides its own implementation.

Example:

Dog:

```text
Woof
```

Cat:

```text
Meow
```

Fish:

```text
Bubble Sounds
```

---

# Concrete Methods

An abstract class may also contain **normal (concrete) methods**.

Example:

```java
public void sleep() {

}
```

Every animal sleeps.

Since the implementation is common,

the parent provides it.

This prevents code duplication.

---

# Constructor in an Abstract Class

One common misconception is:

> Abstract classes cannot have constructors.

This is incorrect.

Abstract classes **can** have constructors.

Reason:

Even though we cannot create an object of the abstract class itself,

its constructor is used to initialize the parent portion of child objects.

Execution Flow:

```text
new Dog()

↓

Animal Constructor

↓

Dog Constructor

↓

Object Ready
```

---

# Fields in an Abstract Class

An abstract class can contain:

* Instance variables
* Static variables
* Final variables

Example:

```java
protected String type;
```

There is no restriction on declaring fields.

---

# Static Methods in an Abstract Class

Allowed.

Example:

```java
public static void info() {

}
```

Static methods belong to the class,

not to objects.

---

# Final Methods in an Abstract Class

Allowed.

Example:

```java
public final void breathe() {

}
```

A final method cannot be overridden.

---

# Abstract Class Can Have

✔ Constructors

✔ Instance Variables

✔ Static Variables

✔ Final Variables

✔ Concrete Methods

✔ Static Methods

✔ Final Methods

✔ Abstract Methods

---

# Abstract Class Cannot Have

✘ Objects

```java
new Animal();
```

---

# Rules of Abstract Methods

### Rule 1

An abstract method cannot have a body.

Correct:

```java
abstract void move();
```

Wrong:

```java
abstract void move() {

}
```

---

### Rule 2

If a class contains an abstract method,

the class itself must be abstract.

Wrong:

```java
class Animal {

    abstract void move();

}
```

Correct:

```java
abstract class Animal {

    abstract void move();

}
```

---

### Rule 3

A concrete subclass must implement every inherited abstract method.

Otherwise,

the subclass must also be declared abstract.

Example:

```java
abstract class Dog extends Animal {

}
```

Valid.

---

# Abstract Modifier

The `abstract` keyword is a **non-access modifier**.

It can only be applied to:

* Classes
* Methods

It cannot be applied to:

* Variables
* Constructors
* Local variables

---

# Abstract Modifier with Other Modifiers

## public abstract

✔ Allowed

```java
public abstract void move();
```

Most common combination.

---

## protected abstract

✔ Allowed

```java
protected abstract void move();
```

Common in inheritance hierarchies.

---

## private abstract

✘ Not Allowed

Reason:

Private methods cannot be inherited or overridden.

Abstract methods must be overridden.

---

## static abstract

✘ Not Allowed

Reason:

Static methods belong to the class and cannot be overridden.

Abstract methods require overriding.

---

## final abstract

✘ Not Allowed

Reason:

`abstract` means "must be overridden."

`final` means "cannot be overridden."

The two modifiers contradict each other.

---

# Object Creation in Abstraction

Suppose:

```java
Dog dog = new Dog();
```

Memory:

```text
Stack

dog
 │
 ▼

Heap

+----------------------------+

Animal Part

type
size
weight

-----------------------------

Dog Part

breed

+----------------------------+
```

Only **one object** is created.

The abstract class contributes the inherited state to the same object.

---

# Constructor Chaining

When a child object is created,

execution follows this order:

```text
Allocate Memory

↓

Child Constructor

↓

super()

↓

Parent Constructor

↓

Parent Initialized

↓

Return

↓

Child Initialized

↓

Object Ready
```

The abstract nature of the parent class does not change constructor chaining.

---

# Advantages of Abstraction

* Hides implementation details
* Provides a common blueprint
* Reduces code duplication
* Improves maintainability
* Makes code easier to extend
* Encourages clean object-oriented design
* Supports runtime polymorphism

---

# Real-World Examples

### Banking

Account

↓

Savings Account

Current Account

Loan Account

Each account calculates interest differently.

---

### Payment System

Payment

↓

UPI

Credit Card

Net Banking

Each payment processes differently.

---

### Animal

Animal

↓

Dog

Fish

Bird

Each animal moves differently.

---

### Smart Appliances

Appliance

↓

Washing Machine

Refrigerator

Air Conditioner

Each appliance performs different work.

---

# Abstract Class vs Normal Class

| Normal Class            | Abstract Class                 |
| ----------------------- | ------------------------------ |
| Can create objects      | Cannot create objects          |
| Complete implementation | May contain incomplete methods |
| All methods implemented | Can contain abstract methods   |
| Used directly           | Intended to be extended        |

---

# Abstraction vs Encapsulation

| Abstraction                                    | Encapsulation                        |
| ---------------------------------------------- | ------------------------------------ |
| Hides implementation                           | Hides data                           |
| Focuses on behavior                            | Focuses on data protection           |
| Achieved using abstract classes and interfaces | Achieved using access modifiers      |
| Answers **What should happen?**                | Answers **Who can access the data?** |

---

# Common Beginner Mistakes

### Mistake 1

Thinking an abstract class contains only abstract methods.

Wrong.

It may contain both abstract and concrete methods.

---

### Mistake 2

Thinking abstract classes cannot have constructors.

Wrong.

They can.

---

### Mistake 3

Thinking abstract classes cannot have variables.

Wrong.

They can contain fields just like normal classes.

---

### Mistake 4

Thinking an abstract method can have a body.

Wrong.

Abstract methods never have implementations.

---

### Mistake 5

Trying to instantiate an abstract class.

```java
new Animal();
```

Compile-time error.

---

# Interview Questions

### What is abstraction?

Abstraction hides implementation details while exposing only essential behavior.

---

### How is abstraction achieved in Java?

Using:

* Abstract Classes
* Interfaces

---

### Can we create an object of an abstract class?

No.

---

### Can an abstract class have constructors?

Yes.

---

### Can an abstract class have concrete methods?

Yes.

---

### Can an abstract class have static methods?

Yes.

---

### Can an abstract class have final methods?

Yes.

---

### Can an abstract class have no abstract methods?

Yes.

Declaring a class abstract prevents direct instantiation and indicates it is intended to serve as a base class.

---

### Can abstract methods be private?

No.

Private methods cannot be overridden.

---

### Can abstract methods be static?

No.

Static methods are not overridden.

---

### Can abstract methods be final?

No.

Final methods cannot be overridden.

---

# Best Practices

Use an abstract class when:

* Multiple related classes share common state or behavior.
* You want to provide partial implementation.
* You want to enforce certain methods while sharing reusable code.
* The subclasses have an **IS-A** relationship.

Avoid using an abstract class when:

* There is no common behavior to share.
* The classes are unrelated.
* You only need to define a contract without shared implementation (use an interface instead).

---

# Summary

* Abstraction hides implementation details.
* Abstract classes cannot be instantiated.
* Abstract classes can contain both abstract and concrete methods.
* Abstract methods have no implementation.
* Child classes must implement inherited abstract methods unless they are also abstract.
* Abstract classes can have constructors, fields, static methods, and final methods.
* The `abstract` modifier can only be applied to classes and methods.
* `private abstract`, `static abstract`, and `final abstract` are illegal combinations.
* Abstract classes are commonly used to model incomplete parent concepts that provide shared functionality while requiring subclasses to implement specific behavior.

---

# Interview Revision (30 Seconds)

* **Abstraction** → Hides implementation details and exposes essential behavior.
* **Abstract Class** → Cannot be instantiated; may contain abstract and concrete methods.
* **Abstract Method** → Declared without a body; must be implemented by concrete subclasses.
* **Constructors** → Allowed in abstract classes and used during constructor chaining.
* **Fields & Methods** → Abstract classes can contain fields, constructors, static methods, final methods, and concrete methods.
* **Use Case** → When related classes share common implementation but require different specialized behavior.
