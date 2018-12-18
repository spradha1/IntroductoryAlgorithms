// heap sort for max heap
public class MaxHeapSort {
    public static void main (String[] args) {
      int[] arr = {12, 19, 25, 25, 17, 8};
      mhsort(arr, 0);
      for (int a: arr) {
        System.out.print(a + " ");
      }
      System.out.println();
    }

    static void mhsort (int[] arr, int i) {
        if (i > (arr.length-1)/2)
            return;
        int l = 2*i + 1;
        int r = 2*i + 2;
        int largest = i;
        if (l<arr.length && arr[l]>arr[i])
            largest = l;
        else
            largest = i;
        if (r<arr.length && arr[r]>arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
        }
        mhsort(arr, ++i);
    }
}