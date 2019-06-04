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
        onStack[v]= true;//v进入递归调用的栈中
        marked[v]=true;
        for(int w: G.adj(v))
            if(this.hasCycle())//G含有有向环
                return ;
            else if(!marked[w])
            {
                edgeTo[w]=v;//v->w
                dfs(G,w);
            }
            else if(onStack[w])//当前访问的w，在此之前已经被dfs递归调用过；说明存在环；
            //将路径压入栈中
            {
                cycle= new Stack<Integer>();
                for(int x=v;x!=w;x=edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                //cycle.push(v);
            }
        onStack[v]= false;//dfs()的最后，dfs(v)结束调用；
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
