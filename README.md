📚 Library Management System

A simple and efficient Java-based Library Management System built using core Java concepts like OOP, File Handling, and Exception Handling. This project allows users to manage books through a console-based interface.

🚀 Features
➕ Add new books
📖 View all books
🔍 Search for books
❌ Delete books
💾 Store data using file handling
⚠️ Custom exception handling (BookNotFoundException)
🛠️ Tech Stack
Java (Core Java)
Object-Oriented Programming (OOP)
File Handling
Exception Handling
📂 Project Structure
Library/
│
├── exception/
│   ├── BookNotFoundException.java
│
├── model/
│   ├── Book.java
│
├── service/
│   ├── LibraryOperations.java
│   ├── LibraryService.java
│
├── util/
│   ├── FileHandler.java
│
├── Main.java
▶️ How to Run
1. Compile the project
javac exception/*.java model/*.java service/*.java util/*.java Main.java
2. Run the project
java Main

⚠️ If your files use package declarations, adjust the run command accordingly.

💡 How It Works
Main.java → Entry point of the application
model → Contains the Book class
service → Handles business logic (add, search, delete)
util → Manages file operations
exception → Custom exception handling
📸 Sample Menu
1. Add Book
2. View Books
3. Search Book
4. Delete Book
5. Exit
🔐 Exception Handling
Uses a custom exception: BookNotFoundException
Ensures proper error messages when a book is not found
📈 Future Enhancements
Convert to Spring Boot REST API
Integrate MySQL database
Add Frontend UI (React / HTML/CSS)
Implement User Authentication
👨‍💻 Author

Surya JV
Java Developer | Backend Enthusiast
