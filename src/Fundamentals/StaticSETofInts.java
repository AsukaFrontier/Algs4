package Fundamentals;

/**
 * Page 61, 62;
 * private int[] a;
 * public StaticSETofInts(int[] keys)
 * public boolean contains(int key)
 * private int rank(int key)
 */
import java.util.Arrays;
public class StaticSETofInts {
    private int[] a;
    //
    public StaticSETofInts(int[] keys)
    {
        a= new int[keys.length];
        for(int i=0;i<keys.length;i++)
            a[i]=keys[i];//保护性复制
        Arrays.sort(a);
    }
    public boolean contains(int key)
    {
        return rank(key)!=-1;
    }
    private int rank(int key)
    {
        //BinarySearch
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
}
