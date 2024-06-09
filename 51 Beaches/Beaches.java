/*
Create a class Beach with the below attributes:
beachId - int
beachName - String
beachRating - int
beachCost - int
Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create class Solution with the main method.
Implement two static methods - findLeastRatingWithName in Solution class.

findLeastRatingWithName method:
-----------------------------------
This method will take three input parameters - array of Beach objects and string parameter and a int parameter. The method
will return the minimum rating attribute from beach objects whose name is matched with string parameter and whose amount
is greater than the int parameter. If no data found of beach objects, then the method should return 0.

Note : All the searches should be case insensitive.

These above mentioned static methods should be called from the main method.
For findLeastRatingWithName method - The main method should print the least rating from the beach array. If return 0, then
you should print "No beach found".

Input ->
1001
Puri
3
8600
1002
Digha
5
6200
1003
Digha
3
4000
1004
Digha
4
5500
digha
5000

Output ->
4
 */

import java.util.*;

public class Beaches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Beach[] beach = new Beach[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();

            beach[i] = new Beach(a, b, c, d);
        }

        sc.nextLine();
        String name = sc.nextLine();
        int amount = sc.nextInt();

        int min = findLeastRating(beach, name, amount);
        if (min > 0) {
            System.out.println(min);
        } else {
            System.out.println("No beach found");
        }
    }

    public static int findLeastRating(Beach[] beach, String name, int amount) {
        int min = Integer.MAX_VALUE;

        for (Beach b : beach) {
            if (b.getName().equalsIgnoreCase(name) && b.getRating() < min && b.getCost() > amount) {
                min = b.getRating();
            }
        }

        return min;
    }
}

class Beach {
    private int id;
    private String name;
    private int rating;
    private int cost;

    public Beach(int id, String name, int rating, int cost) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.cost = cost;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}