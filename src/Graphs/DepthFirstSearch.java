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
    //--------------------UNIT TEST-------------------//
    public static void main(String[] args)
    {
        int[] tinyG_txt={13,13,
                0,5,4,3,0,1,9,12,6,4,5,4,0,2,11,12,9,10,0,6,7,8,9,11,5,3};
        Graph G= new Graph(tinyG_txt);
        int s=0;
        DepthFirstSearch dfsearch=new DepthFirstSearch(G,s);
        for(int v=0;v<G.V();v++)
            if(dfsearch.marked(v))
                System.out.print(v+" ");
        System.out.println();
        if(dfsearch.count()!=G.V())
            System.out.print("Not ");
        System.out.println("Connected.");
    }
}
