
/**
 * File: TwoSum.java (#1)
 * Author: Jiaxin Liu
 * Date: 10/09/2018
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Approach 1: Bruce Force
     *             Time complexity: O(N2) (N square)
     *             Space complexity: O(1)
     *             Description: Loop through each element x in a list and find if there is another value that
     *             equals to target - x, which means loops through the list twice
     *             Efficiency: slow, not recommended
     * @param nums a list of numbers to be compared with
     * @param target the target sum of two numbers
     * @return a list of indices of two sum numbers
     */
    private static int[] twoSum(int[] nums, int target){
        int ans[] = {0, 0};
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Approach 2: Two-Pass Hash Table
     *             Time Complexity: O(n)
     *             Space Complexity: O(n)
     *             Description: Loop through the list and store each value as a key
     *                          and its index in the list as the value in an empty HashMap
     *                          Calculate the complement of the target when reaching a key
     *                          x in the map, complement = target - x
     *                          Loop through the list again to find if there is a key in the map
     *                          that is equals to the complement of the target
     *             Efficiency: fast, recommended
     *
     * @param nums a list of numbers to be compared with
     * @param target the target sum of two numbers
     * @return a list of indices of two sum numbers
     */
    private static int[] twoSumMap(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>(); //the size of the map expanded as
                                                     //the input take place
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.keySet().contains(complement) && map.get(complement) != i){
                return new int[] {i, map.get(complement)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");

    }

    /**
     * Approoach 3: One-Pass Hash Table
     *              Time Complexity: O(n)
     *              Space Complexity: O(n)
     *              Description: Loop through the list once to store the each value as the key
     *                           and the index as its value. Meanwhile, calculate the complement
     *                           of the value(element in the list) and check if the map contains
     *                           it as a key. If true, return the list of these two indices in the
     *                           list, otherwise, put the storing pair in the map
     *              Efficiency: fast; recommended
     * @param nums a list of numbers
     * @param target the target sum of two numbers
     * @return a list of indices of two sum numbers
     */
    public static int[] twoSum3(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution.");

    }

    public static void main(String[] argvs){
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(nums, target)[0] == 0);
        System.out.println(twoSum(nums, target)[1] == 1);

        System.out.println(twoSumMap(nums, target)[0] == 0);
        System.out.println(twoSumMap(nums, target)[1] == 1);

        System.out.println(twoSum3(nums, target)[0] == 0);
        System.out.println(twoSum3(nums, target)[1] == 1);
    }
}
