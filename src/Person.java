import java.util.Calendar;

/**
 * Person class represents a person with first name, last name, ID, title, and year of birth.
 * This class includes methods to get full name, formal name, age, and CSV/JSON/XML representations.
 */
public class Person {

    // Fields
    private String firstName;
    private String lastName;
    private final String ID; // ID cannot change
    private String title;
    private int YOB; // Year of birth

    /**
     * Constructor to create a Person with all fields
     * @param firstName first name of the person
     * @param lastName last name of the person
     * @param ID unique identifier for the person
     * @param title prefix/title like Mr., Ms., Dr., etc.
     * @param YOB year of birth
     */
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getID() { return ID; }
    public String getTitle() { return title; }
    public int getYOB() { return YOB; }

    // Setters (ID cannot be changed)
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setTitle(String title) { this.title = title; }
    public void setYOB(int YOB) { this.YOB = YOB; }

    /**
     * Returns the full name: firstName + space + lastName
     * @return full name of the person
     */
    public String fullName() {
        return firstName + " " + lastName;
    }

    /**
     * Returns formal name: title + space + fullName
     * @return formal name of the person
     */
    public String formalName() {
        return title + " " + fullName();
    }

    /**
     * Returns the age of the person assuming current year
     * @return age in years
     */
    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - YOB;
    }

    /**
     * Returns age for a specified year
     * @param year the year to calculate age for
     * @return age in years for the specified year
     */
    public int getAge(int year) {
        return year - YOB;
    }

    /**
     * Returns CSV representation of the person
     * @return CSV string
     */
    public String toCSV() {
        return ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }

    /**
     * Returns JSON representation of the person
     * @return JSON string
     */
    public String toJSON() {
        return "{ \"ID\": \"" + ID + "\", \"firstName\": \"" + firstName + "\", " +
                "\"lastName\": \"" + lastName + "\", \"title\": \"" + title + "\", " +
                "\"YOB\": " + YOB + " }";
    }

    /**
     * Returns XML representation of the person
     * @return XML string
     */
    public String toXML() {
        return "<Person><ID>" + ID + "</ID><FirstName>" + firstName + "</FirstName>" +
                "<LastName>" + lastName + "</LastName><Title>" + title + "</Title>" +
                "<YOB>" + YOB + "</YOB></Person>";
    }

    /**
     * Overrides toString to give readable representation of person
     * @return string representation
     */
    @Override
    public String toString() {
        return formalName() + ", born " + YOB;
    }

    /**
     * Overrides equals to compare two Person objects by ID
     * @param obj object to compare with
     * @return true if IDs match
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return this.ID.equals(other.ID);
    }
}