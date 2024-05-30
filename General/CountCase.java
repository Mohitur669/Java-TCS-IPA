public class CountCase {
    public static void main(String[] args) {
        String s = "MohituR";
        System.out.println(countUpperCase(s));
        System.out.println(countLowerCase(s));
    }

    public static int countUpperCase(String s) {
        int count = 0;
        for (int i = 0; i <s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))){
                count++;
            }
        }

        return count;
    }

    public static int countLowerCase(String s) {
        int count = 0;
        for (int i = 0; i <s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))){
                count++;
            }
        }

        return count;
    }
}