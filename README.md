# Banking System - ATM Simulator

A comprehensive Java Swing-based Banking System that simulates ATM operations with a complete user interface and MySQL database integration.

## 🏦 Project Overview

This ATM Simulator System provides a full-featured banking application that allows users to:
- Create new bank accounts through a multi-step registration process
- Perform various banking transactions
- Manage account settings and view transaction history
- Experience a realistic ATM interface

## 🎯 Features

### Account Management
- **Multi-step Registration Process**:
  - Page 1: Personal Details (Name, DOB, Gender, Address, etc.)
  - Page 2: Additional Details (Religion, Category, Income, Education, etc.)
  - Page 3: Account Setup (Account Type, Services, Card & PIN generation)

- **Account Types Supported**:
  - Savings Account
  - Fixed Deposit Account
  - Current Account
  - Recurring Account

### Banking Operations
- **💰 Deposit Money**: Add funds to your account
- **💸 Withdraw Money**: Withdraw cash with balance validation
- **💳 Balance Inquiry**: Check current account balance
- **📊 Mini Statement**: View account summary and transaction history
- **🔄 Money Transfer**: Transfer funds between accounts
- **🔐 PIN Change**: Update your ATM PIN securely

### Security Features
- Secure login with Card Number and PIN
- PIN validation for sensitive operations
- Minimum balance maintenance (₹500)
- Input validation and error handling

## 🛠️ Technology Stack

- **Frontend**: Java Swing (GUI)
- **Backend**: Java (Core Logic)
- **Database**: MySQL
- **JDBC**: MySQL Connector/J
- **IDE**: NetBeans (evident from .form files)

## 📁 Project Structure

```
Banking_System/
├── src/
│   ├── bank/management/system/
│   │   ├── Login.java              # Main login interface
│   │   ├── SignupOne.java          # Registration page 1 - Personal details
│   │   ├── SignupTwo.java          # Registration page 2 - Additional details  
│   │   ├── SignupThree.java        # Registration page 3 - Account setup
│   │   ├── Transaction.java        # Main transaction menu
│   │   ├── Deposite.java          # Deposit money functionality
│   │   ├── Withdrawl.java         # Withdrawal functionality
│   │   ├── checkBalance.java      # Balance inquiry
│   │   ├── showBalance.java       # Display balance result
│   │   ├── moneyTransfer.java     # Money transfer (Step 1)
│   │   ├── moneyTransfer2.java    # Money transfer (Step 2)
│   │   ├── MiniStatement.java     # Account statement
│   │   ├── tHistory.java          # Transaction history display
│   │   ├── PinChange.java         # PIN change functionality
│   │   └── ResultSet.java         # Database result utilities
│   ├── com/mysql/cj/
│   │   └── jdbc.java              # JDBC driver utilities
│   └── icon/
│       ├── atm.jpg                # ATM machine background image
│       └── logo.jpg               # Bank logo
└── README.md
```

## 🗄️ Database Schema

The system uses MySQL database named `bank` with the following tables:

### 1. `signup` Table
- Personal information from registration step 1
- Fields: formno, name, fathername, dob, gender, email, marital, address, city, state, pin

### 2. `signup2` Table  
- Additional information from registration step 2
- Fields: formno, religion, category, income, education, occupation, pan, aadhar, seniorcitizen, existaccount

### 3. `signup3` Table
- Account details from registration step 3
- Fields: formno, accounttype, cardnumber, pinnumber, facility

### 4. `Account` Table
- Active account information and transactions
- Fields: formno, cardNumber, pinNumber, type, Balance, Date

## 🚀 Installation & Setup

### Prerequisites
- Java JDK 8 or higher
- MySQL Server
- MySQL Connector/J (JDBC Driver)
- NetBeans IDE (recommended)

### Database Setup
1. Install and start MySQL server
2. Create a database named `bank`
3. Update database credentials in the Java files:
   ```java
   c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "YOUR_PASSWORD");
   ```

### Running the Application
1. Clone or download the project
2. Open in NetBeans IDE
3. Add MySQL Connector/J to the project libraries
4. Update database connection details in all Java files
5. Compile and run `Login.java` to start the application

## 🎮 Usage Guide

### For New Users:
1. Launch the application
2. Click "SIGN UP" to create a new account
3. Fill in all three registration forms
4. Note down your generated Card Number and PIN
5. Use credentials to login and access banking services

### For Existing Users:
1. Enter your Card Number and PIN
2. Click "SIGN IN"
3. Select desired transaction from the main menu

## 💡 Key Features Explained

### Account Creation Process
- **Step 1**: Collect personal information (name, address, contact details)
- **Step 2**: Gather additional details (occupation, income, documents)
- **Step 3**: Set up account type and services, generate card number and PIN
- **Initial Balance**: ₹2000 credited to new accounts (demo purposes)

### Transaction Security
- All sensitive operations require card number and PIN verification
- Minimum balance of ₹500 must be maintained
- Real-time balance updates and transaction logging

### User Interface
- Professional ATM-like interface with background images
- Color-coded elements for better user experience
- Intuitive navigation between different banking operations

## 🔧 Configuration

### Database Configuration
Update the following connection details in all Java files:
```java
String url = "jdbc:mysql://localhost:3306/bank";
String username = "root"; 
String password = "YOUR_MYSQL_PASSWORD";
```

### Default Settings
- Minimum balance: ₹500
- Initial demo balance: ₹2000
- Card number format: 16 digits
- PIN format: 4 digits

## 🐛 Known Issues & Notes

1. **Database Connection**: Ensure MySQL server is running before starting the application
2. **Password**: Currently uses hardcoded database password - update for your MySQL setup
3. **File Paths**: Icon files must be in the correct classpath location
4. **Error Handling**: Basic error handling implemented, can be enhanced further

## 🚀 Future Enhancements

- Add loan management features
- Implement transaction limits
- Add email/SMS notifications
- Create admin panel for bank management
- Add multi-language support
- Implement proper encryption for sensitive data

## 📞 Support

For issues or questions:
- Check database connection settings
- Verify MySQL server is running
- Ensure all dependencies are properly configured
- Review console output for error messages

## 📄 License

This project is for educational purposes and demonstrates Java Swing GUI development with database integration.

---

**Note**: This is a simulation system for learning purposes. Do not use in production environments without proper security implementations.
"# Java-ATM-Banking-System" 
