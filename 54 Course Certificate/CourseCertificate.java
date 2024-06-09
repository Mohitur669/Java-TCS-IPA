/*
Create a Class Course with below attributes:

CourseId - Int
CourseName - String
CourseRating - double
Mode - String
HaveCertificate - boolean

Write getters, setters and parameterized constructor as required.

Create class Solution with main method.

Implement static method - CountCourse in Solution class.

This method will take a String parameter and a double parameter along with the other parameter as array of Course objects.
The method will return the total number of courses which have certificate facility and the rating of the course object is greater
than or equal to the given parameter with match the mode(with case insensitive search).

If no count is there then print "No course found".

Consider below sample input and output:

Input 1:
------------
1001
Java
5
Online
True
1002
Python
3
Offline
False
1003
HTML
4
Offline
True
1004
JavaScript
2
Online
False
3
Online


Output 1:
------------
1
=========================================
Input 2:
------------
1001
Java
5
Online
True
1002
Python
3
Offline
False
1003
HTML
4
Offline
True
1004
JavaScript
2
Online
False
5
Offline

Output 2:
-------------
No course found
 */

import java.util.*;

public class CourseCertificate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Certificate[] course = new Certificate[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            double c = sc.nextDouble();
            sc.nextLine();
            String d = sc.nextLine();
            boolean e = sc.nextBoolean();
            sc.nextLine();

            course[i] = new Certificate(a, b, c, d, e);
        }

        double rating = sc.nextDouble();
        sc.nextLine();
        String mode = sc.nextLine();

        int count = countCourse(course, mode, rating);
        if (count > 0) {
            System.out.println(count);
        } else {
            System.out.println("No course found");
        }
    }

    public static int countCourse(Certificate[] course, String mode, double rating) {
        int count = 0;

        for (Certificate c : course) {
            if (c.isCertificate() && c.getRating() >= rating && c.getMode().equalsIgnoreCase(mode)) {
                count++;
            }
        }

        return count;
    }
}

class Certificate {
    private int id;
    private String name;
    private double rating;
    private String mode;
    private boolean certificate;

    public Certificate(int id, String name, double rating, String mode, boolean certificate) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.mode = mode;
        this.certificate = certificate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isCertificate() {
        return certificate;
    }

    public void setCertificate(boolean certificate) {
        this.certificate = certificate;
    }
}