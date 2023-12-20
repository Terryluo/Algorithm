package util;

public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public static ListNode linkedList(int start, int stop, int step) throws Exception {
        if (start > stop) {
            throw new Exception("Start could not larger than stop");
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for(int i = start; i <= stop; i += step) {
            ListNode nxt = new ListNode(i);
            cur.next = nxt;
            cur = cur.next;
        }

        return dummy.next;
    }

    public static ListNode linkedList(int start, int stop)throws Exception {
        return linkedList(start, stop, 1);
    }

    public static ListNode linkedList(int stop)throws Exception {
        return linkedList(0, stop, 1);
    }

    public static ListNode fromIntegerArray(int[] array) throws Exception {
        if (array == null || array.length == 0) throw new Exception("Array cannot be null or Empty");
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int num : array) {
            ListNode nxt = new ListNode(num);
            cur.next = nxt;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        while(head != null) {
            System.out.printf("%d, ", head.value);
            head = head.next;
        }

        System.out.println();
    }
}
