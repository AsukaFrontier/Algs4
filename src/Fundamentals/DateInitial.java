package Fundamentals;
/**
 * private final int month;
 * private final int day;
 * private final int year;
 * public DateInitial(int m, int d, int y)
 * public int day()
 * public int month()
 * public int year()
 * public String toString()
 * public boolean equals(Object x)
 */
public class DateInitial
{
    private final int month;
    private final int day;
    private final int year;

    public DateInitial(int m, int d, int y)
    {
        month=m;
        day=d;
        year=y;
    }
    public int month()
    {
        return month;
    }
    public int day()
    {
        return day;
    }
    public int year()
    {
        return year;
    }
    public String toString()
    {
        return month()+"/"+day()+"/"+year();
    }
    public boolean equals(Object x)
    {
        //
        if(this==x)
            return true;
        if(x==null)
            return false;
        if(this.getClass()!=x.getClass())
            return false;
        DateInitial that=(DateInitial)x;
        if(this.day()==that.day())
            if(this.month()==that.month())
                if(this.year()==that.year())
                    return true;
        return false;
    }
    //----------UNIT TEST-------------------//
    public static void main(String[] args)
    {
        //Test
        int m=11;
        int d=28;
        int y=1994;
        DateInitial birthday = new DateInitial(m,d,y);
        System.out.println(birthday);
    }
}
