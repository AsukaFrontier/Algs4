package DirectedGraphs;
import Fundamentals.Stack;
/**
 * private boolean[] marked;
 * private int[] edgeTo;
 * private Stack<Integer> cycle;//有向环中的所有顶点(if exists)
 * private boolean[] onStack;//递归调用上的所有顶点
 */
//栈、递归调用，后进先出 LIFO
public class DirectedCycle//寻找有向环
{
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;//有向环中的所有顶点(if exists)
    private boolean[] onStack;//递归调用上的所有顶点

    public DirectedCycle(Digraph G)//构造函数
    {
        onStack= new boolean[G.V()];
        marked= new boolean[G.V()];
        edgeTo= new int[G.V()];
        for(int v=0;v<G.V();v++)
            if(!marked[v])
                dfs(G,v);
    }
    private void dfs(Digraph G, int v)
    {
        //
    }
    public boolean hasCycle()//G是否含有有向环
    {
        return cycle!=null;
    }
    public Iterable<Integer> cycle()//有向环中的所有顶点
    {
        return cycle;
    }
}
