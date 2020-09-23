public class SalariedEmployee extends Employee
{
    protected double monthlySalary;
    protected boolean bonusAwarded;

    public SalariedEmployee(String name, double mSalary, boolean bAwarded)
    {
        super(name);
        monthlySalary = mSalary;
        bonusAwarded = bAwarded;
    }
    public void print()
    {
        System.out.println(name);
        System.out.println(monthlySalary);
        System.out.println(bonusAwarded);
    }
    public double getWeeklyPay()
    {
        double WeeklyPay = monthlySalary * 12 / 52;
        if (bonusAwarded)
        {
            WeeklyPay *= 1.1;
        }
        return Math.round(WeeklyPay*100)/100.0;
    }
    
}
