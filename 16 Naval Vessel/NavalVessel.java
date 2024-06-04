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