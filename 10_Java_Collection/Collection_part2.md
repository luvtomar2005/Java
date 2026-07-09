# Java Collections Framework (Part 2)

# Set, HashSet, LinkedHashSet, TreeSet, equals(), hashCode(), Comparable & Comparator

> **Revision Notes for Interviews, Online Assessments & Backend Development**

---

# Table of Contents

1. Set Interface
2. HashSet
3. equals() and hashCode()
4. LinkedHashSet
5. TreeSet
6. Comparable vs Comparator
7. Comparison Tables
8. Interview Questions
9. Best Practices
10. Quick Revision Sheet

---

# 1. Set Interface

## Package

```java
java.util.Set
```

## Hierarchy

```text
Iterable
    ↑
Collection
    ↑
Set
```

## Why Java Needed Set

`List` allows duplicate elements.

Example

```text
Java
Python
Java
```

Sometimes duplicates should not exist.

Examples:

* Usernames
* Email addresses
* Employee IDs
* Roll Numbers
* Aadhaar Numbers

Java introduced **Set** to guarantee uniqueness.

---

## Characteristics

* No duplicate elements
* No index
* No `get(index)`
* Extends `Collection`
* Different implementations provide different ordering behavior

---

## Major Implementations

```text
Set
 │
 ├── HashSet
 ├── LinkedHashSet
 └── TreeSet
```

---

# 2. HashSet

## Package

```java
java.util.HashSet
```

## Internal Working

`HashSet` internally uses

```java
HashMap<E, Object>
```

Elements are stored as **keys**.

Values are dummy objects.

Conceptually

```text
Java    → PRESENT
Python  → PRESENT
MongoDB → PRESENT
```

---

## Duplicate Detection

When adding an element

```java
set.add("Java");
```

Java performs

```text
hashCode()

↓

Bucket

↓

equals()

↓

Already Exists?

↓

Reject Duplicate
```

---

## Hash Collision

Different objects may produce the same bucket.

Example

```text
Apple

↓

Bucket 4
```

```text
Mango

↓

Bucket 4
```

Java then calls

```java
equals()
```

to determine whether they are actually equal.

---

## Time Complexity

| Operation  | Average Complexity |
| ---------- | ------------------ |
| add()      | O(1)               |
| remove()   | O(1)               |
| contains() | O(1)               |
| iteration  | O(n)               |

---

## Characteristics

* Unique elements
* Fast lookup
* No guaranteed iteration order
* Allows one `null`
* Uses hashing

---

# 3. equals() and hashCode()

One of the most important Java interview topics.

---

## == vs equals()

### ==

Compares references.

```java
a == b
```

Checks

> Are both references pointing to the same object?

---

### equals()

Compares logical equality.

Example

Two students

```text
ID =101

Name=Luv
```

Even if stored in different objects,

they may represent the same student.

---

## Default equals()

Inherited from Object.

Conceptually behaves like

```java
return this == obj;
```

Therefore,

without overriding,

objects are compared by reference.

---

## Why Override equals()

To compare object data instead of memory addresses.

Example

```java
Student

id

name
```

Logical equality may depend on

* id
* name

---

## Why Override hashCode()

Hash-based collections use hash codes before calling equals().

If two objects are equal

```java
a.equals(b) == true
```

then

```java
a.hashCode() == b.hashCode()
```

must also be true.

---

## Contract

### Rule 1

Equal objects

↓

Same hash code

---

### Rule 2

Same hash code

↓

Objects may or may not be equal

(Hash Collision)

---

### Rule 3

Unequal objects

↓

Hash codes may be same or different

---

## Modern Implementation

```java
@Override
public int hashCode() {
    return Objects.hash(id, name);
}
```

---

# 4. LinkedHashSet

## Package

```java
java.util.LinkedHashSet
```

## Why Java Needed It

HashSet provides

* uniqueness
* fast lookup

But does **not** preserve insertion order.

Example

Input

```text
Java
Spring
Redis
MongoDB
```

HashSet Output

```text
Redis
Java
MongoDB
Spring
```

Order is unpredictable.

LinkedHashSet solves this.

---

## Internal Working

Internally uses

```java
LinkedHashMap
```

Conceptually

```text
Hash Table

+

Doubly Linked List
```

The hash table provides fast lookup.

The linked list preserves insertion order.

---

## Characteristics

* No duplicates
* Preserves insertion order
* Average O(1) operations
* Slightly higher memory usage than HashSet
* Allows one `null`

---

# 5. TreeSet

## Package

```java
java.util.TreeSet
```

## Hierarchy

```text
Set
 ↑
SortedSet
 ↑
NavigableSet
 ↑
TreeSet
```

---

## Why Java Needed TreeSet

Neither HashSet nor LinkedHashSet keeps elements sorted.

Example

Input

```text
95
78
88
91
65
```

TreeSet Output

```text
65
78
88
91
95
```

---

## Internal Working

TreeSet internally uses a

```text
Red-Black Tree
```

A Red-Black Tree is a self-balancing binary search tree.

Java maintains the balance automatically.

---

## Ordering

TreeSet does **not** use

```java
hashCode()
```

Instead it compares elements using

* Comparable
* Comparator

---

## Time Complexity

| Operation  | Complexity |
| ---------- | ---------- |
| add()      | O(log n)   |
| remove()   | O(log n)   |
| contains() | O(log n)   |
| iteration  | O(n)       |

---

## Characteristics

* Unique elements
* Automatically sorted
* No insertion order
* No hashing for ordering
* Does not allow `null` when using natural ordering

---

# 6. Comparable vs Comparator

These interfaces define **how objects are ordered**.

---

## Comparable

Package

```java
java.lang
```

Method

```java
compareTo()
```

Sorting logic is written **inside the class**.

Example

```java
class Student implements Comparable<Student>
```

Used for the **natural ordering** of objects.

Examples

* Integer
* String
* Double
* LocalDate

Natural order means there is one obvious way to sort the objects.

---

## Comparator

Package

```java
java.util
```

Method

```java
compare()
```

Sorting logic is written **outside the class**.

Example

```java
class SortByMarks implements Comparator<Student>
```

Allows multiple sorting strategies.

Examples

Sort students by

* Name
* Marks
* Age
* Roll Number

without changing the Student class.

---

## Return Values

Both `compareTo()` and `compare()` follow the same rule.

```text
Negative  → First object comes before second

Zero      → Objects are considered equal

Positive  → First object comes after second
```

For a `TreeSet`, a comparison result of **0** means the new element is treated as a duplicate and is not added.

---

## When to Use

Use Comparable

* One natural ordering
* Sorting is part of the class itself

Use Comparator

* Multiple sorting rules
* Cannot modify the original class
* Need flexible sorting

---

# 7. Complete Comparison

## HashSet vs LinkedHashSet vs TreeSet

| Feature            | HashSet  | LinkedHashSet   | TreeSet                       |
| ------------------ | -------- | --------------- | ----------------------------- |
| Duplicates         | ❌        | ❌               | ❌                             |
| Order              | None     | Insertion Order | Sorted                        |
| Internal Structure | HashMap  | LinkedHashMap   | Red-Black Tree                |
| Uses hashCode()    | ✅        | ✅               | ❌ (for ordering)              |
| Uses equals()      | ✅        | ✅               | Comparison decides uniqueness |
| Uses Comparable    | ❌        | ❌               | ✅                             |
| Uses Comparator    | ❌        | ❌               | ✅                             |
| add()              | O(1) avg | O(1) avg        | O(log n)                      |
| contains()         | O(1) avg | O(1) avg        | O(log n)                      |
| Allows null        | One      | One             | No (natural ordering)         |

---

## Comparable vs Comparator

| Feature                | Comparable   | Comparator    |
| ---------------------- | ------------ | ------------- |
| Package                | java.lang    | java.util     |
| Method                 | compareTo()  | compare()     |
| Logic Location         | Inside Class | Outside Class |
| Natural Ordering       | Yes          | No            |
| Multiple Sorting Rules | No           | Yes           |
| Functional Interface   | No           | Yes           |

---

# 8. Frequently Asked Interview Questions

### Difference between HashSet and LinkedHashSet?

HashSet does not guarantee iteration order.

LinkedHashSet preserves insertion order.

---

### Difference between LinkedHashSet and TreeSet?

LinkedHashSet keeps insertion order.

TreeSet keeps sorted order.

---

### Why does HashSet use hashCode()?

To locate the correct bucket quickly.

---

### Why must equals() and hashCode() be overridden together?

Because hash-based collections depend on both methods working consistently.

---

### Does TreeSet use hashCode()?

No.

It uses comparison (`compareTo()` or `Comparator`) to order elements and determine duplicates.

---

### Difference between Comparable and Comparator?

Comparable defines one natural ordering.

Comparator defines multiple custom orderings.

---

### Which Set implementation is fastest?

For average lookup operations:

**HashSet**

---

### Which Set preserves insertion order?

**LinkedHashSet**

---

### Which Set keeps data sorted?

**TreeSet**

---

# 9. Best Practices

✔ Use **HashSet** when

* Order does not matter.
* Fast lookup is required.
* Duplicate prevention is required.

---

✔ Use **LinkedHashSet** when

* Duplicate prevention is required.
* Insertion order must be preserved.

---

✔ Use **TreeSet** when

* Elements must always remain sorted.
* O(log n) performance is acceptable.

---

✔ Override both

```java
equals()
```

and

```java
hashCode()
```

together.

---

✔ Prefer Comparable for one natural ordering.

✔ Prefer Comparator when multiple sorting strategies are needed.

---

# 10. Quick Revision Sheet

## Set

* No duplicates
* No index

---

## HashSet

* HashMap internally
* O(1) average
* No order
* Uses hashCode() + equals()

---

## LinkedHashSet

* LinkedHashMap internally
* Insertion order
* O(1) average

---

## TreeSet

* Red-Black Tree
* Sorted
* O(log n)
* Uses Comparable/Comparator

---

## equals()

Logical equality.

---

## hashCode()

Finds bucket for hash-based collections.

---

## Comparable

Natural ordering.

Method:

```java
compareTo()
```

---

## Comparator

Custom ordering.

Method:

```java
compare()
```

---

# Topics Completed

✅ Set Interface

✅ HashSet

✅ equals()

✅ hashCode()

✅ Hash Collision

✅ LinkedHashSet

✅ TreeSet

✅ Comparable

✅ Comparator

---

# Next Topics

The remaining major topics in the Java Collections Framework are:

* Queue Interface
* PriorityQueue
* Deque Interface
* ArrayDeque 
* Map Interface
* HashMap
* LinkedHashMap
* TreeMap
* WeakHashMap
* IdentityHashMap
* ConcurrentHashMap
* Collections Utility Class
* Immutable Collections (`List.of()`, `Set.of()`, `Map.of()`)
