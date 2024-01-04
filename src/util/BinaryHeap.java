package util;

public interface BinaryHeap {
    void offer(int num);
    int peek() throws Exception;
    int poll() throws Exception;
    int size();
    boolean isEmpty();
    void update(int index, int num) throws Exception;
}
