package Graphs;
import edu.princeton.cs.algs4.In;
/**
 * private boolean marked;
 * private boolean hasCycle;
 * public Cycle(Graph G)
 * private void dfs(Graph G, int v, int u)
 * public boolean hasCycle()
 */
public class Cycle {
    //检测环，给定的图是无环图吗？
    private boolean[] marked;
    private boolean hasCycle;// By default, hasCycle=false;

    public Cycle(Graph G)//构造函数
    {
        marked= new boolean[G.V()];
        for(int s=0; s<G.V();s++)
            if(!marked[s])
                dfs(G, s, s);
    }
    private void dfs(Graph G, int v, int u)//检测
    {
        marked[v]= true;
        for(int w: G.adj(v))
            if(!marked[w])//如果w未被标记、尚未被访问
                dfs(G,w,v);
            else if(w!=u)//如果w已经被访问过，且w!=u
                hasCycle=true;
            //一个树的根结点，对其dfs(G,v,u)时，其u(上一个访问的结点)一定是其邻接结点
            //对于一个环的最后一个结点，对其dfs(G,v,u)时，其邻接结点一定有一个不是u
            //else (w==u)
    }
    public boolean hasCycle()
    {
        return hasCycle;
    }
    //--------UNIT TEST-----//
    public static void main(String[] args) {
        In in = new In("D:\\Development\\Java\\IDEA\\Algs4\\src\\Graphs\\tinyG.txt");
        Graph G = new Graph(in);
        Cycle finder = new Cycle(G);
        if (finder.hasCycle()) {
            System.out.println("Has Cycle.");
        }
        else {
            System.out.println("Graph is acyclic");
        }
    }
}
