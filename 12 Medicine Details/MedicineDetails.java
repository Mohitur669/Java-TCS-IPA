import java.util.*;

public class MedicineDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Medicine[] md = new Medicine[4];

        for (int i = 0; i < 4; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();

            md[i] = new Medicine(a, b, c, d);
        }

        String di = sc.nextLine();
        int[] ans = priceD(md, di);
        for (int an : ans) {
            System.out.println(an);
        }

    }

    public static int[] priceD(Medicine[] md, String di) {
        List<Integer> l = new ArrayList<>();

        for (Medicine m : md) {
            if (m.getDisease().equalsIgnoreCase(di)) {
                l.add(m.getPrice());
            }
        }

        int i = 0;
        int[] ans = new int[l.size()];
        for (int s : l) {
            ans[i++] = s;
        }

        for (int j = 0; j < ans.length; j++) {
            for (int k = 0; k < ans.length - j - 1; k++) {
                if (ans[k] > ans[k + 1]) {
                    int temp = ans[k];
                    ans[k] = ans[k + 1];
                    ans[k + 1] = temp;
                }
            }
        }

        return ans;
    }
}

class Medicine {
    private String name;
    private String batch;
    private String disease;
    private int price;

    public Medicine(String name, String batch, String disease, int price) {
        this.name = name;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}