package Graphs;
import edu.princeton.cs.algs4.In;
public class TestSearch {
    //
    public static void main(String[] args)
    {
        Graph G = new Graph(new In(args[0]));//create a Graph
        int s= Integer.parseInt(args[1]);//待查找的s
        DepthFirstSearch search= new DepthFirstSearch(G,s);

        for(int v=0;v<G.V();v++)
            if(search.marked(v))//v和s是连通的吗
                System.out.print(v+" ");
         System.out.println();

         if(search.count()!=G.V())//与s连通的顶点总数
             System.out.print("Not");
         System.out.println("connected.");
    }
}
