import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5, 2, 2, 3, 6, 5, 3, 2};
        int[] arr2 = {2, 3, 2, 6, 6, 5, 1};
        arrayIntersection(arr1, arr2);
    }

    public static void arrayIntersection(int[] arr1, int[] arr2) {
        Set<Integer> s = new HashSet<>();
        for (int j : arr1) {
            s.add(j);
        }

        for (int j : arr2) {
            if (s.contains(j)) {
                System.out.print(j + " ");
            }
        }
    }
}