package Searching;

public interface OrderedST<Key extends Comparable<Key>, Value> //Symbol Table
{
    //
    void put(Key key, Value val); //将键值对存入表中，若值为null则将键key从表中删除
    Value get(Key key);
    int size();
    Key min();
    Key max();
    Key floor(Key key);
    Key ceiling(Key key);
    int rank(Key key); //小于key的键的数量
    Key select(int k);
    //interface OrderedST的默认实现
    default void deleteMin()
    {
        delete(min());
    }
    default void deleteMax()
    {
        delete(max());
    }
    default int size(Key lo, Key hi)
    {
        if(hi.compareTo(lo)<0)
            return 0;
        else
            if(contains(hi))
                return rank(hi)-rank(lo)+1;
            else
                return rank(hi)-rank(lo);
    }
    default Iterable<Key> keys(Key lo, Key hi)
    {
        return null;
    }
    default Iterable<Key> keys()
    {
        return keys(min(), max());
    }
    //interface GeneralST的默认实现
    default void delete(Key key)
    {
        put(key, null);
    }
    default boolean contains(Key key)
    {
        return get(key)!=null;
    }
    default boolean isEmpty()
    {
        return size()==0;
    }
}
