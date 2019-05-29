package Graphs;
/**
 * private boolean[] marked;
 * private int count;
 *
 * public DepthFirstSearch(Graph G, int s)//找到和起点s连通的所有顶点
 * private void dfs(Graph G, int v)
 * public boolean marked(int w)           //v和s是连通的吗
 * public int count()                     //与s连通的顶点总数
 */
public class DepthFirstSearch {
    //给定一个连通图，起点s到其他所有顶点都是连通的，marked[]中的所有元素值都将为true;
    private boolean[] marked;//记录和起点连通的所有顶点；
    private int count;//
    public DepthFirstSearch(Graph G, int s)//找到和起点s连通的所有顶点
    {
        marked=new boolean[G.V()];
        dfs(G,s);//从起点开始，深度优先搜索；
    }
    private void dfs(Graph G, int v)
    {
        marked[v]=true;
        count++;
        for(int w: G.adjacent(v))
            if(!marked[w])
                dfs(G,w);
    }
    public boolean marked(int w)//w和s是连通的吗
    {
        return marked[w];
    }
    public int count()//与s连通的顶点总数
    {
        return count;
    }
}
