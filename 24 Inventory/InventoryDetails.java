/*
Create class Inventory with below attributes:

inventoryId - String
maximumQuantity - int
currentQuantity - int
threshold - int

Create class Solution and implement static method "Replenish" in the Solution class.
This method will take array of Inventory objects and a limit int as parameters.
And will return another array of Inventory objects where the limit int is greater than or equal to the original array of
Inventory object's threshold attribute.

Write necessary getters and setters.

Before calling "Replenish" method in the main method, read values for four Inventory objects referring the attributes in above
sequence along with a int limit.Then call the "Replenish" method and write logic in main method to print "Critical Filling",
if the threshold attribute is greater than 75. Else if the threshold attribute is between 50 and 75 then print
"Moderate Filling". Else print "Non-Critical Filling"

Input
---------------------------
1
100
50
50
2
200
60
40
3
150
35
45
4
80
45
40
45

Output
----------------------------
2 Non-Critical Filling
3 Non-Critical Filling
4 Non-Critical Filling
 */

import java.util.*;

public class InventoryDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory[] inv = new Inventory[4];

        for (int i = 0; i < 4; i++) {
            String a = sc.nextLine();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            sc.nextLine();

            inv[i] = new Inventory(a, b, c, d);
        }

        int limit = sc.nextInt();
        Inventory[] ans = replenish(inv, limit);
        for (Inventory i : ans) {
            if (i.getTh() > 75) {
                System.out.println(i.getId() + " Critical Filling");
            } else if (i.getTh() >= 50 && i.getTh() <= 75) {
                System.out.println(i.getId() + " Moderate Filling");
            } else {
                System.out.println(i.getId() + " Non-Critical Filling");
            }
        }

    }

    public static Inventory[] replenish(Inventory[] inv, int limit) {
        List<Inventory> l = new ArrayList<>();

        for (Inventory i : inv) {
            if (limit >= i.getTh()) {
                l.add(i);
            }
        }

        int count = 0;
        Inventory[] ans = new Inventory[l.size()];
        for (Inventory i : l) {
            ans[count++] = i;
        }

        return ans;
    }
}

class Inventory {
    private String id;
    private int max, cur, th;

    public Inventory(String id, int max, int cur, int th) {
        this.id = id;
        this.max = max;
        this.cur = cur;
        this.th = th;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCur() {
        return cur;
    }

    public void setCur(int cur) {
        this.cur = cur;
    }

    public int getTh() {
        return th;
    }

    public void setTh(int th) {
        this.th = th;
    }
}