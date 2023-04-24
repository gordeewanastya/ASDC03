import java.util.LinkedList;
import java.util.Queue;

/**
 * Класс для работы с динамической структрурой - очередью, с элементами типа - Student
 * @author Gordeeva Anastasia
 * */
public class QueueOfStudents {
    private Queue<Student> students = new LinkedList<>();

    /**
     * Проходит по элементам очереди и выводит их на экран
     * @author Gordeeva Anastasia
     * */
    public void traverseAndPrint() {
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("\n\n--------------------\n\n");
    }

    /**
     * Вставляет новый элемент в конец очереди
     * @author Gordeeva Anastasia
     * */
    public void addStudent(Student student) {
        students.offer(student);
    }

    /**
     * Поиск студента указанного как аргумент в очереди
     * @return true / false в зависимости от результата поиска
     * @author Gordeeva Anastasia
     * */
    public boolean lookFor(Student student) {
        return students.contains(student);
    }

    /**
     * Удаляет первого студента стоящего в начале очереди
     * @return удаленного студента
     * @author Gordeeva Anastasia
     * */
    public Student deleteStudent() {
        return students.poll();
    }




}
