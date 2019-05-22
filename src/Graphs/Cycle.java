package Graphs;

/**
 * private boolean[] marked;
 * private boolean hasCycle;
 * public Cycle(Graph G)
 * private void dfs(Graph G, int v, int u)
 * public boolean hasCycle()
 */
public class Cycle //G是无环图吗？假设不存在自环或平行边
{
    private boolean[] marked;
    private boolean hasCycle;
    public Cycle(Graph G)
    {
        marked = new boolean[G.V()];
        for(int s=0;s<G.V();s++)
            if(!marked[s])
                dfs(G,s,s);
    }
    private void dfs(Graph G, int v, int u)
    {
        marked[v]=true;
        for(int w: G.adjacent(v))
            if(!marked[w])
                dfs(G,w,v);
            else if(w!=u)
                hasCycle=true;
    }
    public boolean hasCycle()
    {
        return hasCycle;
    }
}
