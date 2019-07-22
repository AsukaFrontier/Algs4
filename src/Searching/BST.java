package Searching;

public class BST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> //
{
    private class Node
    {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int N; //以该节点为根的子树中的节点总数
        public Node(Key key, Value val, int N)
        {
            this.key= key;
            this.val= val;
            this.N= N;
            //by default, left=null, right=null;
        }
    }
    private Node root;
    //
    public int size()
    {
        return size(root);
    }
    private int size(Node x)
    {
        if(x==null)
            return 0;
        else
            return x.N;
    }
    public void put(Key key, Value val)
    {
        //查找key, 找到则更新其值, 找不到则为其创建一个新的树节点
        root= put(root, key, val);
        return ;
    }
    private Node put(Node x, Key key, Value val)
    {
        //终止递归的条件: 到达树的叶子节点后仍未找到key对应的节点, 则创建新节点;
        if(x==null) //该子树为空, 则在该处新建一个节点
            return new Node(key, val, 1);// private int N: 以该节点为根的子树中的节点总数
        //递归查找
        int cmp= key.compareTo(x.key);
        if(cmp==0) //命中
            x.val= val;
        else
            if(cmp<0)
                x.left= put(x.left, key, val);
            else //cmp>0
                x.right= put(x.right, key, val);
        x.N= size(x.left)+size(x.right)+1;
        return x;
    }
    public Value get(Key key)
    {
        return get(root, key);
    }
    private Value get(Node x, Key key) //recursive implementation;
    {
        if(x==null)
            return null;
        int cmp= key.compareTo(x.key);
        if(cmp==0)
            return x.val;
        else
            if(cmp<0)
                return get(x.left, key);
            else //cmp>0
                return get(x.right, key);
    }
    public Key min()
    {
        //
    }
    public Key max()
    {
        //
    }
    public Key floor(Key key)
    {
        //
    }
    public Key ceiling(Key key)
    {
        //
    }
    public int rank(Key key)
    {
        //
    }
    public Key select(int k)
    {
        //
    }
}
