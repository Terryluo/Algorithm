public class ListNode {
    public int value;
    public ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public static ListNode createNewLinkedList(int start, int stop, int step) {
        if (start > stop) {
            System.out.println("Start could not larger than stop");
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for(int i = start; i <= stop; i += step) {
            ListNode nxt = new ListNode(i);
            cur.next = nxt;
            cur = nxt;
        }

        return dummy.next;
    }

    public static ListNode createNewLinkedList(int start, int stop) {
        return createNewLinkedList(start, stop, 1);
    }

    public static ListNode createNewLinkedList(int stop) {
        return createNewLinkedList(0, stop, 1);
    }

    public static void printLinkedList(ListNode head) {
        while(head != null) {
            System.out.printf("%d, ", head.value);
            head = head.next;
        }

        System.out.println();
    }
}
