package Fundamentals;

public class Accumulator {
    /**
     * Fundamentals.Accumulator()
     * void addDataValue(double val)
     * double mean()
     * String toString()
     */
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
