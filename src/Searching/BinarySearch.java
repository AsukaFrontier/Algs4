package Searching;

public class BinarySearch //
{
    //int整型一维数组的二分查找算法实现
    public static int recursiveBinarySearch(int[] arr, int key)
    {
        //
    }
    public static int iterativeBinarySearach(int[] arr, int key)
    {
        int N= arr.length;
        int lo=0;
        int hi=N-1;
        while(lo<=hi)
        {
            int mid= lo+(hi-lo)/2;
            if(key<arr[mid])
                hi=mid-1;
            else
                if(key==arr[mid])
                    return mid;
                else //key>arr[mid]
                    lo=mid+1;
        }
        return lo;//
    }
}
