public class QuickSort {
  public static void main (String[] args) {
    int[] arr = {12, 19, 15, 21, 19, 17};
    qsort(arr, 0, arr.length-1);
    for (int a: arr) {
      System.out.print(a + " ");
    }
    System.out.println();
  }

  static void qsort (int[] arr, int l, int h) {
    if (l<h) {
      int p = part (arr, l , h);
      qsort (arr, l, p-1);
      qsort (arr, p+1, h);
    }
  }

  static int part (int[] arr, int l, int h){
    int pivot = arr[h];
    int i = l;
    for (int j=l; j<h; j++) {
      if (arr[j]<pivot){
        if (i!=j) {
          int tmp = arr[i];
          arr[i] = arr[j];
          arr[j] = tmp;
        }
        i++;
      }
    }
    int tmp = arr[i];
    arr[i] = arr[h];
    arr[h] = tmp; 
    return i;
  }
}
