package DirectedGraphs;
import edu.princeton.cs.algs4.In;

/**
 * private boolean[] marked;
 * public DirectedDFS(Digraph G, int s)
 * public DirectedDFS(Digraph G, Iterable<Integer> sources)
 * private void dfs(Digraph G, int v)
 * public boolean marked(int v)
 */
public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph G, int s)//构造函数
    //单点可达：是否存在一条从s到达给定顶点v的有向路径？
    {
        marked= new boolean[G.V()];
        dfs(G, s);
    }
    public DirectedDFS(Digraph G, Iterable<Integer> sources)//构造函数
    //多点可达性
    {
        marked= new boolean[G.V()];
        for(int s: sources)
            if(!marked[s])
                dfs(G, s);
    }
    private void dfs(Digraph G, int v)
    {
        marked[v]= true;
        for(int w: G.adj(v))
            if(!marked[w])
                dfs(G, w);
    }
    public boolean marked(int v)
    {
        return marked[v];
    }
    //--------------UNIT TEST----------------//
    public static void main(String[] args)
    {
        //判断：从给定的一个顶点, 能到达哪些其他顶点？
        Digraph G = new Digraph(new In("D:\\Development\\Java\\IDEA\\Algs4\\src\\DirectedGraphs\\tinyDG.txt"));
        int start= 0;

        DirectedDFS search= new DirectedDFS(G, start);//有向图的连通分量
        for(int v=0;v<G.V();v++)
            if(search.marked(v))
                System.out.print(v+" ");
        System.out.println();
    }
}
