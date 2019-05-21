package Fundamentals;

public class Maths {
    //
    public static int abs(int x)
    {
        if(x<0)
            return -x;
        else
            return x;
    }
    public static double abs(double x)
    {
        if(x<0.0)
            return -x;
        else
            return x;
    }

    /**
     *随机将double数组中的元素排序；打乱数组的排序；
     */
    public static void shuffle(double[] a)
    {
        arrayShuffleFromHead(a);
    }
    private static void arrayShuffleFromHead(double[] a)
    {
        int N=a.length;
        for(int i=0;i<N;i++)
        {
            //将a[i]和a[i...N-1]中任意一个元素交换；
            int r=i+uniform(N-i);
            double temp=a[i];
            a[i]=a[r];
            a[r]=temp;
        }
    }
    private static int uniform(int N)//返回0到N-1之间的整数；
    {
        return (int)Math.floor(N*Math.random());
    }
    /**
     *判断素数、判断最大公约数：算法的实现容易实现，算法的原理不易理解，非纯粹的计算机领域的编程问题；
     */
    public static boolean isPrime(int x)
    {
        if(x<0)
            return false;
        else if(x<=2)//&&(x>0)
            return true;
        else//x>2
            for(int i=2;i*i<=x;i++)
                if(x%i==0)
                    return false;
        return true;
    }
    public int greatestCommonDivisor(int p, int q)
    {
        if(q==0)
            return p;
        else if(p==0)
            return q;
        int r=p%q;
        return greatestCommonDivisor(q,r);
    }
    //---------------------UNIT TEST----------------------//
    public static void main(String[] args)
    {
        double[] doubles={1,2,3,5,8,13,21,34};
        shuffle(doubles);
        for(double d:doubles)
            System.out.print((int)d+" ");
    }
}
