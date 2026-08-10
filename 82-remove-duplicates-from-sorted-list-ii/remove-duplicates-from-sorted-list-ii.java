 class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        // Dummy node before head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            // Check if current value is duplicated
            if (curr.next != null &&
                curr.val == curr.next.val) {

                int duplicateValue = curr.val;

                // Skip all nodes having this value
                while (curr != null &&
                       curr.val == duplicateValue) {
                    curr = curr.next;
                }

                prev.next = curr;

            } else {

                // Current node is unique
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}