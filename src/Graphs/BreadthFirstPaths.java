package Graphs;
import Fundamentals.Queue;
import Fundamentals.Stack;
/**
 * private boolean[] marked;
 * private int[] edgeTo;
 * private final int s;
 *
 * public BreadthFirstPaths(Graph G, int s)//构造函数
 * private void bfs(Graph G, int s)
 * public boolean hasPathTo(int v)
 * public Iterable<Integer> pathTo(int v)
 */
public class BreadthFirstPaths {
    private boolean[] marked;//到达该顶点的最短路径已知吗？
    private int[] edgeTo;//到达该顶点的已知路径上的最后一个顶点
    private final int s;//起点

    public BreadthFirstPaths(Graph G, int s)//构造函数
    {
        marked= new boolean[G.V()];
        edgeTo= new int[G.V()];//edgeTo[0]未被使用;
        this.s=s;
        bfs(G,s);
    }
    private void bfs(Graph G, int s)//未使用递归；
    {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s]=true;//标记起点
        queue.enqueue(s);//将其加入队列；
        while(!queue.isEmpty())//当队列非空
        {
            int v=queue.dequeue();//从队列中删去下一顶点，并处理该顶点；
            for(int w:G.adj(v))
                if(!marked[w])//对于每个未被标记的相邻顶点
                {
                    edgeTo[w]=v;//保存最短路径的最后一条边
                    marked[w]=true;//
                    queue.enqueue(w);//将其添加到队列中
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
        Stack<Integer> path = new Stack<>();//把倒序的路径压入栈中，则可返回正序的路径；
        for(int x=v;x!=s;x=edgeTo[v])
            path.push(x);
        path.push(s);
        return path;
    }
}
