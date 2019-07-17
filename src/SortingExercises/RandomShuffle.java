package SortingExercises;
import java.util.Random;
public class RandomShuffle //随机打乱
{
    private static long seed= System.currentTimeMillis();
    private static Random random=new Random(seed);
    public static void shuffle(Comparable[] a)
    {
        int N=a.length;
        for(int i=0;i<N;i++)
        {
            //int nextInt(int bound): Returns a pseudo-random,
            // uniformly distributed int value between 0 (inclusive) and the specified value (exclusive)
            int r=i+random.nextInt(N-i); //nextInt(): returns a int value: [0,N-i); r: [i,N);
            {   //a[i]与a[r]交换(r可能为i: 当前元素与当前元素交换)
                Comparable temp = a[i];
                a[i] = a[r];
                a[r] = temp;
            }
        }
    }
}
