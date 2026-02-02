import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest {

    SalaryWorker salaryWorker;

    @BeforeEach
    void setUp() {
        // annual salary 52000
        salaryWorker = new SalaryWorker("Sarah", "White", "S001",
                "Mrs.", 1980, 0, 52000);
    }

    @Test
    void testCalculateWeeklyPay() {
        double pay = salaryWorker.calculateWeeklyPay(40);
        // 52000 / 52 = 1000
        assertEquals(1000.0, pay);
    }

    @Test
    void testWeeklyPayIgnoresHours() {
        double pay1 = salaryWorker.calculateWeeklyPay(40);
        double pay2 = salaryWorker.calculateWeeklyPay(60);

        assertEquals(pay1, pay2);
    }

    @Test
    void testToCSV() {
        String expected = "S001,Sarah,White,Mrs.,1980,0.0,52000.0";
        assertEquals(expected, salaryWorker.toCSV());
    }

    @Test
    void testToJSON() {
        String json = salaryWorker.toJSON();
        assertTrue(json.contains("annualSalary"));
    }

    @Test
    void testToXML() {
        String xml = salaryWorker.toXML();
        assertTrue(xml.contains("<AnnualSalary>"));
    }
}
