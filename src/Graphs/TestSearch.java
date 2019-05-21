package Graphs;
import java.util.Scanner;

public class TestSearch {
    public static void main(String[] args)
    {
        //
    }
    /**
    public static void main(String[] args)
    {
        Graph G= new Graph(new Scanner(args[0]));
        int s=Integer.parseInt(args[1]);
        DepthFirstSearch dfsearch=new DepthFirstSearch(G,s);
        for(int v=0;v<G.V();v++)
            if(dfsearch.marked(v))
                System.out.print(v+" ");
        System.out.println();
        if(dfsearch.count()!=G.V())
            System.out.print("Not ");
        System.out.println("Conneted.");
    }
     */
}
