public class FixedCapacityQueueofStrings {
    /**
     * public:
     * FixedCapacityQueueofStrings(int cap)
     * void enqueue(String item)
     * String dequeue()
     * boolean isEmpty()
     * int size()
     */
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
    boolean isEmpty()
    {
        return (tail-head)==0;
    }
    public int size()
    {
        return tail-head;
    }
}
