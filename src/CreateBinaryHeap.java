import util.BinaryHeap;
import util.MinHeap;

public class CreateBinaryHeap {
    public static void main(String[] args) throws Exception {
        int[] array = new int[]{3,5,7,2,4,8,9,1,0,6};
        BinaryHeap minHeap = new MinHeap(array);
        System.out.println("minheap size is: " + minHeap.size());
        while (!minHeap.isEmpty()) {
            System.out.printf("%d,",minHeap.poll());
        }
    }
}
