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
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1. Check if there are at least k nodes left
        ListNode temp = head;
        int count = 0;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        // If fewer than k nodes remain, leave them as is
        if (count < k) {
            return head;
        }

        // 2. Reverse the first k nodes (standard linked list reversal)
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // 3. Connect the tail (old head) to the result of the next group
        head.next = reverseKGroup(curr, k);

        // prev is the new head of this reversed k-group
        return prev;
    }
}