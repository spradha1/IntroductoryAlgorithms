// heap sort for max heap
import java.util.ArrayList;

public class MaxHeapSort {
    private static int heapSize; //prevents maxHeapify from meddling with elements already sorted
    public static void main (String[] args) {
        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(new int[]{12, 19, 25, 25, 17, 8});
        list.add(new int[]{1, 3, 2, 16, 9, 10, 14, 8, 7});
        
        for (int[] arr: list) {
            heapSort(arr);
            for (int a: arr)
                System.out.print(a + " ");
            System.out.println();
        }
    }

    static void heapSort (int[] arr) {
        buildMaxHeap(arr);
        for (int h=arr.length-1; h>0; h--) {
            int tmp = arr[0];
            arr[0] = arr[h];
            arr[h] = tmp;
            heapSize--;
            maxHeapify(arr, 0);
        }
    }

    static void buildMaxHeap (int[] arr) {
        heapSize = arr.length;
        for (int j = (arr.length/2) -1; j>=0; j--) {
            maxHeapify(arr, j);
        }
    }

    static void maxHeapify (int[] arr, int i) {
        int l = 2*i + 1;
        int r = 2*i + 2;
        int largest = i;
        if (l<heapSize && arr[l]>arr[i])
            largest = l;
        else
            largest = i;
        if (r<heapSize && arr[r]>arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            maxHeapify(arr, largest);
        }
    }
}