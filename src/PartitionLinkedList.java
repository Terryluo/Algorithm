/*
Given a linked list and a target value T, partition it such that all nodes less than T
are listed before the nodes larger than or equal to target value T.
The original relative order of the nodes in each of the two partitions should be preserved.

        Examples

        L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null

        L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 5, is partitioned to 2 -> 4 -> 3 -> 1 -> 5 -> null
*/


public class PartitionLinkedList {
    public ListNode partition(ListNode head, int target) {
        // create two linked lists, one is for value smaller than target, one is for number equals to /larger than target
        // put smaller linked list at first and concatenate the larger linked list, time complexity: O(n)
        ListNode smallerDummy = new ListNode(0), smallerPointer = smallerDummy;
        ListNode largerDummy = new ListNode(0), largerPointer = largerDummy;
        while (head != null) {
            if (head.value < target) {
                smallerPointer.next = head;
                smallerPointer = smallerPointer.next;
            } else {
                largerPointer.next = head;
                largerPointer = largerPointer.next;
            }
            head = head.next;
        }
        // cutoff the tail of largerPointer
        largerPointer.next = null;
        // link smaller linked list to larger linked list
        smallerPointer.next = largerDummy.next;

        return smallerDummy.next;
    }

    public static void main(String[] args) {
        try {
            ListNode head = ListNode.fromIntegerArray(new int[]{2, 4, 3, 5, 1});
            System.out.println("The previous Linked List is:");
            ListNode.printLinkedList(head);
            PartitionLinkedList pll = new PartitionLinkedList();
            head = pll.partition(head, 3);
            System.out.println("The new Linked List is:");
            ListNode.printLinkedList(head);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
