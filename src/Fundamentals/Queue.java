package Fundamentals;

import java.util.Iterator;
public class Queue<Item> implements Iterable<Item> {
    /**
     * public:
     * void enqueue(Item item)
     * Item dequeue()
     * boolean isEmpty()
     * int size()
     * Iterator<Item> iterator()
     * private:
     * class Node
     * class ListIterator implements Iterator<Item>
     */
    private Node first;
    private Node last;
    private int N;
    private class Node
    {
        Node next;
        Item item;
    }
    public boolean isEmpty()
    {
        return first==null;
    }
    public int size()
    {
        return N;
    }
    public void enqueue(Item item)
    {
        Node newLast= new Node();
        newLast.item=item;
        newLast.next=null;
        if(isEmpty())
            first=newLast;
        else
        {
            last.next=newLast;
            last=newLast;
        }
        N++;
    }
    public Item dequeue()
    {
        Item temp=first.item;
        first=first.next;
        if(isEmpty())
            last=null;
        N--;
        return temp;
    }
    //Iterator Implementation
    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>
    {
        private Node current=first;
        public boolean hasNext()
        {
            return current.next!=null;
        }
        public Item next()
        {
            Item item= current.item;
            current=current.next;
            return item;
        }
        public void remove()
        {
            //
        }
    }
    public static void main(String[] args)
    {
        //Test of Fundamentals.Queue
        Queue<Integer> queue_ints= new Queue<Integer>();
        queue_ints.enqueue(2);
        queue_ints.enqueue(1);
        queue_ints.enqueue(0);
        System.out.println(queue_ints.dequeue());
        System.out.println(queue_ints.size());
    }
}
