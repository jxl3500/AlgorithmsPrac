/**
 * File: LongestSubstring.java
 *
 * @author: Jiaxin Liu
 * Date: Oct. 11th, 2018
 */

import java.util.*;


public class LongestSubstring {

    /**
     * Original solution : Brute Force
     *                  Time Complexity: O(N3) // going through the string twice within one another and
     *                                         // and the checking of list contains is the innermost loop
     *                                         // that has the time time complexity of O(N)
     *                  Space Complexity: O(min(m, n)) // the expanding size of the linked list
     *                  Description: go through character by character in a for loop and set a while loop
     *                               within it to count the rest of the element in the string without
     *                               unrepeated character
     *                  Efficiency: slow, not recommended; some redundancy
     *
     * @param s the string to be identified
     * @return the longest length of the substring without repeated characters
     */
    private static int LongestSubstring1(String s){
        int max = 0;
        int count = 0;
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i ++){
            int j = i;
            while(j < s.length()){
                if (list.contains(s.charAt(j))){
                    if (count > max){
                        max = count;
                    }
                    count = 0;
                    list = new LinkedList<>();
                    break;
                }
                else{
                    list.add(s.charAt(j));
                    j++;
                    count++;
                }
            }
        }
        if (count > max){
            max = count;
        }
        return max;
    }

    /**
     * Approach 2: Sliding windows
     *             Time Complexity: O(2n) ==> O(n)
     *             Space Complexity: O(min(m, n)) // the comparison between the length of the substring
     *                                            // and the length of the string
     *             Description: Within a while loop, define int i as the starting index of the substring
     *                          and int j as the ending index of the substring. The right shifting of j
     *                          determines whether the starting index of i needed to be shifted
     *             Efficiency: better, but not the best
     *
     *
     * @param s the string to be identified
     * @return the longest length of the substring without repeated characters
     */
    private static int longestLength2(String s){
        int len = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < len && j < len){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++)); // the same as: set.add(s.charAt(j));
                                        //              j++;
                ans = Math.max(ans, j - i);
            }

            else{
                set.remove(s.charAt(i++));

            }
        }
        return ans;
    }


    /**
     * Approach 2+: Sliding window optimized
     *              Time Complexity: O(n)
     *              Space Complexity: O(min(m, n))
     *              Description: use a hashMap to store character as the key and its (index(in stirng) + 1)
     *                           as the value. The int j represents each element in the substring in a right
     *                           sliding mode. The int i is determined by the higher value between i itself
     *                           and the related value of int j in the hashMap
     *                           The count of the longest length is calculated by the operation:
     *                              i = Math.max(map.get(s.charAt(j), i));
     *                              ans = Math.max(ans, j - i + 1);
     *              Efficiency: the best way to solve it, recommended
     * @param s the string to be identified
     * @return the longest length of the substring without repeated characters
     */
    private static int longestLength3(String s){
        int len = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < len; j++){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;

    }


    public static void main(String[] args){
        System.out.println(LongestSubstring1(" ") == 1);
        System.out.println(LongestSubstring1("dvdf") == 3);
        System.out.println(LongestSubstring1("bbbbbb") == 1);
        System.out.println(LongestSubstring1("") == 0);
        System.out.println(LongestSubstring1("asjrgapa") == 6);
        System.out.println(longestLength2("asjrgapa") == 6);
    }
}
