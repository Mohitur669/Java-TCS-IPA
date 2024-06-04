/*
Create a class AutonomousCar with the below attributes:

carId – int
brand – String
noOfTestsConducted – int
noOfTestsPassed- int
environment – String

Write getters, setters for the above attributes . Create constructor which takes parameter in the above sequence
except grade.

Create class Solution with main method. Implement two static methods – findTestPassedByEnv and updateCarGrade in
Solution class.

findTestPassedByEnv method:

This method will take two input parameters -array of AutonomousCar objects and string parameter environment. The method
will return the sum of the noOfTestsPassed attribute from autonomousCar objects for the environment passed as parameter.
If no autonomousCar with the given environment is present in the array of AutonomousCar objects, then the method should
return 0.

updateCarGrade method:

This method will take a String parameter brand, along with the array of AutonomousCar objects. The method will return
the autonomousCar object, if the input String parameter matches with the brand attribute of the autonomousCar object.
Before returning the object, the grade should be derived based on the rating calculation mentioned below. This grade
value should be assigned to the object. If any of the above conditions are not met, then the method should return null.
The grade attribute should be calculated as follows: rating .(noOfTestsPassed * 100)/noOfTestsConducted
If the rating > = 80 then grade should be ‘A1’, otherwise the grade should be ‘B2’.

The above mentioned static methods should be called from the main method.

For findTestPassedByEnv method – The main
method should print the totalTestPassed as it is, if the returned value is greater than 0, or it should print “There
are no tests passed in this particular environment”.

For updateCarGrade method – The main method should print the brand and grade of the returned autonomousCar object.
The brand and grade should be concatinated with :: while printing. eg:- Tesla::A1, where Tesla is the brand and Al
is the grade.

If the returned value is null then it should print “No Car is available with the specified brand”. Before calling these
static methods in main, use Scanner object to read the values of four autonomousCar objects referring attributes in the
above mentioned attribute sequence (except grade attribute). Next, read the value for environment and brand.

Input
----------------
100
Tesla
1000
500
Hills
200
Ford
2000
1500
Desert
300
Royce
3000
1700
Hills
400
Mercedez
1000
400
Desert
Desert
Mercedez

Output
-----------
1900
Mercedez::B2
 */

import java.util.Scanner;

public class AutonomousCar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Autonomous[] auto = new Autonomous[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();
            sc.nextLine();
            String e = sc.nextLine();

            auto[i] = new Autonomous(a, b, c, d, e);
        }

        String env = sc.nextLine();
        String brand = sc.nextLine();

        int count = findTest(auto, env);
        if (count > 0) {
            System.out.println(count);
        } else {
            System.out.println("There are no test passed in this particular environment");
        }

        Autonomous ans = upgradeCar(auto, brand);
        if (ans != null) {
            System.out.println(ans.getBrand());
        } else {
            System.out.println("No car is available with the specified brand");
        }
    }

    public static int findTest(Autonomous[] auto, String env) {
        int count = 0;
        for (Autonomous a : auto) {
            if (a.getEnv().equalsIgnoreCase(env)) {
                count += a.getPass();
            }
        }

        return count;
    }

    // TODO
    public static Autonomous upgradeCar(Autonomous[] auto, String brand) {
        Autonomous ans = null;

        for (Autonomous a : auto) {
            if (a.getBrand().equalsIgnoreCase(brand)) {
                int rating = (a.getPass() * 100) / a.getCon();
                if (rating >= 80) {
                    a.setBrand(a.getBrand() + "::A1");
                    ans = a;
                } else {
                    a.setBrand(a.getBrand() + "::B2");
                    ans = a;
                }
            }
        }

        return ans;
    }
}

class Autonomous {
    private int id;
    private String brand;
    private int con;
    private int pass;
    private String env;

    public Autonomous(int id, String brand, int con, int pass, String env) {
        this.id = id;
        this.brand = brand;
        this.con = con;
        this.pass = pass;
        this.env = env;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}