package Graphs;
import Fundamentals.Bag;
import edu.princeton.cs.algs4.In;
/**
 * private final int V;
 * private int E;
 * private Bag<Integer>[] adj;
 *
 * public Graph(int V)
 * public Graph(In in)
 * public void addEdge(int v, int w)
 * public int V()
 * public int E()
 * public Iterable<Integer> adj(int v)
 * public String toString()
 */
public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V)//构造函数
    {
        this.V=V;
        this.E=0;
        adj=(Bag<Integer>[]) new Bag[V];
        for(int v=0;v<V;v++)
            adj[v]=new Bag<Integer>();
    }
    public Graph(In in)//构造函数
    {
        this(in.readInt());//在实例程序中: Graph graph = new Graph(new In(args[0]));
        int E=in.readInt();
        for(int i=0;i<E;i++)
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
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }
    public String toString()
    {
        //
        String s= V+" vertices, "+E+" edges\n";
        for(int v=0;v<V;v++)
        {
            s=s+v+": ";
            for(int w: this.adj(v))//this, 指调用toString()的Graph类的某个对象;
                s=s+w+" ";
            s=s+"\n";
        }
        return s;
    }
}
