package Fundamentals;
/**
 * private final String name;
 * private int count;
 * Counter(String id)
 * void increment()
 * int tally()
 * String toString()
 */
public class Counter {
    private final String name;
    private int count;

    public Counter(String id)
    {
        name=id;
    }
    public void increment()
    {
        count++;
    }
    public int tally()//该对象创建之后计数器被加1的次数；
    {
        return count;
    }
    public String toString()
    {
        return count+" "+name;
    }
    //----------UNIT TEST---------------------//
    public static void main(String[] args)
    {
        Counter heads= new Counter("heads");
        Counter tails= new Counter("tails");
        heads.increment();
        tails.increment();
        System.out.println(heads+" "+tails);
        System.out.println(heads.tally()+tails.tally());
    }
}
