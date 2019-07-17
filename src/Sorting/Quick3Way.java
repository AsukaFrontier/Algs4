package Sorting;
public class Quick3Way implements Sortable //
{
    @Override
    public void sort(Comparable[] a)
    {
        RandomShuffle.shuffle(a);
        sort(a,0,a.length-1);
    }
    private void sort(Comparable[] a, int lo, int hi)
    {
        if(hi<=lo)
            return ;
        int lt= lo;
        int i= lo+1;
        int gt= hi;
        Comparable v= a[lo];
        while(i<=gt)
        {
            int cmp=a[i].compareTo(v);
            if(cmp<0)
                exch(a,lt++,i++);
            else if(cmp>0)
                exch(a,i,gt--);
            else
                i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }
}
