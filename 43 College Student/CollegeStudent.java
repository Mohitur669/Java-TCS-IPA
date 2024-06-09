/*
Create a class Student with the following attributes:

name - String
rollNo - String
age - int
gender - char ('M' for male and 'F' for female)
course - String
semester - int
GPA - double

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create a class Solution with the main method.

Implement two static methods - calculateAverageGPA and getStudentsByCourse in Solution class.

calculateAverageGPA method:
This method will take an array of Student objects as input.
The method will return the average GPA of all the students in the array.
If the array is empty, the method should return 0.

getStudentsByCourse method:
This method will take two input parameters - array of Student objects and a course (string).
The method will return an array of Student objects that are enrolled in the specified course.
If no student with the given course is present in the array of Student objects, then the method should return an empty array.

These above mentioned static methods should be called from the main method.

For calculateAverageGPA method - The main method should print the average GPA returned by the method.
If the returned value is 0, then it should print "Sorry - No students are available".

For getStudentsByCourse method - The main method should print the name, roll number and GPA of the returned Student objects.
If the returned value is an empty array, then it should print "Sorry - No students are available for the given course".

Before calling these static methods in main, use Scanner object to read the values of four Student objects referring
attributes in the above mentioned attribute sequence. Next, read the value for a course.

Example Input:
------------------------
John
1234
20
M
CSE
2
3.5
Alice
5678
19
F
EEE
1
3.7
Bob
9101
21
M
CSE
4
3.9
Sarah
2345
20
F
ME
3
3.2
CSE

Example Output:
---------------------------
3.6
John
1234
3.5
Bob
9101
3.9
 */

import java.util.*;

public class CollegeStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student2[] stu = new Student2[4];
        for (int i = 0; i < stu.length; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            char d = sc.nextLine().charAt(0);
            String e = sc.nextLine();
            int f = sc.nextInt();
            double g = sc.nextDouble();
            sc.nextLine();

            stu[i] = new Student2(a, b, c, d, e, f, g);
        }

        String course = sc.nextLine();

        double ans = calculateAvg(stu);
        if (ans > 0) {
            // todo - rounding numbers
            System.out.printf("%.1f", ans);
            System.out.println();
        } else {
            System.out.println("Sorry - No students are available");
        }

        Student2[] result = getStudentByCourse(stu, course);
        if (result.length > 0) {
            for (Student2 s : result) {
                System.out.println(s.getN());
                System.out.println(s.getR());
                System.out.println(s.getGpa());
            }
        } else {
            System.out.println("Sorry - No students are available for the given course");
        }
    }

    public static double calculateAvg(Student2[] stu) {
        if (stu.length == 0) return 0;

        double ans = 0;

        for (Student2 s : stu) {
            ans += s.getGpa();
        }

        return ans / 4;
    }

    public static Student2[] getStudentByCourse(Student2[] stu, String course) {
        Student2[] result = new Student2[0];

        for (Student2 s : stu) {
            if (s.getC().equalsIgnoreCase(course)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = s;
            }
        }

        return result;
    }
}

class Student2 {
    String n, r;
    int a;
    char g;
    String c;
    int s;
    double gpa;

    public Student2(String n, String r, int a, char g, String c, int s, double gpa) {
        this.n = n;
        this.r = r;
        this.a = a;
        this.g = g;
        this.c = c;
        this.s = s;
        this.gpa = gpa;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public char getG() {
        return g;
    }

    public void setG(char g) {
        this.g = g;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}