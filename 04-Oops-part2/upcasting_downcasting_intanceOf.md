# Upcasting, Downcasting & instanceof in Java

> **Prerequisites**
>
> Before learning this topic, you should already understand:
>
> * Inheritance
> * Method Overriding
> * Runtime Polymorphism

---

# What Problem Does This Topic Solve?

Suppose we have the following hierarchy:

```text
                Movie
                  ▲
                  │
    --------------------------------
    │              │              │
Adventure       Comedy      ScienceFiction
```

Every child class **IS-A** `Movie`.

Java allows us to store any child object inside a parent reference.

Example:

```java
Movie movie = new Adventure("Jaws");
```

But later we may want to use methods that exist only in `Adventure`.

This introduces two important concepts:

* Upcasting
* Downcasting

---

# Upcasting

## Definition

**Upcasting means storing a child object inside a parent reference.**

Example:

```java
Movie movie = new Adventure("Jaws");
```

Read it in English:

> Adventure **IS-A** Movie.

Therefore Java allows:

```text
Adventure Object
        │
        ▼
Movie Reference
```

---

## Why is it called Upcasting?

Inheritance hierarchy:

```text
              Movie
                ▲
                │
          Adventure
```

The object is being referred to by a type higher in the inheritance hierarchy.

Hence the name **Upcasting**.

---

## Is Upcasting Automatic?

Yes.

No cast is required.

```java
Adventure adventure = new Adventure("Jaws");

Movie movie = adventure;
```

Java performs the conversion automatically because every Adventure is also a Movie.

This is called **Implicit Upcasting**.

---

## Memory Diagram

```java
Movie movie = new Adventure("Jaws");
```

```text
STACK

movie
   │
   ▼

HEAP

Adventure Object
```

Important:

* Reference Type = Movie
* Actual Object = Adventure

The object never changes.

Only the reference type changes.

---

## What Can Be Accessed After Upcasting?

Example:

```java
class Movie {

    void watchMovie() {}
}

class Adventure extends Movie {

    void watchAdventure() {}
}
```

After upcasting:

```java
Movie movie = new Adventure("Jaws");
```

Allowed:

```java
movie.watchMovie();
```

Not Allowed:

```java
movie.watchAdventure();
```

Reason:

The compiler only looks at the **reference type**, which is `Movie`.

Since `Movie` does not contain `watchAdventure()`, compilation fails.

---

## Why Does Java Restrict This?

Imagine:

```java
Movie movie = new Comedy("Airplane");
```

If Java allowed:

```java
movie.watchAdventure();
```

What should happen?

A Comedy movie does not have an Adventure-specific method.

To keep the language type-safe, Java only allows methods declared in the reference type.

---

# Why is Upcasting Useful?

Without upcasting:

```java
Adventure adventure = new Adventure("Jaws");
Comedy comedy = new Comedy("Airplane");
ScienceFiction sciFi = new ScienceFiction("Avatar");
```

Every variable has a different type.

With upcasting:

```java
Movie movie;

movie = new Adventure("Jaws");
movie = new Comedy("Airplane");
movie = new ScienceFiction("Avatar");
```

One reference can work with every movie type.

This is the foundation of runtime polymorphism.

---

# Downcasting

## Definition

**Downcasting means converting a parent reference back into its original child type.**

Example:

```java
Movie movie = new Adventure("Jaws");

Adventure adventure = (Adventure) movie;
```

Now we can call:

```java
adventure.watchAdventure();
```

---

## Why is it called Downcasting?

Hierarchy:

```text
            Movie
              ▲
              │
        Adventure
```

The conversion moves downward in the inheritance tree.

Hence the name **Downcasting**.

---

## Is Downcasting Automatic?

No.

Java requires an explicit cast.

Example:

```java
Adventure adventure = (Adventure) movie;
```

The cast tells Java:

> "I know this Movie reference is actually pointing to an Adventure object."

---

## Why Doesn't Java Perform It Automatically?

Suppose:

```java
Movie movie = new Comedy("Airplane");
```

If Java automatically converted it into:

```java
Adventure adventure = movie;
```

the program would become incorrect because a Comedy is not an Adventure.

Therefore Java forces the programmer to perform an explicit cast.

---

## Memory Diagram

```java
Movie movie = new Adventure("Jaws");

Adventure adventure = (Adventure) movie;
```

```text
STACK

movie ----------------------+
                            |
adventure ------------------+
                            |
                            ▼

HEAP

Adventure Object
```

Both references point to the **same object**.

No new object is created.

---

# Safe Downcasting

```java
Movie movie = new Adventure("Jaws");

Adventure adventure = (Adventure) movie;
```

Actual object:

```text
Adventure
```

Cast:

```text
Movie → Adventure
```

Result:

Successful.

---

# Unsafe Downcasting

```java
Movie movie = new Comedy("Airplane");

Adventure adventure = (Adventure) movie;
```

Actual object:

```text
Comedy
```

Requested cast:

```text
Adventure
```

These types are unrelated.

Runtime Result:

```text
ClassCastException
```

---

# ClassCastException

Definition:

An exception thrown when the JVM discovers that the actual object cannot be converted into the requested type.

Example:

```java
Movie movie = new Comedy("Airplane");

Adventure adventure = (Adventure) movie;
```

Output:

```text
Exception in thread "main"
java.lang.ClassCastException
```

The compiler cannot detect this because the reference type is `Movie`.

Only the JVM knows the actual object during execution.

---

# Compiler vs JVM

## During Upcasting

Compiler:

* Checks inheritance relationship.
* Allows conversion automatically.

JVM:

* No runtime risk.

---

## During Downcasting

Compiler:

* Allows the cast because inheritance exists.

JVM:

* Checks the actual object.

If the object is not of the requested type:

```text
ClassCastException
```

---

# Runtime Polymorphism Connection

Example:

```java
Movie movie = new Adventure("Jaws");

movie.watchMovie();
```

Reference Type:

```text
Movie
```

Actual Object:

```text
Adventure
```

The compiler checks:

> Does Movie contain watchMovie()?

Yes.

Compilation succeeds.

The JVM checks:

> Which object does movie actually point to?

Answer:

Adventure

Therefore:

```java
Adventure.watchMovie()
```

executes.

---

# instanceof Operator

## Why Do We Need It?

Downcasting is not always safe.

Before casting, Java provides a way to verify the object's runtime type.

Example:

```java
if (movie instanceof Adventure) {

    Adventure adventure = (Adventure) movie;

    adventure.watchAdventure();
}
```

Now the cast only happens when the object is actually an Adventure.

---

## Syntax

```java
reference instanceof Type
```

Returns:

* true
* false

---

## Example

```java
Movie movie = new Adventure("Jaws");

System.out.println(movie instanceof Adventure);
```

Output:

```text
true
```

---

Another example:

```java
Movie movie = new Comedy("Airplane");

System.out.println(movie instanceof Adventure);
```

Output:

```text
false
```

---

## What Does instanceof Check?

It checks the **runtime type of the actual object**, not the reference type.

Example:

```java
Movie movie = new Comedy("Airplane");
```

Reference:

```text
Movie
```

Object:

```text
Comedy
```

Expression:

```java
movie instanceof Comedy
```

returns:

```text
true
```

because the object is actually a Comedy.

---

# Pattern Matching (Java 16+)

Traditional approach:

```java
if (movie instanceof Comedy) {

    Comedy comedy = (Comedy) movie;

    comedy.watchComedy();
}
```

Modern Java:

```java
if (movie instanceof Comedy comedy) {

    comedy.watchComedy();
}
```

The cast is performed automatically.

Cleaner and safer.

---

# Real-World Backend Example

Imagine a payment system.

```text
PaymentMethod
       ▲
----------------------------
│          │              │
UPI      CreditCard     Wallet
```

Every payment method implements:

```java
pay();
```

Sometimes a payment type has additional functionality.

Before using that functionality, you verify the runtime type.

```java
if (payment instanceof CreditCard card) {

    card.enableEMI();
}
```

This is a common enterprise programming pattern.

---

# Common Beginner Mistakes

## Mistake 1

Thinking:

```java
Movie movie = new Adventure("Jaws");
```

creates a Movie object.

Wrong.

It creates an Adventure object.

Only the reference type is Movie.

---

## Mistake 2

Thinking upcasting changes the object.

Wrong.

The object never changes.

Only the reference type changes.

---

## Mistake 3

Thinking downcasting creates another object.

Wrong.

Both references point to the same object.

---

## Mistake 4

Downcasting without checking.

```java
Adventure adventure = (Adventure) movie;
```

Always verify with `instanceof` when the runtime type is uncertain.

---

# Comparison Table

| Upcasting                         | Downcasting                     |
| --------------------------------- | ------------------------------- |
| Child → Parent                    | Parent → Child                  |
| Automatic                         | Explicit                        |
| Safe                              | Can fail                        |
| No cast required                  | Cast required                   |
| Enables runtime polymorphism      | Accesses child-specific methods |
| Never throws `ClassCastException` | May throw `ClassCastException`  |

---

# Interview Questions

### What is Upcasting?

Storing a child object inside a parent reference.

---

### What is Downcasting?

Converting a parent reference back into its child type using an explicit cast.

---

### Why is Upcasting safe?

Because every child object is also an instance of its parent.

---

### Why is Downcasting risky?

Because the parent reference may point to a different child object.

---

### Why do we use instanceof?

To verify the runtime type before performing a downcast.

---

### Does instanceof check the reference type?

No.

It checks the runtime type of the actual object.

---

### Can Upcasting fail?

No.

---

### Can Downcasting fail?

Yes.

It may throw `ClassCastException`.

---

# Revision Mind Map

```text
Inheritance
      │
      ▼
Upcasting
(Child → Parent)
      │
      ▼
Runtime Polymorphism
      │
      ▼
Need Child-Specific Method
      │
      ▼
Downcasting
(Parent → Child)
      │
      ▼
Unsafe?
      │
      ▼
Use instanceof
      │
      ▼
Safe Downcasting
```

# Final Takeaways

* Upcasting allows one parent reference to refer to many child objects.
* Runtime polymorphism works because of upcasting and method overriding.
* Downcasting gives access to child-specific behavior.
* Downcasting should be used carefully because it can fail at runtime.
* `instanceof` is the safe way to verify an object's runtime type before downcasting.
* The compiler checks the **reference type**.
* The JVM works with the **actual object**.


Upcasting is always safe because every child object is also an instance of its parent. For example, every Dog is an Animal, so a Dog object can always be stored in an Animal reference. Downcasting is risky because a parent reference can point to different child objects. If we try to cast it to the wrong child type, the JVM throws a ClassCastException. Therefore, downcasting should be done only when we're sure of the runtime type, usually by checking with instanceof.