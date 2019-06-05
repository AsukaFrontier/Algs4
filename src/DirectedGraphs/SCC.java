package DirectedGraphs;
/**
 * private boolean[] marked; //已访问过的顶点
 * private int[] id; //强连通分量的标识符
 * private int count; //强连通分量的数量
 * public SCC(Digraph G)
 * private void dfs(Digraph G, int v)
 * public boolean stronglyConnected(int v, int w)
 * public int id(int v)
 * public int count()
 */
public class SCC
//强连通分量
//Strongly Connected Components
//KosarajuCC
{
    private boolean[] marked; //已访问过的顶点
    private int[] id; //强连通分量的标识符
    private int count; //强连通分量的数量
    public SCC(Digraph G)
    {
        marked= new boolean[G.V()];
        id= new int[G.V()];
        DepthFirstOrder order= new DepthFirstOrder(G.reverse()); //有向图的反向图
        for(int s: order.reversePost()) //反向图的逆后序序列
            if(!marked[s])
            {
                dfs(G,s);
                count++;
            }
    }
    private void dfs(Digraph G, int v)
    {
        marked[v]= true;
        id[v]= count;
        for(int w: G.adj(v))
            if(!marked[w])
                dfs(G,w);
    }
    public boolean stronglyConnected(int v, int w)
    {
        return id[v]== id[w];
    }
    public int id(int v)
    {
        return id[v];
    }
    public int count()
    {
        return count;
    }
}
