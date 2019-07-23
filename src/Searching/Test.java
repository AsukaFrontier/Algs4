package Searching;
public class Test<Key extends Comparable<Key>, Value> //
{
    private Key[] keys;
    private Value[] vals;
    public Test(int arrayCapacity)
    {
        //Java创建数组的原理: Java不支持创建泛型数组, 创建数组时, 数组的类型必须是确定的;
        //在new一个数组时并未为该数组分配内存空间
        keys= (Key[]) new Comparable[arrayCapacity];
        vals= (Value[]) new Object[arrayCapacity];
    }
}