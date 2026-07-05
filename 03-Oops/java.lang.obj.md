# Java `java.lang.Object` Class

## Overview

The `java.lang.Object` class is the **root class of the Java class hierarchy**. Every class in Java directly or indirectly extends `Object`, making it the parent of all Java classes.

Even if we do not explicitly write:

```java
class Student extends Object {

}
```

the Java compiler automatically adds it.

For example:

```java
class Student {

}
```

is treated as:

```java
class Student extends Object {

}
```

---

# Why Does Java Have an Object Class?

Imagine we have different classes.

```java
class Dog {

}

class Student {

}

class Car {

}
```

These classes are completely unrelated.

However, Java still allows us to write:

```java
System.out.println(dog);
System.out.println(student);
System.out.println(car);
```

It also allows:

```java
dog.equals(student);
student.getClass();
```

These methods work because every class inherits them from the `Object` class.

The `Object` class provides a common set of behaviors that every Java object automatically receives.

---

# Java Class Hierarchy

```
                 Object
                    │
        ┌───────────┼───────────┐
        │           │           │
     Animal      Student      Vehicle
        │
        │
       Dog
```

Every class ultimately extends `java.lang.Object`.

---

# Important Methods of Object Class

| Method        | Purpose                                       |
| ------------- | --------------------------------------------- |
| `toString()`  | Returns a string representation of the object |
| `equals()`    | Compares two objects                          |
| `hashCode()`  | Returns the hash code of an object            |
| `getClass()`  | Returns runtime class information             |
| `wait()`      | Makes the current thread wait                 |
| `notify()`    | Wakes one waiting thread                      |
| `notifyAll()` | Wakes all waiting threads                     |

For Java Fundamentals and interviews, the most important methods are:

* `toString()`
* `equals()`
* `hashCode()`
* `getClass()`

---

# `toString()`

The `toString()` method returns a string representation of an object.

When we write:

```java
System.out.println(object);
```

Java internally calls:

```java
object.toString();
```

Default output:

```
Student@6d06d69c
```

The default implementation returns:

```
ClassName@HexadecimalHashCode
```

This is why developers often override `toString()` to provide meaningful output.

---

# `equals()`

The `equals()` method compares two objects.

By default, the implementation inherited from `Object` compares object references.

Example:

```java
Student s1 = new Student();
Student s2 = new Student();

System.out.println(s1.equals(s2));
```

Output:

```
false
```

because `s1` and `s2` refer to different objects.

Many classes override `equals()` to compare object data instead of memory references.

---

# `hashCode()`

The `hashCode()` method returns an integer representing the object's hash value.

It is mainly used by collections such as:

* HashMap
* HashSet
* Hashtable

Important Interview Rule:

> Whenever `equals()` is overridden, `hashCode()` should also be overridden to maintain the contract between equality and hashing.

---

# `getClass()`

The `getClass()` method returns runtime information about an object.

Example:

```java
Student student = new Student();

System.out.println(student.getClass());
```

Output:

```
class Student
```

To print only the class name:

```java
System.out.println(student.getClass().getSimpleName());
```

Output:

```
Student
```

---

# Why is Object Important?

Because every Java object automatically inherits:

* Basic identity
* Equality checking
* String representation
* Runtime type information
* Thread synchronization methods

Without the `Object` class, Java would not have a common parent for all objects.

---

# Common Beginner Mistakes

### Mistake 1

Thinking classes without `extends` have no parent.

Wrong.

Every Java class automatically extends `Object`.

---

### Mistake 2

Thinking `System.out.println(object)` prints the object directly.

Actually, Java internally calls:

```java
object.toString();
```

---

### Mistake 3

Thinking `==` and `equals()` are the same.

They are different.

* `==` compares references (for objects).
* `equals()` compares according to its implementation.

---

### Mistake 4

Overriding `equals()` but forgetting `hashCode()`.

This causes incorrect behavior in hash-based collections like `HashMap` and `HashSet`.

---

# Interview Questions

### 1. What is the Object class?

The `Object` class is the root class of the Java class hierarchy. Every Java class directly or indirectly extends it.

---

### 2. Does every Java class inherit Object?

Yes.

Even if `extends Object` is not written, the compiler adds it automatically.

---

### 3. Can we explicitly extend Object?

Yes.

```java
class Student extends Object {

}
```

However, writing it explicitly is unnecessary.

---

### 4. Which Object methods are most commonly overridden?

* `toString()`
* `equals()`
* `hashCode()`

---

### 5. Why do we override `toString()`?

To provide a meaningful string representation of an object for debugging, logging, and printing.

---

### 6. Why are `equals()` and `hashCode()` related?

Objects that are considered equal should produce the same hash code. This is required for correct behavior in hash-based collections.

---

# Key Points to Remember

* Every Java class extends `java.lang.Object`.
* The compiler automatically adds `extends Object` if it is omitted.
* `Object` provides common methods available to every Java object.
* `System.out.println(object)` internally calls `object.toString()`.
* The most important methods for interviews are:

  * `toString()`
  * `equals()`
  * `hashCode()`
  * `getClass()`
* Overriding `equals()` generally requires overriding `hashCode()` as well.
* The `Object` class forms the foundation of Java's object-oriented model.
