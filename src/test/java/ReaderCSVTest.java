import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReaderCSVTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testRead() {
        ReaderCSV reader = new ReaderCSV();
        Student expectedStudent = new Student("John", "Doe", "Mathematics", 3, 90, 1234567890L);
        Student actualStudent = reader.read("John,Doe,Mathematics,3,90,1234567890");
        assertEquals(expectedStudent, actualStudent);
    }



    @Test
    public void testReadFromFile(@TempDir File tempDir) throws IOException {
        // Создание временного файла с тестовыми данными
        File testFile = new File(tempDir, "test.csv");
        String testData = "John,Doe,Mathematics,3,90,1234567890\nJane,Doe,Physics,2,85,2345678901";
        FileUtils.writeStringToFile(testFile, testData, "UTF-8");

        ReaderCSV reader = new ReaderCSV();
        QueueOfStudents expectedQueue = new QueueOfStudents();
        expectedQueue.addStudent(new Student("John", "Doe", "Mathematics", 3, 90, 1234567890L));
        expectedQueue.addStudent(new Student("Jane", "Doe", "Physics", 2, 85, 2345678901L));
        QueueOfStudents actualQueue = reader.readFromFile(testFile);

        assertEquals(expectedQueue, actualQueue);
    }
}