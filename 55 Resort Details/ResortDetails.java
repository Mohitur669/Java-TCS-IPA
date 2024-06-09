/*
Create a class Resort with the below attributes:

resortId - int
resortName - String
Category - String
resortPrice - double
resortRating - double

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create class Solution with the main method.

Implement two static methods - findAvgPrice in Solution class.

findAvgPrice method:
----------------------------------
This method will take two input parameters - array of Resort objects and a string parameter.
The method will return the average of the prices from resort objects whose Category matched with passed as parameter and rating
will greater than 4.
If no resort present found, then the method should return 0.

Note : All the searches should be case insensitive.

These above mentioned static methods should be called from the main method.

For findAvgPrice method - The main method should print the average price as it is if the returned value is
greater than 0, or it should print "No such Resort found".

Before calling these static methods in main, use Scanner object to read the values of four resort objects referring attributes
in the above mentioned attribute sequence. Next, read the value for category.

Input
----------
1004
ABC
3 star
5400.00
4.5
1001
DEF
5 star
4781.45
4.0
1002
GHI
3 star
6235.72
4.2
1008
JKL
2 star
7454.00
4.2
3 star

Output
----------
The average price of 3 star:5817
 */

import java.util.*;

public class ResortDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Resort[] rs = new Resort[4];

        for (int i = 0; i < rs.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            double e = sc.nextDouble();

            rs[i] = new Resort(a, b, c, d, e);
        }

        sc.nextLine();
        String category = sc.nextLine();

        int avg = findAvgPrice(rs, category);
        if (avg > 0) {
            System.out.println("The average price of " + category + ":" + avg);
        } else {
            System.out.println("No such resort found");
        }
    }

    public static int findAvgPrice(Resort[] rs, String category) {
        double avg = 0;
        int count = 0;

        for (Resort r : rs) {
            if (r.getCat().equalsIgnoreCase(category)) {
                avg += r.getPrice();
                count++;
            }
        }

        return (int) avg / count;
    }
}

class Resort {
    private int id;
    private String name;
    private String cat;
    private double price;
    private double rate;

    public Resort(int id, String name, String cat, double price, double rate) {
        this.id = id;
        this.name = name;
        this.cat = cat;
        this.price = price;
        this.rate = rate;
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

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}