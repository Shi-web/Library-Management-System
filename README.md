# Library Management System

This is a Java-based Library Management System that allows users to manage a collection of publications and patrons, and handle checkouts and returns. The system provides a menu-driven interface for users to interact with the library data.

## Features

- **Add Publication**: Add new publications to the library.
- **Add Video**: Add new video materials to the library.
- **Add Patron**: Register new patrons to the library.
- **Check Out Publication**: Allow patrons to check out publications.
- **Check In Publication**: Return checked-out publications to the library.
- **List Patrons**: Display a list of all registered patrons.
- **List Publications**: Display a list of all available publications.
- **Open**: Load library data from a text file.
- **Save**: Save the current library data to a text file.
- **Exit**: Exit the system.

## Getting Started

### Prerequisites

- **Java**: Ensure that Java is installed on your machine. You can verify this by running `java -version` in your terminal.
- **Apache Ant**: This project uses Apache Ant for building. Make sure you have Ant installed. You can verify this by running `ant -version` in your terminal.

### Compilation and Execution

1. **Compile the Project**:
   - Navigate to the project directory where the `build.xml` file is located.
   - Run the following command to compile the project:
     ```bash
     ant
     ```

2. **Run the Project**:
   - After the compilation is successful, run the main program using the following command:
     ```bash
     java mdi.LibraryManager
     ```

### How to Use

- Upon running the program, you will be presented with the main menu.
- Choose an option by entering the corresponding number.
- You can open a `.txt` file to load the library's data. This data can be modified during the session.
- Use the **Save** option to write the changes back to the `.txt` file. The file will reflect all changes made during the session.

### Example Usage

