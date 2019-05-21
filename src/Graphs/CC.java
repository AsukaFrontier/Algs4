package Graphs;

import Fundamentals.Bag;

/**
 * private boolean[] marked;
 * private int[] id;
 * private int count;
 *
 * public CC(Graph G)
 * private void dfs(Graph G, int v)
 * public boolean connected(int v, int w)
 * public int count()
 * public int id(int v)
 */
public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;
    public CC(Graph G)
    {
        marked= new boolean[G.V()];
        id=new int[G.V()];
        for(int s=0;s<G.V();s++)
            if(!marked[s])
            {
                dfs(G,s);
                count++;
            }
    }
    private void dfs(Graph G, int v)
    {
        marked[v]=true;
        id[v]=count;
        for(int w: G.adjacent(v))
            if(!marked[w])
                dfs(G,w);
    }
    public boolean connected(int v, int w)
    {
        return id[v]==id[w];
    }
    public int id(int v)
    {
        return id[v];
    }
    public int count()
    {
        return count;
    }
    //-----------UNIT TEST------//
    public static void main(String[] args)
    {
        int[] tinyG_txt={13,13,
                0,5,4,3,0,1,9,12,6,4,5,4,0,2,11,12,9,10,0,6,7,8,9,11,5,3};
        Graph G=new Graph(tinyG_txt);
        CC cc=new CC(G);
        int M=cc.count();
        System.out.println(M+" component/components.");
        //
        Bag<Integer>[] components;
        components=(Bag<Integer>[]) new Bag[M];
        for(int i=0;i<M;i++)
            components[i]=new Bag<Integer>();
        for(int v=0;v<G.V();v++)
            components[cc.id(v)].add(v);
        for(int i=0;i<M;i++)
        {
            for(int v: components[i])
                System.out.print(v+" ");
            System.out.println();
        }
    }
}
