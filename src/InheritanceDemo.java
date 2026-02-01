import java.util.ArrayList;

public class InheritanceDemo
{
    public static void main(String[] args)
    {
        ArrayList<Worker> workers = new ArrayList<>();

        // Create 3 hourly workers
        Worker w1 = new Worker("John", "Smith", "W001", "Mr.", 1990, 20.00);
        Worker w2 = new Worker("Emily", "Jones", "W002", "Ms.", 1985, 18.50);
        Worker w3 = new Worker("David", "Brown", "W003", "Mr.", 1992, 22.00);

        // Create 3 salary workers
        SalaryWorker s1 = new SalaryWorker("Sarah", "White", "S001", "Mrs.", 1980, 0, 52000);
        SalaryWorker s2 = new SalaryWorker("Michael", "Green", "S002", "Mr.", 1975, 0, 65000);
        SalaryWorker s3 = new SalaryWorker("Anna", "Black", "S003", "Dr.", 1988, 0, 78000);

        // Add all to ArrayList<Worker>
        workers.add(w1);
        workers.add(w2);
        workers.add(w3);
        workers.add(s1);
        workers.add(s2);
        workers.add(s3);

        System.out.println("Workers created successfully.");
    }
}
