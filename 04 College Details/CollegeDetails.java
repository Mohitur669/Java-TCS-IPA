/*
Create a class College with the below attributes.

 id-int

 name -String

 contactNo-int

 address-String

 pinCode-int


Write the getters and setters and parametrized constructor in the above

mentioned sequence as required.



Create the class Solution with the main method.

Implement the two static methods:

 1.findCollegeWithMaximumPincode

 2.searchCollegeByAddress



findCollegeWithMaximumPincode method:

   Create the Static method in the Solution Class.

 This method will take array of the College objects and return the

College object having maximum pincode if found else return null if not

found.

   for this method ,main method will print College object with maximum

pincode if the returned value is not null.if the returned value is null ,


then the main method will print "No college found with mentioned attribute".


searchCollegeByAddress method:

   Create the Static method in the Solution Class.

This method will take array of College objects as input and address as

input and return College object having the mentioned address if found

else return null if not found.

   for this method main method will print College object details as it is ,

 if the returned value is not null.if the returned value is null then ,


main method will print "No college found with mentioned attribute".




***************************************************************************

input 1:

4
109
ACT
2500256
mumbai
695001
107
MCE
2500254
malapuram
612354
113
CTE
2500252
chennai
623145
102
SCT
2500255
AP
523641
AP



OUTPUT1:

id-109

name-ACT

contactNo-2500256

address-mumbai

pincode-695001

id-102

name-SCT

contactNo-2500255

address-AP

pincode-523641


INPUT2:

4
111
MJT
2500251
Calicut
401235
105
MET
2500256
kochi
668745
115
IIT
2500262
banglore
569874
110
ACT
2500263
delhi
687945
delhi


output2:

id-110

name-ACT

contactNo-2500263

address-delhi

pincode-687945

id-110

name-ACT

contactNo-2500263

address-delhi

pincode-687945
 */

import java.util.Scanner;

public class CollegeDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        College[] colleges = new College[n];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            String d = sc.nextLine();
            int e = sc.nextInt();
            sc.nextLine();

            colleges[i] = new College(a, b, c, d, e);
        }

        String cl = sc.nextLine().toLowerCase();

        College maxPin = findCollegeWithMaximumPincode(colleges);
        if (maxPin != null) {
            System.out.println("id-" + maxPin.getId());
            System.out.println("name-" + maxPin.getName());
            System.out.println("contactNo-" + maxPin.getContactNo());
            System.out.println("address-" + maxPin.getAddress());
            System.out.println("pincode-" + maxPin.getPin());
        } else {
            System.out.println("No college found with mentioned attribute");
        }

        College ans = searchCollegeByAddress(colleges, cl);
        if (ans != null) {
            System.out.println("id-" + ans.getId());
            System.out.println("name-" + ans.getName());
            System.out.println("contactNo-" + ans.getContactNo());
            System.out.println("address-" + ans.getAddress());
            System.out.println("pincode-" + ans.getPin());
        } else {
            System.out.println("No college found with mentioned attribute");
        }
    }

    public static College findCollegeWithMaximumPincode(College[] colleges) {
        College ans = null;

        College max = colleges[0];
        for (College c : colleges) {
            if (c.getPin() > max.getPin()) {
                max = c;
            }
        }

        ans = max;
        return ans;
    }

    public static College searchCollegeByAddress(College[] colleges, String cl) {
        College ans = null;

        for (College c : colleges) {
            if (c.getAddress().equalsIgnoreCase(cl)) {
                ans = c;
            }
        }

        return ans;
    }
}

class College {
    int id, contactNo, pin;
    String name, address;

    public College(int id, String name, int contactNo, String address, int pin) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
        this.pin = pin;
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

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}