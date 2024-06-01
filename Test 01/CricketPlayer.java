import java.util.Scanner;

public class CricketPlayer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player[] player = new Player[4];

        for (int i = 0; i < 4; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String pName = sc.nextLine();
            int runs = sc.nextInt();
            sc.nextLine();
            String pType = sc.nextLine();
            String mType = sc.nextLine();

            player[i] = new Player(id, pName, runs, pType, mType);
        }

        String p = sc.nextLine().toLowerCase();
        String m = sc.nextLine().toLowerCase();

        int low = findPlayerWithLowestRuns(player, p);
        if (low > 0) {
            System.out.println(low);
        } else {
            System.out.println("No such player");
        }

        Player[] ans = findPlayerByMatchType(player, m);
        if (ans != null) {
            for (int i = ans.length - 1; i >= 0; i--) {
                System.out.println(ans[i].getId());
            }
        } else {
            System.out.println("No Player with given matchType");
        }

    }

    public static int findPlayerWithLowestRuns(Player[] players, String p) {
        int min = Integer.MAX_VALUE;

        for (Player pl : players) {
            if (pl.getPType().equalsIgnoreCase(p)) {
                min = pl.getRuns();
            }
        }

        return min;
    }

    public static Player[] findPlayerByMatchType(Player[] players, String m) {
        int count = 0;
        for (Player pl : players) {
            if (pl.getMType().equalsIgnoreCase(m)) {
                count++;
            }
        }

        if (count == 0) return null;

        int j = 0;
        Player[] ans = new Player[count];
        for (Player pl : players) {
            if (pl.getMType().equalsIgnoreCase(m)) {
                ans[j] = pl;
                j++;
            }
        }

        return ans;
    }

}

class Player {
    private int id, runs;
    private String name, pType, mType;

    public Player(int id, String name, int runs, String pType, String mType) {
        this.id = id;
        this.name = name;
        this.runs = runs;
        this.pType = pType;
        this.mType = mType;
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

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public String getPType() {
        return pType;
    }

    public void setPType(String pType) {
        this.pType = pType;
    }

    public String getMType() {
        return mType;
    }

    public void setMType(String mType) {
        this.mType = mType;
    }
}