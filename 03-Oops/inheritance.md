# Java Inheritance – Complete Interview Notes

# 1. Definition

**Inheritance** is an Object-Oriented Programming (OOP) concept in which one class acquires the properties (fields) and behaviors (methods) of another class.

The existing class is called the **Parent Class (Superclass/Base Class)**, and the new class is called the **Child Class (Subclass/Derived Class)**.

---

# 2. Why Do We Need Inheritance?

Without inheritance, common code must be written repeatedly.

Example:

```text
SoftwareEngineer
---------------
name
age
email
eat()
sleep()

Manager
-------
name
age
email
eat()
sleep()

HR
--
name
age
email
eat()
sleep()
```

This causes:

* Code duplication
* Difficult maintenance
* Higher chance of bugs

Using inheritance:

```text
                 Employee
      ----------------------------
      name
      age
      email
      eat()
      sleep()
      ----------------------------

        ▲
   ______|_______
  |      |       |

Software Manager  HR
Engineer
```

Common code is written once and reused by all subclasses.

---

# 3. Interview Definition

> Inheritance is the mechanism by which one class acquires the accessible properties and behaviors of another class, promoting code reuse, maintainability, and modeling an **IS-A** relationship.

---

# 4. The `extends` Keyword

Inheritance is achieved using the `extends` keyword.

```java
class Animal {

}

class Dog extends Animal {

}
```

Read it as:

> Dog **IS-A** Animal.

---

# 5. IS-A Relationship

Inheritance should only be used when an **IS-A** relationship exists.

### Correct

* Dog IS-A Animal
* Car IS-A Vehicle
* Student IS-A Person
* SavingsAccount IS-A Account

### Incorrect

* Car IS-A Engine ❌
* Book IS-A Library ❌
* Engine IS-A Car ❌

These are **HAS-A** relationships and should use composition instead of inheritance.

---

# 6. Advantages of Inheritance

* Code Reusability
* Reduces Duplication
* Better Maintainability
* Extensibility
* Supports Runtime Polymorphism
* Models Real-World Relationships

---

# 7. Parent Class Terminology

Parent Class is also known as:

* Superclass
* Base Class
* Parent Class

---

# 8. Child Class Terminology

Child Class is also known as:

* Subclass
* Derived Class
* Child Class

---

# 9. What Gets Inherited?

The child inherits the accessible members of the parent.

### Accessible

* Public fields
* Protected fields
* Public methods
* Protected methods

### Not Directly Accessible

Private members are part of the object but cannot be accessed directly from the child.

---

# 10. Access Modifiers in Inheritance

| Modifier  | Same Class | Same Package | Subclass (Different Package) | Everywhere |
| --------- | ---------- | ------------ | ---------------------------- | ---------- |
| private   | ✅          | ❌            | ❌                            | ❌          |
| default   | ✅          | ✅            | ❌                            | ❌          |
| protected | ✅          | ✅            | ✅                            | ❌          |
| public    | ✅          | ✅            | ✅                            | ✅          |

---

# 11. Constructor Inheritance

Constructors are **NOT inherited**.

However,

When a child object is created,

the parent constructor executes first.

Execution order:

```text
new Dog()

↓

Dog Constructor

↓

super()

↓

Animal Constructor

↓

Return

↓

Dog Constructor Continues
```

---

# 12. Why Parent Constructor Executes First

The parent initializes the inherited portion of the object before the child initializes its own fields.

Think of building a house:

```text
Foundation

↓

Ground Floor

↓

First Floor
```

Similarly:

```text
Animal

↓

Dog
```

---

# 13. The `super()` Constructor

Used to call the parent constructor.

```java
super("Dog", size, weight);
```

Rules:

* Must be the first statement.
* Calls the immediate parent constructor.
* If omitted, Java inserts `super()` automatically (only if the parent has a no-argument constructor).

---

# 14. The `super` Keyword

Besides constructors, `super` can also access the parent implementation.

### Call Parent Method

```java
super.move(speed);
```

### Access Parent Field

```java
super.name;
```

---

# 15. The `this` Keyword

`this` refers to the current object.

Common uses:

* Access instance variables
* Call another constructor (`this()`)
* Pass the current object
* Return the current object

Example:

```java
this.name = name;
```

---

# 16. `this()` vs `super()`

| this()                                      | super()                      |
| ------------------------------------------- | ---------------------------- |
| Calls another constructor in the same class | Calls the parent constructor |
| Constructor chaining                        | Parent initialization        |
| Same class                                  | Parent class                 |
| Must be first statement                     | Must be first statement      |

Both cannot appear together in the same constructor because both must be first.

---

# 17. Object Creation in Inheritance

When creating:

```java
Dog dog = new Dog();
```

Only **ONE** object is created.

Memory:

```text
Dog Object

----------------------------

Animal Part

type
size
weight

----------------------------

Dog Part

earShape
tailShape

----------------------------
```

The Dog object contains the inherited Animal state.

---

# 18. Method Lookup

When:

```java
dog.makeNoise();
```

Java searches:

```text
Dog

↓

Method Found?

↓

Yes

↓

Execute
```

If not found:

```text
Dog

↓

No

↓

Animal

↓

Found

↓

Execute
```

---

# 19. Method Overriding

If the child provides its own implementation of a parent method:

```java
@Override
public void makeNoise() {

    System.out.println("Woof");

}
```

The child's version executes.

---

# 20. Calling Parent Method

```java
@Override
public void move(String speed) {

    super.move(speed);

    System.out.println("Dog Running");

}
```

Output:

```text
Dog moves Fast

Dog Running
```

---

# 21. Types of Inheritance in Java

### Supported

✔ Single

```text
A

↓

B
```

✔ Multilevel

```text
Animal

↓

Dog

↓

Puppy
```

✔ Hierarchical

```text
        Animal
       /      \
     Dog      Cat
```

### Not Supported (Classes)

❌ Multiple Inheritance

```text
Parent1

   \

   Child

   /

Parent2
```

Reason:

The Diamond Problem.

---

# 22. Common Interview Questions

### Why use inheritance?

To model an IS-A relationship and reuse accessible code.

---

### Are constructors inherited?

No.

---

### Does Java support multiple inheritance?

Not for classes.

Yes for interfaces.

---

### Does a child inherit private members?

Private members are part of the object but cannot be accessed directly from the child class.

---

### How many objects are created?

```java
Dog dog = new Dog();
```

Only **one** object.

---

### Why does the parent constructor execute first?

To initialize the parent portion of the object before the child portion.

---

### Can a child class have its own methods?

Yes.

It contains:

* Inherited members
* Its own members

---

### Can the parent call child methods?

No.

An Animal is not necessarily a Dog.

---

# 23. Common Beginner Mistakes

❌ Thinking inheritance copies code.

It doesn't.

The child inherits access to accessible members.

---

❌ Thinking `super()` creates another object.

It doesn't.

It initializes the parent part of the same object.

---

❌ Thinking two objects are created.

Only one object exists.

---

❌ Using inheritance for HAS-A relationships.

Inheritance should model only IS-A relationships.

---

# 24. Interview Tips

Always mention these keywords when explaining inheritance:

* IS-A Relationship
* Code Reusability
* Parent Class
* Child Class
* `extends`
* Constructor Chaining
* `super()`
* Method Overriding
* Runtime Polymorphism (enabled by inheritance)

---

# 25. One-Line Revision

* `extends` → Creates an IS-A relationship.
* Child inherits accessible members of the parent.
* Constructors are not inherited.
* Parent constructor runs before the child constructor.
* `super()` calls the parent constructor or parent method.
* `this()` calls another constructor in the same class.
* Only one object is created in inheritance.
* Method overriding allows the child to provide its own implementation.
* Inheritance is the foundation of runtime polymorphism.
