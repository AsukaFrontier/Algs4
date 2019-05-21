package Graphs;
/**
 * private boolean[] marked;
 * private int count;
 * public DepthFirstSearch(Graph G, int s)
 * private void dfs(Graph G, int v)
 * public boolean marked(int w)
 * public int count()
 */
public class DepthFirstSearch {
    //
    private boolean[] marked;//声明
    private int count;//声明
    public DepthFirstSearch(Graph G, int s)//找到和起点s连通的所有顶点
    {
        marked=new boolean[G.V()];
        dfs(G,s);
    }
    private void dfs(Graph G, int v)
    {
        marked[v]=true;
        count++;
        for(int w: G.adjacent(v))
            if(!marked[w])
                dfs(G,w);
    }
    public boolean marked(int w)//v和s是连通的吗
    {
        return marked[w];
    }
    public int count()//与s连通的顶点总数
    {
        return count;
    }
}
