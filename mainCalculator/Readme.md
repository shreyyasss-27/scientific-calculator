# 🧮 Java Calculator

A menu-driven console-based calculator application developed in Java that performs a wide range of mathematical operations, including arithmetic and trigonometric functions. The application also supports result storage, history tracking, and file-based logging.

---

## 🚀 Features

- 🔢 Basic Operations
    - Addition
    - Subtraction
    - Multiplication
    - Division

- 📐 Advanced Operations
    - Power
    - Square Root

- 📊 Trigonometric Functions
    - Sine
    - Cosine
    - Tangent

- 💾 Memory Functions
    - Store result
    - Recall result
    - Clear result

- 📜 History Tracking
    - Stores previous results
    - Displays result history

- 📝 Operation Logging
    - Logs each operation with result

- ⚠️ Error Handling
    - Handles division by zero

---

## 🛠️ Tech Stack

- Language: Java
- IDE: IntelliJ IDEA
- Concepts Used:
    - Object-Oriented Programming (OOP)
    - File Handling (BufferedReader, BufferedWriter)
    - Exception Handling

---

## 📂 Project Structure
```
mainCalculator/
│
├── Calculator.java
├── History/
│ ├── resultHistory.txt
│ ├── operationLog.txt
│ └── specialResultHistory.txt
```

---

---

## ▶️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/java-calculator.git
   
2. Open in IntelliJ IDEA or any Java IDE
3. Run:
   ```bash
   Calculator.java
   
---
## 🧠 How It Works
- Displays a menu of operations
- Takes user input using Scanner
- Performs selected operation
- Stores results in files
- Maintains a running result for chained calculations
