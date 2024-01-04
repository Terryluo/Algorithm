package util;

import java.util.Arrays;

public class MinHeap implements BinaryHeap {
    int[] minHeap;
    int size;
    public MinHeap(int[] minHeap) throws Exception {
        if (minHeap == null || minHeap.length == 0) {
            throw new Exception("parsing invalid input to construct minHeap");
        }
        this.minHeap = minHeap;
        this.size = minHeap.length;
        heapify();
    }

    public MinHeap(int heapSize) throws Exception {
        if (heapSize <= 0) {
            throw new Exception("heap size cannot be zero or negative!");
        }
        assert heapSize > 0;
        this.minHeap = new int[heapSize];
        this.size = 0;
    }

    private void heapify() {
        // lastParent is the same to last non-leaf node, see the explanation in percolateDown
        int lastParent = size / 2 - 1;
        for (int i = lastParent; i >= 0; i--) {
            percolateDown(i);
        }
    }

    @Override
    public void offer(int num) {
        if (size != 0 && size == minHeap.length) {
            minHeap = Arrays.copyOf(minHeap, (int) (size * 1.5));
        }
        minHeap[size] = num;
        percolateUp(size);
        size++;
    }

    private void percolateUp(int index) {
        while (index > 0) {
            // compare with its parent which is (index - 1) / 2
            int parent = (index - 1) / 2;
            if (minHeap[index] < minHeap[parent]) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void percolateDown(int index) {
        // last non-leaf node which is (size / 2 - 1)
        // why is size/2 - 1? because the last node's index is size - 1, the parent index of the last node is (index - 1) / 2
        // so it is (size - 1 - 1) / 2, which is (size / 2 - 1)
        while (index < size / 2 - 1) {
            int comparedCandidate = index * 2 + 1;
            int rightChild = index * 2 + 2;
            if (rightChild <= size - 1 && minHeap[rightChild] < minHeap[comparedCandidate]) {
                comparedCandidate = rightChild;
            }
            if (minHeap[index] > minHeap[comparedCandidate]) {
                swap(index, comparedCandidate);
                index = comparedCandidate;
            } else {
                // index is the smallest numberamong its children
                break;
            }
        }
    }

    private void swap(int a, int b) {
        int temp = minHeap[a];
        minHeap[a] = minHeap[b];
        minHeap[b] = temp;
    }

    @Override
    public int peek() throws Exception {
        if (size == 0) {
            throw new Exception("there is no element in the heap");
        }
        return minHeap[0];
    }

    @Override
    public int poll() throws Exception {
        if (size == 0) {
            throw new Exception("there is no element in the heap");
        }
        int result = minHeap[0];
        minHeap[0] = minHeap[size - 1];
        size--;
        percolateDown(0);
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void update(int index, int num) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("there is no such element in the heap");
        }
        int current = minHeap[index];
        minHeap[index] = num;
        if (num < current) {
            percolateUp(index);
        } else {
            percolateDown(index);
        }
    }
}
