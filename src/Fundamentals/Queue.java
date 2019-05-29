package Fundamentals;
/**
 * private Node first;
 * private Node last;
 * private int N;
 * private class Node{}
 *
 * public boolean isEmpty()
 * public void enqueue(Item item)
 * public Item dequeue()
 * public int size()
 * public Iterator<Item> iterator()
 * private class ListIterator implements Iterator<Item>{}
 */
import java.util.Iterator;
public class Queue<Item> implements Iterable<Item> {

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
    public void enqueue(Item item)//在链表表头插入结点；
    {
        Node newLast= new Node();
        newLast.item=item;
        newLast.next=null;
        if(isEmpty())
        {
            first=newLast;
            last=newLast;
        }
        else
        {
            last.next=newLast;
            last=newLast;
        }
        N++;
    }
    public Item dequeue()//在链表表尾删除节点
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
        private Node current=first;//记录链表的当前结点
        public boolean hasNext()//检测current是否为null；如果current!=null，则可以调用next()；
        {
            return current!=null;
        }
        public Item next()//保存当前元素的引用，将current变量指向链表中的下一个结点并返回所保存的引用；
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
    //----------UNIT TEST-------------------//
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
