/*
Create class Team with below attributes:

tId - int
tName - String
tCountry - String
tRun - int

The above attributes should be private.Write Getter and Setter and parametrized constructor as required.

Create class Solution with main method.

Implement One static method-

● findPlayer

findPlayer in the solution class.
This method will take array of Team objects, int paramater run and String country and returns the Team object where taken
country is matched with the country of team object and team run is greater than the taken run.

Write code to perform following tasks:

1. In main mehod, take 1st input as integer parameter which shows the number of team object.
2. Take necessary input variable and call findPlayer.
3. All searches should be case insensitive.

For this method- The main method should print the team object. As if the returned value is not null,
or it should print "No team is found from the given country and run".

Input
------------------
3
1
Arijit
India
43
2
Doremon
China
40
3
Donal
England
32
35
China



Output
--------------
2
Doremon
China
40
 */

import java.util.Scanner;

public class TeamPlayer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Team[] team = new Team[n];
        for (int i = 0; i < team.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();

            team[i] = new Team(a, b, c, d);
        }

        int run = sc.nextInt();
        sc.nextLine();
        String con = sc.nextLine();

        Team ans = findPlayer(team, run, con);
        if (ans != null) {
            System.out.println(ans.getId());
            System.out.println(ans.getName());
            System.out.println(ans.getCountry());
            System.out.println(ans.getRun());
        } else {
            System.out.println("No team is found from the given country and run");
        }
    }

    public static Team findPlayer(Team[] team, int run, String con) {
        Team ans = null;

        for (Team t : team) {
            if (t.getCountry().equalsIgnoreCase(con) && t.getRun() > run) {
                ans = t;
            }
        }

        return ans;
    }
}

class Team {
    private int tId;
    private String tName;
    private String tCountry;
    private int tRun;

    public Team(int tId, String tName, String tCountry, int tRun) {
        this.tId = tId;
        this.tName = tName;
        this.tCountry = tCountry;
        this.tRun = tRun;
    }

    public int getId() {
        return tId;
    }

    public void setId(int tId) {
        this.tId = tId;
    }

    public String getName() {
        return tName;
    }

    public void setName(String tName) {
        this.tName = tName;
    }

    public String getCountry() {
        return tCountry;
    }

    public void setCountry(String tCountry) {
        this.tCountry = tCountry;
    }

    public int getRun() {
        return tRun;
    }

    public void setRun(int tRun) {
        this.tRun = tRun;
    }
}