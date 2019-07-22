package Searching;
public class BinarySearchST<Key extends Comparable<Key>, Value>implements OrderedST<Key, Value>//
{
    private Key[] keys;
    private Value[] vals;
    private int N;
    public BinarySearchST(int capacity) //constructor
    {
        keys= (Key[]) new Comparable[capacity]; //keys[]是有序的
        vals= (Value[]) new Object[capacity];
    }
    public int size()
    {
        return N;
    }
    public Value get(Key key)
    {
        if(isEmpty())
            return null;
        int i= rank(key);
        if(i<N&&keys[i].compareTo(key)==0) //查找到该key
            return vals[i];
        else
            return null;
    }
    public void put(Key key, Value val)
    {
        int i= rank(key);
        if(i<N&&keys[i].compareTo(key)==0) //命中
        {
            vals[i]= val;
            return ;//修改key对应的val后退出put()
        }
        //未命中
        for(int j=N;j>i;j--)//将待插入位置(i)的后面的元素各先后移一位
        {
            keys[j]=keys[j-1];
            vals[j]=vals[j-1];
        }
        //插入key对应的val
        keys[i]=key;
        vals[i]=val;
        N++;
    }
    public int rank(Key key) //binarySearch
    {
        int lo=0;
        int hi=N-1;//N: array.length
        while(lo<=hi)
        {
            int mid= lo+(hi-lo)/2;
            int cmp=key.compareTo(keys[mid]);
            if(cmp<0)
                hi=mid-1;
            else
                if(cmp>0)
                    lo=mid+1;
                else
                    return mid;//数组中存在key对应的元素, 则返回该元素对应的位置
        }
        return lo;
    }
    public Key min()
    {
        return keys[0];
    }
    public Key max()
    {
        return keys[N-1];
    }
    public Key select(int k)
    {
        return keys[k];
    }
    public Key ceiling(Key key)
    {
        int i= rank(key);
        return keys[i];
    }
    public Key floor(Key key)
    {
        System.out.println("To be implemented!");
        int i= rank(key);
        return keys[i];
    }
    @Override
    public Iterable<Key> keys(Key lo, Key hi)
    {
        System.out.println("To be implemented!");
        return null;
    }
}
