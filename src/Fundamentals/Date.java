package Fundamentals;
/**
 * private final int day;
 * private final int month;
 * private final int year;
 *
 * public Date(int day, int month, int year)
 * public int day()
 * public int month()
 * public int year()
 * public String toString()
 * public int compareTo(Date that)
 * **
 * public Date(String date)
 * public int hashCode()
 */
public class Date implements Comparable<Date>{
    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year)
    {
        this.day=day;
        this.month=month;
        this.year=year;
    }
     public int day()
     {
     return day;
     }
     public int month()
     {
     return month();
     }
     public int year()
     {
     return year;
     }
    public String toString()
    {
        return month+"/"+day+"/"+year;
    }
    public int compareTo(Date that)
    {
        /**
         * this.compareTo(that)
         * this<that: -1
         * this==that: 0
         * this>that: 1
         */
        if(this.year>that.year)
            return 1;
        if(this.year<that.year)
            return -1;
        //this.year==that.year
        if(this.month>that.month)
            return 1;
        if(this.month<that.month)
            return -1;
        //this.month==that.month
        if(this.day>that.day)
            return 1;
        if(this.day<that.day)
            return -1;
        //this.day==that.day
        return 0;
    }
    //----------UNIT TEST-------------------//
    public static void main(String[] args)
    {
        //
    }
}
