import java.text.SimpleDateFormat;
import java.util.*;

// Bank class
class Bank {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Parameterized constructor
    public Bank(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Setters
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Method to withdraw funds
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance in account: " + accountNumber);
        }
        balance -= amount;
    }

    // Method to deposit funds
    public void deposit(double amount) {
        balance += amount;
    }
}

// InsufficientBalanceException class
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Transaction class
class Transaction {
    private String transactionCode;
    private double amount;
    private String timestamp;

    // Parameterized constructor
    public Transaction(String transactionCode, double amount) {
        this.transactionCode = transactionCode;
        this.amount = amount;
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    // Getters
    public String getTransactionCode() {
        return transactionCode;
    }

    public double getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }
}

// BankUtils class
class BankUtils {
    public static Transaction transferFunds(Bank fromAccount, Bank toAccount, double amount, String transactionCode) throws InsufficientBalanceException {
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        return new Transaction(transactionCode, amount);
    }
}

// Main class
public class BankTransactions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input details for Account 1
        System.out.println("Enter details for Account 1:");
        System.out.print("Account Number: ");
        String accountNumber1 = scanner.nextLine();
        System.out.print("Account Holder Name: ");
        String accountHolderName1 = scanner.nextLine();
        System.out.print("Balance: ");
        double balance1 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Input details for Account 2
        System.out.println("Enter details for Account 2:");
        System.out.print("Account Number: ");
        String accountNumber2 = scanner.nextLine();
        System.out.print("Account Holder Name: ");
        String accountHolderName2 = scanner.nextLine();
        System.out.print("Balance: ");
        double balance2 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Create two Bank objects
        Bank account1 = new Bank(accountNumber1, accountHolderName1, balance1);
        Bank account2 = new Bank(accountNumber2, accountHolderName2, balance2);

        // Input transfer details
        System.out.println("Enter transfer details:");
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Transaction Code: ");
        String transactionCode = scanner.nextLine();

        // Print balances before transfer
        System.out.println("\nBefore Transfer:");
        System.out.println("Account 1: " + account1.getAccountHolderName() + " - " + account1.getAccountNumber() + " - " + account1.getBalance());
        System.out.println("Account 2: " + account2.getAccountHolderName() + " - " + account2.getAccountNumber() + " - " + account2.getBalance());

        // Transfer funds
        try {
            Transaction transaction = BankUtils.transferFunds(account1, account2, amount, transactionCode);

            // Print balances after transfer
            System.out.println("\nAfter Transfer:");
            System.out.println("Account 1: " + account1.getAccountHolderName() + " - " + account1.getAccountNumber() + " - " + account1.getBalance());
            System.out.println("Account 2: " + account2.getAccountHolderName() + " - " + account2.getAccountNumber() + " - " + account2.getBalance());

            // Print transaction details
            System.out.println("\nTransaction Details:");
            System.out.println("Transaction Code: " + transaction.getTransactionCode());
            System.out.println("Amount Transferred: " + transaction.getAmount());
            System.out.println("Timestamp: " + transaction.getTimestamp());
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}