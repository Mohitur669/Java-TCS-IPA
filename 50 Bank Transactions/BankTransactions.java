import java.text.SimpleDateFormat;
import java.util.Date;

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
        // Create two Bank objects
        Bank account1 = new Bank("12345", "John", 5000.0);
        Bank account2 = new Bank("67890", "Jane", 10000.0);

        // Print balances before transfer
        System.out.println("Before Transfer:");
        System.out.println("Account 1: " + account1.getAccountHolderName() + " - " + account1.getAccountNumber() + " - " + account1.getBalance());
        System.out.println("Account 2: " + account2.getAccountHolderName() + " - " + account2.getAccountNumber() + " - " + account2.getBalance());

        // Transfer funds
        try {
            Transaction transaction = BankUtils.transferFunds(account1, account2, 2000.0, "T0001");

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