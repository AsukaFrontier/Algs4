package DirectedGraphs;
import Fundamentals.Queue;
import Fundamentals.Stack;
/**
 * private boolean[] marked;
 * private Queue<Integer> pre;
 * private Queue<Integer> post;
 * private Stack<Integer> reversePost;
 *
 * public DepthFirstOrder(Digraph G)
 * private void dfs(Digraph G, int v)
 * public Iterable<Integer> pre()
 * public Iterable<Integer> post()
 * public Iterable<Integer> reversePost()
 */
public class DepthFirstOrder//有向图中基于深度优先搜索的顶点排序
{
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;
    public DepthFirstOrder(Digraph G)
    {
        pre= new Queue<Integer>();
        post= new Queue<Integer>();
        reversePost= new Stack<Integer>();
        marked= new boolean[G.V()];
        for(int v=0;v<G.V();v++)
            if(!marked[v])
                dfs(G,v);
    }
    private void dfs(Digraph G, int v)
    {
        //
    }
}
