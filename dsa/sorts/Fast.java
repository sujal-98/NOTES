package sorts;

public class Fast {
    // QuickSort is a sorting algorithm based on the Divide and Conquer algorithm
    // that picks an element as a pivot and partitions the given array around the
    // picked pivot by placing the pivot in its correct position in the sorted
    // array.

    // QuickSort is considered an in-place sorting algorithm because it typically
    // sorts the array without requiring additional memory proportional to the size
    // of the input array. It uses only a small, constant amount of extra space to
    // hold variables like the pivot index

    // How does QuickSort work?
    // The key process in quickSort is a partition() . The target of partitions is
    // to place the pivot (any element can be chosen to be a pivot) at its correct
    // position in the sorted array and put all smaller elements to the left of the
    // pivot, and all greater elements to the right of the pivot.

    // Partition is done recursively on each side of the pivot after the pivot is
    // placed in its correct position and this finally sorts the array.

    // There exist two main algorithms for partitioning Lomuto and Hoare.

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot

    // Lomuto Partioning

    // Lomuto Partitioning
    public static int partitioning(int[] arr, int i, int j) {
        int pivot = arr[j]; // Pivot is the last element
        int a = i - 1; // Index of smaller element

        for (int b = i; b <= j - 1; b++) {
            // If current element is smaller than or equal to pivot
            if (arr[b] <= pivot) {
                a++;
                // Swap arr[a] and arr[b]
                swap(arr, a, b);
            }
        }
        // Swap the pivot element with the element at a+1
        swap(arr, a + 1, j);
        return (a + 1); // Return the partitioning index
    }

    // Hoare Partioning- basically finding smallest and largest elements than pivot and swapping them
    public static int Hoarepartitioning(int[] arr, int i, int j) {
        int pivot = arr[i];
        int low = i - 1;
        int high = j + 1;
        while (true) {
            do {
                low++;
            } while (arr[low] < pivot);

            do {
                high--;
            } while (arr[high] > pivot);

            if (low >= high) {
                return high;
            }

            // Swap elements at i and j
            swap(arr, low, high);
        }

    }

    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5, 88, 77, 66, 67, 57, 45, 77, 98, 99, 101 };
        int N = arr.length;

        // Function call
        long startTime = System.nanoTime();

        quicksort(arr, 0, N - 1);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("The Execution Time is : " + duration);

        System.out.println("Sorted array:");
        print(arr);
    }

    // Recursive Quick Sort
    public static void quicksort(int[] arr, int i, int j) {
        if (i < j) {
            int pivot = partitioning(arr, i, j);
            quicksort(arr, i, pivot - 1); // Recursively sort elements before partition
            quicksort(arr, pivot + 1, j); // Recursively sort elements after partition
        }
    }

    //Iterative Quick Sort
    void QuickSort(int arr[], int l, int h)
    {
        // create auxiliary stack
        int stack[] = new int[h - l + 1];

        // initialize top of stack
        int top = -1;

        // push initial values in the stack
        stack[++top] = l;
        stack[++top] = h;

        // keep popping elements until stack is not empty
        while (top >= 0) {
            // pop h and l
            h = stack[top--];
            l = stack[top--];

            // set pivot element at it's proper position
            int p = partitioning(arr, l, h);

            // If there are elements on left side of pivot,
            // then push left side to stack
            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            // If there are elements on right side of pivot,
            // then push right side to stack
            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    }

    // Swapping function
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Print array
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // TC- O(nlogn)------- Worst Case is O(n^2)
    // SC- O(logn)--------- Worst Case is O(n)


    //Application of Quick Sort
    //Quicksort is a cache-friendly algorithm as it has a good locality of reference when used for arrays
    //it is tail recursive
    //it is  inplace
}
