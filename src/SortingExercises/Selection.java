package SortingExercises;
public class Selection implements Sortable //
{
    @Override
    public void sort(Comparable[] a) //Selection Sort
    {
        int N=a.length;
        for(int i=0;i<N;i++)
        {
            int min=i; //最小元素的索引
            for(int j=i+1;j<N;j++)
            {
                if(less(a[j], a[min]))
                    min=j;
            }
            exch(a,i,min);
        }
    }
    //-------------------UNIT TEST---------------//
    public static void main(String[] args)
    {
        Sortable s= new Selection();
        Integer[] ints={5,4,3,2,1,6,7,8,9,10};
        s.sort(ints);
        assert s.isSorted(ints);
        s.show(ints);
    }
}
