Reorder Linked List
==

Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null

        Examples

        L = null, is reordered to null
        L = 1 -> null, is reordered to 1 -> null
        L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
        L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null


Reordering a linked list involves modifying the order of its nodes to achieve a specific arrangement. 
One common task is to reorder the linked list in such a way that it alternates between the first and last elements, 
then the second and second-to-last elements, and so on. 

```
class util.ListNode:
    def __init__(self, value=0, next=None):
        self.value = value
        self.next = next

def reorder_linked_list(head):
    if head is None or head.next is None:
        return head

    # Find the middle of the linked list
    middle = find_middle(head)

    # Reverse the second half of the linked list
    reversed_second_half = reverse_linked_list(middle.next)
    middle.next = None  # Break the link between the first and second halves

    # Merge the two halves of the linked list
    merge_linked_lists(head, reversed_second_half)

def find_middle(head):
    slow = head
    fast = head

    while fast.next is not None and fast.next.next is not None:
        slow = slow.next
        fast = fast.next.next

    return slow

def reverse_linked_list(head):
    prev = None
    current = head

    while current is not None:
        next_node = current.next
        current.next = prev
        prev = current
        current = next_node

    return prev

def merge_linked_lists(first, second):
    while second is not None:
        first_next = first.next
        second_next = second.next

        first.next = second
        second.next = first_next

        first = first_next
        second = second_next

# Example usage:
# Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
head = util.ListNode(1, util.ListNode(2, util.ListNode(3, util.ListNode(4, util.ListNode(5)))))

# Reorder the linked list
reorder_linked_list(head)

# Print the reordered linked list
while head is not None:
    print(head.value, end=" ")
    head = head.next
```
