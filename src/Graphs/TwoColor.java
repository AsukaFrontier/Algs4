package Graphs;

/**
 * private boolean[] marked;
 * private boolean[] color;
 * private boolean isTwoColorable=true;
 * public TwoColor(Graph G)
 * private void dfs(Graph G, int v)
 * public boolean isBipartite()
 */
public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable= true;

    public TwoColor(Graph G)
    {
        marked=new boolean[G.V()];
        color=new boolean[G.V()];//By default, color[element]=false;
        for(int s=0;s<G.V();s++)
            if(!marked[s])
                dfs(G,s);
    }
    private void dfs(Graph G, int v)
    {
        marked[v]=true;
        for(int w: G.adjacent(v))
            if(!marked[w])
            {
                color[w]=!color[v];//color[w]=true;
                dfs(G,w);
            }
            else if(color[w]==color[v])
                isTwoColorable=false;
    }
    public boolean isBipartite()
    {
        return isTwoColorable;
    }
}
