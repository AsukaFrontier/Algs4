package Fundamentals;

public interface UnionFind {
    //UnionFind(int N); //class constructor
    void union(int p, int q);
    int find(int p);
    boolean connected(int p, int q);
    int count();
}
