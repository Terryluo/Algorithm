import java.util.Random;

public class QuickSort {
    private Random random = new Random();

    public QuickSort() {
    }

    public int[] quickSort(int[] array) {
        if (array != null && array.length != 0) {
            this.quickSort(array, 0, array.length - 1);
            return array;
        } else {
            return array;
        }
    }

    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = left + this.random.nextInt(right - left + 1);
            int i = left;
            int j = right - 1;
            this.swap(array, pivot, right);

            while(i <= j) {
                if (array[i] < array[right]) {
                    ++i;
                } else {
                    this.swap(array, i, j);
                    --j;
                }
            }

            this.swap(array, right, i);
            this.quickSort(array, left, i - 1);
            this.quickSort(array, i + 1, right);
        }
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 9, 8, 5, 3};

        assert a != null;

        QuickSort qs = new QuickSort();
        int[] result = qs.quickSort(a);
        int[] var4 = result;
        int var5 = result.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            int num = var4[var6];
            System.out.println(num);
        }

    }
}
