package Fundamentals;
/**
 * private final String who;
 * private final Date when;
 * private final double amount;
 *
 * public Transaction(String who, Date when, double amount)
 * public String who()
 * public Date when()
 * public double amount()
 * public String toString()
 * public boolean equals(Object that)
 * public int compareTo(Transaction that)
 * public int hashCode()
 *
 * public static class WhoOrder implements Comparator<>{}
 * public static class WhenOrder implements Comparator<>{}
 * public static class HowMuchOrder implements Comparator<>{}
 */
import java.util.Comparator;
public class Transaction implements Comparable<Transaction>{
    //
    private final String who;//customer
    private final Date when;//date
    private final double amount;

    public Transaction(String who, Date when, double amount)
    {
        if(Double.isNaN(amount)||Double.isInfinite(amount))
            throw new IllegalArgumentException("amount cannot be NaN or infinite.");
        this.who=who;
        this.when=when;
        this.amount=amount;
    }
    public String who()
    {
        return who;
    }
    public Date when()
    {
        return when;
    }
    public double amount()
    {
        return amount;
    }
    public String toString()
    {
        return String.format("%-10s %10s %8.2f",who, when, amount);
    }
    public int compareTo(Transaction that)
    {
        return Double.compare(this.amount, that.amount);
    }
    public boolean equals(Object other)
    {
        //
        if(other==this)
            return true;
        if(other==null)
            return true;
        if(other.getClass()!=this.getClass())
            return false;
        Transaction that=(Transaction) other;
        return ((this.amount==that.amount)&&(this.when.equals(that.when))&&(this.who.equals(that.who)));
    }
    public int hashCode()
    {
        int hash=1;
        hash=31*hash+who.hashCode();
        hash=31*hash+when.hashCode();
        hash=31*hash+((Double)amount).hashCode();
        return hash;
    }
    public static class WhoOrder implements Comparator<Transaction>
    {
        public int compare(Transaction v, Transaction w)
        {
            return v.who.compareTo(w.who);
        }
    }
    public static class WhenOrder implements Comparator<Transaction>
    {
        public int compare(Transaction v, Transaction w)
        {
            return v.when.compareTo(w.when);
        }
    }
    public static class HowMuchOrder implements Comparator<Transaction>
    {
        public int compare(Transaction v, Transaction w)
        {
            return Double.compare(v.amount, w.amount);
        }
    }
}
