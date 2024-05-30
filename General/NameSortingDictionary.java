/* Sort name by dictionary order
    Input
    -----------------
    Arijit
    Minaz
    Arnab

    Output
    -------------------
    Arijit
    Arnab
    Minaz
 */

import java.util.Arrays;

public class NameSortingDictionary {
    public static void main(String[] args) {
        String[] str = {"Aniket", "Mohitur", "Arijit", "Arnab"};

        for (int i = 0; i < str.length; i++) {
            for (int j = i+1; j < str.length; j++) {
                if (str[i].compareTo(str[j]) > 0) {
                    String name = str[i];
                    str[i] = str[j];
                    str[j] = name;
                }
            }
        }

        System.out.println(Arrays.toString(str));
    }
}