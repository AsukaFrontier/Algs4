package Fundamentals;
/**
 * private double total;
 * private int N;
 *
 * void addDataValue(double val)
 * double mean()
 * String toString()
 */
public class Accumulator
{
    private double total;
    private int N;

    public void addDataValue(double val)
    {
        //
        N++;
        total=total+val;
    }
    private double mean()
    {
        return total/N;
    }
    public String toString()
    {
        return "The total is "+total+", and the mean value is "+String.format("%7.5f",mean());
    }
    //--------------------UNIT TEST-------------//
    public static void main(String[] args)
    {
        //
        int[] ints={1,2,3,5,8,13,21};
        Accumulator acc=new Accumulator();
        for(int a:ints) {
            acc.addDataValue(a);
        }
        System.out.println(acc);
    }
}
