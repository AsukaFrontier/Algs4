package Graphs;
import Fundamentals.Queue;
import Fundamentals.Stack;
/**
 * private boolean[] marked;
 * private int[] edgeTo;
 * private final int s;
 * public BreadthFirstPaths(Graph G, int s)
 * private void bfs(Graph G, int s)
 * public boolean hasPathTo(int v)
 * public Iterable<> pathTo(int v)
 */
public class BreadthFirstPaths
{
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;
    public BreadthFirstPaths(Graph G, int start)
    {
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        this.s=start;
        bfs(G,s);
    }
    private void bfs(Graph G, int s)
    {
        Queue<Integer> queue= new Queue<Integer>();
        marked[s]=true;
        queue.enqueue(s);
        while(!queue.isEmpty())
        {
            int v=queue.dequeue();
            for(int w: G.adjacent(v))
                if(!marked[w])
                {
                    edgeTo[w]=v;
                    marked[w]=true;
                    queue.enqueue(w);
                }
        }
    }
    public boolean hasPathTo(int v)
    {
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v)
    {
        if(!hasPathTo(v))
            return null;
        Stack<Integer> path =new Stack<Integer>();
        for(int x=v;x!=s;x=edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
