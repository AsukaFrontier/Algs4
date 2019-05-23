package Fundamentals;
/**
 * private Node first;
 * private int N;
 *
 * public void push(Item item)
 * public Item pop()
 * public boolean isEmpty()
 * public int size()
 * public Iterator<Item> iterator()
 * private class Node{}
 * private class ListIterator implements Iterator<Item>{}
 */
import java.util.Iterator;
public class Stack<Item> implements Iterable<Item> {

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
    public void push(Item item)
    {
        Node newfirst= new Node();
        newfirst.item=item;
        newfirst.next=first;
        first=newfirst;
        N++;
    }
    public Item pop()
    {
        Item temp= first.item;
        first.item=null;
        first=first.next;
        N--;
        return temp;
    }
    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>
    {
        private Node current =first;
        public boolean hasNext()
        {
            return current != null;
        }
        public void remove()
        {
            //
        }
        public Item next()
        {
            Item item=current.item;
            current= current.next;
            return item;
        }
    }
    //----------UNIT TEST-------------------//
    public static void main(String[] args)
    {
        //
    }
}
