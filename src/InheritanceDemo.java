import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();

        // Create 3 hourly workers
        Worker w1 = new Worker("Mimi", "Lakes", "W001", "Mr.", 1990, 23.00);
        Worker w2 = new Worker("Anne", "Humbert", "W002", "Ms.", 1985, 17.50);
        Worker w3 = new Worker("Dareen", "Johnson", "W003", "Mr.", 1992, 24.00);

        // Create 3 salary workers
        SalaryWorker s1 = new SalaryWorker("Anka", "Lou", "S001", "Ms.", 1980, 0, 55000);
        SalaryWorker s2 = new SalaryWorker("Danny", "Lak", "S002", "Mrs.", 1975, 0, 60000);
        SalaryWorker s3 = new SalaryWorker("Billie", "Sae", "S003", "Dr.", 1988, 0, 79000);

        // Add all to ArrayList<Worker>
        workers.add(w1);
        workers.add(w2);
        workers.add(w3);
        workers.add(s1);
        workers.add(s2);
        workers.add(s3);

        double[] hoursWorkedPerWeek = {40, 50, 40};

        for (int week = 0; week < 3; week++) {
            System.out.println("\nWeek " + (week + 1));
            System.out.println("------------------------------------------------------------");
            System.out.printf("%-20s %-12s %-12s %-12s%n", "Name", "Reg Hours", "OT Hours", "Total Pay");
            System.out.println("------------------------------------------------------------");

            for (Worker w : workers) {
                double totalPay = w.calculateWeeklyPay(hoursWorkedPerWeek[week]);
                double regHours, otHours;

                // Check if Worker is a SalaryWorker
                if (w instanceof SalaryWorker) {
                    regHours = 40;
                    otHours = 0;
                } else { // hourly worker
                    if (hoursWorkedPerWeek[week] <= 40) {
                        regHours = hoursWorkedPerWeek[week];
                        otHours = 0;
                    } else {
                        regHours = 40;
                        otHours = hoursWorkedPerWeek[week] - 40;
                    }
                }

                System.out.printf("%-20s %-12.2f %-12.2f $%-12.2f%n",
                        w.formalName(), regHours, otHours, totalPay);
            }
        }
    }
}
