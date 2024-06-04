/*
Create class Medicine with below attributes:

MedicineName - String
batch - String
disease - String
price - int

Create class Solution and implement static method "getPriceByDisease" in the Solution class.
This method will take array of Medicine objects and a disease String as parameters.
And will return another sorted array of Integer objects where the disease String matches with the
original array of Medicine object's disease attribute (case insensitive search).

Write necessary getters and setters.

Before calling "getPriceByDisease" method in the main method, read values for four Medicine objects
referring the attributes in above sequence along with a String disease. Then call the "getPriceByDisease"
method and print the result.

Input
-------------

dolo650
FAC124W
fever
100
paracetamol
PAC545B
bodypain
150
almox
ALM747S
fever
200
aspirin
ASP849Q
flu
250
fever

Output
---------
100
200
 */

import java.util.*;

public class MedicineDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Medicine[] md = new Medicine[4];

        for (int i = 0; i < 4; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();

            md[i] = new Medicine(a, b, c, d);
        }

        String di = sc.nextLine();
        int[] ans = priceD(md, di);
        for (int an : ans) {
            System.out.println(an);
        }

    }

    public static int[] priceD(Medicine[] md, String di) {
        List<Integer> l = new ArrayList<>();

        for (Medicine m : md) {
            if (m.getDisease().equalsIgnoreCase(di)) {
                l.add(m.getPrice());
            }
        }

        int i = 0;
        int[] ans = new int[l.size()];
        for (int s : l) {
            ans[i++] = s;
        }

        for (int j = 0; j < ans.length; j++) {
            for (int k = 0; k < ans.length - j - 1; k++) {
                if (ans[k] > ans[k + 1]) {
                    int temp = ans[k];
                    ans[k] = ans[k + 1];
                    ans[k + 1] = temp;
                }
            }
        }

        return ans;
    }
}

class Medicine {
    private String name;
    private String batch;
    private String disease;
    private int price;

    public Medicine(String name, String batch, String disease, int price) {
        this.name = name;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}