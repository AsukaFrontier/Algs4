package Graphs;
import Fundamentals.Bag;
import edu.princeton.cs.algs4.In;
/**
 * private int V;
 * private int E;
 * private Bag<Integer>[] adj;
 *
 * public Graph(int V)
 * public Graph(int[] a)
 * public int V()
 * public int E()
 * public void addEdge(int v, int w)
 * public Iterable<Integer>adjacent(int v)
 * public String toString()
 */
public class Graph {
    private final int V;//顶点数目
    private int E;//边的数目
    private Bag<Integer>[] adj;//adj是一个数组，数组中的每个元素是一个Bag<Integer>：包集合，每个集合的元素是一个Integer类；

    public Graph(int V)
    //创建一个含有V个顶点但不含有边的图；
    //给出一个int，表示图的结点数，并将邻接表初始化；
    {
        this.V=V;
        this.E=0;
        adj=(Bag<Integer>[]) new Object[V];//adj指向一个数组,
        for(int v=0;v<V;v++)
            adj[v]=new Bag<Integer>();//adj[]的每个元素，指向一个Bag链表；
    }
    public Graph(int[] a)
    {
        this(a[0]);
        this.E=a[1];
        for(int i=2;i<a.length;i=i+2)
        {
            int v=a[i];
            int w=a[i+1];
            addEdge(v,w);
        }
    }
    public Graph(In in)
    {
        this(in.readInt());
        int E= in.readInt();
        for(int i=0;i<E;i++)//
        {
            int v=in.readInt();
            int w=in.readInt();
            addEdge(v,w);
        }
    }
    public int V()
    {
        return V;
    }
    public int E()
    {
        return E;
    }
    public void addEdge(int v,int w)//v-w
    {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adjacent(int v)//和v相连的所有顶点
    {
        return adj[v];
    }
    public String toString()//对象的字符串表示
    {
        String s= V+" vertex/vertices, "+E+" edge/edges.\n";
        for(int v=0;v<V;v++)
        {
            s=s+v+": ";
            for(int w: this.adjacent(v))
                s=s+w+" ";
            s=s+"\n";
        }
        return s;
    }
}
