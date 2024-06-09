/*
Create a Class Player with below attributes:

id - int
country - String
side - String
price - double

Write getters, setters and parameterized constructor as required.

Create class Solution with main method.

Implement static method - searchPlayerForMatch in Solution class.

This method will take a String parameter along with the other parameter as array of Player objects.
The method will return array of Player where the String parameter appears in the side attribute (with case insensitive search).

This method should be called from main method and display the id of returned objects in ascending order.

Before calling this method(searchPlayerForMatch) in the main method, use Scanner object to read values for four Player objects
referring the attributes in the above sequence, then, read the value for search parameter.
Next call the method searchPlayerForMatch, write the logic to sort the id in ascending order (in main method) and display the
result.

Consider below sample input and output:

Input:
------------
1
India
Batting
2500000
2
Australia
Batting
1000000
3
Srilanka
Bowling
1700000
4
England
Bowling
2000000
Batting

Output:
------------
1
2
 */

import java.util.*;

public class PlayerMatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player3[] player = new Player3[4];
        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();

            player[i] = new Player3(a, b, c, d);
        }

        sc.nextLine();
        String side = sc.nextLine();
        Player3[] ans = searchPlayer(player, side);
        for (Player3 p : ans) {
            System.out.println(p.getId());
        }
    }

    public static Player3[] searchPlayer(Player3[] player, String side) {
        Player3[] ans = new Player3[0];

        for (Player3 p : player) {
            if (p.getSide().equalsIgnoreCase(side)) {
                ans = Arrays.copyOf(ans, ans.length + 1);
                ans[ans.length - 1] = p;
            }
        }

        return ans;
    }
}

class Player3 {
    int id;
    String country, side;
    double price;

    public Player3(int id, String country, String side, double price) {
        this.id = id;
        this.country = country;
        this.side = side;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}