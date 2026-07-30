class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Current value appears more than once.
        if (head.val == head.next.val) {
            int value = head.val;

            // Skip all nodes having the same value.
            while (head != null && head.val == value) {
                head = head.next;
            }

            return deleteDuplicates(head);
        }

        // Keep the current node.
        head.next = deleteDuplicates(head.next);

        return head;
    }
}