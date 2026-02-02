import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    Worker worker;

    @BeforeEach
    void setUp() {
        // create a worker with $20/hour
        worker = new Worker("John", "Smith", "W001", "Mr.", 1990, 20.0);
    }

    @Test
    void testCalculateWeeklyPay_NoOvertime() {
        double pay = worker.calculateWeeklyPay(40);
        assertEquals(800.0, pay);
    }

    @Test
    void testCalculateWeeklyPay_WithOvertime() {
        double pay = worker.calculateWeeklyPay(50);
        // 40 * 20 = 800
        // 10 * 20 * 1.5 = 300
        // total = 1100
        assertEquals(1100.0, pay);
    }

    @Test
    void testToCSV() {
        String expected = "W001,John,Smith,Mr.,1990,20.0";
        assertEquals(expected, worker.toCSV());
    }

    @Test
    void testToJSON() {
        String json = worker.toJSON();
        assertTrue(json.contains("hourlyPayRate"));
    }

    @Test
    void testToXML() {
        String xml = worker.toXML();
        assertTrue(xml.contains("<hourlyPayRate>"));
    }
}
