
/**
 * File: MedianOfTwoSortedArrays.java
 *
 * @author Jiaxin Liu
 * Date: Oct. 11th, 2018
 */

public class MedianofTwoSortedArrays {

    /**
     * Sorting and Merging two sorted arrays
     *
     *
     * @param nums1 first array
     * @param nums2 second array
     * @param nums3 the merged array for nums1 and nums2
     */
    private static void sort(int[] nums1, int[] nums2, int[] nums3){
        int i = 0, j = 0, k = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        while (i < len1 && j < len2){
            if (nums1[i] < nums2[j]){
                nums3[k] = nums1[i];
                k++;
                i++;
            }
            else{
                nums3[k] = nums2[j];
                j++;
                k++;
            }
        }

        while (i < len1){
            nums3[k++] = nums1[i++];
        }

        while (j < len2){
            nums3[k++] = nums2[j++];
        }
    }

    /**
     * Approach 1: Recursive Approach
     *             Time Complexity: O(n)
     *             Space Complexity: O(m + n) ? O(1)
     *             Description: merge and sort two list first, then find the median
     *
     *
     * @param nums1 first array
     * @param nums2 second array
     * @return the median of the two arrays
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums3 = new int[nums1.length + nums2.length]; // initialize the int array
        sort(nums1, nums2, nums3);

        if (nums3.length % 2 == 0){
            int min = nums3[nums3.length / 2 - 1];
            int max = nums3[nums3.length / 2];
            return (double)(min + max) / 2;
        }

        return (double)nums3[nums3.length / 2];
    }

    public static void main(String[] args){
        int[] n1 = {1, 3};
        int[] n2 = {2};
        System.out.println(findMedianSortedArrays(n1, n2));
    }


}
