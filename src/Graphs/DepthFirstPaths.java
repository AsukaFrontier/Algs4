package Graphs;
import Fundamentals.Stack;
/**
 * private boolean[] marked;
 * private int[] edgeTo;
 * private final int s;
 *
 * public DepthFirstPaths(Graph G, int s)
 * private void dfs(Graph G, int v)
 * public boolean hasPathTo(int v)
 * public Iterable<Integer> pathTo(int v)
 */
public class DepthFirstPaths {
    private boolean[] marked;//这个顶点上调用过dfs()了吗?
    private int[] edgeTo;//从起点到一个顶点的已知路径上的最后一个顶点；
    // 如果存在路径v-w, 则edgeTo[w]==v;
    //path: v-w-x; edgeTo[w]=v,edgeTo[x]=w;
    private final int s;//起点

    public DepthFirstPaths(Graph G, int s)//构造函数
    {
        marked= new boolean[G.V()];
        edgeTo= new int[G.V()];
        this.s=s;
        dfs(G,s);
    }
    private void dfs(Graph G, int v)
    {
        marked[v]=true;
        for(int w: G.adj(v))
            if(!marked[w])
            {
                edgeTo[w]=v;//
                dfs(G, w);
            }
    }
    public boolean hasPathTo(int v)//是否存在从s到v的路径
    {
        return marked[v];//如果v被访问过，则肯定存在从s到v的路径；
    }
    public Iterable<Integer> pathTo(int v)//s到v的路径，如果不存在则返回null
    {
        if(!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<>();//把倒序的路径压入栈中，则可返回正序的路径；
        for(int x=v;x!=s;x=edgeTo[v])
            path.push(x);
        path.push(s);
        return path;
    }
}
