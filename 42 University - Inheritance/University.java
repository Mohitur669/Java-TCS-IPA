/*
Create a class Person with the following attributes:

firstName - String
lastName - String
age - int
gender - char ('M' for male and 'F' for female)

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create a class Student that extends the Person class and adds the following attributes:

rollNo - String
course - String
semester - int
GPA - double

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create a class Faculty that extends the Person class and adds the following attributes:

employeeId - String
department - String
designation - String
salary - double

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create a class Solution with the main method.

Implement two static methods - findHighestGPAStudent and findHighestPaidFaculty in Solution class.

findHighestGPAStudent method:
This method will take an array of Student objects as input.
The method will return the Student object with the highest GPA.
If the array is empty, the method should return null.

findHighestPaidFaculty method:
This method will take an array of Faculty objects as input.
The method will return the Faculty object with the highest salary.
If the array is empty, the method should return null.

These above mentioned static methods should be called from the main method.

For findHighestGPAStudent method - The main method should print the roll number, course and GPA of the returned Student object.
If the returned value is null then it should print "Sorry - No student is available".

For findHighestPaidFaculty method - The main method should print the employee ID, department and salary of the returned
Faculty object.
If the returned value is null then it should print "Sorry - No faculty is available".

Before calling these static methods in main, use Scanner object to read the values of two Student objects and two Faculty
objects referring attributes in the above mentioned attribute sequence.

Example Input:

First1
Last1
20
M
Roll1
Course1
2
3.8
First2
Last2
21
F
Roll2
Course2
3
3.9
Faculty1
Last3
35
M
ID1
Department1
Associate Professor
90000.0
Faculty2
Last4
40
F
ID2
Department2
Professor
100000.0

Output:

Roll2
Course2
3.9
ID2
Department2
100000.0
 */

import java.util.*;

public class University {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Students[] st = new Students[2];
        Faculty[] fa = new Faculty[2];

        // Todo - taking what input is imp
        for (int i = 0; i < st.length; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            char d = sc.nextLine().charAt(0);
            String e = sc.nextLine();
            String f = sc.nextLine();
            int g = sc.nextInt();
            double h = sc.nextDouble();
            sc.nextLine();

            st[i] = new Students(a, b, c, d, e, f, g, h);
        }

        for (int j = 0; j < fa.length; j++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            char d = sc.nextLine().charAt(0);
            String e = sc.nextLine();
            String f = sc.nextLine();
            String g = sc.nextLine();
            double h = sc.nextDouble();
            sc.nextLine();

            fa[j] = new Faculty(a, b, c, d, e, f, g, h);
        }

        Students ans1 = findHighestGPAStudent(st);
        if (ans1 != null) {
            System.out.println(ans1.getRoll());
            System.out.println(ans1.getCourse());
            System.out.println(ans1.getGpa());
        } else {
            System.out.println("Sorry - No student is available");
        }

        Faculty ans2 = findHighestPaidFaculty(fa);
        if (ans2 != null) {
            System.out.println(ans2.getId());
            System.out.println(ans2.getDept());
            System.out.println(ans2.getSal());
        } else {
            System.out.println("Sorry - No faculty is available");
        }
    }

    public static Students findHighestGPAStudent(Students[] s) {
        Students h = s[0];
        for (Students students : s) {
            if (students.getGpa() > h.getGpa()) {
                h = students;
            }
        }

        return h;
    }

    public static Faculty findHighestPaidFaculty(Faculty[] f) {
        Faculty h = f[0];
        for (Faculty faculty : f) {
            if (faculty.getSal() > h.getSal()) {
                h = faculty;
            }
        }

        return h;
    }
}

class Person {
    String fn, ln;
    int age;
    char gen;

    public Person(String fn, String ln, int age, char gen) {
        this.fn = fn;
        this.ln = ln;
        this.age = age;
        this.gen = gen;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGen() {
        return gen;
    }

    public void setGen(char gen) {
        this.gen = gen;
    }
}

class Students extends Person {
    String roll, course;
    int sem;
    double gpa;

    public Students(String fn, String ln, int age, char gen, String roll, String course, int sem, double gpa) {
        super(fn, ln, age, gen);
        this.roll = roll;
        this.course = course;
        this.sem = sem;
        this.gpa = gpa;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}

class Faculty extends Person {
    String id, dept, des;
    double sal;

    public Faculty(String fn, String ln, int age, char gen, String id, String dept, String des, double sal) {
        super(fn, ln, age, gen);
        this.id = id;
        this.dept = dept;
        this.des = des;
        this.sal = sal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
}