import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person;

    @BeforeEach
    void setUp() {
        // Create a test Person object
        person = new Person("Frodo", "Baggins", "000002", "Mr.", 1120);
    }

    @Test
    void testFullName() {
        assertEquals("Frodo Baggins", person.fullName());
    }

    @Test
    void testFormalName() {
        assertEquals("Mr. Frodo Baggins", person.formalName());
    }

    @Test
    void testGetAge() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        assertEquals(currentYear - 1120, person.getAge());
    }

    @Test
    void testGetAgeWithYear() {
        // Check age in a specific year
        assertEquals(100, person.getAge(1220));
    }

    @Test
    void testToCSV() {
        assertEquals("000002,Frodo,Baggins,Mr.,1120", person.toCSV());
    }

    @Test
    void testToJSON() {
        String expected = "{ \"ID\": \"000002\", \"firstName\": \"Frodo\", \"lastName\": \"Baggins\", " +
                "\"title\": \"Mr.\", \"YOB\": 1120 }";
        assertEquals(expected, person.toJSON());
    }

    @Test
    void testToXML() {
        String expected = "<Person><ID>000002</ID><FirstName>Frodo</FirstName>" +
                "<LastName>Baggins</LastName><Title>Mr.</Title><YOB>1120</YOB></Person>";
        assertEquals(expected, person.toXML());
    }

    @Test
    void testEquals() {
        Person sameID = new Person("Samwise", "Gamgee", "000002", "Mr.", 1125);
        Person differentID = new Person("Bilbo", "Baggins", "000001", "Mr.", 1060);
        assertTrue(person.equals(sameID));
        assertFalse(person.equals(differentID));
    }

    @Test
    void testSetters() {
        person.setFirstName("Bilbo");
        person.setLastName("Baggins");
        person.setTitle("Dr.");
        person.setYOB(1060);

        assertEquals("Bilbo", person.getFirstName());
        assertEquals("Baggins", person.getLastName());
        assertEquals("Dr.", person.getTitle());
        assertEquals(1060, person.getYOB());
    }
}