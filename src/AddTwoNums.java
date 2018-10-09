/**
 * File: AddTwoNums.java
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * Author: Jiaxin Liu
 */

public class AddTwoNums {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    /**
     * Original Approach -- With bugs
     *                      Reason: redundancy
     *                              does not consider all test cases
     *                              raise null pointer exception
     * @param l1 listnode 1
     * @param l2 listnode 1
     * @return the resulting ListNode, the sum of l1 and l2
     */
    public static ListNode addTwoNums(ListNode l1, ListNode l2){
        ListNode list = new ListNode(0);
        ListNode curr = list;
        while (l1.next != null){
            int sum = l1.val + l2.val;
            if (sum > 9){
                curr.next = new ListNode(0);
                curr = curr.next;
                curr.val = sum % 10;
                l1.next.val = sum / 10 + l1.next.val;

            }
            else{
                curr.val = sum;
                curr.next = new ListNode(0);
                curr = curr.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        int sum = l1.val + l2.val;
        if (sum > 9){
            curr.val = sum % 10;
        }
        else{
            curr.val = sum;
        }
        return list;
    }


    /**
     * Approach 1: Elementary Math
     *             Time Complexity: O(max(m, n)) -- it depends on the length of l1 and l2
     *             Space Complexity: O(max(m, n)) -- it depends on the length of the summation of l1 and l2
     *             Description: use the ListNode structure to get the resulting sum of two
     *                          ListNode. Be careful of the "carry" number when the sum of
     *                          two digits is greater or equals to 10
     *                          Remember to consider all test cases:
     *                              l1 = [], l2 = [1,2]
     *                              l1 = [1, 2, 3], l2 = [3, 7, 9]
     *                              l1 = [3], l2 = [9. 3]
     *                          Pay attention to avoid the null exception
     * @param l1 listnode 1
     * @param l2 listnode 2
     * @return the resulting ListNode, the sum of l1 and l2
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode list = new ListNode(0); // initialize a list node
        ListNode list1 = l1, list2 = l2, curr = list; //make a copy of each listNode to avoid memory exceeding problems
        int carry = 0;
        while (list1 != null || list2 != null){ // consider all test cases
            int x = (list1 != null) ? list1.val : 0;
            int y = (list2 != null) ? list2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (list1 != null) list1 = list1.next; // check to avoid null pointer exception
            if (list2 != null) list2 = list2.next; // check to avoid null pointer exception
        }

        if (carry > 0){
            curr.next = new ListNode(carry);
        }

        return list.next;
    }


    private static void printfunc(ListNode list){
        if (list.next == null){
            System.out.println(list.val);
            return;
        }
        System.out.println(list.val);
        printfunc(list.next);
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        //ListNode list = addTwoNums(l1, l2);
        //printfunc(list);
        printfunc(addTwoNumbers(l1, l2));
        //System.out.println(addTwoNumbers(l1, l2).toString());


    }
}
