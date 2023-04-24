import java.io.*;


public class ReaderCSV {
    public static final String SEPARATOR = ",";

    public Student read(String str){
        try {
            String[] tokens = str.split(SEPARATOR);
            return Student.create(tokens[0],tokens[1],tokens[2],Integer.parseInt(tokens[3])
                    ,Integer.parseInt(tokens[4]),Long.parseLong(tokens[5]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public  QueueOfStudents readFromFile(File file){
        QueueOfStudents queueOfStudents = new QueueOfStudents();
        String data;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((data = reader.readLine()) != null){
                Student stud = read(data);
                queueOfStudents.addStudent(stud);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return queueOfStudents;
    }
}
