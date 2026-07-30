class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Process the remaining list
        head.next = deleteDuplicates(head.next);

        // Remove duplicate
        if (head.val == head.next.val) {
            return head.next;
        }

        return head;
    }
}