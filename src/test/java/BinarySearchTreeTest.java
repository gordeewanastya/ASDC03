import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private BinarySearchTree bst;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        bst = new BinarySearchTree();
        bst.insert(new Student("Ethan","Thompson","Science",2001,2018,1024000000024L));
        bst.insert(new Student("Mia","Jackson","Arts",2002,2019,1020000000020L));
        bst.insert(new Student("Noah","Lee","Engineering",2003,2020,1037000000037L));
        bst.insert(new Student("Olivia","Martinez","Business",2000,2017,1028000000028L));
        bst.insert(new Student("Sophia","Thompson","Arts",2002,2019,1003000000003L));
    }

    @Test
    void preOrderTraversal() {
        bst.preOrderTraversal();
        String expected = "Student{firstName='Ethan', lastName='Thompson', faculty='Science', yearOfBirth=2001, yearOfAdmission=2018, identificationNumber=1024000000024}\n" +
                "Student{firstName='Mia', lastName='Jackson', faculty='Arts', yearOfBirth=2002, yearOfAdmission=2019, identificationNumber=1020000000020}\n" +
                "Student{firstName='Sophia', lastName='Thompson', faculty='Arts', yearOfBirth=2002, yearOfAdmission=2019, identificationNumber=1003000000003}\n" +
                "Student{firstName='Noah', lastName='Lee', faculty='Engineering', yearOfBirth=2003, yearOfAdmission=2020, identificationNumber=1037000000037}\n" +
                "Student{firstName='Olivia', lastName='Martinez', faculty='Business', yearOfBirth=2000, yearOfAdmission=2017, identificationNumber=1028000000028}\n";

        assertEquals(
                expected.replaceAll("\n", "").replaceAll("\r", ""),
                outputStreamCaptor.toString().replaceAll("\n", "").replaceAll("\r", "")
                );
    }

    @Test
    void postOrderTraversal() {
        bst.postOrderTraversal();
        String expected = "Student{firstName='Sophia', lastName='Thompson', faculty='Arts', yearOfBirth=2002, yearOfAdmission=2019, identificationNumber=1003000000003}\n" +
                "Student{firstName='Mia', lastName='Jackson', faculty='Arts', yearOfBirth=2002, yearOfAdmission=2019, identificationNumber=1020000000020}\n" +
                "Student{firstName='Olivia', lastName='Martinez', faculty='Business', yearOfBirth=2000, yearOfAdmission=2017, identificationNumber=1028000000028}\n" +
                "Student{firstName='Noah', lastName='Lee', faculty='Engineering', yearOfBirth=2003, yearOfAdmission=2020, identificationNumber=1037000000037}\n" +
                "Student{firstName='Ethan', lastName='Thompson', faculty='Science', yearOfBirth=2001, yearOfAdmission=2018, identificationNumber=1024000000024}";

        assertEquals(
                expected.replaceAll("\n", "").replaceAll("\r", ""),
                outputStreamCaptor.toString().replaceAll("\n", "").replaceAll("\r", "")
        );

    }

    @Test
    void inOrderTraversal() {
        bst.inOrderTraversal();

        String expected = "Student{firstName='Sophia', lastName='Thompson', faculty='Arts', yearOfBirth=2002, yearOfAdmission=2019, identificationNumber=1003000000003}\n" +
                "Student{firstName='Mia', lastName='Jackson', faculty='Arts', yearOfBirth=2002, yearOfAdmission=2019, identificationNumber=1020000000020}\n" +
                "Student{firstName='Ethan', lastName='Thompson', faculty='Science', yearOfBirth=2001, yearOfAdmission=2018, identificationNumber=1024000000024}\n" +
                "Student{firstName='Olivia', lastName='Martinez', faculty='Business', yearOfBirth=2000, yearOfAdmission=2017, identificationNumber=1028000000028}\n" +
                "Student{firstName='Noah', lastName='Lee', faculty='Engineering', yearOfBirth=2003, yearOfAdmission=2020, identificationNumber=1037000000037}";

        assertEquals(
                expected.replaceAll("\n", "").replaceAll("\r", ""),
                outputStreamCaptor.toString().replaceAll("\n", "").replaceAll("\r", "")
        );
    }

    @Test
    void insert() {
        bst.insert(new Student("Jacob","Caleb","Literature",1997,2020,10895000000024L));
        assertEquals(new Student("Jacob","Caleb","Literature",1997,2020,10895000000024L),bst.search(10895000000024L));
    }

    @Test
    void delete() {
        bst.delete(new Student("Olivia","Martinez","Business",2000,2017,1028000000028L));
        assertNotEquals(new Student("Olivia","Martinez","Business",2000,2017,1028000000028L),bst.search(1028000000028L));
    }
}
