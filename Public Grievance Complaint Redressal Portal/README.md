# Public Grievance Complaint Redressal Portal (PGCRP)

## Project Overview

The Public Grievance Complaint Redressal Portal (PGCRP) is a Java-based console application designed to manage public complaints efficiently.

The system allows citizens to register complaints, route them to appropriate departments, assign field workers, track complaint progress, escalate unresolved issues, submit feedback, and monitor SLA compliance.

This project integrates the Core Java concepts and functionalities developed during Days 1–11 of the HCL Java Full Stack Training Program.

## Technologies Used

- Java 21
- Maven
- Spring Boot (project configuration)
- Java Collections Framework
- Object-Oriented Programming (OOP)
- Java Generics
- Exception Handling
- Java Streams
- CSV File Handling
- Git and GitHub
- IntelliJ IDEA

## Functional Requirements

### FR1: File Complaint
Citizens can register complaints by providing their citizen ID, category, description, and location. Each complaint receives a unique complaint ID.

### FR2: Route Complaint
Registered complaints are processed using a pending queue and marked as routed.

### FR3: Assign Field Worker
Field workers are assigned using the Strategy design pattern.

Implemented strategies:
- CategoryBasedRouting
- LeastLoadedRouting

### FR4: Update Complaint Status
Complaint statuses can be updated to reflect their progress.

Supported statuses:
- REGISTERED
- ROUTED
- ASSIGNED
- IN_PROGRESS
- RESOLVED
- REOPENED

### FR5: Escalate Complaint
Unresolved complaints can be escalated, increasing their priority to HIGH.

### FR6: Track Complaint
Citizens can track complaints using their unique complaint IDs.

### FR7: Rate and Reopen Complaint
Citizens can provide ratings from 1 to 5 and submit feedback for resolved complaints.

Duplicate feedback submissions are prevented.

Resolved complaints can be reopened only once.

### FR8: SLA Compliance
The application generates SLA compliance reports using complaint creation and resolution timestamps.

The current implementation uses a 48-hour SLA threshold.

## Additional Features

- CSV seed data loading
- Generic in-memory repositories
- Complaint sorting and reporting
- Priority-based sorting
- Status-based sorting
- Custom exception handling
- Input validation
- Console-based menu navigation

## Core Java Concepts Implemented

### Object-Oriented Programming
Inheritance, abstraction, encapsulation, and polymorphism are used across the application's models and services.

### Collections Framework
ArrayList, HashMap, ArrayDeque, and other Java collections are used to manage application data.

### Generics
A generic repository provides reusable data access operations.

### Exception Handling
Custom exceptions handle invalid complaint information and missing complaints.

### Strategy Design Pattern
Different worker-assignment strategies are implemented through a common interface.

### Comparator Interface
Custom comparators sort complaints by priority and status.

### Java Streams
Streams are used for filtering, searching, and processing collections.

## Project Architecture

```text
Main Application
       |
       v
ConsoleMenu
       |
       v
ComplaintService
       |
       +---- Models
       |
       +---- Repositories
       |
       +---- Routing Strategies
       |
       +---- Comparators
       |
       +---- CSV Data Loader
```

## Build Instructions

### Prerequisites

- Java 21
- Git
- IntelliJ IDEA or another Java IDE

### Build the Application

Open a terminal in the project root directory.

On Windows:

```powershell
.\mvnw.cmd clean package
```

A successful build displays:

```text
[INFO] BUILD SUCCESS
```

### Run the Application

Open `PublicGrievanceComplaintRedressalPortalApplication.java` in IntelliJ IDEA.

Run the `main()` method.

The application starts with an interactive console menu.

## Testing

The following functionality has been manually tested:

- Complaint registration
- Complaint routing
- Field worker assignment
- Complaint status updates
- Complaint escalation
- Complaint tracking
- Feedback submission
- Duplicate feedback prevention
- One-time complaint reopening
- SLA compliance reports
- Sorted complaint reports
- Application exit

The Maven build has also been verified successfully.

## Current Limitations

- Application data is stored in memory.
- CSV files are used to load initial sample data.
- New complaints and feedback are not permanently persisted.
- The application currently uses a console interface.
- The SLA calculation uses a fixed 48-hour threshold.

## Version

**v1.0-core-java**

Core Java integration milestone covering the functionality developed during Days 1–11.

## Project

HCL Java Full Stack Training – Public Grievance Complaint Redressal Portal.