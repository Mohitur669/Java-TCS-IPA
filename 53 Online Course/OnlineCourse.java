/*
Create a Class Course with below attributes:

CourseName - String
CourseNumber - int
Mode - String
Sharedata - boolean

Write getters, setters and parameterized constructor as required.

Create class Solution with main method.

Implement static method - findCourseStatus in Solution class.

This method will take a String parameter along with the other parameter as array of Course objects.
The method will return status where the String parameter appears in the side attribute (with case insensitive search).

If the number of the course greater than equal to 1000, print "High", if greater or equal to 500 but less than 1000 then print
"Medium" and if less than 500 then print "Low".

If the taken string not match with the Course name then print "No course found".


Consider below sample input and output:

Input 1:
------------
Java
1200
Online
False
Python
600
Offline
False
HTML
800
Offline
False
JavaScript
300
Online
True
Python

Output 1:
------------
Medium
=========================================
Input 2:
------------
Java
1200
Online
False
Python
600
Offline
False
HTML
800
Offline
False
JavaScript
300
Online
True
PHP

Output 2:
-------------
No course found
 */

import java.util.*;

public class OnlineCourse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Courses[] course = new Courses[4];

        for (int i = 0; i < 4; i++) {
            String a = sc.nextLine();
            int b = sc.nextInt();
            sc.nextLine();
            String c = sc.nextLine();
            boolean d = sc.nextBoolean();
            sc.nextLine();

            course[i] = new Courses(a, b, c, d);
        }

        String name = sc.nextLine();

        String ans = findCourseStatus(course, name);
        if (ans != null) {
            System.out.println(ans);
        } else {
            System.out.println("No course found");
        }
    }

    public static String findCourseStatus(Courses[] course, String name) {
        String ans = null;

        for (Courses c : course) {
            if (c.getName().equalsIgnoreCase(name)) {
                int n = c.getNumber();
                if (n >= 1000) {
                    ans = "High";
                }
                if (n >= 500 && n < 1000) {
                    ans = "Medium";
                }
                if (n < 500) {
                    ans = "Low";
                }
            }
        }

        return ans;
    }
}


class Courses {
    String name, mode;
    int number;
    boolean data;

    public Courses(String name, int number, String mode, boolean data) {
        this.name = name;
        this.mode = mode;
        this.number = number;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }
}