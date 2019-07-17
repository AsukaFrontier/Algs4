package SortingExercises;
public class Merge implements Sortable //
{
    private static Comparable[] aux; //类的静态变量
    @Override
    public void sort(Comparable[] a)
    {
        aux= new Comparable[a.length];
        sort(a,0,a.length-1);
    }
    private void sort(Comparable[] a, int lo, int hi)
    //将数组a[lo,...,hi]排序
    {
        if(hi<=lo)
            return ;
        int mid= lo+(hi-lo)/2;
        sort(a,lo,mid); //递归排序
        sort(a,mid+1,hi); //递归排序
        merge(a,lo,mid,hi);
    }
    private void merge(Comparable[] a, int lo, int mid, int hi)
    //将数组a[lo...mid]与a[mid+1...hi]归并为a[lo...hi]
    {
        int i=lo; //左子数组(有序)的起始索引
        int j=mid+1; //右子数组(有序)的起始索引
        for(int k=lo;k<=hi;k++) //将a[lo...hi]复制给aux[lo...hi]
            aux[k]=a[k];
        for(int k=lo;k<=hi;k++) //以索引k对数组a[lo...hi]的merge过程
            if(i>mid) //左子数组已检查完毕
                a[k]=aux[j++];
            else if(j>hi) //右子数组已检查完毕
                a[k]=aux[i++];
            else if(less(aux[i],aux[j]))
                a[k]=aux[i++];
            else
                a[k]=aux[j++];
    }
    //------------------------------UNIT TEST---------------------------//
    public static void main(String[] args)
    {
        Sortable s= new Merge();
        Integer[] ints={5,4,3,2,1,6,7,8,9,10};
        s.sort(ints);
        //assert s.isSorted(ints);
        s.show(ints);
    }
}
