/*
Create a class called Employee with the below attributes:

employeeId - int
name - String
branch - String
rating - double
companyTransport - boolean
The above attributes should be private. write getters, setters and parameterized constructor as required.

Create class MyClass with main method.
Implement two static methods findCountOfEmployeesUsingCompTransport and findEmployeeWithSecondHighestRating
in MyClass class.

findCountOfEmployeesUsingCompTransport method:
----------------------------------------------
This method will take an array of Employee object and a String parameter as input parameters.
This method will calculate and return the count of Employees who are all using company transport
in the given branch (String parameter passed).
If no Employee in the given branch using company transport in the array of Employee objects, then
the method should return 0.

findEmployeeWithSecondHighestRating method:
--------------------------------------------
This method will take an array of Employee objects as an input parameter. This method will return
the object of the second highest rating employee from the array of Employee objects who are not using
company transport.
If all Employees using company transport in the array of Employee objects, then the method should return null.

Note: All the searches should be case sensitive, companyTransport and rating combination of each Employee
is unique.
For findCountOfEmployeesUsingCompTransport method, The main method should print the returned count as it
is if the returned value is greater than 0, else it should print "No such Employees".
Ex: 2 , where 2 is the count


For findEmployeeWithSecondHighestRating method: The main method should print the employeeld and name from
the returned object if the returned value is not null. If the returned value is null, then it should
print "All Employees using company transport".
Ex: 1003
    Uma
where 1003 is the employeeld and Uma is the name.
Before calling these static methods in main, use Scanner object to read the values of four Employee
objects referring attributes in the above mentioned attributes sequence. Next, read the value of String
parameter for capturing branch.

Input :

1001
Ashwa
IT
5
true
1002
Preeti
IT
4
true
1003
Uma
Admin
3
false
1004
Akash
Hardware
4.5
false
IT



Output :

2
1003
Uma
 */

import java.util.*;

public class EmployeeDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] em = new Employee[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            boolean e = sc.nextBoolean();

            em[i] = new Employee(a, b, c, d, e);
        }

        sc.nextLine();
        String br = sc.nextLine();
        int count = findCount(em, br);
        if (count > 0) {
            System.out.println(count);
        } else {
            System.out.println("No such Employees");
        }

        Employee e = findEm(em);
        if (e != null) {
            System.out.println(e.getEmployeeId());
            System.out.println(e.getName());
        } else {
            System.out.println("All Employees using company transport");
        }

    }

    public static int findCount(Employee[] em, String br) {
        int count = 0;

        for (Employee e : em) {
            if (e.getBranch().equalsIgnoreCase(br) && e.getCompanyTransport()) {
                count++;
            }
        }

        return count;
    }

    public static Employee findEm(Employee[] em) {
        Employee high = null;
        Employee second = null;

        for (Employee e : em) {
            if (!e.getCompanyTransport()) {
                if (high == null || e.getRating() > high.getRating()) {
                    second = high;
                    high = e;
                } else if (second == null || e.getRating() > second.getRating()) {
                    second = e;
                }
            }
        }

        return second;
    }
}

class Employee {
    private int employeeId;
    private String name;
    private String branch;
    private double rating;
    private boolean companyTransport;

    public Employee(int employeeId, String name, String branch, double rating, boolean companyTransport) {
        this.employeeId = employeeId;
        this.name = name;
        this.branch = branch;
        this.rating = rating;
        this.companyTransport = companyTransport;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean getCompanyTransport() {
        return companyTransport;
    }

    public void setCompanyTransport(boolean companyTransport) {
        this.companyTransport = companyTransport;
    }
}