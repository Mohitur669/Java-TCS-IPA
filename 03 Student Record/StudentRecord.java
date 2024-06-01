/*
Create a class called Student with the below attributes:

rollNo - int
name - String
branch - String
score - double
dayScholar - boolean

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods -findCountOfDayscholarStudents  and findStudentwithSecondHighestScore in Solution
class.

findCountOfDayscholarStudents:

This method will take an array of Student objects as an input parameter . This method will calculate and return
the count of Students whose score is greater than 80 and who are all from dayScholar.

If no Student scored greater than 80 and from dayScholar are present in the array of Student objects, then the
method should return 0.

findStudentwithSecondHighestScore:

This method will take an array of Student objects as an input parameter. This method will return the object
of the second highest score student from the array of Student objects who are not from the dayScholar.

If no Student is a dayScholar  in the array of Student objects, then the method should return null.

Note : All the searches should be case insensitive.

The combination of dayScholar and score for each student is always unique.

The above mentioned static methods should be called from the main method.

For findCountOfDayscholarStudents method - The main method should print the returned count as it is
if the returned value is greater than 0, else it should print "There are no such dayscholar students".

For findStudentwithSecondHighestScore method - The main method should print the rollNo, name and score
in the below format from the returned object if the retuned value is not null.

rollNo#name#score

If the returned value is null, then it should print ”There are no student from non day scholar”

Before calling these static methods in main, use Scanner object to read the values of four Student
objects referring attributes in the above mentioned attribute sequence.
Consider below sample input and output:

Input:

1001
Ashwa
IT
85
true
1002
Preeti
IT
70
false
1003
Uma
ECE
85
false
1004
Akash
EEE
90
true


Output:
2
1002#Preeti#70.0

 */

import java.util.Scanner;

public class StudentRecord {
    public static void main(String[] args) {
        Student[] students = new Student[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < students.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            sc.nextLine();
            boolean e = sc.nextBoolean();

            students[i] = new Student(a, b, c, d, e);
        }

        int countDay = findCountOfDayscholarStudents(students);
        if (countDay > 0) {
            System.out.println(countDay);
        } else {
            System.out.println("There are no such dayscholar students");
        }

        Student second = findStudentwithSecondHighestScore(students);
        if (second != null) {
            System.out.println(second.getRollNo() + "#" + second.getName() + "#" + second.getScore());
        } else {
            System.out.println("There are no student from non day scholar");
        }
    }

    public static int findCountOfDayscholarStudents(Student[] students) {
        int count = 0;

        for (Student s : students) {
            if (s.getScore() > 80 && s.getDayScholar()) {
                count++;
            }
        }

        return count;
    }

    public static Student findStudentwithSecondHighestScore(Student[] students) {
        Student second = null;
        Student max = null;

        for (Student s : students) {
            if (!s.getDayScholar()) {
                if (max == null || s.getScore() > max.getScore()) {
                    second = max;
                    max = s;
                } else if (second == null || s.getScore() > second.getScore() && second.getScore() != max.getScore()) {
                    second = s;
                }
            }
        }

        return second;
    }
}

class Student {
    private int rollNo;
    private String name;
    private String branch;
    private double score;
    private boolean dayScholar;

    public Student(int rollNo, String name, String branch, double score, boolean dayScholar) {
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.score = score;
        this.dayScholar = dayScholar;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean getDayScholar() {
        return dayScholar;
    }

    public void setDayScholar(boolean dayScholar) {
        this.dayScholar = dayScholar;
    }

}