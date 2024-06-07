/*
Create a class MobileDetails with the below attributes:

MobileId – int
Price - int
Brand – String
isFlagShip – boolean

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class MobileDetails with main method.

Implement two static methods – getTotalPrice() and getSecondMin() in MobileDetails class.

getTotalPrice method:
----------------------------------------
This method will take two int input parameters which take object array and string brand. The method will return the total
price of mobiles of that brand.

If no mobile with the given brand is present in the array of MobileDetails objects, then the method should return 0.

getSecondMin method:
----------------------------------------
This method will take object array which will return the second minimum price from the array and name of that mobile brand.

The above mentioned static methods should be called from the main method.

For getTotalPrice method: The main method should print the total price as it is, if the returned
value is not null, or it should print “There are no mobile with given brand”.

Before calling these static methods in main, use Scanner object to read the values of five objects referring attributes
in the above mentioned attribute sequence.

Input :
---------------------------------------
101
25000
Samsung
True
102
19000
Redmi
False
103
28000
Nokia
True
104
25000
Realme
False
105
40000
Samsung
True
Samsung

Output :
-----------------------------------------
65000
Samsung : 25000
Realme : 25000
 */

import java.util.*;

public class MobileDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mobile[] mob = new Mobile[5];

        for (int i = 0; i < 5; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();
            String c = sc.nextLine();
            boolean d = sc.nextBoolean();

            mob[i] = new Mobile(a, b, c, d);
        }

        sc.nextLine();
        String brand = sc.nextLine();
        int ans = getTotal(mob, brand);
        if (ans > 0) {
            System.out.println(ans);
        } else {
            System.out.println("There are no mobile with given brand");
        }

        Mobile[] result = getSecond(mob);
        for (Mobile m : result) {
            System.out.println(m.getBrand() + " : " + m.getPrice());
        }
    }

    public static int getTotal(Mobile[] mob, String brand) {
        int ans = 0;

        for (Mobile m : mob) {
            if (m.getBrand().equalsIgnoreCase(brand)) {
                ans += m.getPrice();
            }
        }

        return ans;
    }

    // Todo - second min
    public static Mobile[] getSecond(Mobile[] mob) {
        Mobile[] result = new Mobile[0];

        int min = mob[0].getPrice();
        int second = min;
        for (Mobile m : mob) {
            if (m.getPrice() < min) {
                second = min;
                min = m.getPrice();
            } else if (m.getPrice() > min && m.getPrice() < second) {
                second = m.getPrice();
            }
        }

        for (Mobile m : mob) {
            if (m.getPrice() == second) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = m;
            }
        }

        return result;
    }
}

class Mobile {
    private int id;
    private int price;
    private String brand;
    private boolean isFlagShip;

    public Mobile(int id, int price, String brand, boolean isFlagShip) {
        this.id = id;
        this.price = price;
        this.brand = brand;
        this.isFlagShip = isFlagShip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isFlagShip() {
        return isFlagShip;
    }

    public void setFlagShip(boolean isFlagShip) {
        this.isFlagShip = isFlagShip;
    }
}