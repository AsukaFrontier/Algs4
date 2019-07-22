package Searching;
public class BinarySearchST<Key extends Comparable<Key>, Value>implements OrderedST<Key, Value>//
{
    private Key[] keys;
    private Value[] vals;
    private int N;
    //
    public BinarySearchST(int capacity) //constructor
    {
        keys= (Key[]) new Comparable[capacity]; //keys[]是有序的
        vals= (Value[]) new Object[capacity];
    }
    public int size()
    {
        return N;
    }
    public Key min()
    {
        return keys[0];
    }
    public Key max()
    {
        return keys[N-1];
    }
    public Key select(int k) //数组索引对应着排名大小
    {
        return keys[k];
    }
    //如下实现皆基于rank()的实现
    public int rank(Key key) //迭代的binarySearch: 小于key的键的数量
    //rank()使用二分查找算法而实现, 如果未命中, 则返回的位置为其应当被插入的位置
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
        return lo; //二分查找未命中, 返回"数组中小于该元素的元素的数量"
    }
    public Value get(Key key)
    {
        if(isEmpty())
            return null;
        int i= rank(key);
        if(i<N&&keys[i].compareTo(key)==0) //查找到该key
            return vals[i];
        else //在该出现的位置没有出现
            return null;
    }
    public void put(Key key, Value val)
    {
        int i= rank(key); //先定位出该key在数组中应该出现的地方
        if(i<N&&keys[i].compareTo(key)==0) //命中(如果在该出现的地方出现了)
        {
            vals[i]= val;
            return ;//修改key对应的val后退出put()
        }
        //未命中(如果在该出现的地方没出现，就在该位置插入)
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
    public Key ceiling(Key key)
    {
        return keys[rank(key)];
    }
    public Key floor(Key key)
    {
        int i= rank(key);
        if(keys[i]==key)
            return key;
        else
            return keys[i-1];
    }
}
