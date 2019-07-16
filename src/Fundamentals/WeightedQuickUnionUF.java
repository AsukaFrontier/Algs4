package Fundamentals;

public class WeightedQuickUnionUF implements UnionFind //
{
    //class variables
    private int[] id;
    private int[] sz;
    private int count;
    public WeightedQuickUnionUF(int N)
    {
        //
    }
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
        //
    }
    public void union(int p, int q)
    {
        //
    }
}
