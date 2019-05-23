package Fundamentals;
/**
 * private Item[] a;
 * private int N;
 *
 * public FixedCapacityStack(int cap)
 * public void push(Item item)
 * public Item pop()
 * public boolean isEmpty()
 * public int size()
 *
 * private void resize(int max)
 */
public class FixedCapacityStack<Item> {
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
        Item item= a[--N];//此时，a[N]仍然能够索引到Item元素；
        a[N]=null;
        if(N>0&&N==a.length/4)
            resize(a.length/2);
        return item;
    }
    private void resize(int max)
    {
        Item[] temp;
        temp = (Item[]) new Object[max];
        for(int i=0;i<N;i++)
        {
            temp[i]=a[i];
        }
        a=temp;
    }
}
