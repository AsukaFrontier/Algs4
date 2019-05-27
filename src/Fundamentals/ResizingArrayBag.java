package Fundamentals;

import java.util.Iterator;

/**
 * private Item[] b;
 * private int n;
 * public boolean isEmpty()
 * public int size()
 * private void resize(int capacity)
 * public void add(Item item)
 * public Iterator<Item> iterator()
 * private class ArrayIterator implements Iterator<Item>{}
 *
 */
public class ResizingArrayBag<Item> {
    private Item[] b;
    private int n;

    public ResizingArrayBag()
    {
        b = (Item[]) new Object[1];
        n=0;
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
        Item[] temp= (Item[]) new Object[capacity];
        for(int i=0;i<n;i++)
        {
            temp[i]= b[i];
        }
        b=temp;
    }
    public void add(Item item)
    {
        b[n]=item;
        n++;
        if(n==b.length)
            resize(b.length*2);
    }
    public Iterator<Item> iterator()
    {
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<Item>
    {
        public int i=0;
        public boolean hasNext()
        {
            return i<n;
        }
        public Item next()
        {
            Item temp= b[i];
            i++;
            return temp;
        }
        public void remove()
        {
            //
        }
    }
}
