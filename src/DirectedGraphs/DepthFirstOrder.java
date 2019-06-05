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
    private Queue<Integer> pre;  //先序
    private Queue<Integer> post; //后序
    private Stack<Integer> reversePost; //逆后序
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
        pre.enqueue(v);
        marked[v]= true;
        for(int w: G.adj(v))
            if(!marked[w])
                dfs(G,w);
        post.enqueue(v);
        reversePost.push(v);
    }
    public Iterable<Integer> pre()
    {
        return pre;
    }
    public Iterable<Integer> post()
    {
        return post;
    }
    public Iterable<Integer> reversePost()
    {
        return reversePost;
    }
}
