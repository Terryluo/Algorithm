import java.util.Deque;
import java.util.LinkedList;

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

    private void insertNumbers(Deque<Integer> s1, int[] array) {
        for (int num : array) {
            s1.push(num);
        }
    }

    private void printNumbers(Deque<Integer> s1) {
        while (!s1.isEmpty()) {
            System.out.printf("%d, ", s1.pop());
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> s1 = new LinkedList<>();
        SortWithTwoStacks swts = new SortWithTwoStacks();
        swts.insertNumbers(s1, new int[]{1, 3, 2, 5, 6, 14, 90, 5, 6});
        swts.sort(s1);
        swts.printNumbers(s1);
    }
}
