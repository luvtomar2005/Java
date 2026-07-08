# Java Collections Framework (Part 1)

## Complete Revision Notes (Collection → Iterable → Iterator → List → ArrayList → LinkedList)

> **Target Audience:** Java Interviews, Online Assessments, Spring Boot Backend Development

---

# Table of Contents

1. Why Collections Framework?
2. Collection vs Collections vs Collections Framework
3. Collection Interface
4. Iterable
5. Iterator
6. List Interface
7. ArrayList
8. ConcurrentModificationException
9. LinkedList
10. ArrayList vs LinkedList
11. Time Complexity Cheat Sheet
12. Interview Questions
13. Best Practices
14. Key Takeaways

---

# 1. Why Java Needed the Collections Framework

## Problem with Arrays

Arrays have several limitations:

* Fixed size
* Manual resizing
* Difficult insertion
* Difficult deletion
* Limited utility methods

Example:

```java
int[] numbers = new int[5];
```

If the array becomes full:

* Create a larger array
* Copy all elements
* Replace the old array

This is inefficient.

---

## Java's Solution

The Java Collections Framework (JCF) provides:

* Dynamic size
* Standard interfaces
* Reusable data structures
* Sorting algorithms
* Searching utilities
* Better maintainability

---

# 2. Collection vs Collections vs Collections Framework

## Collection

* Interface
* Root interface for most collections
* Defines common operations

Examples:

* add()
* remove()
* contains()
* size()
* clear()

---

## Collections

* Utility class
* Contains only static helper methods

Examples:

```java
Collections.sort(list);

Collections.reverse(list);

Collections.max(list);

Collections.shuffle(list);
```

---

## Collections Framework

Complete architecture consisting of:

* Interfaces
* Implementations
* Algorithms
* Utility classes

---

# 3. Collection Interface

Package

```java
java.util.Collection
```

Root hierarchy:

```text
Iterable
    ↑
Collection
 ├── List
 ├── Set
 └── Queue
```

Collection provides the common contract for storing groups of objects.

---

## Common Methods

```java
add(E e)

remove(Object o)

contains(Object o)

size()

isEmpty()

clear()

iterator()

toArray()

addAll()

removeAll()

retainAll()

containsAll()
```

---

## Important Interview Point

Collection is an interface.

Cannot create object.

Wrong:

```java
Collection<String> c = new Collection<>();
```

Correct:

```java
Collection<String> c = new ArrayList<>();
```

---

# 4. Iterable

Package

```java
java.lang.Iterable
```

Method

```java
Iterator<T> iterator();
```

Purpose:

Provides a standard way to traverse collections.

---

## Why Collection extends Iterable?

So every collection can be traversed using:

```java
for(String item : collection)
```

Enhanced for loop works because of Iterable.

---

# 5. Iterator

Package

```java
java.util.Iterator
```

Methods

```java
hasNext()

next()

remove()
```

---

## Internal Working

Iterator maintains:

* Cursor position
* Expected modification count

---

## next()

Does two things:

* Returns current element
* Moves cursor forward

---

## hasNext()

Checks whether another element exists.

Always use:

```java
while(iterator.hasNext())
```

before calling

```java
next()
```

---

## remove()

Safe way to remove elements during iteration.

Correct:

```java
iterator.remove();
```

Wrong:

```java
list.remove(element);
```

inside iteration.

---

# 6. List Interface

Package

```java
java.util.List
```

Hierarchy

```text
Collection
      ↑
     List
```

List guarantees:

* Ordered collection
* Duplicate elements allowed
* Index-based access

---

## List Methods

```java
get()

set()

add(index)

remove(index)

indexOf()

lastIndexOf()

subList()

listIterator()
```

---

# List Characteristics

✔ Maintains insertion order

✔ Allows duplicates

✔ Supports indexing

---

# 7. ArrayList

Package

```java
java.util.ArrayList
```

Implements

```text
List
```

---

## Internal Structure

Internally uses:

```java
Object[] elementData;
```

ArrayList is basically a dynamic array.

---

## Why ArrayList Exists

Solves array limitations.

Provides:

* Automatic resizing
* Dynamic storage
* Fast random access

---

## Size vs Capacity

### Size

Current number of elements.

Example

```text
Apple
Banana
Orange
```

Size = 3

---

### Capacity

Total available storage before resizing.

Example

Capacity = 10

Size = 3

---

## Constructors

### Default

```java
new ArrayList<>();
```

(Java 8+ starts with an empty internal array and allocates default capacity when the first element is added.)

---

### Initial Capacity

```java
new ArrayList<>(100);
```

Useful when expected size is known.

---

### From Collection

```java
new ArrayList<>(collection);
```

Copies all elements.

---

## Resizing

When full:

Old capacity:

```text
10
```

New capacity:

```text
15
```

Formula (conceptually)

```java
newCapacity = oldCapacity + oldCapacity/2
```

(Implemented internally using bit operations.)

---

## Important Methods

```java
ensureCapacity()

trimToSize()
```

---

### ensureCapacity()

Prepares larger storage.

Good for huge datasets.

---

### trimToSize()

Reduces unused capacity.

---

## Internal add()

Conceptually

```java
if(full)

    grow();

store element;

size++;
```

---

# Time Complexity

| Operation     | Complexity     |
| ------------- | -------------- |
| get()         | O(1)           |
| set()         | O(1)           |
| add(end)      | Amortized O(1) |
| add(index)    | O(n)           |
| remove(index) | O(n)           |
| contains()    | O(n)           |

---

# Why get() is O(1)

Array stores elements continuously.

JVM calculates address directly.

No traversal required.

---

# Why add(index) is O(n)

Elements shift to create space.

---

# 8. ConcurrentModificationException

Most important interview topic.

---

## Why it occurs

Collection modified during iteration.

Wrong:

```java
for(String s : list){

    list.remove(s);

}
```

---

## modCount

Every structural modification increments:

```text
modCount
```

Iterator stores

```text
expectedModCount
```

If

```text
modCount != expectedModCount
```

↓

Throws

```text
ConcurrentModificationException
```

---

## Structural Modification

Examples

✔ add()

✔ remove()

✔ clear()

Not structural

```java
set(index,value)
```

---

## Correct Removal

```java
Iterator<String> it = list.iterator();

while(it.hasNext()){

    if(condition)

        it.remove();

}
```

---

# 9. LinkedList

Package

```java
java.util.LinkedList
```

Implements

* List
* Deque

---

## Internal Structure

Each element stored as a Node.

Conceptually

```java
class Node{

    E item;

    Node prev;

    Node next;

}
```

---

## Doubly Linked List

```text
Apple

↓

Banana

↓

Orange
```

Every node stores

* Previous reference
* Next reference

---

## Advantages

No element shifting.

Fast insertion/removal when node is already known.

---

## Disadvantages

Slow random access.

Must traverse nodes.

---

# Time Complexity

| Operation         | Complexity |
| ----------------- | ---------- |
| get(index)        | O(n)       |
| add(end)          | O(1)       |
| add(beginning)    | O(1)       |
| remove(beginning) | O(1)       |

Important:

Insertion by index is still O(n) because traversal is required.

---

# 10. ArrayList vs LinkedList

| Feature            | ArrayList     | LinkedList         |
| ------------------ | ------------- | ------------------ |
| Internal Structure | Dynamic Array | Doubly Linked List |
| Random Access      | O(1)          | O(n)               |
| Insert Beginning   | O(n)          | O(1)               |
| Remove Beginning   | O(n)          | O(1)               |
| Insert Middle      | O(n)          | O(n)*              |
| Memory             | Lower         | Higher             |
| Cache Performance  | Excellent     | Poor               |

*Traversal dominates the complexity.

---

# Which One Should You Use?

Use ArrayList when:

* Reading frequently
* Index access required
* Backend APIs
* Most Spring Boot applications

Use LinkedList when:

* Frequent insertions/removals at head or tail
* Queue/Deque implementations
* You already have node references

Default choice:

**ArrayList**

---

# 11. Interview Questions

## Difference between Collection and Collections?

Collection → Interface

Collections → Utility Class

---

## Why does Collection extend Iterable?

To support enhanced for loop.

---

## Difference between Iterable and Iterator?

Iterable provides an iterator.

Iterator traverses the collection.

---

## Difference between List and Collection?

List

* Ordered
* Indexed
* Allows duplicates

Collection

* General contract

---

## Difference between size and capacity?

Size

Current stored elements.

Capacity

Maximum elements before resizing.

---

## Why is ArrayList get() O(1)?

Direct index calculation.

---

## Why is LinkedList get() O(n)?

Node traversal.

---

## Why does ConcurrentModificationException occur?

Collection modified during iteration.

---

## Why use iterator.remove()?

Keeps iterator and collection synchronized.

---

# 12. Best Practices

✔ Program to interfaces

```java
List<String> list = new ArrayList<>();
```

Instead of

```java
ArrayList<String> list = new ArrayList<>();
```

---

✔ Use ArrayList by default.

---

✔ Use Iterator for removal during traversal.

---

✔ Use initial capacity if approximate size is known.

---

✔ Never modify collection directly during enhanced for loop.

---

✔ Understand concepts before memorizing Big-O.

---

# 13. Key Takeaways

* Collections Framework provides reusable data structures.
* Collection is an interface.
* Iterable enables enhanced for loop.
* Iterator traverses collections safely.
* List maintains order and allows duplicates.
* ArrayList uses a dynamic array.
* LinkedList uses doubly linked nodes.
* ArrayList is the default choice in most applications.
* ConcurrentModificationException is caused by structural modification during iteration.
* modCount and expectedModCount are the internal mechanism behind fail-fast iterators.

---

# 14. What We Have Completed

✅ Collections Framework

✅ Collection Interface

✅ Iterable

✅ Iterator

✅ List Interface

✅ ArrayList

✅ ArrayList Internals

✅ Capacity vs Size

✅ Constructors

✅ Resizing

✅ ensureCapacity()

✅ trimToSize()

✅ ConcurrentModificationException

✅ modCount

✅ Fail-Fast Iterator

✅ LinkedList

✅ ArrayList vs LinkedList

---

# Next Topics

The next topics in the Java Collections Framework are:

* Set Interface
* HashSet
* equals() Contract
* hashCode() Contract
* LinkedHashSet
* TreeSet
* Map Interface
* HashMap
* LinkedHashMap
* TreeMap
* Queue
* Deque
* PriorityQueue

These topics build directly on the concepts covered in this document.
