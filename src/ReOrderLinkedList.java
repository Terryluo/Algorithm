/*
Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null

        Examples

        L = null, is reordered to null
        L = 1 -> null, is reordered to 1 -> null
        L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
        L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null
*/

public class ReOrderLinkedList {
    public ListNode reorder(ListNode head) {
        // step 1, get the first half linked list
        ListNode firstHalf = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            head = head.next;
            fast = fast.next.next;
        }
        // step 2, get the second half linked list
        ListNode nxt = head.next;
        head.next = null; // cutoff the firstHalf
        head = nxt;
        ListNode secondHalf = new ListNode(head.value);
        head = head.next;
        while (head != null) {
            ListNode newNode = new ListNode(head.value);
            newNode.next = secondHalf;
            secondHalf = newNode;
            head = head.next;
        }
        // step 3, merge the first half and second half together
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (firstHalf != null && secondHalf != null) {
            cur.next = firstHalf;
            firstHalf = firstHalf.next;
            cur = cur.next;
            cur.next = secondHalf;
            secondHalf = secondHalf.next;
            cur = cur.next;
        }
        cur.next = firstHalf;
        return dummy.next;
    }

    public static void main(String[] args) {
        try {
            //ListNode head = ListNode.fromIntegerArray(new int[]{293,16,83,960,430,215,369,813,343,927,480,263,797,885,408,146,895,677,994,673,116,1015,330,714,954,910,339,822,903});
            ListNode head = ListNode.fromIntegerArray(new int[]{1,2,3});
            System.out.println("The previous Linked List is:");
            ListNode.printLinkedList(head);
            ReOrderLinkedList rll = new ReOrderLinkedList();
            head = rll.reorder(head);
            System.out.println("The new Linked List is:");
            ListNode.printLinkedList(head);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
