package Graphs;
import Fundamentals.Bag;
/**
 * Graphs(int V)
 * int V()
 * int E()
 * void addEdge(int v, int w)
 * Iterable<Integer>adj(int v)
 * String toString()
 * **
 * public static int degree(Graphs G, int V)
 * public static int maxDegree(Graphs G)
 * public static double avgDegree(Graphs G)
 * public static int numberOfSelfLoops(Graphs G)
 */
public class Graph {
    private int V;//顶点数目
    private int E;//边的数目
    private Bag<Integer>[] adj;//adj是一个数组，数组中的每个元素是一个Bag<Integer>：包集合，每个集合的元素是一个Integer类；

    public Graph(int V)
    //创建一个含有V个顶点但不含有边的图；
    //给出一个int，表示图的结点数，并将邻接表初始化；
    {
        this.V=V;
        this.E=0;
        adj=(Bag<Integer>[]) new Bag[V];//泛型数组?
        for(int v=0;v<V;v++)
            adj[v]=new Bag<Integer>();
    }
    public int V()
    {
        return V;
    }
    public int E()
    {
        return E;
    }
    public void addEdge(int v,int w)//v -> w
    {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v)//和v相连的所有顶点
    {
        return adj[v];
    }
    public String toString()
    {
        String s= V+" vertex/vertices, "+E+" edge/edges.\n";
        for(int v=0;v<V;v++)
        {
            s=s+v+": ";
            for(int w: this.adj[v])
                s=s+w+" ";
            s=s+"\n";
        }
        return s;
    }
}
