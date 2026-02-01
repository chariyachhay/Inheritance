public class Worker extends Person
{
    private double hourlyPayRate;

    // constructor
    public Worker(String firstName, String lastName, String ID,
                  String title, int YOB, double hourlyPayRate)
    {
        super(firstName, lastName, ID, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    // calculate weekly pay
    public double calculateWeeklyPay(double hoursWorked)
    {
        double pay;

        if(hoursWorked <= 40)
        {
            pay = hoursWorked * hourlyPayRate;
        }
        else
        {
            double regularPay = 40 * hourlyPayRate;
            double overtimeHours = hoursWorked - 40;
            double overtimePay = overtimeHours * hourlyPayRate * 1.5;

            pay = regularPay + overtimePay;
        }

        return pay;
    }

    // display weekly pay
    public void displayWeeklyPay(double hoursWorked)
    {
        double totalPay = calculateWeeklyPay(hoursWorked);

        if(hoursWorked <= 40)
        {
            System.out.printf("Regular Hours: %.2f  Total Pay: $%.2f\n",
                    hoursWorked, totalPay);
        }
        else
        {
            double overtimeHours = hoursWorked - 40;
            double regularPay = 40 * hourlyPayRate;
            double overtimePay = overtimeHours * hourlyPayRate * 1.5;

            System.out.printf("Regular Hours: 40.00  Regular Pay: $%.2f\n",
                    regularPay);
            System.out.printf("Overtime Hours: %.2f  Overtime Pay: $%.2f\n",
                    overtimeHours, overtimePay);
            System.out.printf("Total Pay: $%.2f\n", totalPay);
        }
    }

    // override CSV
    @Override
    public String toCSV()
    {
        return super.toCSV() + "," + hourlyPayRate;
    }

    // override JSON
    @Override
    public String toJSON()
    {
        return super.toJSON().replace("}",
                ", \"hourlyPayRate\": " + hourlyPayRate + "}");
    }

    // override XML
    @Override
    public String toXML()
    {
        return super.toXML().replace("</Person>",
                "   <hourlyPayRate>" + hourlyPayRate + "</hourlyPayRate>\n</Person>");
    }
}
