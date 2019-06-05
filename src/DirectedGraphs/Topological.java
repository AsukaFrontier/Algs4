package DirectedGraphs;

public class Topological
//优先级限制下的调度问题，等价于，计算有向无环图中的所有顶点的拓扑顺序
//当且仅当一幅有向图是无环图时，它才能进行拓扑排序
{
    private Iterable<Integer> order; //顶点的拓扑顺序
    public Topological(Digraph G)
    {
        DirectedCycle cyclefinder= new DirectedCycle(G);
        if(!cyclefinder.hasCycle()) //检测是否是无环图
        {
            DepthFirstOrder dfs= new DepthFirstOrder(G);
            order= dfs.reversePost(); //逆后序
        }
    }
    public Iterable<Integer> order()
    {
        return order;
    }
    public boolean isDAG() //有向无环图 Directed Acyclic Graph
    {
        return order!=null;
    }
}
