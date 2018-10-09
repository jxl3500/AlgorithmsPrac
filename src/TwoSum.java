/**
 * File: TwoSum.java
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
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
        return ans;
    }

    public static void main(int argc, String[] argvs){
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(nums, target)[0] == 2);
        System.out.println(twoSum(nums, target)[1] == 7);
    }
}
