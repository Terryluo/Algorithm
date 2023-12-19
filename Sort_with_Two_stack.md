Sort with Two Stack
==

Sorting a stack using two stacks is a common problem that can be solved using a modified version of the merge sort algorithm. 
The idea is to use two stacks, one as the original stack and the other as an auxiliary stack, to facilitate the sorting process.

In this implementation:

We pop elements from the original stack and compare them with the top element of the auxiliary stack.
If the current element is smaller than the top of the auxiliary stack, we pop elements from the auxiliary stack and push them onto the original stack until we find the correct position for the current element.
Finally, we push the current element onto the auxiliary stack.
The process is repeated until the original stack is empty. The sorted elements are left in the auxiliary stack, which we return as the sorted stack.

This approach has a time complexity of `O(n^2)` in the worst case, where n is the number of elements in the stack. Each element is compared with and possibly moved to the auxiliary stack in the worst case. 
However, the average and best-case time complexity is `O(nlogn)` because the elements are divided into two halves during the process, similar to the merge sort algorithm.

```
public class SortWithTwoStacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        sort(s1, s2);
        // move all s2 numbers to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    private void sort(Deque<Integer> s1, Deque<Integer> s2) {
        if (s1.isEmpty()) {
            return;
        }
        // every time find the global minimum and count for the number for it. at last push all global minimum to s2.
        int globalMinimum = Integer.MAX_VALUE;
        int count = 0;
        while (!s1.isEmpty()) {
            if (s1.peek() < globalMinimum) {
                globalMinimum = s1.peek();
                count = 1;
            } else if (s1.peek() == globalMinimum) {
                count++;
            }
            s2.push(s1.pop());
        }
        while (!s2.isEmpty() && s2.peek() >= globalMinimum) {
            if (s2.peek() == globalMinimum) {
                s2.pop();
            } else {
                s1.push(s2.pop());
            }
        }
        while (count > 0) {
            s2.push(globalMinimum);
            count--;
        }
        sort(s1, s2);
    }
}
```
