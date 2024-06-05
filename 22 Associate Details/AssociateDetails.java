/*
Create class Associate with below attributes:
id - int
name - String
technology - String
experienceInYears - int

Create class Solution and implement static method "associatesForGivenTechnology" in the Solution class.
This method will take array of Associate objects and a searchTechnology String as parameters.
And will return another array of Associate objects where the searchTechnology String matches with the original array of
Associate object's technology attribute (case insensitive search) and experienceInYears attribute should be multiples of 5.

Write necessary getters and setters.

Before calling "associatesForGivenTechnology" method in the main method, read values for five associate objects referring
the attributes in above sequence along with a String searchTechnology.
Then call the "associatesForGivenTechnology" method and write the logic to print the id's in the main method.

Input
-----------------
101
Alex
Java
15
102
Albert
Unix
20
103
Alferd
Testing
13
104
Alfa
Java
15
105
Almas
Java
29
Java

Output
------------------
101
104
 */

import java.util.*;

public class AssociateDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Associate[] ass = new Associate[5];

        for (int i = 0; i < 5; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();

            ass[i] = new Associate(a, b, c, d);
        }

        sc.nextLine();
        String tech = sc.nextLine();

        Associate[] ans = assGivenTech(ass, tech);
        if (ans != null) {
            for (Associate a : ans) {
                System.out.println(a.getId());
            }
        } else {
            System.out.println("No such associate found with given tech");
        }
    }

    public static Associate[] assGivenTech(Associate[] ass, String tech) {
        List<Associate> l = new ArrayList<>();

        for (Associate a : ass) {
            if (a.getTech().equalsIgnoreCase(tech) && a.getYear() % 5 == 0) {
                l.add(a);
            }
        }

        Associate[] ans = new Associate[l.size()];
        int i = 0;
        for (Associate a : l) {
            ans[i++] = a;
        }

        if (ans.length > 0) return ans;
        else return null;
    }
}

class Associate {
    private int id;
    private String name;
    private String tech;
    private int year;

    public Associate(int id, String name, String tech, int year) {
        this.id = id;
        this.name = name;
        this.tech = tech;
        this.year = year;
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

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}