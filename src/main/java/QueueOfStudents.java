import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Класс для работы с динамической структрурой - очередью, с элементами типа - Student
 * @author Gordeeva Anastasia
 * */
public class QueueOfStudents implements Iterable<Student>{
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


    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }

    @Override
    public void forEach(Consumer<? super Student> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Student> spliterator() {
        return Iterable.super.spliterator();
    }
}
