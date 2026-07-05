# Java Strings, StringBuilder, Text Blocks & Formatting

> These topics are fundamental to Java programming and are frequently used in backend development, logging, REST APIs, SQL query generation, JSON creation, file handling, and interview coding questions.

---

# Table of Contents

1. Introduction
2. String
3. String Pool
4. Immutability
5. String Methods
6. StringBuilder
7. String vs StringBuilder
8. StringBuffer
9. Formatting Strings
10. Text Blocks
11. Escape Sequences
12. Best Practices
13. Interview Questions
14. Summary

---

# 1. Introduction

Almost every Java application works with text.

Examples include:

* User names
* Passwords
* Email addresses
* JSON responses
* SQL queries
* Log messages
* File names
* URLs
* API responses

Java provides multiple classes to work with text efficiently.

The most important are:

* String
* StringBuilder
* StringBuffer

---

# 2. String

A **String** is a sequence of characters.

Example:

```text
Hello

Java

Spring Boot
```

Strings are objects in Java.

Even though they look like primitive values, they are instances of the `String` class.

Example:

```text
"Hello"
```

is actually a `String` object.

---

# Why is String Important?

Almost every Java program uses Strings.

Examples:

* Reading user input
* Displaying output
* API communication
* Database queries
* JSON/XML processing

---

# 3. String Pool

Java optimizes memory using the **String Pool**.

Suppose two variables contain the same literal:

```text
"Java"

"Java"
```

Instead of creating two separate objects,

Java stores only one object in the String Pool and both references point to it.

Benefits:

* Saves memory
* Improves performance
* Avoids duplicate String objects

---

# 4. String Immutability

One of the most important interview concepts.

A String is **immutable**.

Immutable means:

> Once a String object is created, its value cannot be changed.

Example:

```text
String = "Java"

↓

Change to

↓

"Python"
```

Java does **not** modify the existing object.

Instead:

* A new String object is created.
* The reference points to the new object.
* The old object remains unchanged until garbage collected.

---

# Why are Strings Immutable?

Immutability provides several advantages:

* Security
* Thread Safety
* Better Performance
* String Pool Optimization
* Reliable Hash Codes

Examples:

* File paths
* Database URLs
* Network addresses
* Usernames
* Passwords

If Strings were mutable, changing one reference could unexpectedly affect others using the same pooled String.

---

# 5. Common String Operations

The `String` class provides many useful methods.

Commonly used methods include:

* length()
* charAt()
* substring()
* indexOf()
* contains()
* startsWith()
* endsWith()
* replace()
* replaceAll()
* toUpperCase()
* toLowerCase()
* trim()
* strip()
* split()
* concat()
* equals()
* equalsIgnoreCase()
* isEmpty()
* isBlank()

Interview Tip:

Know what these methods do conceptually, even if you don't memorize every method.

---

# 6. StringBuilder

Problem:

Since Strings are immutable,

repeated concatenation creates many temporary objects.

Example conceptually:

```text
"Java"

↓

"Java Programming"

↓

"Java Programming Language"

↓

Many temporary objects
```

This wastes:

* Memory
* CPU time

To solve this,

Java provides **StringBuilder**.

---

# What is StringBuilder?

`StringBuilder` is a mutable sequence of characters.

Mutable means:

The same object can be modified repeatedly.

Instead of creating a new object,

the existing object is updated.

---

# Advantages of StringBuilder

* Faster than String for repeated modifications
* Less memory usage
* No unnecessary object creation
* Ideal inside loops

Common operations:

* append()
* insert()
* delete()
* replace()
* reverse()
* capacity()
* length()

---

# Internal Working

String

```text
Original Object

↓

New Object

↓

New Object

↓

New Object
```

StringBuilder

```text
One Object

↓

Modified

↓

Modified

↓

Modified
```

---

# 7. String vs StringBuilder

| String                             | StringBuilder                     |
| ---------------------------------- | --------------------------------- |
| Immutable                          | Mutable                           |
| Creates new object on modification | Modifies existing object          |
| Slower for repeated changes        | Faster for repeated changes       |
| Thread-safe due to immutability    | Not thread-safe                   |
| Uses String Pool (for literals)    | Does not use String Pool          |
| Best for read-only text            | Best for frequently changing text |

---

# 8. StringBuffer

`StringBuffer` is similar to `StringBuilder`.

Difference:

It is **thread-safe**.

This means multiple threads can safely modify the same object.

Because of synchronization,

it is slower than `StringBuilder`.

---

# StringBuilder vs StringBuffer

| StringBuilder                             | StringBuffer                                                            |
| ----------------------------------------- | ----------------------------------------------------------------------- |
| Faster                                    | Slower                                                                  |
| Not synchronized                          | Synchronized                                                            |
| Not thread-safe                           | Thread-safe                                                             |
| Preferred in single-threaded applications | Used in multithreaded environments when shared mutable text is required |

---

# 9. Formatting Strings

Java provides formatted output similar to C's `printf`.

Formatting makes output cleaner and more readable.

Common formatting options include:

* `%s` → String
* `%d` → Integer
* `%f` → Floating-point number
* `%c` → Character
* `%b` → Boolean
* `%n` → Platform-independent newline
* `%%` → Percent sign

Formatting can also control:

* Decimal precision
* Alignment
* Field width
* Padding

Common APIs:

* `System.out.printf()`
* `String.format()`
* `formatted()` (Java 15+)

Formatting is widely used for:

* Reports
* Logs
* Console applications
* Receipts
* Tables

---

# 10. Text Blocks

Introduced as a standard feature in **Java 15**.

A Text Block allows writing multi-line strings without excessive escape characters.

Instead of manually adding newline characters (`\n`) and escaping quotes,

the text can be written almost exactly as it should appear.

Benefits:

* More readable
* Easier maintenance
* Better formatting
* Ideal for JSON
* Ideal for SQL
* Ideal for HTML
* Ideal for XML

Example use cases:

* SQL queries
* JSON responses
* HTML templates
* API payloads
* Email templates

---

# Why Were Text Blocks Introduced?

Before Text Blocks,

large Strings became difficult to read because of:

* Escape characters
* String concatenation
* Newline characters

Text Blocks solve these readability problems.

---

# 11. Escape Sequences

Escape sequences allow special characters inside Strings.

Common escape sequences:

| Escape | Meaning         |
| ------ | --------------- |
| `\n`   | New Line        |
| `\t`   | Tab             |
| `\"`   | Double Quote    |
| `\'`   | Single Quote    |
| `\\`   | Backslash       |
| `\r`   | Carriage Return |
| `\b`   | Backspace       |

Text Blocks reduce the need for many of these escapes in multi-line content.

---

# 12. Best Practices

### Use String

When:

* Text rarely changes
* Configuration values
* Constants
* User names
* URLs
* API endpoints

---

### Use StringBuilder

When:

* Concatenating inside loops
* Building JSON
* Building SQL queries
* Generating reports
* Constructing large text

---

### Use StringBuffer

Only when:

* Multiple threads modify the same mutable text
* Thread safety is required

---

### Use Text Blocks

When writing:

* SQL
* JSON
* HTML
* XML
* Multi-line templates

---

### Use Formatting

When displaying:

* Tables
* Reports
* Currency
* Console output
* Logs

---

# 13. Interview Questions

## What is a String?

A String is an immutable object representing a sequence of characters.

---

## Why is String immutable?

To provide:

* Security
* Thread safety
* Reliable hashing
* String Pool optimization
* Better overall performance characteristics

---

## What is the String Pool?

A special memory area where identical String literals are shared to reduce memory usage.

---

## Difference between String and StringBuilder?

String is immutable.

StringBuilder is mutable and faster for repeated modifications.

---

## Difference between StringBuilder and StringBuffer?

StringBuilder is faster but not synchronized.

StringBuffer is synchronized and thread-safe.

---

## When should StringBuilder be used?

Whenever repeated String modification is required, especially inside loops.

---

## What are Text Blocks?

Text Blocks are multi-line String literals introduced in Java 15 to improve readability and reduce the need for escape sequences.

---

## What is String Formatting?

Formatting allows data to be displayed in a controlled and readable format using format specifiers.

---

## Which class is used most in backend development?

* String
* StringBuilder
* Text Blocks (for SQL, JSON, HTML)
* String formatting for logging and reports

---

# 14. Summary

* String is immutable.
* String literals are stored in the String Pool.
* Modifying a String creates a new object.
* StringBuilder is mutable and ideal for repeated modifications.
* StringBuffer is synchronized and thread-safe.
* Text Blocks simplify multi-line Strings.
* Formatting improves readability of output.
* Choose the right class based on performance, readability, and thread-safety requirements.

---

# Interview Revision (30 Seconds)

* **String** → Immutable sequence of characters.
* **String Pool** → Shared memory for String literals.
* **StringBuilder** → Mutable, fast, not thread-safe.
* **StringBuffer** → Mutable, synchronized, thread-safe.
* **Text Blocks** → Multi-line Strings introduced in Java 15.
* **Formatting** → Produces readable, structured output using format specifiers.

> **Performance Rule:** Use `String` for fixed or infrequently modified text, `StringBuilder` for repeated modifications, and `StringBuffer` only when multiple threads must safely modify the same text.
