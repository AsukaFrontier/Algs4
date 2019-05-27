package Fundamentals;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * private Item[] q;
 * private int N;
 * private int first;
 * private int last;
 *
 * public boolean isEmpty()
 * public int size()
 * private void resize(int capacity)
 * public void enqueue(Item item)
 * public Item dequeue()
 * public Iterator<Item> iterator()
 * private class ArrayIterator implements Iterator<Item>{}
 */
public class ResizingArrayQueue<Item> implements Iterable<Item>{
    private Item[] q;//queue elements;
    private int n;//number of elements on queue;
    private int first;//index of first element of queue;
    private int last;//index of nex available slot;

    public ResizingArrayQueue()
    {
        q=(Item[]) new Object[2];
        n=0;
        first=0;
        last=0;
    }
    public boolean isEmpty()
    {
        return n==0;
    }
    public int size()
    {
        return n;
    }
    private void resize(int capacity)
    {
        assert capacity>=n;
        Item[] temp= (Item[])new Object[capacity];
        for(int i=0;i<n;i++)
        {
            temp[i]=q[(i+first)%q.length];
        }
        q=temp;
        first=0;
        last=n;
    }
    public void enqueue(Item item)
    {
        if(n==q.length)
            resize(2*q.length);
        q[last]=item;
        last++;
        if(last==q.length)
            last=0;
        n++;
    }
    public Item dequeue()
    {
        if(isEmpty())
            throw new NoSuchElementException();
        Item item= q[first];
        q[first]=null;
        n--;
        first++;
        if(first==q.length)
            first=0;
        if(n>0&&n==q.length/4)
            resize(q.length/2);
        return item;
    }
    public Iterator<Item> iterator()
    {
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<Item>
    {
        private int i=0;
        public boolean hasNext()
        {
            return i<n;
        }
        public Item next()
        {
            if(!hasNext())
                throw new NoSuchElementException();
            Item item= q[(i+first)%q.length];
            i++;
            return item;
        }
        public void remove()
        {
            //
        }
    }
}
