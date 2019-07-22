package Searching;

public class BinarySearch //
{
    //int整型一维数组的二分查找算法实现
    //the recursive method to implement binary search algorithm;
    public static int recursiveBinarySearch(int[] arr, int key)
    {
        return recursiveBinarySearch(arr, key, 0, arr.length);
    }
    private static int recursiveBinarySearch(int[] arr, int key, int lo, int hi)
    {
        //一个跳出递归的条件
        if(lo>hi)
            return -1;
        //
        int mid= lo+(hi-lo)/2;
        if(key==arr[mid])
            return mid;
        else if(key<arr[mid])
            return recursiveBinarySearch(arr, key, lo, mid-1);
        else //key>arr[mid]
            return recursiveBinarySearch(arr, key, mid+1, hi);
    }
    //the iterative implementation of binary search algorithm;
    public static int iterativeBinarySearch(int[] arr, int key)
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
        if(arr[lo]==key)
            return lo;
        else
            return -1;
    }
    //--------------UNIT TEST-------------------//
    public static void main(String...args)
    {
        int[] array= {1,3,5,7,9,11,13,15};
        int intLocationIterative= BinarySearch.iterativeBinarySearch(array,5);
        System.out.println(intLocationIterative);
        int intLocationRecursive= BinarySearch.recursiveBinarySearch(array, 5);
        System.out.println(intLocationRecursive);
    }
}
