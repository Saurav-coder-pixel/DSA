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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        if (head == null) {
            return head;
        }

        int times = right - left + 1;
        int pos = 1;

        ListNode before = null;
        ListNode t = head;
        ListNode prv = null;

        while (pos < left) {
            before = t;
            t = t.next;
            pos++;
        }

        ListNode curr = t;

        while (times > 0) {
            ListNode nextNode = curr.next;
            curr.next = prv;
            prv = curr;
            curr = nextNode;
            times--;
        }

        t.next = curr;
        if (before != null) {
            before.next = prv;
            return head;
        }

        return prv;
    }
}