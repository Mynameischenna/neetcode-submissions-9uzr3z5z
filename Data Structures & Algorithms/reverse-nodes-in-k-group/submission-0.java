class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;

        // check if k nodes exist
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {

            ListNode reversedHead = reverse(head, k);

            head.next = reverseKGroup(curr, k);

            return reversedHead;
        }

        return head;
    }

    private ListNode reverse(ListNode head, int k) {

        ListNode prev = null;
        ListNode curr = head;

        while (k-- > 0) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        return prev;
    }
}