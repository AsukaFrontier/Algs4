package Sorts;
import Fundamentals.Date;
/**
 * public static void sort(Comparable[] a)
 * public static boolean isSorted(Comparable[] a)
 * private static boolean less(Comparable v, Comparable w)
 * private static void exch(Comparable[] a, int i, int j)
 * private static void show(Comparable[] a)
 * **
 * public static void main(String[] args)
 */
public class Quick {
    public static void sort(Comparable[] a)
    {
        //
        //arrayShuffle(a);
        //StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi)
    {
        //
        if(hi<=lo)
            return ;
        int j=partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    private static int partition(Comparable[] a, int lo, int hi)
    {
        //
        int i=lo;
        int j=hi+1;
        Comparable v= a[lo];
        while(true)
        {
            while(less(a[++i],v))
                if(i==hi)
                    break;
            while(less(v,a[--j]))
                if(j==lo)
                    break;
            if(i>=j)
                break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }
    /**
    private static void arrayShuffle(Comparable[] a)
    {
        //
    }
     */
    public static boolean isSorted(Comparable[] a)
    {
        for(int i=1;i<a.length;i++)
        {
            if(less(a[i],a[i-1]))
            {
                return false;
            }
        }
        return true;
    }
    private static boolean less(Comparable v, Comparable w)
    {
        if(v.compareTo(w)<0)
            return true;
        return false;
    }
    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    private static void show(Comparable[] a)
    {
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    //-----------------------------------------//
    public static void main(String[] args)
    {
        Integer[] ints={5,4,3,2,1,6,7,8,9,10};
        sort(ints);
        assert isSorted(ints);
        show(ints);
        //
        String[] strs= {"e","d","c","b","a","f","g"};
        sort(strs);
        assert isSorted(strs);
        show(strs);
        //
        Date d1=new Date(28,11,1994);
        Date d2=new Date(02,06,1996);
        Date[] dates={d1,d2};
        sort(dates);
        assert isSorted(dates);
        show(dates);
    }
}
