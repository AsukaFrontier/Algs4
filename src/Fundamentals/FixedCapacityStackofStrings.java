package Fundamentals;
/**
 * private String[] a;
 * private int N;
 * public FixedCapacityStackofStrings(int cap)
 * public void push(String item)
 * public String pop()
 * public boolean isEmpty()
 * public int size()
 */
public class FixedCapacityStackofStrings {
    private String[] a;
    private int N;

    public FixedCapacityStackofStrings(int cap)
    {
        a=new String[cap];
    }
    public void push(String item)
    {
        a[N]=item;
        N++;
    }
    public String pop()
    {
        --N;
        return a[N];
    }
    public boolean isEmpty()
    {
        return N==0;
    }
    public int size()
    {
        return N;
    }
}
