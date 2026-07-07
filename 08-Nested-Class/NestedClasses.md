# Nested Classes in Java - Complete Revision Notes

---

# What are Nested Classes?

A **Nested Class** is a class declared inside another class.

Java introduced nested classes to:

* Logically group classes that work together.
* Improve encapsulation.
* Reduce unnecessary top-level classes.
* Hide helper classes from the outside world.

Instead of:

```text
Car.java

Engine.java
```

we can write:

```java
class Car {

    class Engine {

    }

}
```

If `Engine` is only used by `Car`, keeping it inside `Car` makes the design cleaner.

---

# Types of Nested Classes

Java provides **four** types of nested classes.

```text
Nested Classes
│
├── Static Nested Class
│
└── Inner Classes
     │
     ├── Member Inner Class
     ├── Local Inner Class
     └── Anonymous Inner Class
```

**Important**

Every **Inner Class** is a Nested Class.

But **every Nested Class is NOT an Inner Class.**

A **Static Nested Class** is **not** an Inner Class.

---

# 1. Static Nested Class

## Syntax

```java
class Outer {

    static class Nested {

    }

}
```

---

## Why do we need it?

Use a Static Nested Class when:

* The helper class belongs only to one outer class.
* It does **not** need access to a particular outer object.
* You want logical grouping.

Example:

```text
Student

↓

Builder
```

Instead of

```text
Student.java

StudentBuilder.java
```

we write

```java
class Student {

    static class Builder {

    }

}
```

---

## Object Creation

```java
Car.Engine engine = new Car.Engine();
```

Notice:

No `Car` object is required.

---

## Access Rules

Can directly access:

```java
static variables

static methods
```

Cannot directly access:

```java
instance variables

instance methods
```

because there is no outer object.

---

## Memory

```text
Class Area

-----------------------

Car Class

company = Tesla

-----------------------


Heap

-----------------------

Engine Object

-----------------------
```

There is **no Car object** automatically associated with the Engine.

---

## Use Cases

* Builder Pattern
* Helper Classes
* Utility Classes
* Factory Classes

---

# 2. Member Inner Class

## Syntax

```java
class Outer {

    class Inner {

    }

}
```

Notice:

No `static`.

---

## Why do we need it?

Use it when the inner object belongs to one specific outer object.

Example:

```text
BankAccount

↓

Transaction
```

A Transaction belongs to one BankAccount.

---

## Object Creation

```java
Car car = new Car();

Car.Engine engine = car.new Engine();
```

Notice:

A Car object must exist first.

---

## Hidden Reference

Every Member Inner Class object automatically stores a hidden reference to its enclosing outer object.

Conceptually:

```text
Engine

↓

Car Object
```

This is why it can directly access instance variables.

---

## Access Rules

Can directly access:

* Instance Variables
* Instance Methods
* Static Variables
* Static Methods

of the enclosing class.

---

## Memory

```text
Heap

------------------------

Car Object

model = Tesla

------------------------

Engine Object

|

↓

Reference to Car Object

------------------------
```

---

## Use Cases

* Strong object relationships
* Objects that cannot exist independently

Examples:

* Engine → Car
* Transaction → BankAccount

---

# Static Nested Class vs Member Inner Class

| Feature                 | Static Nested       | Member Inner        |
| ----------------------- | ------------------- | ------------------- |
| Uses static             | Yes                 | No                  |
| Needs outer object      | No                  | Yes                 |
| Object Creation         | `new Outer.Inner()` | `outer.new Inner()` |
| Access Instance Members | No                  | Yes                 |
| Hidden Reference        | No                  | Yes                 |

---

# 3. Local Inner Class

## Syntax

```java
void display() {

    class Local {

    }

}
```

The class is declared inside a method.

---

## Scope

Visible only inside that method.

Outside the method:

```java
Local obj = new Local();
```

Compilation Error.

---

## Why do we need it?

When a helper class is required only inside one method.

Instead of making it a member class,

keep it inside that method.

---

## Access Rules

Can access:

* Outer class members
* Local variables

But local variables must be:

* final
* or effectively final

---

## Effectively Final

Example:

```java
int amount = 5000;
```

If you never modify it,

the compiler treats it as final.

This is called **Effectively Final**.

---

## Why?

Because local variables disappear when the method finishes.

The local inner class captures their value.

To avoid inconsistencies,

Java requires them to remain unchanged.

---

## Use Cases

Rare in modern Java.

Mostly:

* Method-specific helper logic
* Certification questions
* Legacy code

---

# 4. Anonymous Inner Class

## Why do we need it?

Suppose an interface implementation is required only once.

Instead of

```java
class Dog implements Animal {

}
```

we write

```java
Animal animal = new Animal() {

    @Override
    public void sound() {

        System.out.println("Bark");

    }

};
```

No class name.

Hence:

Anonymous Class.

---

## Characteristics

* No programmer-defined class name.
* Created and instantiated together.
* Used only once.
* Compiler generates a synthetic class.

---

## Compiler Concept

Conceptually:

```java
Animal animal = new Animal() {

};
```

becomes something similar to:

```java
class AnonymousAnimal implements Animal {

}

Animal animal =
        new AnonymousAnimal();
```

This is only a conceptual explanation. The compiler actually generates a synthetic class with an internal name.

---

## Common Uses (Before Java 8)

* Event Listeners
* Threads
* Comparator
* Swing
* JavaFX
* Android

---

## Java 8+

Most anonymous classes implementing functional interfaces have been replaced by Lambda Expressions.

---

# Comparison of All Four Types

| Feature                | Static Nested | Member Inner | Local Inner | Anonymous Inner                    |
| ---------------------- | ------------- | ------------ | ----------- | ---------------------------------- |
| Has Name               | Yes           | Yes          | Yes         | No                                 |
| Uses static            | Yes           | No           | No          | No                                 |
| Needs Outer Object     | No            | Yes          | Yes         | Depends on context                 |
| Declared Inside        | Class         | Class        | Method      | Expression                         |
| Visible Outside Method | Yes           | Yes          | No          | No                                 |
| Most Common Today      | Yes           | Limited      | Rare        | Limited (many replaced by lambdas) |

---

# Advantages of Nested Classes

* Better code organization.
* Improved encapsulation.
* Keeps related classes together.
* Reduces unnecessary top-level classes.
* Cleaner project structure.

---

# When to Use Which?

### Static Nested Class

Use when:

* No outer object is needed.
* Helper class belongs to one class.

Example:

* Builder Pattern

---

### Member Inner Class

Use when:

* Inner object belongs to one outer object.
* Frequent access to outer instance data is required.

---

### Local Inner Class

Use when:

* Helper class is required only inside one method.

---

### Anonymous Inner Class

Use when:

* A one-time implementation is required.
* Especially before Java 8.

---

# Common Beginner Mistakes

### Mistake 1

Thinking every nested class is an inner class.

Wrong.

Static Nested Class is **not** an Inner Class.

---

### Mistake 2

Creating Member Inner Class like

```java
new Car.Engine();
```

Wrong.

Correct:

```java
car.new Engine();
```

---

### Mistake 3

Trying to access instance variables directly inside a Static Nested Class.

Not possible.

---

### Mistake 4

Trying to modify a local variable accessed by a Local Inner Class.

Not allowed.

The variable must be effectively final.

---

### Mistake 5

Thinking Anonymous Class and Lambda are the same.

They are different.

Anonymous Classes create a synthetic class.

Lambdas implement a functional interface using a different runtime mechanism.

---

# Frequently Asked Interview Questions

### Q1. What is a Nested Class?

A class declared inside another class.

---

### Q2. How many types of Nested Classes exist?

Four:

* Static Nested Class
* Member Inner Class
* Local Inner Class
* Anonymous Inner Class

---

### Q3. Is every Nested Class an Inner Class?

No.

Only non-static nested classes are Inner Classes.

---

### Q4. Why can't a Static Nested Class access instance variables directly?

Because it has no implicit reference to any outer object.

---

### Q5. Why can a Member Inner Class access private members of the outer class?

Because every Member Inner Class object maintains a hidden reference to its enclosing outer object.

---

### Q6. What is an Effectively Final variable?

A local variable that is assigned only once and never modified.

---

### Q7. Why were Anonymous Classes used before Java 8?

To avoid creating separate implementation classes for one-time use.

---

# Key Takeaways

* Nested classes improve organization and encapsulation.
* Static Nested Classes belong to the outer class.
* Member Inner Classes belong to an outer object.
* Local Inner Classes exist only inside one method.
* Anonymous Inner Classes are one-time implementations.
* Understanding nested classes makes it much easier to learn Lambda Expressions, Functional Interfaces, and the Stream API.
