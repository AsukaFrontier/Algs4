package MinimumSpanningTrees;

public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;
    public Edge(int v, int w, int weight)//构造函数
    {
        this.v= v;
        this.w= w;
        this.weight= weight;
    }
    public double weight()//边的权重
    {
        return weight;
    }
    public int either()//边两端顶点之一
    {
        return v;
    }
    public int other()//边的另一个顶点
    {
        return w;
    }
    public int compareTo(Edge that)//与另一个顶点作比较
    {
        if(this.weight()<that.weight())
            return -1;
        else if(this.weight()==that.weight())
            return 0;
        else
            return 1;
    }
    public String toString()
    {
        return String.format("%d - %d %.2f",v,w,weight);
    }
}
