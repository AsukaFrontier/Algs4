package Fundamentals;
public class GreatestCommonDivisor
{
    public int greatestCommonDivisor(int p, int q)
    {
        if(q==0)
            return p;
        else if(p==0)
            return q;
        int r=p%q;
        return greatestCommonDivisor(q,r);
    }
    //----------------UNIT TEST--------------------//
    public static void main(String[] args)
    {
        int p=24;
        int q=12;
        GreatestCommonDivisor gcd= new GreatestCommonDivisor();
        int gcd_2ints=gcd.greatestCommonDivisor(p,q);
        System.out.print(gcd_2ints+"\n");
    }
}
