package Sorts;
import Fundamentals.Date;
/**
 *private static Comparable[] aux;
 * public static void sort(Comparable[] a)
 * private static void sort(Comparable[] a, int lo, int hi)
 * public static void merge(Comparable [] a, int lo, int mid, int hi)
 * private static boolean less(Comparable v, Comparable w)
 * private static boolean isSorted(Comparable[] a)
 * private static void show(Comparable[] a)
 * public static void main(String[] args)
 */
public class Merge
{
    private static Comparable[] aux;//auxiliary array
    public static void sort(Comparable[] a)
    {
        //
        aux= new Comparable[a.length];
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi)
    {
        //
        if(hi<=lo)
            return ;
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
    public static void merge(Comparable[] a, int lo, int mid, int hi)
    {
        //
        int i=lo;
        int j=mid+1;
        for(int k=lo;k<=hi;k++)
            aux[k]=a[k];
        for(int m=lo;m<=hi;m++)
        {
            if(i>mid)
            {
                a[m]=aux[j];
                j++;
            }
            else if(j>hi)
            {
                a[m]=aux[i];
                i++;
            }
            else if(less(aux[i],aux[j]))
            {
                a[m]=aux[i];
                i++;
            }
            else
            {
                a[m]=aux[j];
                j++;
            }
        }
    }
    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }
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
    private static void show(Comparable[] a)
    {
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    //----------------------------------------------------------//
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
