package Searching;

public class SeparateChainingHashUnsortedST<Key, Value> implements UnorderedST<Key, Value>//
{
    //
    private int N; //键值对总数
    private int M; //散列表大小
    private SequentialSearchUnorderedST<Key, Value>[] st;
    //
    public SeparateChainingHashUnsortedST() //constructor
    {
        this(23); //调用构造函数SeparateChainingHashST(int M);
    }
    private SeparateChainingHashUnsortedST(int M) //M的值是不可由外部赋值的, 可由类的实现者自行更新;
    {
        this.M= M;
        st= (SequentialSearchUnorderedST<Key, Value>[]) new SequentialSearchUnorderedST[M]; //Java不支持创建泛型数组
        for(int i=0; i<M;i++)
            st[i]= new SequentialSearchUnorderedST(); //创建一个Node型结点
    }
    //
    public Value get(Key key)
    {
        return (Value) st[hash(key)].get(key);
    }
    public void put(Key key, Value val)
    {
        st[hash(key)].put(key, val);
    }
    public int size()
    {
        int keysCount= 0;
        for(int i=0;i<M;i++)
        {
            keysCount= keysCount+ st[i].size();
        }
        return keysCount;
    }
    //
    private int hash(Key key) //散列函数
    {
        return (key.hashCode()&0x7fff_ffff)&M;
    }
}
