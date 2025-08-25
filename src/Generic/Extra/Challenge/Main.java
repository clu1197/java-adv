package Generic.Extra.Challenge;

import Generic.Extra.Challenge.utils.QueryList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main generic extra challenge page");

        QueryList<LPAStudent> queryList = new QueryList<>();
        for (int i =0; i<25; i++){
            queryList.add(new LPAStudent());
        }

        System.out.println("Ordered");
        queryList.sort((Comparator.naturalOrder()));
        printList(queryList);

        System.out.println("\n\nMatches");
        var matches = queryList.getMatches("percentComplete", "50").getMatches("course", "python");
        printList(matches);


        System.out.println("\n\nLPA Student Comparator");
        matches.sort(new LPAStudentComparator());
        printList(matches);

    }
    public static void printList(List<?> students){
        for (var student: students) {
            System.out.println(student);
        }
    }

}