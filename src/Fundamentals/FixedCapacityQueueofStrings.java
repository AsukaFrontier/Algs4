package Fundamentals;
/**
 * private String[] q;
 * private int head;
 * private int tail;
 * public FixedCapacityQueueofStrings(int cap)
 * public void enqueue(String item)
 * public String dequeue()
 * public boolean isEmpty()
 * public int size()
 */
public class FixedCapacityQueueofStrings
{
    private String[] q;
    //private int N;
    private int head;
    private int tail;

    public FixedCapacityQueueofStrings(int cap)
    {
        q=new String[cap];
    }
    public void enqueue(String item)
    {
        q[tail]=item;
        tail++;
    }
    public String dequeue()
    {
        String temp= q[head];
        head++;
        return temp;
    }
    public boolean isEmpty()
    {
        return (tail-head)==0;
    }
    public int size()
    {
        return tail-head;
    }
}
