import util.ListNode;

public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        try {
            ListNode head = ListNode.linkedList(10);
            System.out.println("The previous Linked List is:");
            ListNode.printLinkedList(head);
            ReverseLinkedList rll = new ReverseLinkedList();
            head = rll.reverse(head);
            System.out.println("The new Linked List is:");
            ListNode.printLinkedList(head);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

