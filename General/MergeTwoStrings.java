/* Marge two strings using comma

Input:
Arijit,Ghosh
Pop:Mom

Output:
Arijit, Ghosh, Pop:Mom
*/

public class MergeTwoStrings {
    public static void main(String[] args) {
        String s = "Mohd";
        String t = "Mohitur,Rahaman";

        String[] s1 = s.split(",");
        String[] t1 = t.split(",");

        String[] ans = new String[s1.length + t1.length];

        int i;
        for (i = 0; i < s1.length; i++) {
            ans[i] = s1[i];
        }

        for (int j = 0; j < t1.length; j++) {
            ans[i] = t1[j];
            i++;
        }

        for (int j = 0; j < ans.length; j++) {
            System.out.print(ans[j] + ", ");
        }

        /* String n = Arrays.toString(s1);
        String k = n.substring(1, n.length()-1);
        System.out.println(k); */
    }
}