import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/students.csv");
        ReaderCSV readerCSV = new ReaderCSV();

        /**
         * Считываем студентов с файла .csv в Queue
         * */
        QueueOfStudents students = readerCSV.readFromFile(file);
//
//        /**
//         * обход и вывод
//         * */
//        students.traverseAndPrint();
//
//        /**
//         * вставка в конец очереди
//         * */
//        students.addStudent(new Student("ANASTASIA", "GORDEEVA", "COMPUTER SCIENCE",
//                2003,2021,2004560268997L));
//
//        students.traverseAndPrint();
//
//
//        /**
//         * поиск
//         * */
//        String result = students.lookFor(new Student("ANASTASIA", "GORDEEVA", "COMPUTER SCIENCE",
//                2003,2021,2004560268997L)) ?
//        "\nSuccesfully found required student\n" : "\nStudent does not exist\n";
//
//        System.out.println(result);
//
//        /**
//         * удаление из начала очереди
//         * */
//
//        students.deleteStudent();
//
//        students.traverseAndPrint();

        /**Работа с бинарным деревом*/
        System.out.println("___Binary Tree Search:___");
        BinarySearchTree tree = new BinarySearchTree();

        /**Вставка элементов в бинарное дерево*/
        for(Student stud: students){
            tree.insert(stud);
        }
        /**Обход в прямом порядке*/
        tree.preOrderTraversal();


        /**Удаление элемента из бинарного дерева*/
        tree.delete(new Student("Chloe","Bailey","Arts",
                2002,2019,1005000000005L));


        /**Обход в обратном порядке*/
        tree.postOrderTraversal();


        /**Поиск в бинарном дереве*/
        long studentIDNPtoSearch = 1027000000027L;
        tree.resultOfBinaryTreeSearch(tree.search(studentIDNPtoSearch),studentIDNPtoSearch);

        /**Обход в центрированном порядке*/
        tree.inOrderTraversal();

    }
}