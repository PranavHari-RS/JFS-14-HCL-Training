# PGCRP - A1 Core Java Practical

## Project Overview

This project is a standalone Java console application developed as part of the HCL Java Full Stack Training Day 12 practical assessment.

It implements two core flows of the Public Grievance Complaint Redressal Portal (PGCRP) using plain Java.

## Technologies Used

- Java 21
- Maven
- Java Collections Framework
- Object-Oriented Programming
- Exception Handling

## Core Functionalities

### 1. File Complaint

Citizens can register complaints by entering:

- Citizen ID
- Complaint Category
- Description
- Location

The application generates a unique complaint ID and assigns the initial status `REGISTERED`.

### 2. Track Complaint

Citizens can enter a complaint ID to retrieve complaint details and view the current status.

If the complaint ID does not exist, the application displays an appropriate error message.

## Core Java Concepts

| Concept | Implementation |
|---|---|
| OOP | Classes, objects, constructors, encapsulation |
| Collections | HashMap |
| Exception Handling | Custom exception and input validation |
| Loops | While loop for menu navigation |
| Conditional Logic | Switch statement |
| Scanner | Console input |
| Method Overriding | toString() |

## Project Structure

```text
src/main/java/com/pgcrp/pgcrpcorejavapractical/
├── PgcrpCoreJavaPracticalApplication.java
├── model/
│   └── Complaint.java
├── service/
│   └── ComplaintService.java
└── exception/
    └── ComplaintNotFoundException.java
```

## Build Instructions

Run the following command from the project root:

```powershell
.\mvnw.cmd clean package
```

Expected result:

```text
BUILD SUCCESS
```

## Run Instructions

Open `PgcrpCoreJavaPracticalApplication.java` in IntelliJ IDEA and run the `main()` method.

## Console Menu

```text
======================================
 PUBLIC GRIEVANCE COMPLAINT PORTAL
======================================
1. File Complaint
2. Track Complaint
3. Exit
```

## Validation

The application handles:

- Empty complaint details
- Invalid complaint IDs
- Invalid menu choices

## Limitations

Complaint data is stored in memory using a HashMap and is not preserved after the application exits.

## Assessment

**Day:** 12

**Assessment:** A1 Core Java Practical

**Project:** Public Grievance Complaint Redressal Portal

**Implemented Flows:** File Complaint and Track Complaint