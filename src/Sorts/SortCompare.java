package Sorts;
import Fundamentals.Stopwatch;
/**
 * public static double time(String alg, Double[] a)
 * public static double timeRandomInput(String alg, int N,int T)
 * public static void main(String[] args)
 */
public class SortCompare {
    public static double time(String alg, Double[] a)
    {
        Stopwatch timer= new Stopwatch();
        if(alg.equals("Insertion"))
            Insertion.sort(a);
        if(alg.equals("Selection"))
            Insertion.sort(a);
        if(alg.equals("Shell"))
            Insertion.sort(a);
        if(alg.equals("Merge"))
            Insertion.sort(a);
        if(alg.equals("Quick"))
            Insertion.sort(a);
        if(alg.equals("Heap"))
            Insertion.sort(a);
        if(alg.equals("InsertionAdvanced"))
            InsertionAdvanced.sort(a);
        return timer.elapsedTime();
    }
    public static double timeRandomInput(String alg, int N, int T)
    {
        double total=0;
        Double[] a= new Double[N];
        for(int t=0;t<T;t++)//How many times
        {
            //Random r= new Random();
            for(int i=0;i<N;i++)
                a[i]=Math.floor(Math.random()*100);
            total= total+time(alg,a);
        }
        return total;
    }
    public static void main(String[] args)
    {
        String alg1= "Shell";
        String alg2= "Selection";
        String alg3= "Insertion";
        String alg4= "InsertionAdvanced";
        int N=10000;
        int T=20;
        double t1=timeRandomInput(alg1,N,T);
        double t2=timeRandomInput(alg2,N,T);
        double t3=timeRandomInput(alg3,N,T);
        double t4=timeRandomInput(alg4,N,T);
        System.out.println("Sorting and Comparing...");
        System.out.printf("For %d random doubles, after %d times\n",N,T);
        System.out.printf("%s %s %s %s: %.1f %.1f %.1f %.1f\n",alg1,alg2,alg3,alg4,t1,t2,t3,t4);
    }
}
