// Majority of an element means if an element is present in an array for more than n/2 times,
//  where n is the length of the Array
//  Array = {3, 3, 4, 2, 4, 4, 2, 4, 4} => 4

import java.util.HashMap;
import java.util.Map;

public class MajorityElementInArray {
    public static void main(String[] args) {
        int[] array = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int result = findMajorityElement(array);
        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("No majority element found.");
        }
    }

    public static int findMajorityElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1; // No majority element
    }
}