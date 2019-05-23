package Fundamentals;
/**
 * private final String name;
 * private int count;
 *
 * public Counter(String id)
 * public void increment()
 * public int tally()//计数器的值
 * public String toString()
 */
public class Counter {
    //实例变量的声明；
    private final String name;
    private int count;
    //构造函数；
    public Counter(String id)
    {
        name=id;
    }
    //实例方法
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
    //测试用例；
    //----------UNIT TEST---------------------//
    public static void main(String[] args)
    {
        //创建并初始化类的对象；
        Counter heads= new Counter("heads");
        Counter tails= new Counter("tails");
        //调用实例方法
        heads.increment();
        tails.increment();
        System.out.println(heads+", "+tails);
        System.out.println(heads.tally()+tails.tally());
    }
}
