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
public class Shell {
    public static void sort(Comparable[] a)
    {
        //create h-sequence
        int[] h_sequence_pow3={1,4,13,40,121,364,1093,3280,9841,29524,88573,265720,797161,2391484};
        //match a h-sequence
        int index_max_h_sequence=0;
        while(a.length>h_sequence_pow3[index_max_h_sequence])
        {
            index_max_h_sequence++;
        }
        index_max_h_sequence--;
        //each element in h-sequence
        //int count_exch=0;
        for(int i=index_max_h_sequence;i>=0;i--)
        {
            int current_element_in_h_sequence=h_sequence_pow3[i];
            for(int j=0;j<current_element_in_h_sequence;j=j+1)
            {
                for(int k=j+current_element_in_h_sequence;k<a.length;k=k+current_element_in_h_sequence)
                {
                    int m=k;
                    //exch()
                    while(m>=current_element_in_h_sequence&&less(a[m],a[m-current_element_in_h_sequence]))
                    {
                        exch(a,m,m-current_element_in_h_sequence);
                        m=m-current_element_in_h_sequence;
                        //count_exch++;
                    }
                }
            }
        }
        //System.out.println("Shell exch(): "+count_exch);
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
        //assert isSorted(ints);
        show(ints);
        //
        String[] strs= {"e","d","c","b","a","f","g"};
        sort(strs);
        //assert isSorted(strs);
        show(strs);
        //
        Date d1=new Date(02,06,1996);
        Date d2=new Date(28,11,1994);
        Date[] dates={d1,d2};
        sort(dates);
        //assert isSorted(dates);
        show(dates);
    }
}
