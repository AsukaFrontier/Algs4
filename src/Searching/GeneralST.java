package Searching;
public interface GeneralST<Key, Value> //
{
    void put(Key key, Value value);
    Value get(Key key);
    int size();
    //interface GenaralST的默认实现
    default void delete(Key key) //默认(延时)实现
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
