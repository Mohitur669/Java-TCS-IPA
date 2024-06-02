import java.util.*;

public class EmployeeDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] em = new Employee[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            boolean e = sc.nextBoolean();

            em[i] = new Employee(a, b, c, d, e);
        }

        sc.nextLine();
        String br = sc.nextLine();
        int count = findCount(em, br);
        if (count > 0) {
            System.out.println(count);
        } else {
            System.out.println("No such Employees");
        }

        Employee e = findEm(em);
        if (e != null) {
            System.out.println(e.getEmployeeId());
            System.out.println(e.getName());
        } else {
            System.out.println("All Employees using company transport");
        }

    }

    public static int findCount(Employee[] em, String br) {
        int count = 0;

        for (Employee e : em) {
            if (e.getBranch().equalsIgnoreCase(br) && e.getCompanyTransport()) {
                count++;
            }
        }

        return count;
    }

    public static Employee findEm(Employee[] em) {
        Employee high = null;
        Employee second = null;

        for (Employee e : em) {
            if (!e.getCompanyTransport()) {
                if (high == null || e.getRating() > high.getRating()) {
                    second = high;
                    high = e;
                } else if (second == null || high.getRating() > second.getRating()) {
                    second = e;
                }
            }
        }

        return second;
    }
}

class Employee {
    private int employeeId;
    private String name;
    private String branch;
    private double rating;
    private boolean companyTransport;

    public Employee(int employeeId, String name, String branch, double rating, boolean companyTransport) {
        this.employeeId = employeeId;
        this.name = name;
        this.branch = branch;
        this.rating = rating;
        this.companyTransport = companyTransport;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean getCompanyTransport() {
        return companyTransport;
    }

    public void setCompanyTransport(boolean companyTransport) {
        this.companyTransport = companyTransport;
    }
}