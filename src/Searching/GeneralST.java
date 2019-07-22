package Searching;
public interface GeneralST<Key, Value> //
{
    void put(Key key, Value value);
    Value get(Key key);
    int size();
    //interface GenaralST的默认实现
    default Iterable<Key> keys()
    {
        return null;
    }
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
