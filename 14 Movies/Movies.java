/*
Create class Movie with below attributes:

movieName - String
company - String
genre - String
budget - int

Create class Solution and implement static method "getMovieByGenre" in the Solution class. This method will
take array of Movie objects and a searchGenre String as parameters. And will return another array of Movie
objects where the searchGenre String matches with the original array of Movie object's genre attribute
(case insensitive search).

Write necessary getters and setters.

Before calling "getMovieByGenre" method in the main method, read values for four Movie objects referring the
attributes in above sequence along with a String searchGenre. Then call the "getMovieByGenre" method and write
logic in main method to print "High Budget Movie",if the movie budget attribute is greater than 80000000 else
print "Low Budget Movie".

Input
---------
aaa
Marvel
Action
250000000
bbb
Marvel
Comedy
25000000
ccc
Marvel
Comedy
2000000
ddd
Marvel
Action
300000000
Action

Output
-------------------
High Budget Movie
High Budget Movie
 */

import java.util.*;

public class Movies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Movie[] mov = new Movie[4];

        for (int i = 0; i < 4; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();

            mov[i] = new Movie(a, b, c, d);
        }

        String gen = sc.nextLine();

        Movie[] ans = getMovie(mov, gen);
        for (Movie a : ans) {
            if (a.getBudget() > 80000000) {
                System.out.println("High Budget Movie");
            } else {
                System.out.println("Low Budget Movie");
            }
        }

    }

    public static Movie[] getMovie(Movie[] mov, String gen) {
        List<Movie> l = new ArrayList<>();

        int count = 0;
        for (Movie m : mov) {
            if (m.getGenre().equalsIgnoreCase(gen)) {
                l.add(m);
                count++;
            }
        }

        Movie[] ans = new Movie[count];
        int i = 0;
        for (Movie m : l) {
            ans[i++] = m;
        }

        return ans;
    }
}

class Movie {
    String name, company, genre;
    int budget;

    public Movie(String name, String company, String genre, int budget) {
        this.name = name;
        this.company = company;
        this.genre = genre;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}