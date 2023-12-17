Quick Sort
==

QuickSort is a sorting algorithm that follows the divide-and-conquer paradigm to efficiently sort an array or list of elements. It was developed by Tony Hoare in 1960 and is widely used due to its efficiency and average-case time complexity of `O(nlogn)`, 
where "n" is the number of elements to be sorted.

The basic idea behind QuickSort is to partition the array into two sub-arrays based on a chosen pivot element. Elements smaller than the pivot are placed on its left, and elements greater than the pivot are placed on its right. The pivot is then in its 
final sorted position. The process is repeated recursively on the sub-arrays until the entire array is sorted.

#### Here are the key steps of the QuickSort algorithm:
**Select a Pivot:** Choose a pivot element from the array. There are various strategies for selecting the pivot, such as choosing the first or last element, the middle element, or using a random element.
**Partitioning:** Rearrange the array so that elements smaller than the pivot are on its left, and elements greater than the pivot are on its right. The pivot is now in its final sorted position.
**Recursion:** Recursively apply the above two steps to the sub-arrays on the left and right of the pivot until the entire array is sorted.

The efficiency of QuickSort lies in its ability to sort the array in-place, requiring only a small amount of additional memory for recursive calls. However, in the **worst-case scenario**, if the pivot selection consistently results in unbalanced partitions, 
the time complexity can degrade to `O(n^2)`. To mitigate this, randomized pivot selection or other optimization techniques can be employed.

Despite the potential for worst-case scenarios, QuickSort is often faster in practice than other `O(nlogn)` sorting algorithms, such as Merge Sort, due to its efficient use of cache and better constant factors.
