/*
Create a class NavalVessel with the below attributes:

vesselld – int
vesselName – String
noOfVoyagesPlanned – int
noOfVoyagesCompleted – int
purpose – String


Write getters, setters for the above attributes. Create constructor which takes parameter in the above
sequence except classification.

Create class Solution with main method. Implement two static methods – findAvgVoyagesByPct and findVesselByGrade
in Solution class.

findAvgVoyagesByPct method:

This method will take two input parameters -array of NavalVessel objects and int parameter percentage. The method will
return the average of the noOfVoyagesCompleted attribute from NavalVessel objects which meets the percentage requirement
as mentioned below.The percentage for each navalVessel is calculated as
percentage .(noOfVoyagesCompleted * 100)/noOfVoyagesPlanned. If the above calculated percentage is greater than or equal
to the percentage passed as the parameter, then those objects should participate in the average calculation. If there are
no objects with the mentioned criteria, then the method should return 0.

findVesselByGrade method:

This method will take a String parameter purpose, along with the array of NavalVessel objects. The method will return the
NavalVessel object, if the input String parameter matches with the purpose attribute of the NavalVessel object. Before
returning the object, the classification should be derived as mentioned below. This classification value should be assigned
to the object before returning. If any of the above conditions are not met, then the method should return null. The
classification attribute should be calculated based on the percentage calculation mentioned above.
If the percentage = 100 then classification should be ‘Star’, if percentage is between 99 and 80 then classification should
be ‘Leader, if percentage is between 79 and 55 then classification should be ‘Inspirer' otherwise the classification should
be ‘Striver’ If the returned value is null then it should print “No Naval Vessel is available with the specified purpose”.

Before calling these static methods in main, use Scanner object to read the values of four NavalVessel objects referring
attributes in the above mentioned attribute sequence (except the classification attribute). Next, read the value for
percentage and purpose.

Input
-------------------
111
Rojer
100
100
Passenger
222
Kalam
200
100
Goods
333
Yashwin
400
300
Army
444
Thanishwini
500
500
Welfare
75
Army

Output
------------------
300
Yashwin%Inspirer
 */

import java.util.*;

public class NavalVessel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Naval[] nv = new Naval[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();
            sc.nextLine();
            String e = sc.nextLine();

            nv[i] = new Naval(a, b, c, d, e);
        }

        int per = sc.nextInt();
        sc.nextLine();
        String grade = sc.nextLine();

        int ans = findAvg(nv, per);
        if (ans > 0) {
            System.out.println(ans);
        }

        List<Naval> l = findVessel(nv, grade);
        for (Naval n : l) {
            int p = (n.getComp() * 100) / n.getPlan();

            if (p == 100) {
                System.out.println((n.getName() + "%Star"));
            } else if (p > 80 && p < 99) {
                System.out.println((n.getName() + "%Leader"));
            } else if (p > 55 && p < 79) {
                System.out.println((n.getName() + "%Inspirer"));
            } else {
                System.out.println((n.getName() + "%Striver"));
            }
        }


    }

    public static int findAvg(Naval[] nv, int per) {
        List<Naval> l = new ArrayList<>();

        for (Naval n : nv) {
            int p = (n.getComp() * 100) / n.getPlan();
            if (p >= per) {
                l.add(n);
            }
        }

        int sum = 0;
        for (Naval n : l) {
            sum += n.getComp();
        }

        return sum / l.size();
    }

    public static List<Naval> findVessel(Naval[] nv, String grade) {
        List<Naval> l = new ArrayList<>();

        for (Naval n : nv) {
            if (n.getPurpose().equalsIgnoreCase(grade)) {
                l.add(n);
            }
        }

        return l;
    }
}

class Naval {
    int id, plan, comp;
    String name, purpose;

    public Naval(int id, String name, int plan, int comp, String purpose) {
        this.name = name;
        this.plan = plan;
        this.comp = comp;
        this.purpose = purpose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public int getComp() {
        return comp;
    }

    public void setComp(int comp) {
        this.comp = comp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;

    }
}