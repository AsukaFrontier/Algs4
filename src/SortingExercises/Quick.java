package SortingExercises;
public class Quick implements Sortable //
{
    @Override
    public void sort(Comparable[] a)
    {
        RandomShuffle.shuffle(a); //随机打乱
        sort(a,0,a.length-1);
    }
    private void sort(Comparable[] a, int lo, int hi)
    {
        if(hi<=lo) //对于只有一个元素的sort(), 不再进行递归
            return ;
        int j= partition(a,lo,hi);
        sort(a,lo,j-1);//递归的sort()不包含j
        sort(a,j+1,hi);
    }
    private int partition(Comparable[] a, int lo, int hi) //partition()方法本身不进行递归
    //a[lo...hi]
    {
        //每一次partition()只保证当前的a[lo,hi]中: a[lo,j-1]<=a[j], a[j]<=a[j+1,hi];
        int i= lo;
        int j= hi+1;
        Comparable v= a[lo];
        while(true)
        {
            while(less(a[++i],v)&&i<hi) //(不扫描a[lo])扫描左侧, 直至找到一个元素a[i]>a[lo]
                continue;
            while(less(v,a[--j])&&j>lo) //扫描右侧, 直至找到一个元素a[j]<a[lo]
                continue;
            if(i>=j) //a[lo]的插入位置
                break; //跳出外层循环
            exch(a,i,j); //将左侧比a[lo]大的元素和右侧比a[lo]小的元素交换; //处理非中间的不适元素
        }
        exch(a,lo,j); //将a[lo]与a[j]交换;
        // 此处a[j]<a[lo]: while(less(v,a[--j])&&j>lo) continue;语句使得索引j对应的a[j]小于a[lo];
        return j;
    }
    //------------------------UNIT TEST-----------------------//
    public static void main(String[] args)
    {
        Sortable s= new Quick();
        Integer[] ints={5,4,3,2,6,7,8,1,9,10};
        s.sort(ints);
        //assert s.isSorted(ints);
        s.show(ints);
    }
}
