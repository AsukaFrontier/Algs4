package Graphs;
import Fundamentals.Queue;
public class BreadthFirstSearch {
    private boolean[] marked;
    private int count;

    public BreadthFirstSearch(Graph G, int s)//给定一个图，一个起点顶点
    {
        marked= new boolean[G.V()];
        bfs(G,s);
    }
    private void bfs(Graph G, int s)
    {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);
        while(!queue.isEmpty())
        {
            int v = queue.dequeue();
            marked[v]=true;
            for(int w: G.adj(v))
                if(!marked[w])
                {
                   queue.enqueue(w);
                   count++;
                }
        }
    }
    public boolean marked(int w)
    {
        return marked[w];
    }
    public int count()
    {
        return count;
    }
}
