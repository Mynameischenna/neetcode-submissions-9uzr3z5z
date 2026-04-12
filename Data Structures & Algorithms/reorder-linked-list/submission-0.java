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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode mid = findMedian(head);
        ListNode second = reverse(mid.next);
        ListNode first = head;
        mid.next = null; // break the center
        while (second != null) {
            ListNode l1 = first.next;
            ListNode l2 = second.next;

            first.next = second;
            second.next = l1;

            first = l1;
            second = l2;
        }
    }
    public ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
        ListNode next = curr.next; // save next
        curr.next = prev;      // reverse link
        prev = curr;           // move prev
        curr = next;           // move curr
    }

    return prev; // new head
}
    private ListNode findMedian(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
