 import java.util.PriorityQueue;

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        // Put the first node of every list into the heap
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        // Dummy node
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {

            // Get smallest node
            ListNode node = pq.poll();

            // Add it to answer
            current.next = node;
            current = current.next;

            // Add next node from the same list
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}