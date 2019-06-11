package MinimumSpanningTrees;
import Fundamentals.Bag;
import edu.princeton.cs.algs4.In;
public class EdgeWeightedGraph//加权无向图
{
    private final int V;
    private int E;
    private Bag<Edge>[] adj;//邻接表
    //adj是一个数组，数组中的每个元素是一个Bag<Edge>，Bag<>集合中的每个元素是Edge的对象;

    public EdgeWeightedGraph(int V)//构造函数，创建一幅含有V个顶点的空图
    {
        this.V=V;
        this.E=0;
        adj= (Bag<Edge>[])new Bag[V];
        for(int v=0;v<V;v++)
            adj[v]= new Bag<Edge>();
    }
    public EdgeWeightedGraph(In in)//从输入流中读取一个图
    {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            validateVertex(v);
            validateVertex(w);
            double weight = in.readDouble();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }
    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
    public int V()
    {
        return V;
    }
    public int E()
    {
        return E;
    }
    public void addEdge(Edge e)//向无向图中添加一条边e
    {
        int v= e.either();
        int w= e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
    public Iterable<Edge> adj(int v)//和v相关联的所有边
    {
        return adj[v];
    }
    public Iterable<Edge> edges()//返回加权无向图中的所有边
    {
        Bag<Edge> b= new Bag<Edge>();
        for(int v=0;v<V;v++)//图中共有V个顶点
            for(Edge e: adj[v])//顶点v的所有边
                if(e.other(v)>v)//如果顶点v的某条边的另一个顶点大于v（该边未出现过），将该边加入到Bag
                    b.add(e);
        return b;
    }
}
