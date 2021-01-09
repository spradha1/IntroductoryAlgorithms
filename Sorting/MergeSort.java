public class MergeSort {
  public static void main (String[] args) {
    int[] arr = {42, 19, 25, 25, 17, 8};
    for (int a: msort(arr)) {
      System.out.print(a + " ");
    }
    System.out.println();
  }

  static int[] msort (int[] arr) {
    if (arr.length <=1)
      return arr;
    int mid = arr.length/2;
    int[] left = new int[mid];
    int[] right = new int[arr.length-mid];
    for (int i=0; i<mid; i++) {
      left[i] = arr[i];
    }
    for (int j=0; j<right.length; j++) {
      right[j] = arr[mid+j];
    }
    return merge(msort(left), msort(right));
  }

  static int[] merge (int[] left, int[] right) {
    int[] narr = new int[left.length + right.length];
    int l = 0, r = 0, n = 0;
    while (l!=left.length && r!=right.length) {
      if (left[l] <= right[r]) {  // <= for stable sort
        narr[n++] = left[l++];
      }
      else {
        narr[n++] = right[r++];
      }
    }
    if (l == left.length) {
      while (r<right.length) {
          narr[n++] = right[r++];
        }
      }
    else {
      while (l<left.length) {
        narr[n++] = left[l++];
      }
    } 
    return narr;
  }
}
