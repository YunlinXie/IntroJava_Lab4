//import java.util.Scanner;




import java.util.Scanner;
import java.util.Collections;

public class Main
{
    public static void main(String[] args)
    {
        String result = "";
        double totalWeeklyPay = 0.0;
        int numberOfBonus = 0;
        Scanner sc = new Scanner(System.in);

        final int NAME_WIDTH = 30;
        final int CLASS_WIDTH = 15;
        final int HOURS_WIDTH = 8;
        final int SALES_WIDTH = 12;
        final int RATE_WIDTH = 8;
        final int WEEKLYPAY_WIDTH = 12;
        final int TOTAL_WIDTH =
                        NAME_WIDTH +
                        CLASS_WIDTH +
                        HOURS_WIDTH +
                        SALES_WIDTH +
                        RATE_WIDTH +
                        WEEKLYPAY_WIDTH;


        result += EmployeeTools.getWidthNStringStartWith("Name", NAME_WIDTH);
        result += EmployeeTools.getWidthNStringStartWith("Class", CLASS_WIDTH);
        result += EmployeeTools.getWidthNStringStartWith("Hours", HOURS_WIDTH);
        result += EmployeeTools.getWidthNStringStartWith("Sales", SALES_WIDTH);
        result += EmployeeTools.getWidthNStringStartWith("Rate", RATE_WIDTH);
        result += EmployeeTools.getWidthNStringStartWith("Weekly Pay", WEEKLYPAY_WIDTH);
        result += "\n";

        result += EmployeeTools.getNCharStr(TOTAL_WIDTH, '=');
        result += "\n";



        while (true)
        {
            System.out.println("Please enter employee's name or 'exit': ");
            String name = sc.nextLine();
            if (name.compareToIgnoreCase("exit") == 0)
            {
                break;
            }

            System.out.println("Please enter employee's type or 'exit': ");
            String type = sc.nextLine();

            if (type.compareToIgnoreCase("exit") == 0)
            {
                break;
            }



            if (type.compareToIgnoreCase("salaried") == 0)
            {
                System.out.println("Please enter monthly salary: ");
                double msalary = sc.nextDouble();
                sc.nextLine();

                System.out.println("Please enter 'yes' if this employee has bonus, otherwise 'no': ");
                String bonus = sc.nextLine();
                boolean bAwarded = bonus.compareToIgnoreCase("yes") == 0;
                if (bAwarded)
                {
                    numberOfBonus++;
                }

                SalariedEmployee se = new SalariedEmployee(name, msalary, bAwarded);
                double pay = se.getWeeklyPay();
                totalWeeklyPay += pay;

                String weeklyPayString = "$" + String.valueOf(pay) + (bAwarded ? "*" : "");

                String employeeResult = EmployeeTools.getWidthNStringStartWith(name, NAME_WIDTH);
                employeeResult += EmployeeTools.getWidthNStringStartWith("Salaried", CLASS_WIDTH);
                employeeResult += EmployeeTools.getWidthNStringStartWith("", HOURS_WIDTH);
                employeeResult += EmployeeTools.getWidthNStringStartWith("", SALES_WIDTH);
                employeeResult += EmployeeTools.getWidthNStringStartWith("", RATE_WIDTH);
                employeeResult += EmployeeTools.getWidthNStringStartWith(weeklyPayString, WEEKLYPAY_WIDTH);


                result += employeeResult;
                result += "\n";
            }


            if (type.compareToIgnoreCase("hourly") == 0)
            {
                System.out.println("Please enter hours worked for the week: ");
                double hours = sc.nextDouble();
                sc.nextLine();
                System.out.println("Please enter hourly rate: ");
                double rate = sc.nextDouble();
                sc.nextLine();

                HourlyEmployee he = new HourlyEmployee(name, hours, rate);
                double pay = he.getWeeklyPay();
                totalWeeklyPay += pay;

                String weeklyPayString = "$" + String.valueOf(pay);

                String employeeResult = EmployeeTools.getWidthNStringStartWith(name, NAME_WIDTH);
                employeeResult += EmployeeTools.getWidthNStringStartWith("Hourly", CLASS_WIDTH);
                employeeResult += EmployeeTools.getWidthNStringStartWith(String.valueOf(hours), HOURS_WIDTH);
                employeeResult += EmployeeTools.getWidthNStringStartWith("", SALES_WIDTH);
                employeeResult += EmployeeTools.getWidthNStringStartWith("$" + String.valueOf(rate), RATE_WIDTH);
                employeeResult += EmployeeTools.getWidthNStringStartWith(weeklyPayString, WEEKLYPAY_WIDTH);


                result += employeeResult;
                result += "\n";
            }


            if (type.compareToIgnoreCase("commissioned") == 0)
            {
                System.out.println("Please enter week's sales: ");
                double sales = sc.nextDouble();
                sc.nextLine();

                CommissionedEmployee ce = new CommissionedEmployee(name, sales);
                double pay = ce.getWeeklyPay();
                totalWeeklyPay += pay;

                String weeklyPayString = "$" + String.valueOf(pay);

                String employeeResult = EmployeeTools.getWidthNStringStartWith(name, NAME_WIDTH);
                employeeResult += EmployeeTools.getWidthNStringStartWith("Commissioned", CLASS_WIDTH);
                employeeResult += EmployeeTools.getWidthNStringStartWith("", HOURS_WIDTH);
                employeeResult += EmployeeTools.getWidthNStringStartWith("$" + String.valueOf(sales), SALES_WIDTH);
                employeeResult += EmployeeTools.getWidthNStringStartWith("", RATE_WIDTH);
                employeeResult += EmployeeTools.getWidthNStringStartWith(weeklyPayString, WEEKLYPAY_WIDTH);

                result += employeeResult;
                result += "\n";
            }



        }

        result += EmployeeTools.getNCharStr(TOTAL_WIDTH, '=');
        result += "\n";

        result += "TOTAL $" + String.format("%.2f", totalWeeklyPay);
        result += "\n";

        result += "* " + numberOfBonus + " bonus were awarded to employees.";
        result += "\n";


        System.out.print(result);

    }
}

