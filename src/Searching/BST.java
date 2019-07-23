package Searching;
import java.util.ArrayList;
public class BST<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> //
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
    public Key floor(Key key) //查找<=key的max
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
            else //cmp>0: 1, 若右子树中的最小的节点都比key大, 则当前根结点就是所求值; 否则(若右子树中的最小结点仍比key小), 在右子树中继续floor();
            {
                Node temp= min(x.right);
                if(temp.key.compareTo(key)>0)
                    return x;
                else
                    return floor(x.right, key);
                /**
                 * //另一种写法
                 * Node t= floor(x.right, key);
                 * if(t!=null)
                 *     return t;
                 * else
                 *     return x;
                 */
            }
    }
    public Key ceiling(Key key) //>=key的min
    {
        Node x= ceiling(root, key);
        if(x==null)
            return null;
        else
            return x.key;
    }
    private Node ceiling(Node x, Key key)
    {
        int cmp= key.compareTo(x.key);
        if(cmp==0)
            return x;
        else
            if(cmp>0) //key>x.key
                return ceiling(x.right, key);
            else //cmp<0: key<x.key
            {
                Node temp= max(x.left);
                if(key.compareTo(temp.key)<0)
                    return ceiling(x.left, key);
                else
                    return x;
            }
    }
    public int rank(Key key)
    {
        return rank(root, key);
    }
    private int rank(Node x, Key key)
    {
        if(x==null)
            return 0;
        int cmp= key.compareTo(x.key);
        if(cmp==0) //当前根结点即为待rank的结点键
            return size(x.left);
        else
            if(cmp<0) //key在左子树中
                return rank(x.left, key);
            else //cmp>0
                return (size(x.left)+1)+ rank(x.right, key);
    }
    public Key select(int k)
    {
        return select(root, k);
    }
    private Key select(Node x, int k)
    {
        if(x==null)
            return null;
        int t= size(x.left); //左子树中节点数量
        if(t==k)
            return x.key;
        else
            if(t>k) //左子树中节点数量大于k
                return select(x.left, k);
            else //t<k
                return select(x.right, k-(t+1));
    }
    @Override
    public void deleteMin()
    {
        root= deleteMin(root);
        return ;
    }
    private Node deleteMin(Node x)
    {
        if(x.left==null) //最终调用过程
            return x.right;
        //调用过程: 只要该节点左子树不为空, 则应递归调用其左子树的deleteMin();
        x.left= deleteMin(x.left);
        x.N= size(x.left)+size(x.right)+1; //or: x.N--;
        return x;
    }
    @Override
    public void deleteMax()
    {
        root= deleteMax(root);
        return ;
    }
    private Node deleteMax(Node x)
    {
        if(x.right==null)
            return x.left;
        x.right= deleteMax(x.right);
        x.N--;
        return x;
    }
    @Override
    public void delete(Key key)
    {
        root= delete(root, key);
        return ;
    }
    private Node delete(Node x, Key key)
    {
        //找到该节点并删除该节点||在二叉树中并不存在该节点, 则不用再进行删除操作;
        if(x==null) //若已经到达叶子节点的两条子链接, 且仍未找到该key时, 则在二叉树中不存在该节点, 递归结束;
            return null;
        int cmp= key.compareTo(x.key);
        if(cmp<0)
            return delete(x.left, key);
        else
            if(cmp>0)
                return delete(x.right, key);
            else //cmp==0: 找到待删除的结点
            {
                Node toBeDeleted= x; //待删除的结点
                if(x.right==null) //x.left==null也不影响后续操作
                    return x.left; //若待删除结点的右子树为空, 则删除该节点后需要把该节点的左子树返回给待删除结点的父节点;
                //x仍指向着待删除结点所对应的位置;
                x= min(x.right);//待删除结点的右子树中的最小节点: 后继节点; 将后继节点替代待删除结点;
                x.left= toBeDeleted.left;
                x.right= deleteMin(toBeDeleted.right);
            }
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }
    @Override
    public Iterable<Key> keys(Key lo, Key hi)
    {
        ArrayList<Key> aList= new ArrayList<>();
        keys(root, aList, lo, hi);
        return aList;
    }
    private void keys(Node x, ArrayList aList, Key lo, Key hi)
    {   //中序遍历: 先遍历左子树, 再访问根结点, 再遍历右子树
        if(x==null)
            return ;
        int cmplo= lo.compareTo(x.key);
        int cmphi= hi.compareTo(x.key);
        //先查找根结点的左子树
        if(cmplo<0) //若lo<x.key: 区间的最小值在该节点的左子树中
            keys(x.left, aList, lo, hi);
        //再查找根结点
        if(cmplo<=0&&cmphi>=0)// lo<=x.key&&hi>=x.key等价于x.key>=lo&&x.key<=hi
            aList.add(x.key);
        //再查找根结点的右子树
        if(cmphi>0)
            keys(x.right, aList, lo, hi);
    }
    /**
     * //一般形式的中序遍历
     * private void visit(Node x)
     * {
     *     if(x==null)
     *         return ;
     *     visit(x.left);
     *     System.out.println(x.key);
     *     visit(x.right);
     * }
     */
}
