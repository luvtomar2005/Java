# Lambda Expressions in Java - Complete Revision Notes

---

# Introduction

Lambda Expressions were introduced in **Java 8** to support **Functional Programming**.

Their primary goal is to reduce boilerplate code by allowing developers to write the implementation of a **Functional Interface** without creating a separate implementation class or an anonymous inner class.

Lambda expressions are heavily used in:

* Streams API
* Collections Framework
* Comparator
* Predicate
* Consumer
* Supplier
* Function
* Optional
* CompletableFuture
* Spring Boot

---

# Why Were Lambda Expressions Introduced?

Before Java 8, implementing a simple interface required:

```text
Create Interface
        ↓
Create Class
        ↓
Override Method
        ↓
Create Object
        ↓
Call Method
```

Example:

```java
interface Animal {
    void sound();
}

class Dog implements Animal {

    @Override
    public void sound() {
        System.out.println("Bark");
    }
}

Animal animal = new Dog();
animal.sound();
```

If the implementation was required only once, developers used Anonymous Inner Classes.

```java
Animal animal = new Animal() {

    @Override
    public void sound() {
        System.out.println("Bark");
    }

};
```

Still a lot of unnecessary code.

Java 8 introduced Lambda Expressions to keep only the method implementation.

---

# What is a Lambda Expression?

A Lambda Expression is a concise way to provide the implementation of a Functional Interface.

General syntax:

```java
(parameters) -> expression
```

or

```java
(parameters) -> {

}
```

The `->` operator is called the **Lambda Operator**.

---

# Lambda Syntax

## No Parameters

```java
() -> System.out.println("Hello");
```

Equivalent to:

```java
void greet() {
    System.out.println("Hello");
}
```

---

## One Parameter

```java
name -> System.out.println(name);
```

Equivalent to:

```java
void print(String name) {
    System.out.println(name);
}
```

---

## Multiple Parameters

```java
(a, b) -> a + b
```

Equivalent to:

```java
int add(int a, int b) {
    return a + b;
}
```

---

## Multi-Line Lambda

```java
(a, b) -> {

    int result = a + b;

    return result;

}
```

---

# Functional Interface

A Lambda Expression works only with a **Functional Interface**.

A Functional Interface contains:

* Exactly one abstract method.

It may also contain:

* Default methods
* Static methods
* Private methods (Java 9+)

Example:

```java
@FunctionalInterface
interface Greeting {

    void greet();

    default void message() {
        System.out.println("Welcome");
    }

    static void info() {
        System.out.println("Greeting Interface");
    }
}
```

This is still a Functional Interface because there is only one abstract method.

---

# @FunctionalInterface Annotation

Purpose:

Compile-time validation.

Example:

```java
@FunctionalInterface
interface Greeting {

    void greet();

}
```

If another abstract method is added,

the compiler generates an error.

Important:

The annotation **does not make** an interface functional.

It only verifies that the interface satisfies the rule.

---

# Why Exactly One Abstract Method?

Suppose

```java
interface Animal {

    void sound();

}
```

Lambda:

```java
Animal animal =
        () -> System.out.println("Bark");
```

Java knows the lambda implements:

```java
sound()
```

Now suppose

```java
interface Animal {

    void sound();

    void eat();

}
```

Question:

Which method should the lambda implement?

* sound()
* eat()

The compiler cannot decide.

Hence Lambdas require exactly one abstract method.

---

# Built-in Functional Interfaces

Package:

```text
java.util.function
```

Java provides standard functional interfaces so developers don't need to create their own for common tasks.

---

# Predicate<T>

Purpose:

Represents a condition.

Method:

```java
boolean test(T t);
```

Input:

One

Output:

boolean

Example:

```java
Predicate<Integer> isAdult =
        age -> age >= 18;

System.out.println(isAdult.test(20));
```

Common Uses:

* Validation
* Filtering
* Streams API

---

# Consumer<T>

Purpose:

Consumes data.

Method:

```java
void accept(T t);
```

Input:

One

Output:

Nothing

Example:

```java
Consumer<String> printer =
        System.out::println;

printer.accept("Java");
```

Common Uses:

* Printing
* Logging
* Saving Data
* Sending Notifications

---

# Supplier<T>

Purpose:

Supplies data.

Method:

```java
T get();
```

Input:

None

Output:

One Object

Example:

```java
Supplier<String> greeting =
        () -> "Welcome";

System.out.println(greeting.get());
```

Common Uses:

* UUID Generation
* Token Generation
* Lazy Initialization
* Default Values

---

# Function<T,R>

Purpose:

Transforms one object into another.

Method:

```java
R apply(T t);
```

Input:

T

Output:

R

Example:

```java
Function<String,Integer> length =
        String::length;

System.out.println(length.apply("Spring"));
```

Common Uses:

* Entity → DTO
* DTO → Entity
* Object Mapping
* Data Transformation

---

# Built-in Functional Interfaces Summary

| Interface     | Input | Output  | Method   | Primary Use    |
| ------------- | ----- | ------- | -------- | -------------- |
| Predicate<T>  | 1     | boolean | test()   | Validation     |
| Consumer<T>   | 1     | void    | accept() | Action         |
| Supplier<T>   | 0     | 1       | get()    | Supply         |
| Function<T,R> | 1     | 1       | apply()  | Transformation |

---

# Method References

Method References were introduced in Java 8.

Purpose:

Provide a shorter syntax when a Lambda simply calls an existing method.

Lambda:

```java
name -> System.out.println(name)
```

Method Reference:

```java
System.out::println
```

Both perform exactly the same work.

---

# Method Reference Operator

```java
::
```

Meaning:

Reference an existing method or constructor.

It does **not** invoke the method immediately.

---

# Types of Method References

## 1. Static Method Reference

Syntax:

```java
ClassName::staticMethod
```

Example:

```java
Math::abs
```

---

## 2. Instance Method Reference of a Particular Object

Syntax:

```java
object::instanceMethod
```

Example:

```java
printer::print
```

---

## 3. Instance Method Reference of an Arbitrary Object of a Particular Type

Syntax:

```java
ClassName::instanceMethod
```

Example:

```java
String::length
```

The object is supplied later by the functional interface.

---

## 4. Constructor Reference

Syntax:

```java
ClassName::new
```

Example:

```java
Supplier<Student> supplier =
        Student::new;
```

---

# Lambda vs Method Reference

| Lambda                       | Method Reference      |
| ---------------------------- | --------------------- |
| `x -> System.out.println(x)` | `System.out::println` |
| `x -> Math.abs(x)`           | `Math::abs`           |
| `s -> s.length()`            | `String::length`      |
| `() -> new Student()`        | `Student::new`        |

Method References improve readability.

They do not introduce new functionality.

---

# Anonymous Class vs Lambda

| Anonymous Class                           | Lambda                                             |
| ----------------------------------------- | -------------------------------------------------- |
| More boilerplate                          | Concise                                            |
| Creates an anonymous implementation class | Provides implementation for a functional interface |
| Can extend a class                        | Cannot extend a class                              |
| Can implement any interface               | Works only with functional interfaces              |

---

# Lambda vs Method Reference

| Lambda                          | Method Reference                           |
| ------------------------------- | ------------------------------------------ |
| More flexible                   | More concise                               |
| Can contain multiple statements | Must simply delegate to an existing method |
| Can include additional logic    | Cannot add extra logic                     |

---

# Common Beginner Mistakes

### Mistake 1

Thinking Lambda Expressions replace every Anonymous Class.

Wrong.

They replace Anonymous Classes only for Functional Interfaces.

---

### Mistake 2

Thinking Functional Interfaces contain only one method.

Wrong.

They contain only one **abstract** method.

---

### Mistake 3

Thinking `@FunctionalInterface` creates a Functional Interface.

Wrong.

It only validates the interface.

---

### Mistake 4

Trying to replace every Lambda with a Method Reference.

Only Lambdas that directly call an existing method can be replaced.

---

### Mistake 5

Thinking Method References execute immediately.

Wrong.

They only refer to a method.

Execution happens when the functional interface method is invoked.

---

# Java Version Notes

### Java 8

Introduced:

* Lambda Expressions
* Functional Interfaces
* Method References
* `java.util.function`
* Streams API

### Java 9

Functional Interfaces can contain private methods.

---

# Real-World Spring Boot Usage

Predicate:

```java
users.stream()
     .filter(User::isActive);
```

Function:

```java
users.stream()
     .map(User::getName);
```

Consumer:

```java
users.forEach(System.out::println);
```

Constructor Reference:

```java
users.stream()
     .map(UserDTO::new);
```

Comparator:

```java
Comparator.comparing(User::getName);
```

---

# Frequently Asked Interview Questions

### Q1. What is a Lambda Expression?

A concise way to implement a Functional Interface.

---

### Q2. Why were Lambdas introduced?

To reduce boilerplate code and support functional programming.

---

### Q3. What is a Functional Interface?

An interface containing exactly one abstract method.

---

### Q4. Why does a Lambda require a Functional Interface?

Because the compiler must know exactly which abstract method the Lambda implements.

---

### Q5. Can a Functional Interface have default methods?

Yes.

---

### Q6. Can it have static methods?

Yes.

---

### Q7. Can it have private methods?

Yes (Java 9+).

---

### Q8. What does `@FunctionalInterface` do?

It validates that the interface has exactly one abstract method.

---

### Q9. Can every Lambda be replaced by a Method Reference?

No.

Only when the Lambda simply calls an existing method or constructor.

---

### Q10. What are the four built-in Functional Interfaces every Java developer should know?

* Predicate
* Consumer
* Supplier
* Function

---

# Best Practices

* Use `@FunctionalInterface` for custom functional interfaces.
* Prefer Java's built-in functional interfaces before creating your own.
* Use Method References when they improve readability.
* Keep lambda expressions short and focused.
* If a lambda becomes large or contains complex business logic, extract it into a separate method.

---

# Key Takeaways

* Lambda Expressions reduce boilerplate code.
* Lambdas work only with Functional Interfaces.
* Functional Interfaces contain exactly one abstract method.
* `@FunctionalInterface` provides compile-time validation.
* Java provides standard functional interfaces:

  * Predicate
  * Consumer
  * Supplier
  * Function
* Method References are shorthand for simple lambda expressions that directly invoke existing methods.
* These concepts are the foundation of the Streams API and modern Spring Boot development.
