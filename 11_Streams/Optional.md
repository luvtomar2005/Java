# Streams API - Complete Revision Notes

## What is a Stream?

A Stream is a pipeline used to process data from collections, arrays, files, or other data sources in a declarative way. A Stream **does not store data**; it processes existing data.

```
Collection
     ↓
  Stream
     ↓
Operations
     ↓
Result
```

---

# Why Streams were introduced

Before Java 8, collection processing required explicit loops, temporary collections, and mutable variables.

Streams provide:

* Cleaner code
* Functional programming style
* Internal iteration
* Lazy evaluation
* Easy parallel processing
* Better readability

---

# Stream Pipeline

Every Stream has three stages:

```
Source
    ↓
Intermediate Operations
    ↓
Terminal Operation
```

Example:

```java
employees.stream()
         .filter(Employee::isActive)
         .map(Employee::getName)
         .toList();
```

---

# Creating Streams

### From Collection

```java
list.stream()
```

### From Array

```java
Arrays.stream(array)
```

### From Values

```java
Stream.of(...)
```

### Empty Stream

```java
Stream.empty()
```

### Infinite Streams

```java
Stream.generate(...)
Stream.iterate(...)
```

### Primitive Streams

```java
IntStream
LongStream
DoubleStream
```

---

# Intermediate Operations

Intermediate operations are:

* Lazy
* Return another Stream
* Do not execute immediately

## filter()

Keeps only matching elements.

Uses:

```
Predicate<T>
```

Returns:

```
Stream<T>
```

---

## map()

Transforms one object into another.

Uses:

```
Function<T,R>
```

Returns:

```
Stream<R>
```

---

## flatMap()

Transforms each element into another Stream and flattens them.

Example:

```
Stream<List<String>>

↓

Stream<String>
```

---

## distinct()

Removes duplicate elements.

Uses internally:

* equals()
* hashCode()

---

## sorted()

Sorts stream elements.

Versions:

```java
sorted()

sorted(Comparator)
```

Uses:

* Comparable
* Comparator

---

## peek()

Used mainly for debugging.

Uses:

```
Consumer<T>
```

Does not modify elements.

---

## limit()

Keeps first N elements.

Useful for:

* Top records
* Infinite streams
* Pagination

---

## skip()

Ignores first N elements.

Useful for:

* Pagination
* Offset processing

---

# Terminal Operations

Terminal operations trigger execution.

After a terminal operation, the Stream cannot be reused.

## forEach()

Consumes elements.

Returns:

```
void
```

---

## collect()

Collects Stream into a collection.

Common collectors:

* toList()
* toSet()
* toMap()
* groupingBy()
* joining()

---

## toList()

Modern Java (Java 16+).

Returns an unmodifiable List.

---

## count()

Returns number of elements.

---

## reduce()

Combines many values into one.

Examples:

* Sum
* Product
* Maximum
* String concatenation

---

## min()

Returns smallest element.

Returns:

```
Optional<T>
```

---

## max()

Returns largest element.

Returns:

```
Optional<T>
```

---

## findFirst()

Returns first element.

Returns:

```
Optional<T>
```

---

## findAny()

Useful mainly in parallel streams.

Returns:

```
Optional<T>
```

---

## anyMatch()

Returns true if at least one element matches.

---

## allMatch()

Returns true if every element matches.

---

## noneMatch()

Returns true if no element matches.

---

# Stateful vs Stateless Operations

## Stateless

* filter()
* map()
* flatMap()
* peek()

Each element is processed independently.

## Stateful

* sorted()
* distinct()

Need information about multiple elements.

---

# Lazy Evaluation

Intermediate operations never execute until a terminal operation is encountered.

```
stream()

↓

filter()

↓

map()

↓

Nothing Happens

↓

collect()

↓

Execution Starts
```

---

# Functional Interfaces Used

| Operation | Functional Interface |
| --------- | -------------------- |
| filter()  | Predicate            |
| map()     | Function             |
| flatMap() | Function             |
| peek()    | Consumer             |
| sorted()  | Comparator           |
| forEach() | Consumer             |

---

# Common Interview Questions

### Difference between Stream and Collection

Collection stores data.

Stream processes data.

---

### Can a Stream be reused?

No.

Once a terminal operation executes, the Stream is consumed.

---

### Difference between map() and flatMap()

map()

```
Employee

↓

String
```

flatMap()

```
Department

↓

List<Employee>

↓

Employee
```

---

### Difference between filter() and map()

filter()

* Removes elements

map()

* Transforms elements

---

### Difference between distinct() and sorted()

distinct()

* Removes duplicates

sorted()

* Changes order

---

### Difference between peek() and forEach()

peek()

* Intermediate
* Mainly debugging

forEach()

* Terminal
* Consumes Stream

---

### Difference between skip() and limit()

skip()

* Ignores first N

limit()

* Keeps first N

---

# Complexity

| Operation | Complexity       |
| --------- | ---------------- |
| filter    | O(n)             |
| map       | O(n)             |
| distinct  | O(n) average     |
| sorted    | O(n log n)       |
| limit     | O(min(n, limit)) |
| skip      | O(n)             |

---

# Best Practices

* Prefer Streams for collection processing.
* Keep pipelines readable.
* Avoid side effects inside Stream operations.
* Prefer `toList()` in Java 16+.
* Use `Comparator.comparingInt()` for primitive numeric sorting.
* Do not reuse consumed Streams.

---

# Backend Usage Frequency

⭐⭐⭐⭐⭐

* filter()
* map()
* collect()
* toList()

⭐⭐⭐⭐

* sorted()
* distinct()
* count()

⭐⭐⭐

* reduce()
* findFirst()
* anyMatch()

⭐⭐

* peek()
* findAny()
* noneMatch()

---

# One-Line Memory Trick

```
Create Stream
      ↓
Filter Data
      ↓
Transform Data
      ↓
Sort / Remove Duplicates
      ↓
Limit / Skip (Optional)
      ↓
Collect or Consume
```
