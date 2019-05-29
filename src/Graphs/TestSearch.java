package Graphs;
import edu.princeton.cs.algs4.In;
public class TestSearch {
    public static void main(String[] args)
    {
        //Graph G = new Graph(new In(args[0]));
        Graph G= new Graph(new In("D://Development//Java//IDEA//Algs4//src//Graphs//tinyG.txt"));
        //int s= Integer.parseInt(args[1]);
        int s=9;
        //DepthFirstSearch search= new DepthFirstSearch(G,s);
        BreadthFirstSearch search= new BreadthFirstSearch(G,s);
        for(int v=0;v<G.V();v++)
            if(search.marked(v))
                System.out.print(v+" ");
        System.out.println();

        if(search.count()!=G.V())
            System.out.println("Not connected");
    }
}
