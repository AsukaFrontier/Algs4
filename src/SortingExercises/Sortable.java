package SortingExercises;

public interface Sortable //Selection, Insertion, Shell, Merge, Quick, Heap
{
    default void sort(Comparable[] a)
    {
        //
    }
    default boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }
    default void exch(Comparable[] a, int i, int j)
    {
        Comparable t= a[i];
        a[i]= a[j];
        a[j]= t;
    }
    default void show(Comparable[] a)
    {
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    default boolean isSorted(Comparable[] a)
    {
        for(int i=1;i<a.length;i++)
            if(less(a[i], a[i-1]))
                return false;
        return true;
    }
}
