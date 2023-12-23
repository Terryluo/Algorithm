/*
Given three arrays sorted in ascending order. Pull one number from each array to form a coordinate <x,y,z> in a 3D space.
Find the coordinates of the points that is k-th closest to <0,0,0>.
We are using euclidean distance here.

Assumptions

The three given arrays are not null or empty, containing only non-negative numbers
K >= 1 and K <= a.length * b.length * c.length
Return

a size 3 integer list, the first element should be from the first array, the second element should be from the second array and the third should be from the third array
Examples

A = {1, 3, 5}, B = {2, 4}, C = {3, 6}

The closest is <1, 2, 3>, distance is sqrt(1 + 4 + 9)

The 2nd closest is <3, 2, 3>, distance is sqrt(9 + 4 + 9)
*/

import util.TreeNode;

import java.util.*;

public class KthClosestPoint {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        // The intuitive solution for this question is to try all points distance to <0,0,0>
        // We can use priority queue to save the point according to the distance
        // step 1. create a priority queue with a comparator in k size
        //Queue<List<Integer>> maxHeap = new PriorityQueue<>(k, (l1, l2) -> compareLists(l1, l2)); // this is a better expression than below
        Queue<List<Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                return compareLists(l1, l2);
            }
        });
        // step 2. try all points from a, b, c
        for (int l = 0; l < a.length; l++) {
            for (int m = 0; m < b.length; m++) {
                for (int n = 0; n < c.length; n++) {
                    List<Integer> current = Arrays.asList(a[l], b[m], c[n]);
                    if (maxHeap.size() < k) {
                        maxHeap.add(current);
                    } else {
                        if (compareLists(maxHeap.peek(), current) < 0) {
                            // the top element larger than current
                            maxHeap.poll();
                            maxHeap.add(current);
                        }
                    }
                }
            }
        }
        // step 3. pop out the kth the closest result
        return maxHeap.peek();
    }

    private int compareLists(List<Integer> l1, List<Integer> l2) {
        int x1 = l1.get(0), y1 = l1.get(1), z1 = l1.get(2);
        int x2 = l2.get(0), y2 = l2.get(1), z2 = l2.get(2);
        return x2 * x2 + y2 * y2 + z2 * z2 - x1 * x1 - y1 * y1 - z1 * z1;
    }

    public static void main(String[] args) {
        KthClosestPoint rvobt = new KthClosestPoint();
        List<Integer> result = rvobt.closest(new int[]{1,2,3}, new int[]{2,4}, new int[]{1,2}, 10);
        for (Integer i : result) {
            System.out.printf("%d, ", i);
        }
    }
}
