package DirectedGraphs;
import Fundamentals.Bag;
import edu.princeton.cs.algs4.In;
/**
 * private final int V;
 * private int E;
 * private Bag<Intger>[] adj;
 *
 * public Digraph(int V)
 * public Digraph(In in)
 * public int V()
 * public int E()
 * public void addEdge(nt v, int w)
 * public Iterable<Integer> adj(int v)
 * public String toString()
 * public Digraph reverse()
 */
public class Digraph //有向图: Directed Graph
{
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V)//创建一幅含有V个顶点、没有边的有向图
    {
        this.V=V;
        this.E=0;
        adj= (Bag<Integer>[]) new Bag[V];
        for(int v=0;v<V;v++)
            adj[v]= new Bag<Integer>();
    }
    public Digraph(In in)//构造函数
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
    public void addEdge(int v, int w)//v->w
    {
        adj[v].add(w);
        E++;
    }
    public Iterable<Integer> adj(int v)//由v指出的边所连接的所有顶点
    {
        return adj[v];
    }
    public String toString()
    {
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
    public Digraph reverse()//该图的反向图
    {
        Digraph R= new Digraph(V);
        for(int v=0;v<V;v++)
            for(int w: adj[v])
                R.addEdge(w,v);//把 v->w reverse 为 w->v
        return R;
    }

}
