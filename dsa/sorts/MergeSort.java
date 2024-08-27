
public class MergeSort {
    // Merge sort is a sorting algorithm that follows the divide-and-conquer
    // approach. It works by recursively dividing the input array into smaller
    // subarrays and sorting those subarrays then merging them back together to
    // obtain the sorted array

    // 1. Divide: Divide the list or array recursively into two halves until it can
    // no
    // more be divided.
    // 2. Conquer: Each subarray is sorted individually using the merge sort
    // algorithm.
    // 3. Merge: The sorted subarrays are merged back together in sorted order. The
    // process continues until all elements from both subarrays have been merged.

    public static void merge(int[] arr, int start, int end, int mid) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[start + i];
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = arr[mid + i +1];
        }
        int i = 0, j = 0;
        int k = start;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k++] = arr1[i];
            i++;
        }
        while (j < n2) {
            arr[k++] = arr2[j];
            j++;
        }
    }

    // sorting function
    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, end, mid);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given array is");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array is");
        printArray(arr);
    }

    // Time Complexity:
    // Best Case: O(n log n), When the array is already sorted or nearly sorted.
    // Average Case: O(n log n), When the array is randomly ordered.
    // Worst Case: O(n log n), When the array is sorted in reverse order.
    // Auxiliary Space: O(n), Additional space is required for the temporary array
    // used during merging.

    // Advantages of Merge Sort:
    // Stability : Merge sort is a stable sorting algorithm, which means it
    // maintains the relative order of equal elements in the input array.
    // Guaranteed worst-case performance: Merge sort has a worst-case time
    // complexity of O(N logN) , which means it performs well even on large
    // datasets.
    // Simple to implement: The divide-and-conquer approach is straightforward.
    // Naturally Parallel : We independently merge subarrays that makes it suitable
    // for parallel processing.


    
    // Disadvantages of Merge Sort:
    // Space complexity: Merge sort requires additional memory to store the merged
    // sub-arrays during the sorting process.
    // Not in-place: Merge sort is not an in-place sorting algorithm, which means it
    // requires additional memory to store the sorted data. This can be a
    // disadvantage in applications where memory usage is a concern.
    // Slower than QuickSort in general. QuickSort is more cache friendly because it
    // works in-place.
}
