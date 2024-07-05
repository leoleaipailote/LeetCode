/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return divide(head, length);
    }

    public ListNode divide(ListNode head, int length) {
        if (head == null || head.next == null)
            return head;
        int mid = (length - 1) / 2;
        ListNode end = head;
        for (int i = 0; i < mid; i++)
            end = end.next;
        ListNode right = divide(end.next, length - (mid + 1));
        end.next = null;
        ListNode left = divide(head, mid + 1);
        return conquer(right, left);
    }

    public ListNode conquer(ListNode x, ListNode y) {
        ListNode head = new ListNode();
        ListNode temp = head;
        while (x != null && y != null) {
            if (x.val <= y.val) {
                head.next = x;
                x = x.next;
            } else {
                head.next = y;
                y = y.next;
            }
            head = head.next;
        }
        while (x != null) {
            head.next = x;
            x = x.next;
            head = head.next;
        }
        while (y != null) {
            head.next = y;
            y = y.next;
            head = head.next;
        }
        return temp.next;
    }
}