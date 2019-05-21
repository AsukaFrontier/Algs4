package Fundamentals;

public class Maths {
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
     *判断素数、判断最大公约数：算法的实现容易实现，算法的原理不易理解，并非纯粹的计算机领域的编程问题；
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
}
