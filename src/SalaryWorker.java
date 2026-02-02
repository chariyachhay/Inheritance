public class SalaryWorker extends Worker
{
    private double annualSalary;

    // constructor
    public SalaryWorker(String firstName, String lastName, String ID,
                        String title, int YOB,
                        double hourlyPayRate, double annualSalary)
    {
        super(firstName, lastName, ID, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    // override calculateWeeklyPay
    @Override
    public double calculateWeeklyPay(double hoursWorked)
    {
        // hoursWorked is not used but kept for polymorphism
        return annualSalary / 52.0;
    }

    // override displayWeeklyPay
    @Override
    public void displayWeeklyPay(double hoursWorked)
    {
        double weeklyPay = calculateWeeklyPay(hoursWorked);

        System.out.printf("Salary Worker Weekly Pay: $%.2f\n", weeklyPay);
        System.out.println("This is based on an annual salary of $" + annualSalary);
    }

    // override CSV
    @Override
    public String toCSV()
    {
        return super.toCSV() + "," + annualSalary;
    }

    // override JSON
    @Override
    public String toJSON()
    {
        return "{ \"ID\": \"" + getID() + "\", " +
                "\"firstName\": \"" + getFirstName() + "\", " +
                "\"lastName\": \"" + getLastName() + "\", " +
                "\"title\": \"" + getTitle() + "\", " +
                "\"YOB\": " + getYOB() + ", " +
                "\"annualSalary\": " + annualSalary + " }";
    }

    // override XML
    @Override
    public String toXML()
    {
        return "<SalaryWorker>" +
                "<ID>" + getID() + "</ID>" +
                "<FirstName>" + getFirstName() + "</FirstName>" +
                "<LastName>" + getLastName() + "</LastName>" +
                "<Title>" + getTitle() + "</Title>" +
                "<YOB>" + getYOB() + "</YOB>" +
                "<AnnualSalary>" + annualSalary + "</AnnualSalary>" +
                "</SalaryWorker>";
    }
}
