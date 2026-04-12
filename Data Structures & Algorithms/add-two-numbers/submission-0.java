/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int cap = 0;
        while (l1 != null && l2 != null) {
            int data = l1.val + l2.val + cap;
            int curr = 0;
            if (data >= 10) {
                curr = data %10;
                cap = 1;
            } else {
                cap = 0;
                curr = data;
            }
            ListNode node = new ListNode(curr);
            dummy.next = node;
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int data = l1.val + cap;
            int curr = 0;
            if (data >= 10) {
                curr = data %10;
                cap = 1;
            } else {
                cap = 0;
                curr = data;
            }
            ListNode node = new ListNode(curr);
            dummy.next = node;
            dummy = dummy.next;
            l1 = l1.next;
        }
         while (l2 != null) {
            int data = l2.val + cap;
            int curr = 0;
            if (data >= 10) {
                curr = data %10;
                cap = 1;
            } else {
                cap = 0;
                curr = data;
            }
            ListNode node = new ListNode(curr);
            dummy.next = node;
            dummy = dummy.next;
            l2 = l2.next;
        }
        if (cap == 1) {
            ListNode node = new ListNode(1);
            dummy.next = node;
        }
        return temp.next;
    }
}
