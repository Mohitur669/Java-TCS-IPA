/*
Create a class BankAccount with the following attributes:

accountNumber - int
accountHolderName - String
balance - double

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create a class Solution with the main method.

Implement two static methods - withdraw and deposit in Solution class.

withdraw method:
------------------------------------------
This method will take two input parameters - array of BankAccount objects and the account number (int) from which withdrawal
should be done.
The method will check if the account number is present in the array of BankAccount objects.
If present, the method will then check if the balance is sufficient to withdraw the requested amount (double). If yes, it will
deduct the amount from the account balance and return the updated balance.
If the account number is not present or the balance is not sufficient, the method should return -1.

deposit method:
--------------------------------------------
This method will take two input parameters - array of BankAccount objects and the account number (int) in which deposit should
be done.
The method will check if the account number is present in the array of BankAccount objects.
If present, it will add the deposit amount (double) to the account balance and return the updated balance.
If the account number is not present, the method should return -1.

These above mentioned static methods should be called from the main method.

For withdraw method - The main method should print the updated balance if the returned value is greater than or equal to 0, or
it should print "Sorry - Insufficient balance" if the returned value is -1, or it should print "Sorry - Account not found" if
the returned value is -2.

For deposit method - The main method should print the updated balance if the returned value is greater than or equal to 0, or
it should print "Sorry - Account not found" if the returned value is -1.

Before calling these static methods in main, a parameterized constructor in the above mentioned attribute sequence as required.

Input
------------------------
1001
Alice
5000.0
1002
Bob
10000.0
1003
Charlie
15000.0
1002
5000.0
1001
10000.0

Output
---------------------------
5000.0
15000.0

 */

import java.util.*;

public class BankAccounts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount[] bank = new BankAccount[3];
        for (int i = 0; i < 3; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            double c = sc.nextDouble();

            bank[i] = new BankAccount(a, b, c);
        }

        int no = sc.nextInt();
        double wa = sc.nextDouble();

        int ac = sc.nextInt();
        Double da = sc.nextDouble();

        double ans = withdraw(bank, no, wa);
        if (ans >= 0) {
            System.out.println(ans);
        } else if (ans == -1) {
            System.out.println("Sorry - Insufficient balance");
        } else if (ans == -2) {
            System.out.println("Sorry - Account not found");
        }

        double result = deposit(bank, ac, da);
        if (result >= 0) {
            System.out.println(result);
        } else {
            System.out.println("Sorry - Account not found");
        }
    }

    // Todo - returning different values
    public static double withdraw(BankAccount[] bank, int no, double wa) {
        for (BankAccount b : bank) {
            if (b.getAcNo() == no) {
                if (b.getBalance() >= wa) {
                    b.setBalance(b.getBalance() - wa);
                    return b.getBalance();
                } else {
                    return -1;
                }
            }
        }

        return -2;
    }

    public static double deposit(BankAccount[] bank, int ac, double da) {
        for (BankAccount b : bank) {
            if (b.getAcNo() == ac) {
                b.setBalance(b.getBalance() + da);
                return b.getBalance();
            }
        }

        return -1;
    }
}

class BankAccount {
    private int acno;
    private String acname;
    private double balance;

    public BankAccount(int acno, String acname, double balance) {
        this.acno = acno;
        this.acname = acname;
        this.balance = balance;
    }

    public int getAcNo() {
        return acno;
    }

    public void setAcNo(int acno) {
        this.acno = acno;
    }

    public String getAcName() {
        return acname;
    }

    public void setAcName(String acname) {
        this.acname = acname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}