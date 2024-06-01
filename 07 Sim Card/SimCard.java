import java.util.Scanner;

public class SimCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sim[] s = new Sim[5];
        for (int i = 0; i < s.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            double c = sc.nextDouble();
            double d = sc.nextDouble();
            sc.nextLine();
            String e = sc.nextLine();

            s[i] = new Sim(a, b, c, d, e);
        }

        String c1 = sc.nextLine();
        String c2 = sc.nextLine();

        Sim[] arr = transferCustomerCircle(s, c1, c2);
        for (Sim sim : arr) {
            System.out.println(sim.getSimId() + " " + sim.getCustomerName() + " " + sim.circle + " " + sim.getRatePerSecond());
        }
    }

    // TODO
    public static Sim[] transferCustomerCircle(Sim[] s, String c1, String c2) {
        int count = 0;

        // First pass to count the number of matching Sims
        for (Sim sim : s) {
            if (sim.getCircle().equalsIgnoreCase(c1)) {
                count++;
            }
        }

        // Create the array with the exact count
        Sim[] details = new Sim[count];
        int index = 0;

        // Second pass to collect the matching Sims and update their circle
        for (Sim sim : s) {
            if (sim.getCircle().equalsIgnoreCase(c1)) {
                sim.setCircle(c2);
                details[index++] = sim;
            }
        }

        // Sorting by ratePerSecond in descending order
        for (int i = 0; i < details.length - 1; i++) {
            for (int j = i + 1; j < details.length; j++) {
                if (details[i].getRatePerSecond() < details[j].getRatePerSecond()) {
                    Sim temp = details[i];
                    details[i] = details[j];
                    details[j] = temp;
                }
            }
        }

        return details;
    }
}

class Sim {
    int simId;
    String customerName, circle;
    double balance, ratePerSecond;

    public Sim(int simId, String customerName, double balance, double ratePerSecond, String circle) {
        this.simId = simId;
        this.customerName = customerName;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }

    public int getSimId() {
        return simId;
    }

    public void setSimId(int simId) {
        this.simId = simId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRatePerSecond() {
        return ratePerSecond;
    }

    public void setRatePerSecond(double ratePerSecond) {
        this.ratePerSecond = ratePerSecond;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }
}