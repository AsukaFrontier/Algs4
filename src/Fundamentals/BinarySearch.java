package Fundamentals;
/**
 * public static int rank(int key,int[] a)
 * public static int rankRecursive(int key, int[] a)
 * private static int rankRecursive(int key, int[] a, int lo, int hi)
 */
public class BinarySearch
{
    public static int rank(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }
    //rank()的递归实现
    public static int rankRecursive(int key, int[] a) {
        return rankRecursive(key, a, 0, a.length-1);
    }
    private static int rankRecursive(int key, int[] a, int lo, int hi)
    {
        if(lo>hi)
            return -1;
        int mid=lo+(hi-lo)/2;
        if(key<a[mid])
            return rankRecursive(key, a, lo,mid-1);
        if(key>a[mid])
            return rankRecursive(key, a,mid+1, hi);
        else
            return mid;
    }
    //----------------UNIT TEST--------------------//
    public static void main(String[] args)
    {
        int[] ints={1,2,3,5,8,13,21,34,55};
        int int_index=rankRecursive(13,ints);
        System.out.print(int_index);
    }
}
