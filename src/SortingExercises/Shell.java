package SortingExercises;

public class Shell implements Sortable //
{
    @Override
    public void sort(Comparable[] a)
    {
        int N= a.length;
        //construct h-sequence: 1,4(1*3+1),13(4*3+1),40(13*3+1),121(40*3+1),...
        int h=1;
        while(h<N/3)
            h=h*3+1; //Here, h=4;
        //Shell sort
        while(h>=1) //h随着递增序列h-sequence递减
        {
            for(int i=h;i<N;i++) //j的数组索引: a[h...a.length-1]
                for(int j=i;j>=h&&less(a[j],a[j-h]);j=j-h) //j与其间隔h的元素比较
                    exch(a,j,j-h);
            h=h/3;
        }

    }
    //-------------------UNIT TEST---------------//
    public static void main(String[] args)
    {
        Sortable s= new Shell();
        Integer[] ints={5,4,3,2,1,6,7,8,9,10};
        s.sort(ints);
        //assert s.isSorted(ints);
        s.show(ints);
    }
}
