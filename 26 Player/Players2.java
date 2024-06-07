/*
Create class Player2 with below attributes:

id - int
name - String
iccRank - int
matchesPlayed - int
runsScored - int

Create class Solution and implement static method "findAverageOfRuns" in the Solution class.
This method will take array of Player objects and a target int as parameters.
And will return another double array where the target int is lesser than or equal to the original array of Player object's
matchesPlayed attribute and contains the average run scored by each player satisfying above condition.

Write necessary getters and setters.

Before calling "findAverageOfRuns" method in the main method, read values for four Player objects referring the attributes
in above sequence along with a int target.
Then call the "findAverageOfRuns" method and write logic in main method to print "Grade A",if the calculated averageRun
value is 80 to 100. Else if the averageRun value is between 50 and 79 then print "Grade B". Else print "Grade C".

Input
------------------
100
Sachin
5
150
13000
101
Sehwag
4
120
10000
103
Dhoni
7
110
7000
104
Kohli
15
57
4400
100

Output
--------------------
Grade A
Grade A
Grade B
 */

import java.util.*;

public class Players2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player2[] player = new Player2[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();

            player[i] = new Player2(a, b, c, d, e);
        }

        int target = sc.nextInt();
        double[] ans = findAvgOfRuns(player, target);
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] >= 80 && ans[i] <= 100) {
                System.out.println("Grade A");
            } else if (ans[i] >= 50 && ans[i] <= 79) {
                System.out.println("Grade B");
            } else {
                System.out.println("Grade C");
            }
        }

    }

    public static double[] findAvgOfRuns(Player2[] player, int target) {
        List<Double> l = new ArrayList<>();

        for (Player2 p : player) {
            if (target <= p.getMatch()) {
                double avg = (double) p.getRun() / p.getMatch();
                l.add(avg);
            }
        }

        int count = 0;
        double[] ans = new double[l.size()];
        for (Double b : l) {
            ans[count++] = b;
        }

        return ans;
    }
}

class Player2 {
    private int id;
    private String name;
    private int rank, match, run;

    public Player2(int id, String name, int rank, int match, int run) {
        this.id = id;
        this.name = name;
        this.rank = rank;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
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