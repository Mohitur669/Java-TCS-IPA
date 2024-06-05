/*
Create a class Fruits with below attributes as private
● int fruitId
● String fruitName
● int price
● int rating

Write getters, setters and parameterized constructor in the abovementioned attribute
sequence as required.

Create class Solution with main method

Implement One static method-

● findMaximumPriceByRating

findMaximumPriceByRating in the solution class.
This method will take array of Fruit objects, int paramater and returns the maximum priced fruit
object from array of Fruit objects whichever has rating greater than the rating
(rating parameter passed). This method should be called from main method.

Write code to perform following tasks:

1. Take necessary input variable and call findMaximumPriceByRating.

For this method- The main method should print the fruitId from returnedobject. As if the
returned value is not null, or it should print "No such Fruit".

Note:- Before calling this static method, use Scanner object to read thevalues of four Fruits
objects. No two Fruits will have same price. All thesearches should be case insensitive.
Consider below sample input and output to test your code.


Input
-------------------
555
Apple
200
5
777
Orange
150
4
333
Banana
100
4
888
Avocado
250
4
3

Output
-----------------
888
 */

import java.util.*;

public class FruitMarket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fruits[] fr = new Fruits[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();

            fr[i] = new Fruits(a, b, c, d);
        }

        int rating = sc.nextInt();
        Fruits ans = findMax(fr, rating);

        if (ans != null) {
            System.out.println(ans.getId());
        } else {
            System.out.println("No such fruit");
        }
    }

    public static Fruits findMax(Fruits[] fr, int rating) {
        Fruits ans = null;

        int max = fr[0].getPrice();
        for (Fruits f : fr) {
            if (f.getPrice() > max && f.getRating() > rating) {
                max = f.getPrice();
                ans = f;
            }
        }

        return ans;
    }
}

class Fruits {
    private int id;
    private String name;
    private int price;
    private int rating;

    public Fruits(int id, String name, int price, int rating) {
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