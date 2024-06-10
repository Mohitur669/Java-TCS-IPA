/* Group the employees by city

 * Input:
 * ----------------
 * Employee |      City
 * ---------------------
 * Arijit       Kolkata
 * Minaz        Mumbai
 * Rahul        Chennai
 * Rajesh       Kolkata
 * Sekhar       Chennai
 * Kasim        Chennai

 * Output:
 * ----------------
 * Kolkata: Arijit,Rajesh
 * Mumbai: Minaz
 * Chennai: Rahul,Sekhar,Kasim
 */

import java.util.*;

public class SetEmployeesByLocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of entries
        System.out.print("Enter the number of entries: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Lists to store names and cities
        List<String> names = new ArrayList<>();
        List<String> cities = new ArrayList<>();

        // Read the entries
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter city: ");
            String city = sc.nextLine();

            // Add name and city to their respective lists
            names.add(name);
            cities.add(city);
        }

        // List to keep track of already printed cities
        List<String> printedCities = new ArrayList<>();

        for (int i = 0; i < cities.size(); i++) {
            String city = cities.get(i);

            // Skip the city if it has already been printed
            if (printedCities.contains(city)) {
                continue;
            }

            printedCities.add(city);

            // Find all names corresponding to the current city
            List<String> cityNames = new ArrayList<>();
            for (int j = 0; j < cities.size(); j++) {
                if (cities.get(j).equals(city)) {
                    cityNames.add(names.get(j));
                }
            }

            // Print the city and corresponding names
            System.out.println(city + ": " + String.join(",", cityNames));
        }
    }
}

/*
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of entries
        System.out.print("Enter the number of entries: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Map to store city names and the corresponding list of people
        Map<String, List<String>> cityMap = new HashMap<>();

        // Read the entries
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter city: ");
            String city = scanner.nextLine();

            // Add the name to the list for the given city
            if (!cityMap.containsKey(city)) {
                cityMap.put(city, new ArrayList<>());
            }
            cityMap.get(city).add(name);
        }

        // Print the output
        System.out.println("\nOutput:");
        System.out.println("----------------");

        for (Map.Entry<String, List<String>> entry : cityMap.entrySet()) {
            String city = entry.getKey();
            List<String> names = entry.getValue();
            System.out.println(city + ": " + String.join(",", names));
        }

        scanner.close();
    }
}
 */