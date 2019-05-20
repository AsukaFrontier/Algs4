package Fundamentals;
import java.util.Arrays;
/**
 * public static int rank(int key,int[] a)
 */
public class BinarySearch //有问题?
{
    public static int rank(int key, int[] a)
    {
        int lo=0;
        int hi=a.length-1;
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            if(key<a[mid])
                hi=mid-1;
            else if(key>a[mid])
                lo=mid+1;
            else
                return mid;
        }
        return -1;
    }
    //----------------UNIT TEST--------------------//
    public static void main(String[] args)
    {
        //
    }
}
