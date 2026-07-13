# Java I/O (Input/Output) – Interview Revision Notes

> **Goal:** This document is a quick revision guide for Java I/O covering the most important concepts, interview questions, and real-world backend usage.

---

# 1. What is Java I/O?

Java I/O (Input/Output) is the mechanism through which a Java program communicates with the outside world.

Input means data coming **into** the program.

Output means data going **out** of the program.

Examples:

* Reading files
* Writing files
* Reading keyboard input
* Writing logs
* Sending network data
* Saving objects
* Reading configuration files

---

# 2. Byte Streams vs Character Streams

## Byte Streams

Parent Classes

* InputStream
* OutputStream

Work with:

* Raw bytes

Best Used For

* Images
* Videos
* PDFs
* ZIP files
* Audio
* Executable files

Examples

* FileInputStream
* FileOutputStream
* BufferedInputStream
* BufferedOutputStream

---

## Character Streams

Parent Classes

* Reader
* Writer

Work with

* Characters

Best Used For

* Text files
* JSON
* XML
* CSV
* Logs
* Configuration files

Examples

* FileReader
* FileWriter
* BufferedReader
* BufferedWriter
* PrintWriter

---

# Interview Question

**When should you use InputStream instead of Reader?**

Use **InputStream** for binary files.

Use **Reader** for text files because it understands character encoding.

---

# 3. File Class

Represents a file or directory.

It **does not** read or write data.

Common Methods

```java
exists()
createNewFile()
delete()
isFile()
isDirectory()
length()
mkdir()
listFiles()
```

---

# 4. FileInputStream & FileOutputStream

Used for binary files.

```java
FileInputStream
```

Reads bytes.

```java
FileOutputStream
```

Writes bytes.

Best for:

* Images
* Videos
* PDFs
* ZIP files

---

## Important Interview Question

**Why does read() return int instead of byte?**

Because:

* 0–255 represent valid byte values.
* -1 represents End Of File (EOF).

---

# 5. FileReader & FileWriter

Used for text files.

FileReader

* Reads characters

FileWriter

* Writes characters

Suitable for

* TXT
* CSV
* JSON
* XML

---

## Append Mode

```java
new FileWriter("file.txt", true);
```

Without `true`, existing content is overwritten.

---

# 6. BufferedReader & BufferedWriter

Purpose

Improve performance by using an internal memory buffer.

Instead of reading one character at a time,

Java reads a large block into memory.

---

## Most Important Method

```java
readLine()
```

Reads an entire line.

Returns

```java
null
```

at the end of the file.

---

## BufferedWriter

Useful methods

```java
write()

newLine()

flush()
```

---

## Interview Question

**Why is BufferedReader faster than FileReader?**

Because it reads data in blocks using an internal buffer, reducing expensive disk I/O operations.

---

# 7. PrintWriter

Provides convenient methods:

```java
print()

println()

printf()
```

Useful for

* Reports
* Logs
* Text output
* Formatted data

Example

```java
writer.printf("Age : %d%n", age);
```

---

## Interview Question

Difference between BufferedWriter and PrintWriter

BufferedWriter

* Better control over writing
* Uses `newLine()`

PrintWriter

* Easier formatting
* Supports `print()`, `println()`, `printf()`

---

# 8. Serialization

Serialization

Object → Bytes

Deserialization

Bytes → Object

Classes

```java
ObjectOutputStream

ObjectInputStream
```

---

## Serializable Interface

```java
implements Serializable
```

Marker Interface

Contains no methods.

---

## transient Keyword

Fields marked transient

* Are NOT serialized.

Common use

* Passwords
* OTP
* Temporary cache

---

## serialVersionUID

Maintains version compatibility during serialization.

Example

```java
private static final long serialVersionUID = 1L;
```

---

## Interview Questions

What is Serialization?

What is Deserialization?

What is a Marker Interface?

Why use transient?

What is serialVersionUID?

---

# 9. DataInputStream & DataOutputStream

Used for primitive data types.

Examples

```java
writeInt()

writeDouble()

writeBoolean()

writeChar()

writeUTF()
```

Matching read methods

```java
readInt()

readDouble()

readBoolean()

readChar()

readUTF()
```

---

## Golden Rule

Read data in the EXACT same order in which it was written.

Wrong order

↓

Corrupted data or exception.

---

# 10. Scanner vs BufferedReader

| Feature               | Scanner    | BufferedReader |
| --------------------- | ---------- | -------------- |
| Speed                 | Slower     | Faster         |
| Parsing               | Automatic  | Manual         |
| Reads Primitive Types | Yes        | No             |
| Reads Line            | Yes        | Yes            |
| Best For              | User input | Large input    |

---

## Famous Interview Question

Why does

```java
nextInt()

nextLine()
```

fail?

Because `nextInt()` leaves the newline (`\n`) in the input buffer.

Solution

```java
nextInt();

nextLine();
```

Consume the leftover newline before reading the next line.

---

# 11. Console Class

Used for secure console input.

Example

```java
Console console = System.console();
```

Read password

```java
char[] password =
        console.readPassword();
```

---

## Why char[] instead of String?

Strings are immutable.

char[] can be cleared from memory after use.

---

# 12. Modern Java NIO.2

Package

```java
java.nio.file
```

Main Classes

* Path
* Files

Modern replacement for the File API.

---

## Path

Represents a file or directory path.

```java
Path path = Path.of("student.txt");
```

---

## Files

Utility class for file operations.

Most Useful Methods

```java
Files.exists()

Files.createFile()

Files.readString()

Files.writeString()

Files.copy()

Files.move()

Files.delete()
```

---

## Interview Question

Difference between File and Path

File

* Legacy API (Java 1.0)

Path

* Modern API (Java 7)
* More powerful and flexible

---

# 13. Most Important Interview Questions

### Q1. Byte Stream vs Character Stream?

Binary vs Text.

---

### Q2. Why does read() return int?

To return **-1** at EOF.

---

### Q3. BufferedReader vs Scanner?

Scanner parses input automatically.

BufferedReader is faster.

---

### Q4. FileReader vs FileInputStream?

FileReader

* Characters

FileInputStream

* Bytes

---

### Q5. BufferedReader vs FileReader?

BufferedReader uses buffering and provides `readLine()`.

---

### Q6. PrintWriter vs BufferedWriter?

PrintWriter provides formatting (`print`, `println`, `printf`).

BufferedWriter focuses on efficient character writing.

---

### Q7. What is Serialization?

Object → Bytes.

---

### Q8. What is transient?

Excludes a field from serialization.

---

### Q9. What is serialVersionUID?

Version identifier used during serialization.

---

### Q10. Why must read order match write order in Data Streams?

Because binary data has no metadata describing the sequence. Reading with a different type or order misinterprets the bytes.

---

### Q11. Difference between File and Path?

Path is the modern API.

---

### Q12. Why use InputStreamReader?

It converts a byte stream (`System.in`) into a character stream so that classes like `BufferedReader` can read text.

---

# 14. Backend Usage

| Task                        | Recommended Class                   |
| --------------------------- | ----------------------------------- |
| Read Image                  | FileInputStream                     |
| Save PDF                    | FileOutputStream                    |
| Read Configuration File     | BufferedReader / Files.readString() |
| Write Logs                  | BufferedWriter / PrintWriter        |
| Read JSON File              | Files.readString()                  |
| Save Java Object            | ObjectOutputStream                  |
| Restore Java Object         | ObjectInputStream                   |
| Read Primitive Binary Data  | DataInputStream                     |
| Write Primitive Binary Data | DataOutputStream                    |
| Modern File Operations      | Path + Files                        |

---

# 15. Which Class Should I Use?

```text
Need to work with a file?
        │
        ▼
Binary or Text?
        │
   ┌──────────────┐
   │              │
Binary          Text
   │              │
InputStream    Reader
OutputStream   Writer
   │              │
Need Speed?   Need Speed?
   │              │
BufferedInput  BufferedReader
BufferedOutput BufferedWriter
```

For modern Java (Java 11+):

```text
Need simple file operations?
        │
        ▼
Use Path + Files
```

---

# 16. Best Practices

* Use **try-with-resources** for all I/O operations.
* Use **BufferedReader** and **BufferedWriter** for large text files.
* Use **InputStream/OutputStream** for binary data.
* Use **Reader/Writer** for text.
* Use **Path** and **Files** instead of `File` in modern applications.
* Never serialize sensitive fields; mark them `transient`.
* Always define `serialVersionUID` for serializable classes.
* Read data in the same order it was written with `DataInputStream`/`DataOutputStream`.
* Prefer UTF-8 when working with text.
* Close resources promptly to avoid resource leaks.

---

# Final Interview Cheat Sheet

| Requirement           | Class              |
| --------------------- | ------------------ |
| Read Binary File      | FileInputStream    |
| Write Binary File     | FileOutputStream   |
| Read Text File        | BufferedReader     |
| Write Text File       | BufferedWriter     |
| Formatted Output      | PrintWriter        |
| Save Object           | ObjectOutputStream |
| Load Object           | ObjectInputStream  |
| Save Primitive Types  | DataOutputStream   |
| Load Primitive Types  | DataInputStream    |
| Fast Keyboard Input   | BufferedReader     |
| Easy Keyboard Input   | Scanner            |
| Secure Password Input | Console            |
| Modern File API       | Path + Files       |

---

# What Interviewers Expect

For service-based company interviews (Cognizant, Infosys, TCS, Capgemini, Accenture, Wipro), you should be comfortable explaining:

* The difference between byte streams and character streams.
* When to choose `InputStream` vs `Reader`.
* Why buffering improves performance.
* Why `read()` returns `int`.
* The purpose of serialization and the `Serializable` interface.
* `transient` and `serialVersionUID`.
* The rule that `DataInputStream` must read values in the same order they were written.
* Why `Scanner` is slower than `BufferedReader`.
* Why `InputStreamReader` is needed with `System.in`.
* Why `Path` and `Files` are preferred over `File` in modern Java.
* Which I/O class you would choose for common backend scenarios.


# Interview Questions with Answers

## Q1. What is Java I/O?

**Answer:**

Java I/O (Input/Output) is the mechanism through which a Java program reads data from external sources and writes data to external destinations. Examples include reading files, writing files, taking keyboard input, sending data over a network, and saving objects.

---

## Q2. What is the difference between InputStream and OutputStream?

**Answer:**

* `InputStream` reads **bytes** into a Java program.
* `OutputStream` writes **bytes** from a Java program.
* They are abstract parent classes of all byte streams.

---

## Q3. What is the difference between Reader and Writer?

**Answer:**

* `Reader` reads **characters**.
* `Writer` writes **characters**.
* They automatically handle character encoding.
* They are mainly used for text files.

---

## Q4. What is the difference between Byte Streams and Character Streams?

**Answer:**

| Byte Streams                             | Character Streams             |
| ---------------------------------------- | ----------------------------- |
| Work with bytes                          | Work with characters          |
| Used for binary files                    | Used for text files           |
| Parent classes: InputStream/OutputStream | Parent classes: Reader/Writer |
| No encoding support                      | Handles character encoding    |

---

## Q5. Why does `read()` return `int` instead of `byte` or `char`?

**Answer:**

Because Java needs a special value (`-1`) to indicate **End Of File (EOF)**.

A `byte` or `char` cannot safely represent both all valid data values and EOF.

---

## Q6. What is FileInputStream?

**Answer:**

`FileInputStream` is a subclass of `InputStream` used to read raw bytes from a file. It is mainly used for binary files such as images, PDFs, videos, ZIP files, and audio files.

---

## Q7. What is FileOutputStream?

**Answer:**

`FileOutputStream` writes raw bytes to a file. It creates the file if it does not exist and overwrites it by default unless append mode is enabled.

---

## Q8. What is FileReader?

**Answer:**

`FileReader` is a character stream used to read text files. It converts bytes into characters using the appropriate character encoding.

---

## Q9. What is FileWriter?

**Answer:**

`FileWriter` writes characters into text files. It automatically converts characters into bytes before writing them.

---

## Q10. Why is BufferedReader faster than FileReader?

**Answer:**

Because `BufferedReader` reads a large block of characters into an internal buffer and serves subsequent reads from memory instead of repeatedly accessing the disk.

---

## Q11. What is `readLine()`?

**Answer:**

`readLine()` reads an entire line of text from a file and returns a `String`. It returns `null` when the end of the file is reached.

---

## Q12. What is the difference between BufferedReader and FileReader?

**Answer:**

`FileReader` directly reads characters from a file.

`BufferedReader` wraps a `Reader`, adds buffering for better performance, and provides the `readLine()` method.

---

## Q13. What is PrintWriter?

**Answer:**

`PrintWriter` is a character stream that provides convenient methods like `print()`, `println()`, and `printf()` for writing formatted text.

---

## Q14. Difference between PrintWriter and BufferedWriter?

**Answer:**

`PrintWriter` focuses on convenience and formatting.

`BufferedWriter` focuses on efficient buffered writing.

---

## Q15. What is Serialization?

**Answer:**

Serialization is the process of converting a Java object into a byte stream so that it can be stored in a file or transmitted over a network.

---

## Q16. What is Deserialization?

**Answer:**

Deserialization is the reverse process of serialization. It reconstructs a Java object from a byte stream.

---

## Q17. What is Serializable?

**Answer:**

`Serializable` is a marker interface. It has no methods and simply tells the JVM that objects of the class are allowed to be serialized.

---

## Q18. What is a Marker Interface?

**Answer:**

A marker interface is an interface that contains no methods or fields. It provides metadata to the JVM or compiler.

Examples:

* `Serializable`
* `Cloneable`

---

## Q19. What is the transient keyword?

**Answer:**

The `transient` keyword prevents a field from being serialized.

It is commonly used for:

* Passwords
* OTPs
* Temporary cache values
* Sensitive information

---

## Q20. What is serialVersionUID?

**Answer:**

`serialVersionUID` is a unique version identifier for a serializable class. It helps Java verify compatibility between the serialized object and the current class definition during deserialization.

---

## Q21. What is ObjectOutputStream?

**Answer:**

`ObjectOutputStream` serializes Java objects and writes them to an output stream.

---

## Q22. What is ObjectInputStream?

**Answer:**

`ObjectInputStream` reads serialized objects from an input stream and reconstructs them into Java objects.

---

## Q23. What is DataOutputStream?

**Answer:**

`DataOutputStream` writes Java primitive data types (`int`, `double`, `boolean`, etc.) and strings in binary format.

---

## Q24. What is DataInputStream?

**Answer:**

`DataInputStream` reads primitive data types written by `DataOutputStream`.

---

## Q25. Why must reading order match writing order in Data Streams?

**Answer:**

Because binary data does not contain information about the type or order of values. Reading in a different order causes incorrect interpretation of the bytes, resulting in corrupted data or exceptions.

---

## Q26. What is the difference between Data Streams and Object Streams?

**Answer:**

Data Streams store primitive values.

Object Streams store complete Java objects.

Object Streams require the class to implement `Serializable`.

---

## Q27. What is the difference between Scanner and BufferedReader?

**Answer:**

| Scanner            | BufferedReader                  |
| ------------------ | ------------------------------- |
| Slower             | Faster                          |
| Automatic parsing  | Manual parsing                  |
| Reads tokens       | Reads complete lines            |
| Good for beginners | Good for high-performance input |

---

## Q28. Why is Scanner slower than BufferedReader?

**Answer:**

Scanner performs tokenization, validation, and automatic type conversion. BufferedReader simply reads text, making it faster.

---

## Q29. Why do we use InputStreamReader with BufferedReader?

**Answer:**

Because `System.in` is a byte stream, while `BufferedReader` requires a character stream. `InputStreamReader` converts bytes into characters.

---

## Q30. Why does nextInt() followed by nextLine() cause problems?

**Answer:**

`nextInt()` reads only the integer and leaves the newline character (`\n`) in the input buffer. The next `nextLine()` immediately consumes that leftover newline, resulting in an empty string.

---

## Q31. What is the Console class?

**Answer:**

`Console` is used for secure console input. Its `readPassword()` method hides the password while the user types.

---

## Q32. Why does Console return char[] instead of String?

**Answer:**

A `char[]` can be cleared from memory after use, whereas a `String` is immutable and remains in memory until garbage collection.

---

## Q33. What is NIO.2?

**Answer:**

NIO.2 is the modern file API introduced in Java 7. It provides classes such as `Path` and `Files` for cleaner, more powerful, and easier file handling than the legacy `File` API.

---

## Q34. What is Path?

**Answer:**

`Path` represents the location of a file or directory. It does not perform file operations; it only represents the path.

---

## Q35. What is the Files class?

**Answer:**

`Files` is a utility class containing static methods to create, copy, move, delete, read, and write files.

---

## Q36. Difference between File and Path?

**Answer:**

`File` is the legacy API introduced in Java 1.0.

`Path` is the modern API introduced in Java 7. It is more flexible, integrates better with modern file operations, and is the preferred choice in new Java applications.

---

## Q37. Which Java I/O classes are commonly used in backend development?

**Answer:**

* `BufferedReader` – Reading text efficiently.
* `BufferedWriter` / `PrintWriter` – Writing text and logs.
* `Files` and `Path` – Modern file operations.
* `FileInputStream` / `FileOutputStream` – Binary files.
* `ObjectOutputStream` / `ObjectInputStream` – Serialization.
* `DataInputStream` / `DataOutputStream` – Primitive binary data.
