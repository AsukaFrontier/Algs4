package Graphs;
import Fundamentals.Stack;
/**
 * private boolean marked;
 * private int[] edgeTo;
 * private int s;
 * public DepthFirstPaths(Graph G, int s)
 * private void dfs(Graph G, int v)
 * public boolean hasPathTo(int v)
 * public Iterable<Integer> pathTo(int v)
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstPaths(Graph G, int s)
    {
        marked =new boolean[G.V()];
        edgeTo= new int[G.V()];
        this.s=s;
        dfs(G,s);
    }
    private void dfs(Graph G, int v)
    {
        marked[v]=true;
        for(int w: G.adjacent(v))
            if(!marked[w])
            {
                edgeTo[w]=v;//v -> w
                dfs(G, w);
            }
    }
    public boolean hasPathTo(int v)
    {
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v)
    {
        //
        if(!hasPathTo(v))
            return null;
        Stack<Integer> path=new Stack<Integer>();
        for(int x=v;x!=s;x=edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
    //----------UNIT TEST----------//
    public static void main(String[] args)
    {
        int[] tinyG_txt={13,13,
                0,5,4,3,0,1,9,12,6,4,5,4,0,2,11,12,9,10,0,6,7,8,9,11,5,3};
        Graph G=new Graph(tinyG_txt);
        int s=0;
        DepthFirstPaths dfpaths=new DepthFirstPaths(G,s);
        for(int v=0;v<G.V();v++)
        {
            System.out.print(s+" to "+v+": ");
            if(dfpaths.hasPathTo(v))
                for(int x: dfpaths.pathTo(v))
                    if(x==s)
                        System.out.print(x);
                    else
                        System.out.print("-"+x);
            else
                System.out.print("No path.");
            System.out.println();
        }
    }
}
