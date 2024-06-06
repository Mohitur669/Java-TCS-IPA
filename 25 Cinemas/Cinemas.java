/*
Create a class Cinema with the below attributes:

movieId - int
director - String
rating - int
budget - int

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create class Solution with the main method.

Implement two static methods - findAvgBudgetByDirector and getMovieByRatingBudget in Solution class.

findAvgBudgetByDirector method:
----------------------------------
This method will take two input parameters - array of Movie objects and string parameter director.
The method will return the average of the budget attribute from Movie objects directed by the director passed as parameter.
If no movie with the given director is present in the array of movie objects, then the method should return 0.

getMovieByRatingBudget method:
----------------------------------
This method will take two int parameters rating and budget, along with the array of movie objects.
The method will return the movie object, if the input parameters rating and budget, matches with the rating and budget
attribute of the movie object respectively.

Also check if rating is a factor of budget (eg: 3 is a factor of 12 because 3 divides 12 without leaving a remainder).
If any of the conditions are not met, then the method should return null.

Note : No two movie object would have the same value for rating and budget attributes.
All the searches should be case insensitive.
The budget mentioned are in crores and in INR.

These above mentioned static methods should be called from the main method.

For findAvgBudgetByDirector method - The main method should print the average budget as it is if the returned value is
greater than 0, or it should print "Sorry - The given director has not yet directed any movie".

For getMovieByRatingBudget method - The main method should print the movieId of the returned movie object. If the returned
value is null then it should print "Sorry - No movie is available with the specified rating and budget requirement".

Before calling these static methods in main, use Scanner object to read the values of four Movie objects referring attributes
in the above mentioned attribute sequence. Next, read the value for director, rating and budget.

Input
----------
1101
GVM
4
100
1201
Shankar
5
500
1301
Shankar
3
50
1401
GVM
5
300
GVM
5
300

Output
----------
200
1401
 */

import java.util.*;

public class Cinemas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cinema[] cinema = new Cinema[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();

            cinema[i] = new Cinema(a, b, c, d);
        }

        sc.nextLine();
        String dir = sc.nextLine();
        int rating = sc.nextInt();
        int budget = sc.nextInt();

        int ans = findAvg(cinema, dir);
        if (ans > 0) {
            System.out.println(ans);
        } else {
            System.out.println("Sorry - The given director has not yet directed any movie");
        }

        Cinema result = movieRating(cinema, rating, budget);
        if (result != null) {
            System.out.println(result.getId());
        } else {
            System.out.println("Sorry - No movie is available with teh specified rating and budget requirement");
        }
    }

    public static int findAvg(Cinema[] cinema, String dir) {
        int ans = 0;
        int count = 0;

        for (Cinema c : cinema) {
            if (c.getDirector().equalsIgnoreCase(dir)) {
                ans += c.getBudget();
                count++;
            }
        }

        return ans / count;
    }

    public static Cinema movieRating(Cinema[] cinema, int rating, int budget) {
        Cinema result = null;

        for (Cinema c : cinema) {
            if (c.getRating() == rating && c.getBudget() == budget && budget % rating == 0) {
                result = c;
            }
        }

        return result;
    }
}

class Cinema {
    private int id;
    private String director;
    private int rating, budget;

    public Cinema(int id, String director, int rating, int budget) {
        this.id = id;
        this.director = director;
        this.rating = rating;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}