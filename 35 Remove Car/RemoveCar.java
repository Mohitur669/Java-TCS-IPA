/*
Create a class Car with the below attributes:

carId – int
carName – String
fuelType – String

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class RemoveCar with main method.

Implement two static methods – RemoveAndRearrange in RemoveCar class.

RemoveAndRearrange method:
This method will take int input parameter. The method will return the new array of Car object and remove that car whose
id is match with the input parameter. Remove the car details and return the array with continuous new ids.

If no car with the given id is present in the array of Car objects, then the method should return null.

Note: No two Car object would have the same engine id.

The above mentioned static methods should be called from the main method.

For RemoveAndRearrange method: The main method should print the id and car name as it is, if the returned
value is not null, or it should print “There are no car with given id”.

Before calling these static methods in main, use Scanner object to read the values of five objects referring attributes
in the above mentioned attribute sequence. next, read the value of int parameters for capturing car id.

Input :

1001
Maruti
Diesel
1002
Kia
Pertro
1003
Hyundai
Diesel
1004
Taxi
Petrol
1005
Truck
Diesel
1003

Output :

1001 : Maruti
1002 : Kia
1004 : Taxi
1005 : Truck
 */

import java.util.*;

public class RemoveCar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car[] car = new Car[5];
        for (int i = 0; i < car.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();

            car[i] = new Car(a, b, c);
        }

        int id = sc.nextInt();
        Car[] ans = removeAndRearrange(car, id);

        if (ans.length > 0) {
            for (Car c : ans) {
                System.out.println(c.getId() + " : " + c.getName());
            }
        } else {
            System.out.println("There are no car with given id");
        }
    }

    public static Car[] removeAndRearrange(Car[] car, int id) {
        Car[] ans = new Car[0];

        for (Car c : car) {
            if (c.getId() != id) {
                ans = Arrays.copyOf(ans, ans.length + 1);
                ans[ans.length - 1] = c;
            }
        }

        return ans;
    }
}

class Car {
    private int id;
    private String name;
    private String type;

    public Car(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}