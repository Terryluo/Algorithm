Reverse Linked List
==


Reversing a linked list involves changing the direction of links between nodes, effectively flipping the list so that the tail becomes the new head and vice versa. Here's a simple algorithm to reverse a linked list:
```
class util.ListNode:
    def __init__(self, value=0, next=None):
        self.value = value
        self.next = next

def reverse_linked_list_recursive(head):
    # Base case: an empty list or a list with a single node is already reversed
    if head is None or head.next is None:
        return head

    # Reverse the rest of the list
    new_head = reverse_linked_list_recursive(head.next)

    # Update the next pointer of the current node to point to its previous node
    head.next.next = head
    head.next = None

    return new_head

# Example usage:
# Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
head = util.ListNode(1, util.ListNode(2, util.ListNode(3, util.ListNode(4, util.ListNode(5)))))

# Reverse the linked list using recursion
new_head = reverse_linked_list_recursive(head)

# Print the reversed linked list
while new_head is not None:
    print(new_head.value, end=" ")
    new_head = new_head.next
```

In this recursive approach, the reverse_linked_list_recursive function takes the head of the current portion of the linked list and returns the new head of the reversed list. 
The base case checks if the list is empty or has only one node. If the base case is not met, the function reverses the rest of the list and then updates the pointers to reverse the current node.

Recursion allows you to express the logic of reversing a linked list in a concise and elegant way. 
However, keep in mind that excessive recursion might lead to a stack overflow for very long linked lists, as each recursive call consumes additional stack space.
