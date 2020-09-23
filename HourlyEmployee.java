public class HourlyEmployee extends Employee
{
	protected double hours;
	protected double rate;
	public final double HOURS_LIMT = 40;
	
    public HourlyEmployee(String name, double hours, double rate)
    {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
    public void print()
    {
        System.out.println(name);
        System.out.println(hours);
        System.out.println(rate);
    }
    public double getWeeklyPay()
    {
    	double WeeklyPay;
    	
    	if (hours <= HOURS_LIMT)
    	{
        	WeeklyPay = hours * rate;
        }
        else
        {
            WeeklyPay = rate * HOURS_LIMT + 2 * rate * (hours - HOURS_LIMT);
        }
        return Math.round(WeeklyPay*100)/100.0;
    }
    
}
