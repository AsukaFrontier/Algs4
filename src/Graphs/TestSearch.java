package Graphs;
public class TestSearch {
    public static void main(String[] args)
    {
        int[] tinyG_txt={13,13,
                0,5,4,3,0,1,9,12,6,4,5,4,0,2,11,12,9,10,0,6,7,8,9,11,5,3};
        Graph G= new Graph(tinyG_txt);
        int s=0;
        DepthFirstSearch dfsearch=new DepthFirstSearch(G,s);
        for(int v=0;v<G.V();v++)
            if(dfsearch.marked(v))
                System.out.print(v+" ");
        System.out.println();
        if(dfsearch.count()!=G.V())
            System.out.print("Not ");
        System.out.println("Connected.");
    }
}
