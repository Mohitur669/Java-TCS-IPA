/*
Create a class TravelAgencies with below attributes:

regNo – int
agencyName – String
packageType – String
price – int
flightFacility – boolean

Write getters, setters for the above attributes . Create constructor which takes parameter in the above sequence.

Create class Solution with main method. Implement two static methods – findAgencyWithHighestPackagePrice and
agencyDetailsforGivenIdAndType in Solution class.

findAgencyWithHighestPackagePrice method:

This method will take array of TravelAgencies objects as an input parameter and return the highest package
price from the given array of objects.

agencyDetailsForGivenldAndType method:

This method will take three input parameters -array of TravelAgencies objects, int parameter regNo and String
parameter packageType. The method will return the TravelAgencies object based on below conditions.

FlightFacility should be available.
The input parameters(regNo and packageType) should matched with the regNo and packageType of TravelAgencies object.
If any of the above conditions are not met, then the method should return null. Note : Same Travel agency can
have more than one package type. Travel agency and package type combination is unique. All the searches should
be case insensitive.

The above mentioned static methods should be called from the main method.


For findAgencyWithHighestPackagePrice method – The main method should print the highestPackagePrice as it is.
For agencyDetailsForGivenldAndType method -The main method should print the AgencyName and price of the returned
object.The AgencyName and price should be concatinated with : while printing.
---------
Input
---------
123
A2Z Agency
Platinum
50000
true
345
SSS Agency
Gold
30000
false
987
Cox and Kings
Diamond
40000
true
888
Global Tours
Silver
20000
false
987
Diamond
-------------------------------
Output
-------------------------------
50000
Cox and Kings:40000
 */

import java.util.*;

public class TravelAgency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agency[] agency = new Agency[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            boolean e = sc.nextBoolean();

            agency[i] = new Agency(a, b, c, d, e);
        }

        int reg = sc.nextInt();
        sc.nextLine();
        String pack = sc.nextLine();

        int ans = findAgency(agency);
        if (ans > 0) {
            System.out.println(ans);
        }

        Agency result = agencyDetails(agency, reg, pack);
        if (result != null) {
            System.out.println(result.getAgencyName() + ":" + result.getPrice());
        }
    }

    public static int findAgency(Agency[] agency) {
        int ans = agency[0].getPrice();

        for (Agency a : agency) {
            if (a.getPrice() > ans) {
                ans = a.getPrice();
            }
        }

        return ans;
    }

    public static Agency agencyDetails(Agency[] agency, int reg, String pack) {
        Agency result = null;
        for (Agency a : agency) {
            if (a.getRegNo() == reg && a.getPackageType().equalsIgnoreCase(pack)) {
                result = a;
            }
        }

        return result;
    }
}

class Agency {
    int regNo;
    String agencyName;
    String packageType;
    int price;
    boolean flightFacility;

    public Agency(int regNo, String agencyName, String packageType, int price, boolean flightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getFlightFacility() {
        return flightFacility;
    }

    public void setFlightFacility(boolean flightFacility) {
        this.flightFacility = flightFacility;
    }
}