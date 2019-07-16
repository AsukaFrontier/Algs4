package Fundamentals;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class GeneralUnionFind implements UnionFind // quick-find
{
    // class variables
    private int[] id;
    private int count;
    // class constructor
    public GeneralUnionFind(int N)
    {
        count=N;
        id= new int[N];
        for(int i=0;i<id.length;i++)
            id[i]=i;
    }
    // instance methods
    public int count()
    {
        return count;
    }
    public boolean connected(int p, int q)
    {
        return find(p)==find(q);
    }
    public int find(int p)
    {
        return id[p];
    }
    public void union(int p, int q) //每次出现整数对时，都要运行一次union()
    {
        int pID= find(p); //array visited
        int qID= find(q); //array visited

        if(pID==qID)
            return ;
        for(int i=0;i<id.length;i++)
            //array visited(at least): 只有p和q一个链接(p只和自身链接): (N-1)+(1+1)
            //array visited(at most ): 除了q本身, p和所有其他触点都已链接: (N-1)*2+1
            if(id[i]==pID)
                id[i]= qID;
        count--; //该次union()后，分量减少一个
    }
    //-------------------------UNIT TEST-------------------------//
    public static void main(String[] args) throws IOException
    {
        Scanner in= new Scanner(Paths.get("D:\\Development\\Java\\SourceCode\\algs4\\algs4Data\\mediumUF.txt"), "UTF-8");
        int N= in.nextInt();
        UnionFind uf= new GeneralUnionFind(N);
        while(in.hasNext())
        {
            int p= in.nextInt();
            int q= in.nextInt();
            if(uf.connected(p, q))
                continue;
            uf.union(p, q);
            System.out.println(p+ " "+ q);
        }
        System.out.println(uf.count()+ " components.");
    }
}
