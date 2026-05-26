# 📇 Contact Management System

A desktop-based **Contact Management System** built using **Java AWT/Swing**, **MySQL**, and **JDBC** for managing contacts efficiently.

This project allows users to **Add, View, Edit, and Delete contacts** while storing data in a MySQL database using **XAMPP**.

---

## 🚀 Project Overview

This project was built as part of my learning journey in Java application development and database integration.

The goal of this project was not only to build a working application but also to understand:

- How real-world projects are structured
- How frontend UI connects with databases
- How CRUD operations work
- How debugging plays a major role in development

---

## ✨ Features

✅ Add New Contact  
✅ View Contact Details  
✅ Edit Existing Contact  
✅ Delete Contact  
✅ MySQL Database Integration  
✅ Desktop UI using Java AWT/Swing  
✅ Dynamic Contact List Refresh

---

## 🛠️ Tech Stack

- **Java**
- **Java AWT / Swing** (UI Design)
- **MySQL**
- **JDBC**
- **XAMPP**
- **IntelliJ IDEA**

---

## 📸 Screenshots

### 🏠 Main Dashboard
https://github.com/Jeswin-Madona/Contact-Management-System-Java/blob/a4bd9a85d96394cb3389ec912190b7a8de6235d4/Screenshot%202026-05-26%20202134.png

### ➕ Add Contact
![img_1.png](img_1.png)

### ✏️ Edit Contact
![img_2.png](img_2.png)

### 🗑️ Delete Contact
https://github.com/Jeswin-Madona/Contact-Management-System-Java/blob/a4bd9a85d96394cb3389ec912190b7a8de6235d4/Screenshot%202026-05-26%20202134.png

### 🗄️ Database in phpMyAdmin
![img_3.png](img_3.png)

---

## 🎥 Project Demo


Watch the demo here:  
https://github.com/Jeswin-Madona/Contact-Management-System-Java/blob/2a62c5fbd906397ecbcf3693f4803298a038aa84/cms.mp4

---

## 📂 Project Structure

```text
ContactManagementSystem/
│── Main.java
│── Database.java
│── Contact.java
│── ContactsList.java
│── OpenContact.java
│── GUI.java
```

### Structure Explanation

### `Main.java`
Acts as the **entry point** of the application.

### `Database.java`
Handles:
- MySQL Connection
- Insert Contact
- Update Contact
- Delete Contact
- Fetch Contacts

### `Contact.java`
Represents the **Contact Model** and stores:
- ID
- First Name
- Last Name
- Phone Number
- Email

### `ContactsList.java`
Displays all contacts in the UI and handles:
- Contact Listing
- View Button
- Edit Button
- Delete Button

### `OpenContact.java`
Handles:
- Creating New Contact
- Editing Contact
- Viewing Contact Details

### `GUI.java`
Contains reusable UI components such as:
- Buttons
- Labels
- TextFields

---

## 💡 Key Learnings From This Project

This project helped me learn much more than just coding.

### 1️⃣ Java UI Development
Learned how to build desktop applications using **Java AWT/Swing**.

### 2️⃣ Database Integration
Understood how to connect Java applications with **MySQL using JDBC**.

### 3️⃣ XAMPP & phpMyAdmin
As a beginner to XAMPP, I learned:
- How MySQL works
- Database creation
- Managing tables
- phpMyAdmin usage
- Port configuration

### 4️⃣ Debugging & Problem Solving
Faced and solved real-world issues like:
- SQL connection errors
- JDBC configuration problems
- MySQL authentication issues
- XAMPP port conflicts
- Database connection debugging

### 5️⃣ Project Architecture
Learned how to organize a project into multiple files instead of writing everything in one class.

This improved my understanding of:
- Separation of concerns
- Code structure
- Maintainability

### 6️⃣ CRUD Operations
Understood how **Create, Read, Update, Delete (CRUD)** operations work in software applications.

---

## ⚙️ Database Setup

### Create Database

```sql
CREATE DATABASE `contacts management system`;
```

### Create Table

```sql
CREATE TABLE contacts (
    ID INT PRIMARY KEY,
    `First Name` VARCHAR(100),
    `Last Name` VARCHAR(100),
    `Phone Number` VARCHAR(20),
    Email VARCHAR(100)
);
```

---

## 🔧 Installation & Setup

### 1. Clone the Repository

```bash
git clone YOUR_GITHUB_LINK
```

### 2. Open in IntelliJ IDEA

### 3. Add MySQL Connector JAR

Download and add:

`mysql-connector-j`

to project libraries.

### 4. Start XAMPP

Start:
- Apache
- MySQL

### 5. Configure Database Credentials

Update `Database.java`:

```java
private String url =
"jdbc:mysql://127.0.0.1:3308/contacts%20management%20system";

private String user = "root";
private String pass = "";
```

### 6. Run the Project

Run:

```text
Main.java
```

---

## 🌱 My Learning Journey

This project started as a simple idea but turned into an amazing learning experience.

While building it, I realized software development is not just about writing code — it is about solving problems.

I encountered:
- Database connection failures
- SQL syntax mistakes
- Port configuration issues
- Authentication problems
- UI bugs

Solving these issues helped me understand how real software projects are built step by step.

This project improved both my **technical skills** and **problem-solving mindset**.

---

## 🤝 Feedback

I’m still learning and improving.

Suggestions and feedback are always welcome!

---

## 📬 Connect With Me

### LinkedIn
https://www.linkedin.com/in/jeswinmadona/

### Portfolio
https://www.jeswin-madona-portfolio.netlify.app


### GitHub
https://github.com/Jeswin-Madona
