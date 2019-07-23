package Searching;
public class RedBlackBinarySearchTree<Key extends Comparable<Key>, Value>
{
    private static final boolean RED= true;
    private static final boolean BLACK= false;
    private class Node
    {
        Key key;
        Value val;
        Node left;
        Node right;
        int N;
        boolean color;
        Node(Key key, Value val, int N, boolean color)
        {
            this.key= key;
            this.val= val;
            this.N= N;
            this.color= color;
            //By default: left=null, right= null;
        }
    }
    private Node root;
    public int size()
    {
        return size(root);
    }
    private int size(Node x)
    {
        if(x==null)
            return 0;
        return x.N;
    }
    public void put(Key key, Value val)
    {
        root= put(root, key, val);
        root.color= BLACK;
    }
    private Node put(Node h, Key key, Value val)
    {
        if(h==null)
            return new Node(key, val, 1, RED);
        int cmp= key.compareTo(h.key);
        if(cmp<0)
            h.left= put(h.left, key, val);
        else
            if(cmp>0)
                h.right= put(h.right, key, val);
            else
                h.val= val;
        //
        if((!isRed(h.left))&&isRed(h.right))
            h=rotateLeft(h);
        if(isRed(h.left)&&isRed(h.left.left))
            h=rotateRight(h);
        if(isRed(h.left)&&isRed(h.right))
            flipColors(h);
        h.N= size(h.left)+size(h.right)+1;
        return h;
    }
    //
    private boolean isRed(Node x) //指向该节点的链接(从它的父结点指向它)是红链接还是黑链接?
    {
        if(x==null)
            return false; //空链接默认为黑链接
        return x.color==RED; //在创建该节点的时候指定(指向该节点的链接)其颜色
    }
    private Node rotateLeft(Node h)
    {
        Node x= h.right;
        h.right= x.left;
        x.left=h;
        x.color= h.color;
        h.color= RED;
        x.N= h.N;
        h.N= size(h.left)+size(h.right)+1;
        return x;
    }
    private Node rotateRight(Node h)
    {
        Node x= h.left;
        h.left= x.right;
        x.right= h;
        x.color= h.color;
        h.color= RED;
        x.N= h.N;
        h.N= size(h.left)+size(h.right)+1;
        return x;
    }
    private void flipColors(Node h)
    {
        h.color= RED; //
        h.left.color=BLACK;
        h.right.color=BLACK;
    }
}
