package Searching;
public class LinearProbingHashUnorderedST<Key, Value> implements UnorderedST<Key, Value>//
{
    //
    private int N; //符号表中键值对的总数
    private int M=50; //线性探测表的大小: M>N;
    // 假设线性探测表的大小满足符号表键值对对数量的需求
    private Key[] keys;
    private Value[] vals;
    //
    public LinearProbingHashUnorderedST()
    {
        keys= (Key[]) new Object[M];
        vals= (Value[]) new Object[M];
    }
    //
    public void put(Key key, Value val)
    {
        int i; //通过散列函数得到的线性探测表的数组索引
        for(i= hash(key);keys[i]!=null;i=(i+1)%M)
            if(keys[i].equals(key))
            {
                vals[i]=val;
                return ;
            }
        //若线性探测表中没有找到key所对应的, 则在数组的null处put该元素
        keys[i]= key;
        vals[i]= val;
        N++;
    }
    public Value get(Key key)
    {
        for(int i= hash(key); keys[i]!=null; i=(i+1)%M)
            if(keys[i].equals(key))
                return vals[i];
        return null;
    }
    public int size()
    {
        return N;
    }
    //
    private int hash(Key key) //散列函数
    {
        return (key.hashCode()&0x7fff_ffff) %M;
    }
}
