package Fundamentals;
/**
 * private Item[] a;
 * private int N=0;
 * public boolean isEmpty()
 * public int size()
 * public void push(Item item)
 * public Item pop()
 * public Iterator<Item> iterator()
 * private void resize(int max)
 * private class ReverseArrayIterator implements Iterator<Item>{}
 */
import java.util.Iterator;
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N=0;

    public boolean isEmpty()
    {
        return N==0;
    }
    public int size()
    {
        return N;
    }
    public void push(Item item)
    {
        if(N==a.length)
            resize(a.length*2);
        a[N]=item;
        N++;
    }
    public Item pop()
    {
        Item temp=a[--N];
        a[N]=null;
        if(N>0&&a.length/4==N)
        {
            resize(a.length/2);
        }
        return temp;
    }
    public Iterator<Item> iterator()
    {
        return new ReverseArrayIterator();
    }
    private void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        for(int i=0;i<a.length;i++)
        {
            temp[i]=a[i];
        }
        a=temp;
    }
    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int i=N;
        public boolean hasNext()
        {
            return i>0;
        }
        public Item next()
        {
            return a[--i];
        }
        public void remove()
        {
            //
        }
    }
    //----------UNIT TEST-------------------//
    public static void main(String[] args)
    {
        //Test of Fundamentals.ResizingArrayStack
        ResizingArrayStack<String> stack= new ResizingArrayStack<String>();
        stack.push("This");
        stack.push("is");
        stack.push("a");
        stack.push("test.");
        for(String s:stack)
            System.out.println(s);
        System.out.println(stack.pop());
        for(String s:stack)
            System.out.println(s);
    }
}
