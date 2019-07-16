package Fundamentals;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class AdvancedUnionFind implements UnionFind // quick-find
{
    // class variables
    private int[] id;
    private int count;
    // class constructor
    public AdvancedUnionFind(int N)
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
    public int find(int p) //找出触点p的根触点
    {
        while(p!=id[p]) //loop
            p=id[p];
        return p;
    }
    public void union(int p, int q) //每次出现整数对时，都要运行一次union()
    {
        int pRoot= find(p);
        int qRoot= find(q);
        if(pRoot==qRoot)
            return ;
        //else
        id[pRoot]= qRoot;
        count--;
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

