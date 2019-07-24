package Searching;
public interface UnorderedST<Key, Value> //
{
    void put(Key key, Value value);
    Value get(Key key);
    int size();
    //interface GenaralST的默认实现
    default void delete(Key key) //默认不删除
    {
        return ;
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
