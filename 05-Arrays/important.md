# Arrays in Java - Complete Revision Notes

## What is an Array?

An **array** is a fixed-size data structure that stores multiple values of the **same data type** under a single variable name.

Instead of creating multiple variables:

```java
int mark1 = 85;
int mark2 = 90;
int mark3 = 78;
```

We can write:

```java
int[] marks = {85, 90, 78};
```

---

# Why do Arrays Exist?

Without arrays:

* Managing thousands of variables is impossible.
* Iteration becomes difficult.
* Searching, sorting, and processing data becomes inefficient.

Arrays solve this problem by storing related values together.

Real-world examples:

* Student marks
* Employee IDs
* Product prices
* Daily temperatures
* Monthly sales

---

# Important Characteristics

* Stores multiple values.
* Stores only one data type.
* Fixed size after creation.
* Elements are stored in contiguous memory.
* Supports fast random access using indexes.

---

# Array Declaration

```java
int[] numbers;
```

Meaning:

* `int` → Type of every element.
* `[]` → This variable is an array.
* `numbers` → Reference variable.

At this point, **no array is created**.

---

# Array Creation

```java
numbers = new int[5];
```

Meaning:

* `new` → Creates a new array object.
* `int` → Elements are integers.
* `[5]` → Space for five elements.

---

# Declaration and Creation Together

```java
int[] numbers = new int[5];
```

Most commonly used.

---

# Array Initialization

### Method 1

```java
int[] numbers = new int[5];
```

Default values:

```text
0 0 0 0 0
```

---

### Method 2

```java
int[] numbers = {10,20,30,40};
```

Java automatically creates the array.

Equivalent to:

```java
int[] numbers = new int[]{10,20,30,40};
```

---

# Index

Array indexing starts from **0**.

Example:

```text
Index

0   1   2   3

+----+----+----+----+
|10  |20  |30  |40  |
+----+----+----+----+
```

First element:

```java
numbers[0]
```

Last element:

```java
numbers[numbers.length - 1]
```

---

# Why Does Index Start From 0?

Arrays are stored in contiguous memory.

Address calculation:

```text
Address = Base Address + (Index × Size of Data Type)
```

Example:

```text
Base Address = 1000

Index 0 → 1000
Index 1 → 1004
Index 2 → 1008
```

Using index `0` makes the calculation simple and efficient.

---

# Contiguous Memory

Contiguous means:

"Stored one after another."

```text
1000
1004
1008
1012
1016
```

This allows direct access to any element.

---

# Time Complexity

Accessing any element:

```java
numbers[index]
```

Time Complexity:

```text
O(1)
```

Reason:

Java calculates the memory location directly instead of searching.

---

# Arrays are Objects

Many beginners think:

```java
int[] numbers;
```

is a primitive type.

This is incorrect.

Arrays are **objects**.

The elements may be primitive, but the array itself is always an object.

---

# Memory Representation

```java
int[] numbers = new int[3];
```

Stack

```text
numbers
   |
   |
   V
```

Heap

```text
+----+----+----+
| 0  | 0  | 0  |
+----+----+----+
```

The variable stores only a reference.

The actual array object is stored in the heap.

---

# Primitive (Value) Types vs Reference Types

## Primitive (Value) Types

Examples:

```java
int
double
char
boolean
```

Store the actual value.

Example:

```java
int x = 10;
```

Memory:

```text
Stack

x

10
```

---

## Reference Types

Examples:

* String
* Arrays
* Objects
* Collections

They store a reference to an object.

Example:

```java
String name = "Java";
```

Memory:

```text
Stack

name
  |
  V

Heap

"Java"
```

---

# Arrays are Reference Types

Example:

```java
int[] arr = {10,20,30};
```

The array object lives in the heap.

The variable stores only the reference.

---

# Primitive Assignment

```java
int a = 10;
int b = a;

b = 50;
```

Output

```text
a = 10
b = 50
```

Reason:

Values are copied.

---

# Reference Assignment

```java
int[] arr1 = {10,20,30};

int[] arr2 = arr1;

arr2[0] = 100;
```

Output

```text
arr1[0] = 100
```

Reason:

Only the reference is copied.

Both variables point to the same array.

---

# Creating an Actual Copy

```java
int[] copy = original.clone();
```

or

```java
int[] copy = Arrays.copyOf(original, original.length);
```

Now both arrays are independent.

---

# Comparing Arrays

Wrong:

```java
arr1 == arr2;
```

This compares references.

Correct:

```java
Arrays.equals(arr1, arr2);
```

This compares elements.

---

# Arrays.binarySearch()

Package:

```java
import java.util.Arrays;
```

Method:

```java
Arrays.binarySearch(array, key);
```

---

# Purpose

Searches an element in a **sorted array** using the Binary Search algorithm.

Time Complexity:

```text
O(log n)
```

---

# Important Rule

The array **must be sorted**.

Correct:

```text
10 20 30 40 50
```

Wrong:

```text
40 10 20 50 30
```

If the array isn't sorted, the result is undefined.

---

# Return Values

If found:

Returns index.

Example:

```java
Arrays.binarySearch(arr,30);
```

Returns

```text
2
```

---

If not found:

Returns

```text
-(Insertion Point)-1
```

Example:

Searching

```text
35
```

Inside

```text
10 20 30 40 50
```

Insertion point:

```text
3
```

Return value:

```text
-4
```

---

# Main Method

Standard entry point:

```java
public static void main(String[] args)
```

Meaning of each keyword:

### public

Accessible from anywhere.

The JVM must be able to call it.

---

### static

Belongs to the class.

The JVM can call it without creating an object.

---

### void

Returns nothing.

---

### main

Special method name recognized by the JVM.

---

### String[] args

Array of command-line arguments.

Example:

```bash
java Main Java Spring
```

Creates

```java
args[0] = "Java";
args[1] = "Spring";
```

---

# String[] vs String...

Both are valid:

```java
public static void main(String[] args)
```

```java
public static void main(String... args)
```

Reason:

The compiler converts

```java
String... args
```

into

```java
String[] args
```

Internally they are identical.

Because of this, the following does **not** compile:

```java
public static void main(String... args){}

public static void main(String[] args){}
```

Compiler error:

```
Method already defined.
```

---

# Common Beginner Mistakes

### Mistake 1

Thinking arrays are primitive types.

Wrong.

Arrays are objects.

---

### Mistake 2

Using an invalid index.

```java
arr[5];
```

Throws:

```
ArrayIndexOutOfBoundsException
```

---

### Mistake 3

Using

```java
arr.length()
```

Wrong.

Correct:

```java
arr.length
```

Arrays have a field, not a method.

---

### Mistake 4

Using Binary Search on an unsorted array.

Always sort first:

```java
Arrays.sort(arr);
```

---

### Mistake 5

Thinking

```java
int[] b = a;
```

creates a new array.

Wrong.

It only copies the reference.

---

# Important Interview Questions

1. Why does array indexing start from 0?
2. Why are arrays fixed in size?
3. Are arrays objects?
4. Where are arrays stored?
5. Difference between primitive and reference types.
6. What happens when you assign one array variable to another?
7. Difference between `==` and `Arrays.equals()`.
8. Why must Binary Search use a sorted array?
9. Why is `main()` static?
10. Difference between `String[] args` and `String... args`.

---

# Best Practices

* Use arrays when the size is known and fixed.
* Use `ArrayList` when the size changes dynamically.
* Always validate indexes before accessing elements.
* Use `Arrays.equals()` to compare contents.
* Use `Arrays.copyOf()` or `clone()` when you need a separate copy.
* Sort an array before using `Arrays.binarySearch()`.

---

# Quick Revision (30-Second Recap)

* Arrays store multiple values of the same type.
* Arrays have a fixed size.
* Arrays are objects and are reference types.
* Array objects live in the heap; local reference variables live in the stack.
* Indexing starts at `0`.
* Random access is `O(1)`.
* `int[] b = a;` copies the reference, not the array.
* Use `clone()` or `Arrays.copyOf()` for a real copy.
* `Arrays.binarySearch()` requires a sorted array and runs in `O(log n)`.
* `public static void main(String[] args)` is the JVM entry point.
* `String... args` and `String[] args` are equivalent because varargs are compiled into an array.
