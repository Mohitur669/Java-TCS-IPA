/*
Create a class Institution with below attributes:

institutionId - int
institutionName - String
noOfStudentsPlaced - int
noOfStudentsCleared- int
location - String
grade - String

Write getters, setters for the above attributes.
Create constructor which takes parameter in the above sequence except grade.

Create class Solution with main method.
Implement two static methods - FindNumClearancedByLoc and UpdateInstitutionGrade in Solution class.

FindNumClearancedByLoc method:
----------------------------------------------
This method will take two input parameters - array of Institution objects and string parameter location.
The method will return the sum of the noOfStudentsCleared attribute from institution objects for the location passed as
parameter. If no institution with the given location is present in the array of institution objects, then the method
should return 0.

UpdateInstitutionGrade method:
-----------------------------------------------
This method will take a String parameter institutionName, along with the array of Institution objects.
The method will return the institution object, if the input String parameter matches with the institutionName attribute of the
institution object. Before returning the object, the grade should be arrived based on the rating calculation mentioned below.
This grade value should be assigned to the object.If any of the above conditions are not met, then the method should return
null.

* The grade attribute should be calculated as follows:

Rating=(noOfStudentsPlaced * 100)/noOfStudentsCleared
If the rating >= 80 , then grade should be 'A'.
Else, then grade should be 'B'

**Note:**
--------------------------------------------
No institution object would have the same value for institutionName attribute.
All institution object would have the noOfStudentsPlaced value lesser than noOfStudentsCleared value.
All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For FindNumClearancedByLoc method - The main method should print the noOfClearance as it is, if the returned value is
greater than 0, or it should print "There are no cleared students in this particular location".

For UpdateInstitutionGrade method - The main method should print the institutionName and grade of the returned Institution
object. The instituationName and grade should be concatinated with :: while printing. eg:- TCS::A, where TCS is the
institution name and A is the grade.
If the returned value is nullthen it should print "No Institute is available with the specified name".

Before calling these static methods in main, use Scanner object to read the values of four Phone objects referring attributes
in the above mentioned attribute sequence (except grade attribute). Next, read the value for location and institutionName.

Input
-------------------------------------------
111
Amrita
5000
10000
Chennai
222
Karunya
16000
20000
Coimbatore
333
AppleTech
10000
12000
Chennai
444
Aruna
6000
10000
Vellore
Chennai
Karunya

Output
----------------------------------------
22000
Karunya::A

Starter Code
========================================
    import java.util.Scanner
    public class Solution
    {

    public static void main(String[] args)
    {
    //code to read values
    //code to call required method
    //code to display the result
    }

    public static int findNumClearancedByLoc(Institution[] instArray, String location)
    {
    //method logic
    }

    public static Institution updateInstitutionGrade(Institution[] instArray, String instName)
    {
    //method logic
    }
    }
    class Institution
    {
    //code to build Institution class
    }
 */

import java.util.*;

public class Institutions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Institute[] in = new Institute[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();
            sc.nextLine();
            String e = sc.nextLine();

            in[i] = new Institute(a, b, c, d, e);
        }

        String loc = sc.nextLine();
        String name = sc.nextLine();

        int ans = findNum(in, loc);
        if (ans != 0) {
            System.out.println(ans);
        } else {
            System.out.println("There are no cleared students in this particular location");
        }

        Institute result = updateInstitute(in, name);
        if (result != null) {
            System.out.println(result.getName());
        } else {
            System.out.println("No Institute is available with the specified name");
        }

    }

    public static int findNum(Institute[] in, String loc) {
        int ans = 0;

        for (Institute i : in) {
            if (i.getLocation().equalsIgnoreCase(loc)) {
                ans += i.getClear();
            }
        }

        return ans;
    }

    public static Institute updateInstitute(Institute[] in, String name) {
        Institute result = null;
        for (Institute i : in) {
            if (i.getName().equalsIgnoreCase(name)) {
                int rating = (i.getPlaced() * 100) / i.getClear();
                if (rating >= 80) {
                    i.setName(i.getName() + "::A");
                    result = i;
                } else {
                    i.setName(i.getName() + "::B");
                    result = i;
                }
            }
        }

        return result;
    }
}

class Institute {
    private int id, placed, clear;
    private String name, location, grade;

    public Institute(int id, String name, int placed, int clear, String location) {
        this.id = id;
        this.clear = clear;
        this.name = name;
        this.placed = placed;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClear() {
        return clear;
    }

    public void setClear(int clear) {
        this.clear = clear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlaced() {
        return placed;
    }

    public void setPlaced(int placed) {
        this.placed = placed;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}