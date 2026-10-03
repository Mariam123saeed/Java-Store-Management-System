# Store Management System

A console-based Store Management System developed in Java as a practical project for applying Java fundamentals, arrays, methods, input validation, and problem-solving.

## Project Overview

The system manages products in a small store through a menu-driven console application.

It supports adding products, displaying product information, selling and restocking products, searching by product code, monitoring low-stock items, calculating inventory value, and generating sales reports.

The project was implemented using Java fundamentals without classes or objects, focusing on procedural programming and building a complete application from basic Java concepts.

## Features

* Add new products
* Display all products
* Sell products
* Restock products
* Search for a product by code
* Show low-stock products
* Calculate total inventory value
* Generate sales reports
* Identify the best-selling product
* Validate user input and handle invalid operations

---

## Prerequisites

Before running the project, install:

* Java JDK 25
* IntelliJ IDEA
* Git

---

## Java JDK 25 Installation – Ubuntu

Java 25 was used to develop and run this project.

### 1. Update package information

```bash
sudo apt update
```

This updates the local package index.

### 2. Check the available Java versions

```bash
apt search openjdk
```

This displays the available OpenJDK packages in the Ubuntu repositories.

### 3. Install OpenJDK 25

If OpenJDK 25 is available through the configured repository:

```bash
sudo apt install openjdk-25-jdk
```

### 4. Verify the Java installation

Check the installed Java version:

```bash
java -version
```

Check the Java compiler:

```bash
javac -version
```

Expected output should indicate Java 25, for example:

```text
openjdk version "25..."
javac 25...
```

### 5. Check the Java installation path

```bash
which java
```

To display the configured Java installations:

```bash
update-java-alternatives --list
```

If multiple Java versions are installed, you can select the required version with:

```bash
sudo update-alternatives --config java
```

Then select Java 25 from the displayed options.

For the compiler:

```bash
sudo update-alternatives --config javac
```

Select the Java 25 compiler.

---

## IntelliJ IDEA Installation – Ubuntu

IntelliJ IDEA was used as the IDE for developing this project.

### Option 1: Install using Snap

Install IntelliJ IDEA Community Edition:

```bash
sudo snap install intellij-idea-community --classic
```

Launch IntelliJ IDEA:

```bash
intellij-idea-community
```

### Option 2: Launch from the Applications Menu

After installation, open:

```text
Applications → Development → IntelliJ IDEA
```

---

## Configure Java 25 in IntelliJ IDEA

After opening the project in IntelliJ IDEA:

```text
File
  ↓
Project Structure
  ↓
Project
```

Set:

```text
Project SDK: Java 25
Language Level: 25
```

If Java 25 is not available:

```text
Project Structure
  ↓
SDKs
  ↓
+
  ↓
Add JDK
```

Select the directory containing the Java 25 JDK.

You can find the installed JDK path using:

```bash
readlink -f $(which javac)
```

For example, the result may point to:

```text
/usr/lib/jvm/java-25-openjdk-amd64/bin/javac
```

In IntelliJ IDEA, select the JDK directory:

```text
/usr/lib/jvm/java-25-openjdk-amd64
```

---

## Running the Project

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA.
2. Open:

```text
src/Main.java
```

3. Make sure Java 25 is selected as the Project SDK.
4. Click the **Run ▶** button.

### Using the Terminal

From the project directory:

```bash
cd ~/Documents/NTI/Technical/java/"Store Management System"
```

Compile the Java source file:

```bash
javac -d out src/Main.java
```

* `javac` → Java compiler.
* `-d out` → Places compiled `.class` files inside the `out` directory.
* `src/Main.java` → Java source file.

Run the compiled program:

```bash
java -cp out Main
```

* `java` → Runs the Java application.
* `-cp out` → Uses the `out` directory as the classpath.
* `Main` → The main class.

---

## Java Concepts Applied

### Java Fundamentals

* Variables and data types
* Constants
* `if / else`
* `switch`
* `for` loops
* `do / while` loops
* `Scanner`
* `printf` formatting

### Arrays

The project uses five parallel arrays to manage product data:

* `productCodes`
* `productNames`
* `prices`
* `stockQuantities`
* `soldQuantities`

A `productCount` variable is used to track the number of active products.

### Methods

The application is divided into focused helper methods, including:

* `findProductIndex()`
* `addProduct()`
* `displayAllProducts()`
* `sellProduct()`
* `restockProduct()`
* `searchProduct()`
* `showLowStockAlert()`
* `calculateInventoryValue()`
* `showSalesReport()`
* `showBestSeller()`

This structure demonstrates how a large program can be divided into smaller, reusable operations.

### Input Validation

The application validates:

* Duplicate product codes
* Empty product names
* Invalid prices
* Negative stock quantities
* Invalid sale quantities
* Selling more than the available stock
* Searching for non-existing products
* Division by zero when there are no sales

### Searching

A linear search is used to find products by their unique product code.

```java
int index = findProductIndex(productCodes, code, productCount);
```

---

## Example Operations

### Add Product

```text
Product Code: 1001
Product Name: Laptop
Price: 1200
Initial Stock: 15

✓ Product added successfully!
```

### Sell Product

```text
Product Code: 1001
Quantity: 5

✓ Sale successful!
Total Price: $6000.00
Remaining Stock: 10 units
```

### Search Product

```text
Product Found:
==================
Code: 1001
Name: Laptop
Price: $1200.00
Stock: 10 units
Sold: 5 units
Total Revenue from this product: $6000.00
==================
```

---

## Project Structure

```text
Store-Management-System/
├── src/
│   └── Main.java
├── README.md
└── .gitignore
```

## Technologies

* Java 25
* IntelliJ IDEA
* Git
* GitHub

## Learning Focus

This project was built as part of a Java learning path to practice programming fundamentals before moving into Object-Oriented Programming.

The project focuses on understanding:

**Variables → Conditions → Loops → Arrays → Methods → Validation → Searching → Problem Solving**

These concepts provide the foundation for the next projects, where Object-Oriented Programming, clean code, and SOLID principles are introduced.

## Author

**Mariam Saeed**

QA / Software Testing Engineer
