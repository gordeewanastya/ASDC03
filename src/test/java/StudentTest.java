import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    public void testDefaultConstructor(){
        Student s = new Student();
        assertEquals("", s.getFirstName());
        assertEquals("", s.getLastName());
        assertEquals("", s.getFaculty());
    }


    @Test
    public void testConstructorWithParameters(){
        String firstName = "John";
        String lastName = "Doe";
        String faculty = "Computer Science";
        int yearOfBirth = 1998;
        int yearOfAdmission = 2017;
        long identificationNumber = 123456789;

        Student s = new Student(firstName, lastName, faculty, yearOfBirth, yearOfAdmission, identificationNumber);

        assertEquals(firstName, s.getFirstName());
        assertEquals(lastName, s.getLastName());
        assertEquals(faculty, s.getFaculty());
        assertEquals(yearOfBirth, s.getYearOfBirth());
        assertEquals(yearOfAdmission, s.getYearOfAdmission());
        assertEquals(identificationNumber, s.getIdentificationNumber());
    }


    @Test
    public void testCopyConstructor(){
        String firstName = "John";
        String lastName = "Doe";
        String faculty = "Computer Science";
        int yearOfBirth = 1998;
        int yearOfAdmission = 2017;
        long identificationNumber = 123456789;

        Student s1 = new Student(firstName, lastName, faculty, yearOfBirth, yearOfAdmission, identificationNumber);
        Student s2 = new Student(s1);

        assertEquals(s1, s2);
    }


    @Test
    public void testEquals(){
        String firstName = "John";
        String lastName = "Doe";
        String faculty = "Computer Science";
        int yearOfBirth = 1998;
        int yearOfAdmission = 2017;
        long identificationNumber = 123456789;

        Student s1 = new Student(firstName, lastName, faculty, yearOfBirth, yearOfAdmission, identificationNumber);
        Student s2 = new Student(firstName, lastName, faculty, yearOfBirth, yearOfAdmission, identificationNumber);
        Student s3 = new Student(firstName, lastName, faculty, yearOfBirth, yearOfAdmission, 987654321);

        assertTrue(s1.equals(s2));
        assertFalse(s1.equals(s3));
    }


    @Test
    public void testClone(){
        String firstName = "John";
        String lastName = "Doe";
        String faculty = "Computer Science";
        int yearOfBirth = 1998;
        int yearOfAdmission = 2017;
        long identificationNumber = 123456789;

        Student s1 = new Student(firstName, lastName, faculty, yearOfBirth, yearOfAdmission, identificationNumber);

        try {
            Student s2 = s1.clone();
            assertEquals(s1, s2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testCreateStudent() {
        String firstName = "John";
        String lastName = "Doe";
        String faculty = "Mathematics";
        int yearOfBirth = 2000;
        int yearOfAdmission = 2020;
        long identificationNumber = 123456789;

        Student s = new Student(firstName, lastName, faculty, yearOfBirth, yearOfAdmission, identificationNumber);

        assertEquals(firstName, s.getFirstName());
        assertEquals(lastName, s.getLastName());
        assertEquals(faculty, s.getFaculty());
        assertEquals(yearOfBirth, s.getYearOfBirth());
        assertEquals(yearOfAdmission, s.getYearOfAdmission());
        assertEquals(identificationNumber, s.getIdentificationNumber());
    }

    @Test
    public void testEqualsAndHashCode() {
        String firstName = "John";
        String lastName = "Doe";
        String faculty = "Mathematics";
        int yearOfBirth = 2000;
        int yearOfAdmission = 2020;
        long identificationNumber = 123456789;

        Student s1 = new Student(firstName, lastName, faculty, yearOfBirth, yearOfAdmission, identificationNumber);
        Student s2 = new Student(firstName, lastName, faculty, yearOfBirth, yearOfAdmission, identificationNumber);
        Student s3 = new Student(firstName, lastName, faculty, yearOfBirth, yearOfAdmission, 987654321);

        assertTrue(s1.equals(s2));
        assertFalse(s1.equals(s3));
        assertEquals(s1.hashCode(), s2.hashCode());
        assertNotEquals(s1.hashCode(), s3.hashCode());
    }

    @Test
    public void testCloneMethod() throws CloneNotSupportedException {
        String firstName = "John";
        String lastName = "Doe";
        String faculty = "Mathematics";
        int yearOfBirth = 2000;
        int yearOfAdmission = 2020;
        long identificationNumber = 123456789;

        Student s1 = new Student(firstName, lastName, faculty, yearOfBirth, yearOfAdmission, identificationNumber);
        Student s2 = s1.clone();

        assertEquals(s1, s2);
        assertNotSame(s1, s2);
    }

    @Test
    public void testCompareTo() {
        Student s1 = new Student("John", "Doe", "Mathematics", 2000, 2020, 123456789);
        Student s2 = new Student("Jane", "Doe", "Computer Science", 1999, 2019, 987654321);
        Student s3 = new Student("Alice", "Smith", "Physics", 2001, 2021, 123456789);

        assertTrue(s1.compareTo(s2) < 0);
        assertTrue(s1.compareTo(s3) == 0);

    }

}