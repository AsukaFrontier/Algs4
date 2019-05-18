package Search;
import Fundamentals.Queue;
/**
 * private Node root;
 * private class Node{
 *     private Key key;
 *     private Value val;
 *     private Node left,right;
 *     private int N;
 *     public Node(Key key, Value val, int N){}
 * }
 * public int size()
 * **private int size(Node x)
 * public Value get(Key key)
 * **private Value get(Node x, Key key)
 * public void put(Key key, Value val)
 * **private Node put(Node x, Key key, Value val)
 * public Key max()
 * **private Node max(Node x)
 * public Key min()
 * **private Key min(Node x)
 * public Key floor(Key key)
 * **private Node floor(Node x, Key key)
 * public Key ceiling(Key key)
 * **private Node ceiling(Node x, Key key)
 * public Key select(int k)
 * **private Node select(Node x,int k)
 * public int rank(Key key)
 * **private int rank(Key key, Node x)
 * public void delete(Key key)
 * **private Node delete(Node x,Key key)
 * public void deleteMin()
 * **private Node deleteMin(Node x)
 * public void deleteMax()
 * **private void deleteMax(Node x)
 * public Iterable<Key> keys()
 * public Iterable<Key> keys(Key lo, Key hi)
 * **private void keys(Node x, Queue<Key> queue, Key lo, Key hi)
 */
public class BST<Key extends Comparable<Key>,Value> {
    private Node root;
    private class Node
    {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;
        public Node(Key key, Value val,int N)
        {
            this.key=key;
            this.val=val;
            this.N=N;
        }
    }
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
    //
    public Value get(Key key)
    {
        return get(root,key);
    }
    private Value get(Node x, Key key)
    {
        if(x==null)
            return null;
        int cmp=key.compareTo(x.key);
        if(cmp<0)//待查找的key<当前结点的key
            return get(x.left,key);
        else if(cmp==0)//待查找的key==当前结点的key
            return x.val;
        else
            return get(x.right,key);//cmp>0
    }
    //
    public void put(Key key, Value val)
    {
        root=put(root,key,val);
    }
    private Node put(Node x, Key key, Value val)
    {
        if(x==null)
            return new Node(key,val,1);
        int cmp=key.compareTo(x.key);
        if(cmp<0)
            x.left=put(x.left,key,val);
        else if(cmp>0)
            x.right=put(x.right,key,val);
        else
            x.val=val;
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }
    //
    public Key min()
    {
        return min(root).key;
    }
    private Node min(Node x)
    {
        if(x.left==null)
            return x;
        return min(x.left);
    }
    //
    public Key max()
    {
        return max(root).key;
    }
    private Node max(Node x)
    {
        if(x.right==null)
            return x;
        return max(x.right);
    }
    //
    public Key floor(Key key)//求<=某键的最大键；
    {
        Node x=floor(root,key);
        if(x==null)
            return null;
        return x.key;
    }
    private Node floor(Node x, Key key)
    {
        if(x==null)
            return null;
        int cmp=key.compareTo(x.key);
        if(cmp==0)
            return x;
        if(cmp<0)//key比当前键小，从当前键的左子树递归floor()
            return floor(x.left,key);
        Node t=floor(x.right,key);//key比当前键大，从当前键的右子树递归floor()
        if(t!=null)//如果在右子树中找到
            return t;
        else
            return x;
    }
    //
    public Key ceiling(Key key)//求>=某键的最小键
    {
        Node x=ceiling(root, key);
        if(x==null)
            return null;
        return x.key;
    }
    private Node ceiling(Node x, Key key)
    {
        if(x==null)
            return null;
        int cmp=key.compareTo(x.key);
        if(cmp==0)
            return x;
        if(cmp>0)
            return ceiling(x.right,key);
        Node t=ceiling(x.left,key);
        if(t!=null)
            return t;
        else
            return x;
    }
    //
    public Key select(int k)
    {
        return select(root, k).key;
    }
    private Node select(Node x,int k)
    {
        if(x==null)
            return null;
        int t=size(x.left);
        if(t==k)
            return x;
        else if(t>k)
            return select(x.left,k);
        else//if(t<k)
            return select(x.right,k-1-t);
    }
    //
    public int rank(Key key)
    {
        return rank(key,root);
    }
    private int rank(Key key, Node x)
    {
        if(x==null)
            return 0;
        int cmp=key.compareTo(x.key);
        if(cmp==0)
            return size(x.left);
        else if(cmp<0)
            return rank(key,x.left);
        else
            return size(x.left)+1+rank(key,x.right);
    }
    //
    public void deleteMin()
    {
        root=deleteMin(root);
    }
    private Node deleteMin(Node x)
    {
        if(x.left==null)
            return x.right;//删除x结点，把x结点的右子树作为返回值
        //if(x.left!=null)
        x.left=deleteMin(x.left);
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }
    //
    public void deleteMax()
    {
        root=deleteMax(root);
    }
    public Node deleteMax(Node x)
    {
        if(x.right==null)
            return x.left;
        //if(x.right!=null)
        x.right=deleteMax(x.right);
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }
    //
    public void delete(Key key)
    {
        root=delete(root,key);
    }
    private Node delete(Node x, Key key)
    {
        if(x==null)
            return null;
        int cmp=key.compareTo(x.key);
        if(cmp<0)
            x.left=delete(x.left,key);
        else if(cmp>0)
            x.right=delete(x.right,key);
        else
        {
            if(x.right==null)
                return x.left;
            if(x.left==null)
                return x.right;
            //该结点存在两个结点的情况
            Node t=x;
            x=min(x.right);
            x.right=deleteMin(x.right);
            x.left=t.left;
        }
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }
    //
    public Iterable<Key> keys()
    {
        return keys(min(),max());
    }
    public Iterable<Key> keys(Key lo, Key hi)
    {
        Queue<Key> queue =new Queue<Key>();
        keys(root,queue,lo,hi);
        return queue;
    }
    private void keys(Node x. Queue<Key> queue, Key lo, Key hi)
    {
        if(x==null)
            return ;
        int cmplo=lo.compareTo(x.key);
        int cmphi=lo.compareTo(x.key);
        if(cmplo<0)
            keys(x.left,queue,lo,hi);
        if(cmplo<=0&&cmphi>=0)
            queue.enqueue(x.key);
        if(cmphi>0)
            keys(x.right.queue,lo,hi);
    }
    /**
    private void printTree(Node x)//中序遍历
    {
        if(x==null)
            return;
        printTree(x.left);
        System.out.print(x.key+" ");
        printTree(x.right);
    }
     */
}
