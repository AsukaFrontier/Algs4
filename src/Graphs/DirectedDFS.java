package Graphs;

/**
 * private boolean[] marked;
 * public DirectedDFS(Digraph G, int s)
 * public DirectedDFS(Digraph G, Iterable<Integer> sources)
 * private void dfs(digraph G, int v)
 * public boolean marked(int v)
 */
public class DirectedDFS
{
    //
    private boolean[] marked;
    public DirectedDFS(Digraph G, int s)
    {
        marked=new boolean[G.V()];
        dfs(G,s);
    }
    public DirectedDFS(Digraph G, Iterable<Integer> sources)
    {
        //
        marked= new boolean[G.V()];
        for(int s: sources)
            if(!marked[s])
                dfs(G,s);
    }
    private void dfs(Digraph G, int v)
    {
        marked[v]=true;
        for(int w: G.adjacent(v))
            if(!marked[w])
                dfs(G,w);
    }
    public boolean marked(int v)
    {
        return marked[v];
    }
    //--------UNIT TEST-------//
}
