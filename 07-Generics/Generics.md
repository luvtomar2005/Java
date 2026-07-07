# Java Generics - Complete Revision Notes

## What are Generics?

Generics allow classes, interfaces, and methods to work with different data types while maintaining compile-time type safety.

Introduced in **Java 5**.

Example:

```java
ArrayList<String> names = new ArrayList<>();
```

---

# Why Were Generics Introduced?

Before Generics:

* Collections stored `Object`.
* Explicit casting was required.
* Runtime `ClassCastException` was common.
* Code duplication increased.

Generics solve these problems by:

* Providing compile-time type checking.
* Eliminating most explicit casting.
* Increasing code reusability.
* Improving readability.

---

# Generic Class

```java
class Box<T> {

    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```

`T` is a **type parameter** (placeholder for a type).

Common naming conventions:

* `T` → Type
* `E` → Element
* `K` → Key
* `V` → Value
* `U`, `R` → Additional type parameters

---

# Generic Method

```java
public <T> void print(T value) {
    System.out.println(value);
}
```

Important:

* `<T>` appears **before** the return type.
* The type is determined independently for each method call.

---

# Generic Class vs Generic Method

| Generic Class                     | Generic Method                     |
| --------------------------------- | ---------------------------------- |
| Type fixed when object is created | Type inferred for each method call |
| Scope is the whole class          | Scope is only the method           |

---

# Multiple Type Parameters

Example:

```java
class Pair<K, V> {

    private K key;
    private V value;
}
```

Used heavily in:

* `Map<K,V>`
* `HashMap<K,V>`
* `Map.Entry<K,V>`

---

# Bounded Type Parameters

```java
class Calculator<T extends Number> { }
```

Purpose:

Restrict the allowed types.

Allowed:

* Integer
* Double
* Float
* Long
* Short
* Byte

Not Allowed:

* String
* Student
* Employee

Benefits:

* Type safety
* Access to methods defined in the bound (e.g. `doubleValue()`)

Multiple bounds:

```java
<T extends Number & Comparable<T>>
```

---

# Generics and Reference Types

Generics work only with **reference types**.

Illegal:

```java
List<int>
```

Correct:

```java
List<Integer>
```

Wrapper Classes:

| Primitive | Wrapper   |
| --------- | --------- |
| int       | Integer   |
| double    | Double    |
| char      | Character |
| boolean   | Boolean   |
| long      | Long      |
| float     | Float     |
| short     | Short     |
| byte      | Byte      |

---

# Autoboxing

Automatic conversion:

```java
list.add(10);
```

becomes conceptually:

```java
list.add(Integer.valueOf(10));
```

---

# Unboxing

Automatic conversion:

```java
int x = integerObject;
```

becomes conceptually:

```java
int x = integerObject.intValue();
```

---

# Comparable

Package:

```text
java.lang
```

Purpose:

Defines the **natural ordering** of objects.

Method:

```java
compareTo(T other)
```

Return values:

* Negative → Current object comes first.
* Zero → Equal.
* Positive → Current object comes later.

Use Comparable when there is one obvious natural ordering.

Examples:

* Roll Number
* Employee ID
* Account Number

Prefer:

```java
Integer.compare(a, b)
```

instead of subtraction.

---

# Comparator

Package:

```text
java.util
```

Purpose:

Defines custom ordering outside the class.

Method:

```java
compare(T o1, T o2)
```

Use Comparator when multiple sorting rules are needed.

Examples:

* Sort by name
* Sort by salary
* Sort by marks
* Sort by joining date

Comparator is a functional interface.

---

# Comparable vs Comparator

| Comparable                   | Comparator                    |
| ---------------------------- | ----------------------------- |
| `java.lang`                  | `java.util`                   |
| Natural ordering             | Custom ordering               |
| One sorting rule             | Multiple sorting rules        |
| Implemented inside the class | Implemented outside the class |
| `compareTo()`                | `compare()`                   |

---

# Wildcards

## Unbounded Wildcard

```java
List<?>
```

Represents a list of an unknown type.

* Safe to read as `Object`.
* Cannot add elements (except `null`).

---

## Upper Bounded Wildcard

```java
List<? extends Number>
```

Meaning:

A list whose element type is `Number` or any subclass of `Number`.

Good for reading.

Cannot safely add elements.

---

## Lower Bounded Wildcard

```java
List<? super Integer>
```

Meaning:

A list whose element type is `Integer` or any superclass of `Integer`.

Safe to add `Integer`.

Reading returns `Object`.

---

# PECS Principle

**Producer Extends, Consumer Super**

* Use `extends` when the collection produces data.
* Use `super` when the collection consumes data.

---

# Type Erasure

Type erasure removes generic type information after compile-time type checking.

Example:

```java
Box<String>
```

becomes conceptually:

```java
Box
```

at runtime.

Reasons:

* Backward compatibility with pre-Java 5 bytecode.
* No separate class for every generic type.

Consequences:

* Cannot create `new T()`.
* Cannot use `instanceof List<String>`.
* Runtime class information does not retain generic type arguments.

---

# Best Practices

* Always use generics instead of raw types.
* Use meaningful type parameter names (`T`, `E`, `K`, `V`).
* Prefer `Integer.compare()`, `Long.compare()`, `Double.compare()` over subtraction.
* Use Comparable for one natural ordering.
* Use Comparator for multiple sorting strategies.
* Use bounded generics only when restrictions are necessary.
* Remember PECS when working with wildcards.

---

# Common Interview Questions

1. Why were Generics introduced?
2. What is type safety?
3. Difference between Generic Class and Generic Method?
4. Why can't Generics use primitive types?
5. What are bounded type parameters?
6. Difference between Comparable and Comparator?
7. What are wildcards?
8. Explain PECS.
9. What is Type Erasure?
10. Why can't we create `new T()`?
11. Why is `instanceof List<String>` illegal?
12. Why does `Box<String>.getClass() == Box<Integer>.getClass()` return `true`?

---

# Key Takeaways

* Generics provide compile-time type safety.
* They eliminate most explicit casting.
* Generic code is reusable and expressive.
* Wrapper classes enable generics to work with primitive values through autoboxing.
* Comparable defines one natural order; Comparator supports many custom orders.
* Wildcards control flexibility in APIs (`?`, `? extends`, `? super`).
* PECS is the rule to remember for wildcards.
* Type Erasure removes generic type information after compilation while preserving backward compatibility.
