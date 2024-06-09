/*
Create a class Employee with the below attributes:
EmpId - int
EmpName - String
Dept - String
Rating - int
Salary - int

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create class Solution with the main method.

Implement two static methods - findDept and findSecondHighestSalary in Solution class.

findDept method:
-----------------------------------
This method will take two input parameters - array of Employee objects and int parameter. The method
will return the dept array attribute from employee objects whose salary is matched with int parameter and rating greater than
equal to 3. If no data found of beach objects, then the method should return null.

findSecondHighestSalary method:
-----------------------------------
This method will take two input parameters - array of Employee objects and string parameter. The method
will return the second highest salary from employee objects whose dept is matched with string parameter.
If no data found of beach objects, then the method should return 0.

Note: No two employees have same rating. All the searches should be case insensitive.

These above mentioned static methods should be called from the main method.
For findDept method - The main method should print the dept from the Employee array. If return null, then you should print
"No Department found".
For findSecondHighestSalary method - The main method should print the 2nd highest salary from the Employee array with
the following condition. If return 0, then you should print "No data found".


Input ->
101
Arijit
Computer
4
35000
102
Rakesh
Electronics
2
18000
103
Mahima
Mechanical
3
35000
104
Saniya
Mechanical
5
68000
105
Rajesh
Computer
1
30000
35000
Mechanical

Output ->
Computer, Mechanical
35000
 */

import java.util.*;

public class EmployeeSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee2[] emp = new Employee2[5];

        for (int i = 0; i < emp.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            int e = sc.nextInt();

            emp[i] = new Employee2(a, b, c, d, e);
        }

        int salary = sc.nextInt();
        sc.nextLine();
        String dept = sc.nextLine();

        // todo - output matching
        String[] ans = findDept(emp, salary);
        if (ans.length > 0) {
            String s = Arrays.toString(ans);
            s = s.substring(1, s.length() - 1);
            System.out.println(s);
        } else {
            System.out.println("No department found");
        }

        int secondHighSalary = findSecondHighSalary(emp, dept);
        if (secondHighSalary > 0) {
            System.out.println(secondHighSalary);
        } else {
            System.out.println("No data found");
        }
    }

    public static String[] findDept(Employee2[] emp, int salary) {
        String[] ans = new String[0];

        for (Employee2 e : emp) {
            if (e.getSalary() == salary && e.getRating() >= 3) {
                ans = Arrays.copyOf(ans, ans.length + 1);
                ans[ans.length - 1] = e.getDept();
            }
        }

        return ans;
    }

    public static int findSecondHighSalary(Employee2[] emp, String dept) {
        int max = Integer.MIN_VALUE;
        int second = max;

        for (Employee2 e : emp) {
            if (e.getDept().equalsIgnoreCase(dept)) {
                if (e.getSalary() > max) {
                    second = max;
                    max = e.getSalary();
                } else if (e.getSalary() > second && e.getSalary() < max) {
                    second = e.getSalary();
                }
            }
        }

        return second;
    }
}

class Employee2 {
    int id, rating, salary;
    String name, dept;

    public Employee2(int id, String name, String dept, int rating, int salary) {
        this.id = id;
        this.rating = rating;
        this.salary = salary;
        this.name = name;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}