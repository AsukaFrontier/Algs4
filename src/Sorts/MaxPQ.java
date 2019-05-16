package Sorts;
/**
 * private Key[] pq;
 * private int N=0;
 * public MaxPQ(int maxN)
 * public boolean isEmpty()
 * public int size()
 * public void insert(Key v)
 * public Key delMax()
 *
 * private boolean less(int i, int j)
 * private void exch(int i, int j)
 * private void swim(int k)
 * private void sink(int k)
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N=0;

    public MaxPQ(int maxN)
    {
        pq= (Key[]) new Comparable[maxN+1];
    }
    public boolean isEmpty()
    {
        return N==0;
    }
    public void insert(Key v)
    {
        N++;
        pq[N]=v;
        swim(N);
    }
    public Key delMax()
    {
        Key max= pq[1];
        exch(1,N);
        N--;
        pq[N+1]=null;
        sink(1);
        return max;
    }
    private boolean less(int i, int j)
    {
        return pq[i].compareTo(pq[j])<0;
    }
    private void exch(int i, int j)
    {
        Key temp= pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
    }
    private void swim(int k)
    {
        while(k>1&&less(k/2,k))
        {
            exch(k/2,k);
            k/=2;
        }
    }
    private void sink(int k)
    {
        while(k*2<=N)
        {
            int j=k*2;
            if(j<N&&less(j+1,j))
                j++;
            if(!less(k,j))
                break;
            exch(k,j);
            k=j;
        }
    }
}
