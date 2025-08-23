package Generic.Extra;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main generic extra page");

        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
//        students.add(new LPAStudent()); // this could work
        printList(students);

        /**
         * generic invariable by default
         * */
        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
        printList(lpaStudents); //does NOT compile with public static void printList(List<Student> students)
    }

//    public static void printList(List<Student> students) {
//        for (var student : students) {
//            System.out.println(student);
//        }
//        System.out.println();
//    }

//    // turn it into a generic method, with upper limit
//    public static <T extends Student> void printList(List<T> students) {
//        for (var student : students) {
//            System.out.println(student);
//        }
//        System.out.println();
//    }

    // turn it into a generic method, with upper limit
    public static void printList(List<? extends Student> students) {
        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
}