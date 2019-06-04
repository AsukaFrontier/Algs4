package DirectedGraphs;

import Fundamentals.Bag;

/**
 * private final int V;
 * private int E;
 * private Bag<Intger>[] adj;
 *
 * public Digraph(int V)
 * public int V()
 * public int E()
 * public void addEdge(nt v, int w)
 * public Iterable<Integer> adj(int v)
 * public Digraph reverse()
 */
public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V)
    {
        this.V=V;
        this.E=0;
        adj= (Bag<Integer>[]) new Bag[V];
        for(int v=0;v<V;v++)
            adj[v]= new Bag<Integer>();
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
    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }
    public Digraph reverse()
    {
        Digraph R= new Digraph(V);
        for(int v=0;v<V;v++)
            for(int w: adj[v])
                R.addEdge(w,v);//把 v->w reverse 为 w->v
        return R;
    }
}
