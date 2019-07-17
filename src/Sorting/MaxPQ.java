package Sorting;
/**
 * public MaxPQ(int maxN)
 * public boolean isEmpty()
 * public int size()
 * public void insert(Key v)
 * public Key delMax()
 */
public class MaxPQ<Key extends Comparable<Key>>//
{
    private Key[] pq; //基于堆的完全二叉树数组
    private int N; //By default, N==0;
    public MaxPQ(int maxN)
    {
        pq= (Key[]) new Comparable[maxN+1]; //此处(强制类型转换)非泛型数组
    }
    public boolean isEmpty()
    {
        return N==0;
    }
    public int size()
    {
        return N;
    }
    public void insert(Key v)
    {
        pq[++N]= v; //pq[0]不使用, 在数组尾部插入新元素, 然后进行swim()
        swim(N);
    }
    public Key delMax()
    {
        //删除pq[1], 然后把数组尾部的元素添加到pq[1]上, 再对pq[1]进行sink()
        Key max= pq[1];
        exch(1,N--);
        pq[N+1]=null;
        sink(1);
        return max;
    }
    //---------------private instance methods--------------//
    private boolean less(int i, int j)
    {
        return pq[i].compareTo(pq[j])<0;
    }
    private void exch(int i, int j)
    {
        Key temp= pq[i];
        pq[i]= pq[j];
        pq[j]= temp;
    }
    private void swim(int k)
    {
        while(k>1&&less(k/2, k))
        {
            exch(k/2, k);
            k=k/2;
        }
    }
    private void sink(int k)
    {
        while(2*k<=N)
        {
            int j=2*k;
            if(j<N&&less(j,j+1))
                j++;
            if(less(j,k))
                break; //不需要交换
            exch(k,j);
            k=j;
        }
    }
    //--------------------------UNIT TEST------------------------//
    public static void main(String...args)
    {
        //
    }
}
