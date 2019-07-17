package Sorting;

public class Insertion implements Sortable //
{
    @Override
    public void sort(Comparable[] a)
    {
        int N= a.length;
        for(int i=1;i<N;i++)
            for(int j=i;j>0&&less(a[j],a[j-1]);j--)
                exch(a,j-1,j);
    }
    //-------------------UNIT TEST---------------//
    public static void main(String[] args)
    {
        Sortable s= new Insertion();
        Integer[] ints={5,4,3,2,1,6,7,8,9,10};
        s.sort(ints);
        //assert s.isSorted(ints);
        s.show(ints);
    }
}
