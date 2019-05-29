package Graphs;
/**
 * public static int degree(Graphs G, int V)
 * public static int maxDegree(Graphs G)
 * public static double avgDegree(Graphs G)
 * public static int numberOfSelfLoops(Graphs G)
 */
public class GraphProcessing {
    public static int degree(Graph G, int v)
    {
        int degree=0;
        for(int w:G.adjacent(v))
            degree++;
        return degree;
    }
    public static int maxDegree(Graph G)
    {
        int max=0;
        for(int v=0;v<G.V();v++)
            if(degree(G,v)>max)
                max=degree(G,v);
        return max;
    }
    public static double avgDegree(Graph G)
    {
        return 2*G.E()/G.V();
    }
    public static int numberOfSelfLoops(Graph G)//计算自环的个数
    {
        int count=0;
        for(int v=0;v<G.V();v++)
            for(int w:G.adjacent(v))
                if(v==w)
                    count++;
        return count;
    }
}
