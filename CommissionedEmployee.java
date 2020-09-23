public class CommissionedEmployee extends Employee
{
    protected double weekSales;
    public final double commissionRate = 0.2;

    public CommissionedEmployee(String name, double sales)
    {
        super(name);
		weekSales = sales;
    }
    public void print()
    {
        System.out.println(name);
        System.out.println(weekSales);
    }
    public double getWeeklyPay()
    {
        double WeeklyPay = weekSales * commissionRate;

        return Math.round(WeeklyPay*100)/100.0;
        
    }

}