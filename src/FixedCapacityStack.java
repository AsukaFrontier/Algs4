public class FixedCapacityStack<Item> {
    /**
     * FixedCapacityStack(int cap)
     * void push(Item item)
     * Item pop()
     * boolean isEmpty()
     * int size()
     */
    private Item[] a;
    private int N;
    public FixedCapacityStack(int cap)
    {
        a=(Item[]) new Object[cap];
    }
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
        Item item= a[--N];
        a[N]=null;
        if(N>0&&N==a.length/4)
            resize(a.length/2);
        return item;
    }
    private void resize(int max)
    {
        Item[] temp= (Item[]) new Object[max];
        for(int i=0;i<N;i++)
        {
            temp[i]=a[i];
        }
        a=temp;
    }
}
