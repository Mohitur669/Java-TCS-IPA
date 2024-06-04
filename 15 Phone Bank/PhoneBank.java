import java.util.*;

public class PhoneBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Phone[] phone = new Phone[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();

            phone[i] = new Phone(a, b, c, d);
        }

        sc.nextLine();
        String brand = sc.nextLine();
        String os = sc.nextLine();

        int price = findPrice(phone, brand);
        if (price > 0) {
            System.out.println(price);
        } else {
            System.out.println("The given brand is not available");
        }

        Phone ph = getPhone(phone, os);
        if (ph != null) {
            System.out.println(ph.getId());
        } else {
            System.out.println("No phones are available with specifies os and price range");
        }

    }

    public static int findPrice(Phone[] phones, String brand) {
        int ans = 0;
        for (Phone ph : phones) {
            if (ph.getBrand().equalsIgnoreCase(brand)) {
                ans += ph.getPrice();
            }
        }

        return ans;
    }

    public static Phone getPhone(Phone[] phones, String os) {
        Phone ph = null;

        for (Phone p : phones) {
            if (p.getOs().equalsIgnoreCase(os) && p.getPrice() >= 50000) {
                ph = p;
            }
        }

        return ph;
    }
}

class Phone {
    int id, price;
    String os, brand;

    public Phone(int id, String os, String brand, int price) {
        this.id = id;
        this.os = os;
        this.brand = brand;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}