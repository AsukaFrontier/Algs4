package Graphs;
import Fundamentals.Bag;
/**
 * private int V;
 * private int E;
 * private Bag<Integer>[] adj;
 * public Graph(int V)
 * public int V()
 * public int E()
 * public void addEdge(int v, int w)
 * public Iterable<Integer>adj(int v)
 * public String toString()
 * **
 * public static int degree(Graphs G, int V)
 * public static int maxDegree(Graphs G)
 * public static double avgDegree(Graphs G)
 * public static int numberOfSelfLoops(Graphs G)
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
    public Iterable<Integer> adjacent(int v)//和v相连的所有顶点
    {
        return adj[v];
    }
    public String toString()
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
    //Graph Processing
    public static int degree(Graph G, int v)
    {
        int degree=0;
        for(int w:G.adjacent(v))
            degree++;
        return degree;
    }
    public static int maxDegree(Graph G)
    {
        int max=0;
        for(int v=0;v<G.V();v++)
            if(degree(G,v)>max)
                max=degree(G,v);
        return max;
    }
    public static double avgDegree(Graph G)
    {
        return 2*G.E()/G.V();
    }
    public static int numberOfSelfLoops(Graph G)//计算自环的个数
    {
        int count=0;
        for(int v=0;v<G.V();v++)
            for(int w:G.adjacent(v))
                if(v==w)
                    count++;
        return count;
    }
    //--------------UNIT TEST--------------//
    public static void main(String[] args)
    {
        int[] tinyG_txt={13,13,
                0,5,4,3,0,1,9,12,6,4,5,4,0,2,11,12,9,10,0,6,7,8,9,11,5,3};

    }
}
