// binary search on sorted array of integers
import java.util.*;

public class BinarySearch<E extends Object> implements Comparator<Object>{

    static final int TO_FIND = 81;
    public static void main (String[] args) {
        int[] arr = {1, 3, 11, 15, 21, 29, 30, 37};
        System.out.println(bsearch(arr, 0, arr.length-1, TO_FIND));
    }

    static int bsearch(int[] arr, int l, int r, int x) {
        if (r>=0 && l<arr.length) {
            int med = (l+r)/2;
            int comp = new BinarySearch().compare(x, arr[med]);
            switch(comp) {
                case 0:
                    return med;
                case 1:
                    return bsearch(arr, med+1, r, x);
                case -1:
                    return bsearch(arr, l, med-1, x);
                default:
            }
        }
        return -1;
    }

    // method can be modified for different data types
    @Override
    public int compare(Object x, Object y) {
        if(x instanceof Integer && y instanceof Integer) {
            return Long.signum((Integer)x - (Integer)y);
        }
        else
            return -5;  //dummy return value for unavailable measures for other data types;
    }
}