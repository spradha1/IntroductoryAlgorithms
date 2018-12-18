public class CountSort {
    public static void main (String[] args) {
        int[] arr = {6, 1, 2, 4, 1, 3, 0, 4};
        int max = 0;
        for(int a: arr)
            max = Math.max(max, a);
        int[] sorted = csort(arr, max+1);
        for (int a: sorted) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static int[] csort(int[] arr, int k) {
        int[] newArr = new int[arr.length];
        int[] store = new int[k];
        for (int j=0; j<arr.length; j++) {
            store[arr[j]]++;
        }
        for (int i=1; i<store.length; i++) {
            store[i] += store[i-1];
        }
        for(int n=arr.length-1; n>=0; n--) {
            newArr[--store[arr[n]]] = arr[n];
        }
        return newArr;
    }

}