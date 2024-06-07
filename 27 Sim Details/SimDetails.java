/*
Create class Sim2 with below attributes:

id - int
company - String
balance - int
ratePerSecond - double
circle - String

Create class Solution and implement static method "matchAndSort" in the Solution class.

This method will take array of Sim objects, search_circle String and search_rate double as parameters.
And will return another Sim array where the search_circle matches with the circle parameter of the original Sim array and
the search_rate double is greater than the original array of Sim object's ratePerSecond attribute which is also sorted by
means of balance attribute in descending order.

Write necessary getters and setters.

Before calling "matchAndSort" method in the main method, read values for four Sim objects referring the attributes in above
sequence along with a String search_circle and a double search_rate. Then call the "matchAndSort" method and write logic in
main method to print the id's of the result obtained.

Input
--------------------------
1
jio
430
1.32
mumbai
2
idea
320
2.26
mumbai
3
airtel
500
2.54
mumbai
4
vodafone
640
3.21
mumbai
mumbai
3.4

Output
--------------------------
4
3
1
2
 */

import java.util.*;

public class SimDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sims[] s = new Sims[4];
        for (int i = 0; i < s.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            double d = sc.nextDouble();
            sc.nextLine();
            String e = sc.nextLine();

            s[i] = new Sims(a, b, c, d, e);
        }
        String cir = sc.nextLine();
        double rate = sc.nextDouble();

        Sims[] ans = matchAndSort(s, cir, rate);
        for (Sims a : ans) {
            System.out.println(a.getId());
        }
    }

    public static Sims[] matchAndSort(Sims[] sim, String cir, double rate) {
        List<Sims> l = new ArrayList<>();

        for (Sims s : sim) {
            if (s.getCircle().equalsIgnoreCase(cir) && rate > s.getRps()) {
                l.add(s);
            }
        }

        int count = 0;
        Sims[] ans = new Sims[l.size()];
        for (Sims s : sim) {
            ans[count++] = s;
        }

        for (int i = 0; i < ans.length - 1; i++) {
            for (int j = i + 1; j < ans.length; j++) {
                if (ans[i].getBalance() < ans[j].getBalance()) {
                    Sims temp = ans[i];
                    ans[i] = ans[j];
                    ans[j] = temp;
                }
            }
        }

        return ans;
    }
}

class Sims {
    private int id;
    private String company;
    private int balance;
    private double rps;
    private String circle;

    public Sims(int id, String company, int balance, double rps, String circle) {
        this.id = id;
        this.company = company;
        this.balance = balance;
        this.rps = rps;
        this.circle = circle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getRps() {
        return rps;
    }

    public void setRps(double rps) {
        this.rps = rps;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }
}