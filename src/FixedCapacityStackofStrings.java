public class FixedCapacityStackofStrings {
    /**
     * FixedCapacityStackofStrings(int cap)
     * void push(String item)
     * String pop()
     * boolean isEmpty()
     * int size()
     */
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

    public static void main(String[] args)
    {
        //
    }
}
