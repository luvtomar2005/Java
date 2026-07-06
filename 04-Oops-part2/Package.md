# 📦 Packages in Java

> **Prerequisites**
>
> Before learning Packages, you should understand:
>
> * Classes & Objects
> * Constructors
> * Access Modifiers (Basic)
> * Object Creation
> * Import Statements (Basic)

---

# 1. Problem First (Why Were Packages Introduced?)

Imagine you're working on a large banking application.

The project contains:

* Customer
* Account
* Transaction
* Loan
* Employee
* Manager
* Report
* Notification
* Payment
* Authentication

After a few months, the project grows to over **2,000 Java classes**.

Without packages, your project would look like this:

```text
Project

Customer.java
Account.java
Transaction.java
Loan.java
Employee.java
Manager.java
Payment.java
Notification.java
Report.java
...
2000 more files
```

Finding a single class becomes difficult.

Now imagine another developer also creates a class named:

```java
class Customer
```

Java now has two classes with the same name.

Which one should it use?

This is exactly the problem Packages solve.

Packages provide:

* Organization
* Namespace management
* Better maintainability
* Better security
* Better code reuse

---

# 2. Real World Analogy

Think about a hospital.

```
Hospital

├── Cardiology
│      ├── Doctor
│      ├── Nurse
│
├── Neurology
│      ├── Doctor
│      ├── Nurse
│
├── Accounts
│      ├── Accountant
│
└── Reception
       ├── Receptionist
```

Notice something.

Each department can have a **Doctor**.

There is no confusion because every doctor belongs to a different department.

Packages work exactly the same way.

---

# 3. What is a Package?

## Simple Definition

A package is a way to organize related Java classes into a logical group.

---

## Technical Definition

A package is a namespace that groups related classes, interfaces, enums, annotations, and sub-packages together.

---

# 4. Package Syntax

```java
package com.luv.java;
```

Let's break it down.

```
package
```

Keyword telling Java that this class belongs to a package.

```
com
```

Usually represents the company or organization.

```
luv
```

Organization, username, or project owner.

```
java
```

Module or project name.

Together:

```
com.luv.java
```

represents one package.

---

# 5. Why Package Statement Must Be First

Example

```java
package com.luv.java;

public class Main {

}
```

The package statement tells the compiler:

> Before compiling this class, place it inside this package.

If Java allowed package statements later in the file, it wouldn't know where the class belongs.

Therefore it must be the first non-comment statement.

---

# 6. Package Hierarchy

Example

```
com
 └── luv
      └── java
            └── basics
```

Each dot represents another folder.

Project structure:

```
src

└── com
      └── luv
            └── java
                  └── basics
                          Main.java
```

---

# 7. Types of Packages

## Built-in Packages

Provided by Java.

Examples

```
java.lang

java.util

java.io

java.time

java.sql

java.net

java.nio
```

---

## User Defined Packages

Created by developers.

Example

```
com.luv.java

com.bank.account

com.ecommerce.payment
```

---

# 8. What is an Import Statement?

Example

```java
import java.util.Scanner;
```

Breakdown

```
java
```

Top-level package.

↓

```
util
```

Sub-package.

↓

```
Scanner
```

Class.

Meaning:

> Import the Scanner class from the java.util package.

---

# 9. Why Do We Need import?

Suppose Scanner wasn't imported.

Java only knows

```
Scanner
```

Question

Which Scanner?

There could be many classes named Scanner.

The import statement tells Java exactly which class to use.

---

# 10. Fully Qualified Name (FQN)

Instead of writing

```java
import java.util.Scanner;
```

we can directly write

```java
java.util.Scanner scanner =
        new java.util.Scanner(System.in);
```

This is called the Fully Qualified Name.

Generally, we avoid writing it repeatedly because it makes the code verbose.

---

# 11. Why is java.lang Imported Automatically?

Have you noticed?

We never write:

```java
import java.lang.String;
```

or

```java
import java.lang.System;
```

Still, Java recognizes them.

Why?

Because the compiler automatically imports:

```
java.lang.*
```

for every Java program.

That is why classes like:

* String
* System
* Object
* Math
* Exception

are available without an explicit import.

---

# 12. Package vs Folder

Many beginners think:

> Package = Folder

Not exactly.

A package is a Java language concept.

A folder is part of the operating system.

Normally, Java maps packages to folders.

Example

Package:

```
com.luv.java
```

Folder:

```
com/
   luv/
      java/
```

The mapping makes class loading easier.

---

# 13. Naming Convention

Java follows the reverse domain naming convention.

Examples

```
com.google

com.microsoft

com.oracle

org.springframework

io.github.username
```

Why reverse domain?

Because internet domain names are globally unique.

This prevents naming conflicts.

---

# 14. Default Package

Suppose you don't write:

```java
package ...
```

Then the class belongs to the Default Package.

Example

```java
public class Main {

}
```

This is acceptable for small programs.

Real projects should never use the default package.

---

# 15. Access Modifiers and Packages

Packages affect accessibility.

| Modifier  | Same Class | Same Package | Different Package (Subclass) | Different Package (Non-Subclass) |
| --------- | ---------- | ------------ | ---------------------------- | -------------------------------- |
| public    | ✅          | ✅            | ✅                            | ✅                                |
| protected | ✅          | ✅            | ✅                            | ❌                                |
| default   | ✅          | ✅            | ❌                            | ❌                                |
| private   | ✅          | ❌            | ❌                            | ❌                                |

---

# 16. How JVM Finds Classes

Compilation

```
Main.java

↓

Main.class
```

Class Loader

↓

Package Name

↓

Folder Structure

↓

Load Bytecode

↓

JVM Executes

Packages help the JVM locate compiled classes correctly.

---

# 17. Backend Development Example

Your Spring Boot project might look like:

```
com.luv.urlshortener

├── controller
├── service
├── repository
├── entity
├── dto
├── config
├── security
├── exception
├── util
└── UrlShortenerApplication.java
```

Each package has one responsibility.

This organization improves maintainability and scalability.

---

# 18. Best Practices

✅ Group related classes together.

✅ Use meaningful package names.

✅ Follow reverse-domain naming.

✅ One public class per file.

✅ Avoid the default package in production applications.

---

# 19. Common Beginner Mistakes

### Mistake 1

Thinking packages are only folders.

Wrong.

Packages are namespaces used by Java.

---

### Mistake 2

Forgetting the package declaration after moving a file.

The package declaration and folder structure should match.

---

### Mistake 3

Using the default package in real projects.

Avoid it except for very small learning programs.

---

### Mistake 4

Creating random package names.

Prefer:

```
com.company.project
```

instead of:

```
mypackage
```

---

# 20. Interview Questions

### What is a package?

A package is a namespace that groups related Java classes and interfaces together.

---

### Why do we use packages?

* Organize code
* Avoid class name conflicts
* Improve maintainability
* Provide access control
* Improve reusability

---

### Difference between package and folder?

A package is a Java namespace.

A folder is an operating system directory.

Java usually maps packages to folders.

---

### Why is java.lang imported automatically?

Because the Java compiler automatically imports all classes from `java.lang`.

---

### Can two packages have classes with the same name?

Yes.

Example

```
java.util.Date

java.sql.Date
```

Both classes are named `Date`, but belong to different packages.

---

### Why must the package statement be first?

Because the compiler must know the package before processing the class.

---

# 21. Summary

* A package is a namespace that groups related classes.
* Packages improve organization and prevent naming conflicts.
* Packages are usually mapped to folders.
* Built-in packages are provided by Java.
* User-defined packages are created by developers.
* `import` allows easy access to classes from other packages.
* `java.lang` is imported automatically.
* Large enterprise applications rely heavily on proper package organization.

---

# 22. Revision Mind Map

```
Packages
      │
      ▼
Organize Classes
      │
      ▼
Avoid Name Conflicts
      │
      ▼
Namespace
      │
      ▼
Built-in / User Defined
      │
      ▼
Import Statement
      │
      ▼
Fully Qualified Name
      │
      ▼
Package Hierarchy
      │
      ▼
Spring Boot Project Structure
```
Q1. Why can't a static method access instance variables directly?

Answer: Because a static method belongs to the class, not to any specific object. Since multiple objects may exist, the JVM doesn't know which object's instance variable should be accessed.

Q2. Why is main() static?

Answer: The JVM must start the program before any objects are created. Making main() static allows the JVM to invoke it directly using the class name without creating an object.

Q3. Where are static and instance variables stored?
Instance variables are stored inside each object in the heap.
Static variables belong to the class, not to any object. They are stored in the JVM's class-related memory area (often referred to conceptually as the Method Area/Metaspace, though the exact implementation is JVM-specific).
