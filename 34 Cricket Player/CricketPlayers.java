/*
Create class Player3 with below attributes:

id - int
name - String
Country - String
matchesPlayed - int
runsScored - int

the above attribute should be private ,write getter and setter and parametrized constructor as well.

Create class Solution and implement static method "findPlayerName" in the Solution class.
This method will take array of Player objects and a String as country parameters and int as run parameter.
And will return another array of Player object where the String is matched with country and run scored of that Player object
is greater than the input int parameter. All the searches should be case insensitive.

Before calling "findPlayerName" method in the main method, read values for Player objects referring the attributes
in above sequence along with a int target.
Then call the "findPlayerName" method and write logic in main method to print Player object. If any of the input doesn't match
with the following attributes then print "No player found".

Note:
--------------
1. First take input as the number of player object, then the player details
2. Show the output as the dictionary order of the players name
3. First print player id, and then use ' : ' sign and after that player name
    3 : Arijit
    1 : Minaz
    5 : Priyanka

Input : 1
--------------
5
1
Arnab
India
4
94
2
Virat
UK
5
68
3
Arijit
India
82
87
4
Raj
India
21
78
5
Priyanka
India
12
86
India
80

Output : 1
-----------------
3:Arijit
1:Arnab
5:Priyanka

___________________________________________________________

Input : 2
--------------
5
1
Arnab
India
4
94
2
Virat
UK
5
68
3
Arijit
India
82
87
4
Raj
India
21
78
5
Priyanka
India
12
86
UK
80

Output : 2
--------------------
No player found
 */

import java.util.*;

public class CricketPlayers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Cricket[] cricket = new Cricket[n];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            int e = sc.nextInt();

            cricket[i] = new Cricket(a, b, c, d, e);
        }

        sc.nextLine();
        String country = sc.nextLine();
        int run = sc.nextInt();

        Cricket[] ans = findPlayerName(cricket, country, run);
        if (ans.length > 0) {
            for (Cricket cr : ans) {
                System.out.println(cr.getId() + ":" + cr.getName());
            }
        } else {
            System.out.println("No Player found");
        }
    }

    // Todo - Sorting names
    public static Cricket[] findPlayerName(Cricket[] cricket, String country, int run) {
        Cricket[] ans = new Cricket[0];

        for (Cricket c : cricket) {
            if (c.getCountry().equalsIgnoreCase(country) && c.getRun() > run) {
                ans = Arrays.copyOf(ans, ans.length + 1);
                ans[ans.length - 1] = c;
            }
        }

        for (int i = 0; i < ans.length - 1; i++) {
            for (int j = i + 1; j < ans.length; j++) {
                if (ans[i].getName().compareTo(ans[j].getName()) > 0) {
                    Cricket temp = ans[i];
                    ans[i] = ans[j];
                    ans[j] = temp;
                }
            }
        }

        return ans;
    }
}

class Cricket {
    private int id;
    private String name;
    private String country;
    private int match;
    private int run;

    public Cricket(int id, String name, String country, int match, int run) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.match = match;
        this.run = run;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getMatch() {
        return match;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }
}