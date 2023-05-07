import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class QueueOfStudentsTest {

    private QueueOfStudents queue;

    @BeforeEach
    void setUp() {
        queue = new QueueOfStudents();
    }

    @Test
    void testAddStudent() {
        Student student = new Student("John", "Doe", "Mathematics", 3, 90, 1234567890L);
        queue.addStudent(student);

        Assertions.assertTrue(queue.lookFor(student));
        Assertions.assertEquals(student, queue.iterator().next());
    }

    @Test
    void testDeleteStudent() {
        Student student1 = new Student("John", "Doe", "Mathematics", 3, 90, 1234567890L);
        Student student2 = new Student("Jane", "Doe", "Physics", 2, 85, 2345678901L);
        queue.addStudent(student1);
        queue.addStudent(student2);

        Student deletedStudent = queue.deleteStudent();

        Assertions.assertEquals(student1, deletedStudent);
        Assertions.assertFalse(queue.lookFor(student1));
        Assertions.assertTrue(queue.lookFor(student2));
    }


    @Test
    void testTraverseAndPrint() {
        Student student1 = new Student("John", "Doe", "Mathematics", 3, 90, 1234567890L);
        Student student2 = new Student("Jane", "Doe", "Physics", 2, 85, 2345678901L);
        queue.addStudent(student1);
        queue.addStudent(student2);

        Assertions.assertDoesNotThrow(() -> queue.traverseAndPrint());
    }
}