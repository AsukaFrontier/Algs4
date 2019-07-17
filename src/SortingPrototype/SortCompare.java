package SortingPrototype;
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
        {
            Insertion.sort(a);
            assert Insertion.isSorted(a);
        }
        if(alg.equals("Selection"))
        {
            Selection.sort(a);
            assert Selection.isSorted(a);
        }
        if(alg.equals("Shell"))
        {
            Shell.sort(a);
            assert Shell.isSorted(a);
        }
        if(alg.equals("Merge"))
        {
            Merge.sort(a);
            assert Merge.isSorted(a);
        }
        if(alg.equals("Quick"))
        {
            Quick.sort(a);
            assert Quick.isSorted(a);
        }
        /**
        if(alg.equals("Heap"))
        {
            Heap.sort(a);
            assert.isSorted(a);
        }
         */
        if(alg.equals("InsertionAdvanced"))
        {
            InsertionAdvanced.sort(a);
            InsertionAdvanced.isSorted(a);
        }
        if(alg.equals("ShellGeneral"))
        {
            ShellGeneral.sort(a);
            assert ShellGeneral.isSorted(a);
        }
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
        int N=2_000_000;
        int T=10;
        String alg1= "Quick";
        double t1=timeRandomInput(alg1,N,T);
        String alg2= "Merge";
        double t2=timeRandomInput(alg2,N,T);
        System.out.println("SortingPrototype and Comparing...");
        System.out.printf("For %d random doubles, after %d times\n",N,T);
        System.out.printf("%s %s: %.1f %.1f\n",alg1,alg2,t1,t2);
    }
}
