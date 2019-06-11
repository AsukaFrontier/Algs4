package MinimumSpanningTrees;
import Fundamentals.Queue;
import edu.princeton.cs.algs4.MinPQ;

public class LazyPrimMST {
    private boolean[] marked;//最小生成树的顶点
    private Queue<Edge> mst; //最小生成树的边
    private MinPQ<Edge> pq;  //横切边，包括已失效的边

    public LazyPrimMST(EdgeWeightedGraph G)//构造函数，将加权无向图作为输入参数
    {
        marked= new boolean[G.V()];
        mst= new Queue<Edge>();
        pq= new MinPQ<Edge>();
        visit(G,0); //假设G是一幅连通图
        while(!pq.isEmpty())//优先队列非空
        {
            Edge e= pq.delMin();//从pq中得到权重最小的边
            int v= e.either();
            int w= e.other(v);
            if(marked[v]&&marked[w])
                continue;//进入下一次循环：略过失效的边，即树中的两个顶点所对应的边
            mst.enqueue(e);
            if(!marked[v])
                visit(G,v);
            if(!marked[w])
                visit(G,w);
        }
    }
    private void visit(EdgeWeightedGraph G, int v)
    //标记顶点v，将所有连接v和未被标记顶点的边加入pq
    {
        marked[v]= true;
        for(Edge e: G.adj(v))
            if(!marked[e.other(v)])
                pq.insert(e);
    }
    public Iterable<Edge> edge()
    {
        return mst;
    }
}
