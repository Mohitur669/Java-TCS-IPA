/*
create the class Course with the below Attributes.

courseId- int
courseName- String
courseAdmin- String
quiz- int
handson -int

The above methods should be private ,write getter and
setter and parametrized constructor as required.

create class courseProgram with main method.

implement two static methods-
   findAvgOfQuizByAdmin method:this method will take array
of Course objects and a String  value as input parameters.
This method will find out Average (as int) of Quiz questions
for given Course Admin (String parametre passed)
This method will return Average if found.if there is no course
that matches then the method should return 0.

sortCourseByHandsOn method:
This method will take an Array of Course Objects and int
value as input parameters.
This methods should return an Array of Course objects in an
ascending order of their  handson which are less than the
given handson(int parameter passed) value. if there is no
such course then the method should return null.

The above mentioned static methods should be called from
main methods.

for findAvgOfQuizByAdmin method: The main method
should print the average if the returned value is not 0.
if the returned value is 0 then it should print "No Course
found."


for sortCourseByHandsOn method:
                        the  main method should print the name
of the Course from the returned Course object Array if the
returned value is not null.if the returned value is null then
it should print "No Course found with mentioned attribute."

input1:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Nisha
17

output1:
35
kubernetes
Apache Spark
cassandra

input2:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Shubhamk
5

output 2:
No Course found
No Course found with mentioned attributes.
*/

import java.util.Arrays;
import java.util.Scanner;

public class CourseProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Course[] courses = new Course[4];

        // taking input
        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            int e = sc.nextInt();
            sc.nextLine();

            courses[i] = new Course(a, b, c, d, e);
        }

        String admin = sc.nextLine();
        int hand = sc.nextInt();

        int findAvg = findAvgOfQuizByAdmin(courses, admin);
        if (findAvg == 0) {
            System.out.println("No Course found.");
        } else {
            System.out.println(findAvg);
        }

        Course[] handsOn = sortCourseByHandsOn(courses, hand);
        if (handsOn != null) {
            for (int i = 0; i < handsOn.length; i++) {
                System.out.println(handsOn[i].getCourseName());
            }
        } else {
            System.out.println("No Course found with mentioned attribute.");
        }

    }

    public static int findAvgOfQuizByAdmin(Course[] c, String s) {
        int sum = 0, count = 0;
        for (int i = 0; i < c.length; i++) {
            Course course = c[i];
            if (course.getCourseAdmin().equals(s)) {
                sum += course.getQuiz();
                count++;
            }
        }

        if (count > 0) {
            return sum / count;
        }

        return 0;
    }

    public static Course[] sortCourseByHandsOn(Course[] courses, int hand) {
        Course[] obj = new Course[4];
        int count = 0;
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].getHandson() < hand) {
                obj[count] = courses[i];
                count++;
            }
        }
        Course val;
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (obj[i].getHandson() > obj[j].getHandson()) {
                    val = obj[i];
                    obj[i] = obj[j];
                    obj[j] = val;
                }
            }
        }

        Course[] ans = Arrays.copyOfRange(obj, 0, count - 1);
        if (ans.length > 0) {
            return ans;
        } else {
            return null;
        }
    }
}

class Course {
    private int courseId, quiz, handson;
    private String courseName, courseAdmin;

    public Course(int courseId, String courseName, String courseAdmin, int quiz, int handson) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseAdmin = courseAdmin;
        this.quiz = quiz;
        this.handson = handson;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getQuiz() {
        return quiz;
    }

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    public int getHandson() {
        return handson;
    }

    public void setHandson(int handson) {
        this.handson = handson;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseAdmin() {
        return courseAdmin;
    }

    public void setCourseAdmin(String courseAdmin) {
        this.courseAdmin = courseAdmin;
    }
}