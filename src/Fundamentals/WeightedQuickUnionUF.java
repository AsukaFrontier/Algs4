package Fundamentals;

public class WeightedQuickUnionUF implements UnionFind //
{
    //class variables
    private int[] id; //父链接数组
    private int[] sz; //各个根结点所对应的分量的大小
    private int count;
    public WeightedQuickUnionUF(int N)
    {
        count= N;
        id= new int[N];
        for(int i=0;i<N;i++)
            id[i]= i;
        sz= new int[N];
        for(int i=0;i<N;i++) //初始分量大小: 1
            sz[i]=1;
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
        while(p!=id[p])
            p= id[p];
        return p;
    }
    public void union(int p, int q)
    {
        int i= find(p);
        int j= find(q);
        if(i==q)
            return ;
        if(sz[i]<sz[j])//i所在的树的大小 小于 j所在的树的大小
        {
            id[i]=j;
            sz[j]=sz[i]+sz[j];
        }
        else
        {
            id[j]=i;
            sz[i]=sz[j]+sz[i];
        }
        count--;
    }
}
