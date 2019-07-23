package Searching;
public class SequentialSearchUnorderedST<Key, Value> implements UnorderedST<Key, Value> //
{
    //一般符号表接口的无序链表实现，效率较低;
    //该实现，当删除部分链表的值时，仍会使得部分链表的结点存在，占用内存空间;
    private class Node
    {
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next)
        {
            this.key=key;
            this.val=val;
            this.next=next;
        }
    }
    private Node first;
    //with a default constructor
    public void put(Key key, Value val)
    {
        //查找给定的键，找到则更新其值，否则在表中新建结点
        for(Node x=first;x!=null;x=x.next)
            if(key.equals(x.key)) //命中，更新该值
            {
                x.val=val;
                return ;//结束put()方法的执行
            }
        first= new Node(key, val, first); //未命中，(在链表首部)新建并插入该值
    }
    public Value get(Key key)
    {
        for(Node x= first; x!=null;x=x.next)
            if(key.equals(x.key))
                return x.val;
            else //继续循环，查找下一个结点的元素
                continue;
        return null;
    }
    public int size()
    {
        int nodeCount= 0;
        for(Node x= first; x!=null;x=x.next)
            nodeCount++;
        return nodeCount;
    }
}
