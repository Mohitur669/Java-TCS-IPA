/*
Create a class Employee with the following attributes:

name (string)
age (int)
salary (double)
Write getters, setters, and a parameterized constructor in the above-mentioned attribute sequence as required.

Create a class Solution with the main method.

Implement two static methods - calculateYearlySalary and calculateTax in the Solution class.

calculateYearlySalary method:
-----------------------------------------
This method will take an Employee object as input.
The method will calculate the yearly salary of the employee (assuming that the employee works for 12 months in a year) and
return it as a double.

calculateTax method:
-----------------------------------------
This method will take an Employee object as input.
The method will calculate the tax to be paid by the employee based on the following rules:

If the yearly salary is less than or equal to 50000, the tax is 10% of the yearly salary.
If the yearly salary is greater than 50000 but less than or equal to 100000, the tax is 20% of the amount over 50000 plus 10%
of the first 50000.
If the yearly salary is greater than 100000, the tax is 30% of the amount over 100000 plus 20% of the amount between 50000 and
100000 plus 10% of the first 50000.
The method will return the tax amount as a double.
These above-mentioned static methods should be called from the main method.

For calculateYearlySalary method - The main method should print the yearly salary returned by the method.

For calculateTax method - The main method should print the tax amount returned by the method.

Before calling these static methods in main, use a Scanner object to read the values of an Employee object's attributes.

Example Input:
----------------
John
30
55000.0

Example Output:
----------------
Yearly salary of John: 660000.0
Tax to be paid by John: 183000.0
 */

import java.util.*;

public class Employees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int age = sc.nextInt();
        double salary = sc.nextDouble();

        Employee1 em = new Employee1(name, age, salary);

        double ans = calculateYearlySalary(em);
        System.out.println("Yearly salary of " + name + ": " + ans);

        double tax = calculateTax(em);
        System.out.println("Tax to be paid by " + name + ": " + tax);
    }

    public static double calculateYearlySalary(Employee1 em) {
        return em.getSalary() * 12;
    }

    // todo - tax logic
    public static double calculateTax(Employee1 em) {
        double result = 0;
        double ys = calculateYearlySalary(em);

        if (ys <= 50000) {
            result = ys * 0.10;
        } else if (ys > 50000 && ys <= 100000) {
            result = (50000 * 0.10) + ((ys - 50000) * 0.20);
        } else if (ys > 100000) {
            result = (50000 * 0.10) + (50000 * 0.20) + ((ys - 100000) * 0.30);
        }

        return result;
    }
}


class Employee1 {
    private String name;
    private int age;
    private double salary;

    public Employee1(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}