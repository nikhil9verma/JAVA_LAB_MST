import java.util.*;

class StudentListEmptyException extends Exception {
    public StudentListEmptyException(String message) {
        super(message);
    }
}

class StudentManager {
    private ArrayList<String> students = new ArrayList<>();

    public void addStudent(String name) {
        students.add(name);
    }

    public void removeStudent(String name) {
        students.remove(name);
    }

    public void displayStudents() throws StudentListEmptyException {
        if (students.isEmpty()) {
            throw new StudentListEmptyException("Student list is empty!");
        }
        ArrayList<String> sortedList = new ArrayList<>(students);
        Collections.sort(sortedList);
        System.out.println("Sorted names: " + String.join(", ", sortedList));
    }
}

public class studentDemo
 {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.addStudent("Alice");
        manager.addStudent("Bob");
        manager.addStudent("Charlie");
        try {
            manager.displayStudents();
            System.out.println("Removing Bob...");
            manager.removeStudent("Bob");
            manager.displayStudents();
            System.out.println("Removing Alice and Charlie...");
            manager.removeStudent("Alice");
            manager.removeStudent("Charlie");
            manager.displayStudents();
        } catch (StudentListEmptyException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}