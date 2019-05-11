package Sorts;
/**
 * public static void sort(Comparable[] a)
 * public static boolean isSorted(Comparable[] a)
 * private static boolean less(Comparable v, Comparable w)
 * private static void exch(Comparable[] a, int i, int j)
 * private static void show(Comparable[] a)
 * **
 * public static void main(String[] args)
 */
public class Insertion {
    public static void sort(Comparable[] a)
    {
        //
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

