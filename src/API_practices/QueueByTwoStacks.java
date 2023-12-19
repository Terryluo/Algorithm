package API_practices;

import java.util.Deque;
import java.util.LinkedList;

public class QueueByTwoStacks {
    private Deque<Integer> in;
    private Deque<Integer> out;
    public QueueByTwoStacks() {
        this.in = new LinkedList<>();
        this.out = new LinkedList<>();
    }

    public Integer poll() {
        if (out.isEmpty()) {
            move();
        }
        return out.peek() == null ? null : out.pop();
    }

    public void offer(int element) {
        in.push(element);
    }

    public Integer peek() {
        if (out.isEmpty()) {
            move();
        }
        return out.peek();
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void move() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }
}
