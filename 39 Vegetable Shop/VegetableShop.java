/*
Create a class Vegetable with below attributes:

VegetableId - int
VegetableName - String
Price - int
Rating - int

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods - findMinimumPriceByRating in Solution class.

findMinimumPriceByRating method:
-----------------------------------------------
The method will return minimum price object from array of vegetable objects, whichever by rating greater than given rating.
If no vegetable with the above condition is present in the array of vegetable object, then the mothod return null.

Note :
No vegetable has the same price.
All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For findMinimumPriceByRating method - The main method should print the id of vegetable object or it should print
"No such Vegetables".

Eg: 1002
where 1002 is the id whose price is lowest

Before calling these static methods in main, use Scanner object to read the values of four Vegetable objects referring
attributes in the above mentioned attribute sequence.
Next, read the value of int parameter for rating.

Consider below sample input and output:

Input1
---------------------------
1001
Carrot
90
5
1002
Tomato
40
4
1003
Bectroot
80
4
1004
Onion
78
3
2

Output1
-------------------------------
1002
=====================================================================================
Input2
---------------------------
1001
Carrot
90
5
1002
Tomato
40
4
1003
Bectroot
80
4
1004
Onion
78
3
7

Output2
----------------------------
No such Vegetables
 */

import java.util.*;

public class VegetableShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vegetable[] veg = new Vegetable[4];
        for (int i = 0; i < veg.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();

            veg[i] = new Vegetable(a, b, c, d);
        }

        int rating = sc.nextInt();
        Vegetable ans = findMinPrice(veg, rating);
        if (ans != null) {
            System.out.println(ans.getId());
        } else {
            System.out.println("No such vegetables");
        }
    }

    public static Vegetable findMinPrice(Vegetable[] veg, int rating) {
        Vegetable ans = null;

        int min = veg[0].getPrice();
        for (Vegetable v : veg) {
            if (v.getRating() > rating && v.getPrice() < min) {
                ans = v;
                min = v.getPrice();
            }
        }

        return ans;
    }
}

class Vegetable {
    private int id;
    private String name;
    private int price;
    private int rating;

    public Vegetable(int id, String name, int price, int rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}