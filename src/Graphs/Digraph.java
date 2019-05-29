package Graphs;
//Directed Graph
import Fundamentals.Bag;
/**
 * private final int V;
 * private int E;
 * private Bag<Integer>[]adj;
 * public Digraph(int V)
 * public Digraph(int[] a)
 * public int V()
 * public int E()
 * public void addEdge(int v, int w)
 * public Iterable<Integer> adjacent(int v)
 * public Digraph reverse()
 * public String toString()
 */
public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V)
    {
        this.V=V;
        this.E=0;
        adj=(Bag<Integer>[]) new Bag[V];
        for(int v=0;v<V;v++)
            adj[v]=new Bag<Integer>();
    }
    public Digraph(int[] a)
    {
        this(a[0]);
        this.E=a[1];
        //for(int i=2;i<2*E+2;i=i+2)
        for(int i=2;i<a.length;i=i+2)
        {
            int v=a[i];
            int w=a[i+1];
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
        E++;
    }
    public Iterable<Integer> adjacent(int v)
    {
        return adj[v];
    }
    public Digraph reverse()
    {
        Digraph R= new Digraph(V);
        for(int v=0;v<V;v++)
            for(int w: adjacent(v))
                R.addEdge(w,v);
        return R;
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
}
