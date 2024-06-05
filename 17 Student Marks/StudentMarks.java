/*
Create a class Student with below attributes:

rollNo - int
name - String
subject - String
grade - char
date - String [DD/MM/YYYY]



The above attributes should be private.Write Getter and Setter and parametrized constructor as required.


Create class Solution with main method.
****************************************************************************
Implement one static method: findStudentByGradeAndMonth Solution Class.


findStudentByGradeAndMonth Method:

This method will take an array of Student objects, char value as grade and int value as month
for input parameters.The method will find out all Students from the given grade and month.
This method will return array of Student object assending based on their rollNo if found.
If there is no Student that matches then the method should return null.

for this method- main method should print Student name, subject and total student found [The
length of the list], if the returned value is not null. If the returned value is null then
main method should print "No student found".


NOTE:
	1. For Taking char as input use sc.nextLine().charAt(0)
	2. To match/check the month You havee to convert int month in the parameter to String.
	3. No need to count the Student array if return not null just print the array length.


****************************************************************************



Consider the below input and output:


input1:

111
Arijit
Math
B
22/09/2023
101
Priyanka
English
A
30/03/2022
107
Shreosi
History
C
13/05/2022
105
Tatan
Physics
A
27/03/2022
A
3


output1:

Priyanka
English
Tatan
Physics
2





input2:

111
Sohel
Math
B
22/09/2022
101
Priyanka
English
A
30/03/2022
107
Gopa
History
C
12/05/2022
105
Kamal
Physics
A
27/03/2022
A
7



output 2:

No student found
 */

import java.util.*;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stu[] student = new Stu[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            char d = sc.nextLine().charAt(0);
            String e = sc.nextLine();

            student[i] = new Stu(a, b, c, d, e);
        }

        char grade = sc.nextLine().charAt(0);
        int month = sc.nextInt();

        Stu[] ans = findStudent(student, grade, month);
        if (ans.length > 0) {
            for (Stu s : ans) {
                System.out.println(s.getName());
                System.out.println(s.getSub());
            }
            System.out.println(ans.length);
        } else {
            System.out.println("No student found");
        }
    }

    // TODO - Very Important
    public static Stu[] findStudent(Stu[] student, char grade, int month) {
        List<Stu> l = new ArrayList<>();

        for (Stu s : student) {
            String[] m = s.getDate().split("/");
            if (s.getGrade() == grade && Integer.parseInt(m[1]) == month) {
                l.add(s);
            }
        }

        Stu[] ans = new Stu[l.size()];
        int count = 0;
        for (Stu s : l) {
            ans[count++] = s;
        }

        for (int i = 0; i < l.size() - 1; i++) {
            for (int j = i + 1; j < l.size(); j++) {
                if (ans[i].getRoll() > ans[j].getRoll()) {
                    Stu temp = ans[i];
                    ans[i] = ans[j];
                    ans[j] = temp;
                }
            }
        }

        return ans;
    }
}

class Stu {
    private int roll;
    private String name;
    private String sub;
    private char grade;
    private String date;

    public Stu(int roll, String name, String sub, char grade, String date) {
        this.roll = roll;
        this.name = name;
        this.sub = sub;
        this.grade = grade;
        this.date = date;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}