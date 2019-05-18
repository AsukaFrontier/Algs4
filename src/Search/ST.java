package Search;
/**
 * *indicates a default implementation;
 * ST()
 * void put(Key key, Value val)
 * Value get(Key key)
 * void delete(Key key)
 * int size()
 * Key min()
 * Key max()
 * Key floor(Key key)
 * Key ceiling(Key key)
 * int rank(Key key)
 * Key select(int k)
 * Iterable<Key> keys(Key lo, Key hi)
 * *boolean contains(Key key)
 * *boolean isEmpty()
 * *void deleteMin()
 * *void deleteMax()
 * *int size(Key lo, Key hi)
 * *Iterable<Key> keys()
 */
public class ST<Key extends Comparable<Key>, Value>
{
    void put(Key key, Value val)
    {
        //
    }
    Value get(Key key)
    {
        //
    }
    void delete(Key key)
    {
        //
    }
    int size() {
        //
    }
    Key min() {
        //
    }
    Key max() {
        //
    }
    Key floor(Key key) {
        //
    }
    Key ceiling(Key key) {
        //
    }
    int rank(Key key) {
        //
    }
    Key select(int k) {
        //
    }
    Iterable<Key> keys(Key lo, Key hi) {
        //
    }
    boolean contains(Key key) {
        return get(key) != null;
    }
    boolean isEmpty() {
        return size() == 0;
    }
    void deleteMin() { delete(min()); }
    void deleteMax() { delete(max()); }
    int size(Key lo, Key hi)
    {
        if (hi.compareTo(lo) < 0)
            return 0;
        else if (contains(hi))
            return rank(hi) - rank(lo) + 1;
        else
            return rank(hi) - rank(lo);
    }
    Iterable<Key> keys() {
        return keys(min(), max());
    }
    //----------------------------------------------//
    public static void main(String[] args)
    {
        //
    }
}
