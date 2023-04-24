import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/students.csv");
        ReaderCSV readerCSV = new ReaderCSV();

        /**
         * Считываем студентов с файла .csv в Queue
         * */
        QueueOfStudents students = readerCSV.readFromFile(file);

        /**
         * обход и вывод
         * */
        students.traverseAndPrint();

        /**
         * вставка в конец очереди
         * */
        students.addStudent(new Student("ANASTASIA", "GORDEEVA", "COMPUTER SCIENCE",
                2003,2021,2004560268997L));

        students.traverseAndPrint();


        /**
         * поиск
         * */
        String result = students.lookFor(new Student("ANASTASIA", "GORDEEVA", "COMPUTER SCIENCE",
                2003,2021,2004560268997L)) ?
        "\nSuccesfully found required student\n" : "\nStudent does not exist\n";

        System.out.println(result);

        /**
         * удаление из начала очереди
         * */

        students.deleteStudent();

        students.traverseAndPrint();
    }
}