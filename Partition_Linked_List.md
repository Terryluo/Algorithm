Partition Linked List
==

#### Example
Given a linked list and a target value T, partition it such that all nodes less than T
are listed before the nodes larger than or equal to target value T.
The original relative order of the nodes in each of the two partitions should be preserved.

L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null

L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 5, is partitioned to 2 -> 4 -> 3 -> 1 -> 5 -> null

#### Solution
create two linked lists, one is for value smaller than target, one is for number equals to /larger than target
put smaller linked list at first and concatenate the larger linked list, time complexity: `O(n)`

```
public ListNode partition(ListNode head, int target) {
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
```
