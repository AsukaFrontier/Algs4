package Searching;
public class BST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> //
{
    //实现BinarySearchTree查找算法所需的数据结构: binary search tree(二叉查找树)
    private class Node
    {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int N; //以该节点为根的子树中的节点总数(包括该节点)
        public Node(Key key, Value val, int N) //a constructor of Node;
        {
            this.key= key;
            this.val= val;
            this.N= N;
            //by default, left=null, right=null;
        }
    }
    //类的实例域
    private Node root; //该类所创建的每一个实例对象都是一个树
    //类的实例方法
    public int size()
    {
        return size(root); //根节点的节点总数
    }
    private int size(Node x) //节点x所在的子树的节点总数
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
        {
            Node newSubTree= new Node(key, val, 1);// private int N: 以该节点为根的子树中的节点总数
            return newSubTree;
        }
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
        //递归结束的条件之一: 当前已访问到叶子节点, 未命中;
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
        if(min(root)==null)
            return null;
        else
            return min(root).key;
    }
    private Node min(Node x)
    {
        if(x==null)
            return null;
        if(x.left==null)
            return x;
        else
            return min(x.left);
    }
    public Key max()
    {
        if(max(root)==null)
            return null;
        else
            return max(root).key;
    }
    private Node max(Node x)
    {
        if(x==null)
            return null;
        if(x.right==null)
            return x;
        else
            return max(x.right);
    }
    public Key floor(Key key)
    {
        Node x= floor(root, key);
        if(x==null)
            return null;
        else
            return x.key;
    }
    private Node floor(Node x, Key key)
    {
        if(x==null)
            return null;
        int cmp= key.compareTo(x.key);
        if(cmp<0)
            return floor(x.left, key);
        else
            if(cmp==0)
                return x;
            else
            {
                Node temp= min(x.right);
                if(temp.key.compareTo(key)>0)
                    return x;
                else
                    return floor(x.right, key);
            }
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
