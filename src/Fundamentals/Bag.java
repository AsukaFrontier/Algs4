package Fundamentals;
import java.util.Iterator;
/**
 * private Node first;
 * private int N;
 * private class Node{}
 *
 * boolean isEmpty()
 * int size()
 * public void add(Item item)
 * public Iterator<Item> iterator()
 * private class ListIterator implements Iterator<Item>{}
 */
public class Bag<Item> implements Iterable<Item>
{
    private Node first;
    private int N;
    private class Node
    {
        Item item;
        Node next;
    }
    public boolean isEmpty()
    {
        return first==null;
    }
    public int size()
    {
        return N;
    }
    public void add(Item item)
    {
        Node oldfirst= first;
        first=new Node();
        first.item=item;
        first.next=oldfirst;//在链表的前端插入新元素；
        N++;
    }
    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>
    {
        private Node current= first;
        public boolean hasNext()
        {
            return current!=null;
        }
        public void remove()
        {
            //
        }
        public Item next()
        {
            Item item=current.item;
            current=current.next;
            return item;
        }
    }
}
