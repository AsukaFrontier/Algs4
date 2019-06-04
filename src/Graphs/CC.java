package Graphs;
//连通分量Connected Components
/**
 * private boolean[] marked;
 * private int[] id;
 * private int count;
 * public CC(Graph G)
 * private void dfs(Graph G, int v)
 * public boolean connected(int v, int w)//v和w连通吗
 * public int id(int v)//v所在的连通分量的标识符(0~count()-1)
 * public int count()//连通分量数
 */
public class CC {
    private boolean[] marked; //寻找一个顶点，作为每个连通分量中深度优先搜索的起点
    private int[] id; //以顶点作为索引，将同一个连通分量中的顶点和连通分量的标识符关联起来
    private int count; //连通分量数
    //0会赋值给第一个连通分量中的所有顶点
    //1会赋值给第二个连通分量中的所有顶点
    public CC(Graph G)
    {
        marked= new boolean[G.V()];
        id=new int[G.V()];
        for(int s=0; s<G.V();s++)
            if(!marked[s])
            {
                dfs(G,s);
                count++;
            }
    }
    private void dfs(Graph G, int v)
    {
        marked[v]= true;
        id[v]= count;
        for(int w: G.adj(v))
            if(!marked[w])
                dfs(G, w);
    }
    public boolean connected(int v, int w)
    {
        return id[v]==id[w];
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
