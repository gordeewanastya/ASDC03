
/**
 * Implementation of binary tree to store instances of Student class
 * @author Gordeeva Anastasia
 * */
public class BinarySearchTree {
    private Node root;

    /**
     * A class representing a single node of the binary tree
     * @author Gordeeva Anastasia
     * @see BinarySearchTree
     * */
    private class Node {
        private Student student;
        private Node left;
        private Node right;

        public Node(Student student) {
            this.student = student;
            this.left = null;
            this.right = null;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(new Student("Ethan","Thompson","Science",2001,2018,1024000000024L));
        bst.insert(new Student("Mia","Jackson","Arts",2002,2019,1020000000020L));
        bst.insert(new Student("Noah","Lee","Engineering",2003,2020,1037000000037L));
        bst.insert(new Student("Olivia","Martinez","Business",2000,2017,1028000000028L));
        bst.insert(new Student("Sophia","Thompson","Arts",2002,2019,1003000000003L));

        bst.inOrderTraversal();
    }

    /**
     * Обход binary tree в прямом порядке
     * Сверху-вниз, то есть корень посещается раньше, чем его поддеревья
     * @author Gordeeva Anastasia
     * */
    public void preOrderTraversal() {
//        System.out.println("\n\nTraverse Pre Order: \n\n");
        preOrderTraversal(root);
//        System.out.println("\n\n=============\n\n");
    }


    /**
     * Реализует обход binary tree в прямом порядке
     * Сверху-вниз, то есть корень посещается раньше, чем его поддеревья
     * @author Gordeeva Anastasia
     * */
    private void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.println(node.student);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    /**
     * Обход binary tree в обратном порядке
     * Снизу-вверх, то есть корень посещается позже, чем его поддеревья
     * @author Gordeeva Anastasia
     * */
    public void postOrderTraversal() {
//        System.out.println("\n\nTraverse Post Order: \n\n");
        postOrderTraversal(root);
//        System.out.println("\n\n=============\n\n");
    }


    /**
     * Реализует обход binary tree в обратном порядке
     * Снизу-вверх, то есть корень посещается позже, чем его поддеревья
     * @author Gordeeva Anastasia
     * */
    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.student);
        }
    }

    /**
     * Обход binary tree в центрированном/симметричном порядке
     * Левое поддерево, потом корень посещается , потом правое поддерево
     * @author Gordeeva Anastasia
     * */
    public void inOrderTraversal(){
//        System.out.println("\n\nTraverse In Order: \n\n");
        inOrderTraversal(root);
//        System.out.println("\n\n=============\n\n");
    }


    /**
     * Реализует обход binary tree в центрированном/симметричном порядке
     * Левое поддерево, потом корень посещается , потом правое поддерево
     * @author Gordeeva Anastasia
     * */
    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.student);
            inOrderTraversal(node.right);
        }
    }


    /**
     * Вставка элемента в  binary tree
     * @see BinarySearchTree#insert(Node, Student)
     * @author Gordeeva Anastasia
     * */
    public void insert(Student student) {
        root = insert(root, student);
    }

    /**
     * Реализует основную логику вставки элемента в  binary tree
     * @author Gordeeva Anastasia
     * */
    private Node insert(Node node, Student student) {
        if (node == null) {
            return new Node(student);
        }

        if (student.getIdentificationNumber() < node.student.getIdentificationNumber()) {
            node.left = insert(node.left, student);
        } else if (student.getIdentificationNumber() > node.student.getIdentificationNumber()) {
            node.right = insert(node.right, student);
        }

        return node;
    }

    /**
     * Удаление элемента в  binary tree
     * @see BinarySearchTree#delete(Node, Student)
     * @author Gordeeva Anastasia
     * */
    public void delete(Student student) {
        root = delete(root, student);
    }

    /**
     * Реализация логики удаления элемента в  binary tree
     * @see BinarySearchTree#delete(Student)
     * @author Gordeeva Anastasia
     * */
    private Node delete(Node node, Student student) {
        if (node == null) {
            return null;
        }

        //Node to delete found
        if (student.getIdentificationNumber() == node.student.getIdentificationNumber()) {
            //A node has no children:
            if (node.left == null && node.right == null) {
                return null;
            }

            //A node has exactly one child:
            if (node.right == null) {
                return node.left;
            }

            if (node.left == null) {
                return node.right;
            }


            //Case when a node has 2 children
            //First figure out who will replace the deleted node:
            Student smallestValue = findSmallestValue(node.right);
            node.student = smallestValue;
            node.right = delete(node.right, smallestValue);
            return node;

        }
        if (student.getIdentificationNumber() < node.student.getIdentificationNumber()) {
            node.left = delete(node.left, student);
            return node;
        }
        node.right = delete(node.right, student);
        return node;
    }

    /**
     * Вспомогательный метод для поиска минимального значения узла
     * @author Gordeeva Anastasia
     * */
    private Student findSmallestValue(Node node) {
        return node.left == null ? node.student : findSmallestValue(node.left);
    }

    /**
     * Поиск элемента в  binary tree
     * @see BinarySearchTree#search(Node,long) 
     * @author Gordeeva Anastasia
     * */
    public Student search(long id) {
        Node node = search(root, id);

        if (node == null) {
            return null;
        } else {
            return node.student;
        }
    }


    /**
     * Реализует основную логику поиска элемента в  binary tree
     * @author Gordeeva Anastasia
     * */
    private Node search(Node node, long id) {
        if (node == null || node.student.getIdentificationNumber() == id) {
            return node;
        }

        if (id < node.student.getIdentificationNumber()) {
            return search(node.left, id);
        } else {
            return search(node.right, id);
        }
    }


    /**
     * Оформление вывода результата поиска ({@link BinarySearchTree#search(long) search(long)}) в binary tree
     * @author Gordeeva Anastasia
     * */
    public void resultOfBinaryTreeSearch(Student foundStudent, Long studentIDNPtoSearch){

        if (foundStudent == null) {
            System.out.println("Student with identification number " + studentIDNPtoSearch + " not found.");
        } else {
            System.out.println("Found student: " + foundStudent.getFirstName() + " " + foundStudent.getLastName());
        }
    }
}
