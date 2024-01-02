package util;

public class minHeap implements BinaryHeap {
    int[] minHeap;
    int size;
    minHeap (int[] minHeap) {
        this.minHeap = minHeap;
        size = minHeap.length;
        heapify();
    }

    private void heapify() {
        int lastParent = (minHeap.length - 1) / 2;
        for (int i = lastParent; i >= 0; i--) {
            percolateDown(i);
        }
    }

    @Override
    public void offer(int num) {

    }

    private void percolateUp() {

    }

    private void percolateDown(int index) {
        while (index < minHeap.length) {
            if (index > (minHeap.length - 1) / 2) return;
            int leftChild = index * 2 + 1 < minHeap.length ? index * 2 + 1 : -1;
            int rightChild = index * 2 + 2 < minHeap.length ? index * 2 + 2 : leftChild;
            int comparedChild;
            if (leftChild == -1) {
                comparedChild = -1;
            } else {
                comparedChild = minHeap[leftChild] <= minHeap[rightChild] ? leftChild : rightChild;
            }
            if (minHeap[index] > minHeap[comparedChild]) {
                swap(index, comparedChild);
                index = comparedChild;
            }
        }
    }

    private void swap(int a, int b) {
        int temp = minHeap[a];
        minHeap[a] = minHeap[b];
        minHeap[b] = temp;
    }

    @Override
    public int peek() {
        return minHeap[0];
    }

    @Override
    public int poll() {
        return 0;
    }
}
