# Nova Bank ATM Management System

![Bank Logo](src/icons/logo.jpg)

A comprehensive Java-based Bank Management System with ATM functionality built using Java Swing for the user interface and MySQL for database management.

## 📋 Features

- **User Authentication**
  - Secure login with card number and PIN
  - New user registration (signup) with detailed personal information
  - PIN change functionality

- **Account Management**
  - Check account balance
  - View transaction history
  - Generate mini statements

- **Transaction Operations**
  - Deposit funds
  - Withdraw cash
  - Money transfer between accounts
  - Transaction history tracking

- **User-Friendly Interface**
  - Modern GUI built with Java Swing
  - Responsive design with intuitive navigation
  - ATM interface simulation
  
## 🖼️ Screenshots

### Login Screen
![Login Screen](screenshots/login_screen.png)
*The main login interface where users enter their card number and PIN*

### Registration Process
![Registration Form - Personal Details](screenshots/signup_personal.png)
*Page 1: Personal details registration form*

![Registration Form - Additional Details](screenshots/signup_additional.png)
*Page 2: Additional information collection*

![Registration Form - Account Details](screenshots/signup_account.png)
*Page 3: Account type selection and service options*

### Main ATM Interface
![ATM Transaction Menu](screenshots/transaction_menu.png)
*Main transaction menu with all available banking operations*

### Deposit & Withdrawal
![Deposit Screen](screenshots/deposit_screen.png)
*Interface for depositing funds into account*

![Withdrawal Screen](screenshots/withdrawal_screen.png)
*Interface for withdrawing funds from account*

### Account Management
![Balance Inquiry](screenshots/balance_inquiry1.png)
*Screen showing current account balance*

![Balance Inquiry](screenshots/balance_inquiry2.png)
*Screen showing current account balance*

![Mini Statement](screenshots/mini_statement1.png)
*Transaction history and account details*

![Mini Statement](screenshots/mini_statement2.png)
*Transaction history and account details*

### Money Transfer
![Recipient Selection](screenshots/money_transfer1.png)
*First step of money transfer - entering recipient details*

![Transfer Amount](screenshots/money_transfer2.png)
*Second step of money transfer - entering amount and confirming*

### Security
![PIN Change](screenshots/pin_change.png)
*Interface for changing the account PIN*

## 🔧 Technologies Used

- **Java** - Core programming language
- **Java Swing** - For creating the graphical user interface
- **MySQL** - Database for storing user data and transactions
- **JDBC** - For database connectivity
- **jcalendar** - For date selection in forms

## ⚙️ System Requirements

- Java JDK 23 or later
- MySQL Server
- MySQL Connector/J 9.4.0
- jcalendar-tz-1.3.3-4.jar
- NetBeans IDE (recommended for development)

## 🚀 Installation & Setup

1. **Clone the repository**
   ```
   git clone https://github.com/itssoumodip/Java-ATM-Banking-System.git
   ```

2. **Set up the database**
   - Create a MySQL database named `bankmanagmentsystem`
   - Update the database connection parameters in the `Conn.java` file if needed
   ```java
   c = DriverManager.getConnection("jdbc:mysql:///bankmanagmentsystem", "root", "yourpassword");
   ```

3. **Add required libraries**
   - Add MySQL Connector/J to your project
   - Add jcalendar-tz library to your project

4. **Compile and run the application**
   - The entry point is the `Login.java` class

## 📝 Database Structure

The system uses a MySQL database with the following main tables:

- **Account**: Stores account details including card number, PIN, and balance
- **Users**: Stores user personal information
- **Transactions**: Records all transaction history

## 🧩 Project Structure

- **Login.java**: Entry point, handles user authentication
- **SignupOne.java**, **SignupTwo.java**, **SignupThree.java**: Multi-step registration process
- **Transaction.java**: Main dashboard for various banking operations
- **Deposite.java**: Handles deposit functionality
- **Withdrawl.java**: Handles withdrawal functionality
- **checkBalance.java**: For balance inquiries
- **MiniStatement.java**: Shows recent transaction history
- **moneyTransfer.java**: Facilitates funds transfer between accounts
- **PinChange.java**: Allows users to update their PIN
- **Conn.java**: Manages database connections

## ⚠️ Security Considerations

- Passwords are stored in the database (consider implementing encryption in production)
- The system uses basic SQL queries (implement prepared statements for production to prevent SQL injection)
- Always use secure connection strings in a production environment

## 🛠️ Future Enhancements

- Implement password hashing for better security
- Add email verification for new accounts
- Implement two-factor authentication
- Add admin dashboard for bank managers
- Improve transaction history with advanced filtering options

## 👥 Contributors

- Soumodip - Project Developer

## 📄 License

This project is available for educational and personal use.

---

© 2025 Nova Bank ATM Management System
