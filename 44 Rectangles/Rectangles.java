/*
Create a class Rectangle with the following attributes:

length - double
breadth - double

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create a class Solution with the main method.

Implement two static methods - calculateArea and calculatePerimeter in Solution class.

calculateArea method:
This method will take a Rectangle object as input.
The method will calculate the area of the rectangle and return it as a double.

calculatePerimeter method:
This method will take a Rectangle object as input.
The method will calculate the perimeter of the rectangle and return it as a double.

These above mentioned static methods should be called from the main method.

For calculateArea method - The main method should print the area returned by the method.

For calculatePerimeter method - The main method should print the perimeter returned by the method.

Before calling these static methods in main, use Scanner object to read the values of two Rectangle objects referring
attributes in the above mentioned attribute sequence.

Example Input:
5.5
3.2
7.0
4.5

Example Output:
17.6
17.4
31.5
23.0
 */

import java.util.*;

public class Rectangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle[] rec = new Rectangle[2];
        for (int i = 0; i < 2; i++) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();

            rec[i] = new Rectangle(a, b);
        }

        double[] ans = calculateArea(rec);
        double[] result = calculatePerimeter(rec);

        if (ans != null && result != null) {
            for (int i = 0; i < 2; i++) {
                System.out.println(ans[i]);
                System.out.println(result[i]);
            }
        } else {
            System.out.println("Data not found");
        }
    }

    // todo - creating array from an object with given conditions (obj property)
    public static double[] calculateArea(Rectangle[] rec) {
        double[] ans = new double[0];

        for (Rectangle r : rec) {
            double area = r.getB() * r.getL();
            ans = Arrays.copyOf(ans, ans.length + 1);
            ans[ans.length - 1] = area;
        }

        if (ans.length != 0) {
            return ans;
        }
        return null;
    }

    public static double[] calculatePerimeter(Rectangle[] r) {
        double[] result = new double[0];

        for (int i = 0; i < r.length; i++) {
            double per = 2 * (r[i].getL() + r[i].getB());
            result = Arrays.copyOf(result, result.length + 1);
            result[result.length - 1] = per;
        }

        if (result.length > 0) {
            return result;
        }
        return null;
    }
}

class Rectangle {
    private double l;
    private double b;

    public Rectangle(double l, double b) {
        this.l = l;
        this.b = b;
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}