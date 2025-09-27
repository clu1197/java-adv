package Streams.TerminalOperationsChallenge;

import Streams.StreamOperationChallenge.*;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // ---------------------------
        // Setup Courses
        // ---------------------------
        Course pymc = new Course("PYMC","Python Masterclass",50);
        Course jmc = new Course("JMC","Java Masterclass",100);
        Course jgames = new Course("JGAME","Creating games in Java");

        // ---------------------------
        // Generate 5000 random students
        // ---------------------------
        // 1) Using Stream.iterate (returns List via .toList -> unmodifiable)
        List<Student> students0 = Stream
                .iterate(1, s -> s <= 5000, s -> s + 1)
                .map(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        // 2) Using IntStream.rangeClosed (map to Students)
        List<Student> students = IntStream
                .rangeClosed(1, 5000)
                .mapToObj(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        // ---------------------------
        // Task 2: Calculate Average Percent Complete for JMC course
        // ---------------------------
        // reduce(identity, accumulator) -> explicit summing
        double totalPercent = students.stream()
                .mapToDouble(s -> s.getPercentComplete("JMC"))
                .reduce(0, Double::sum);

        double averagePercent = totalPercent / students.size();
        System.out.printf("Average Percent complete = %.2f%% %n", averagePercent);

        // OR simply use .sum() (commented out in your code)

        // ---------------------------
        // Task 3: Hard workers
        // ---------------------------
        // Criteria:
        //   - Active this month (.getMonthsSinceActive("JMC") == 0)
        //   - Percent complete >= 1.25 * average (topPercent)
        int topPercent = (int) (1.25 * averagePercent);
        System.out.printf("Best Percentage Complete = %d%% %n", topPercent);

        List<Student> hardWorkers = students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .toList();
        System.out.println("hardWorkers = " + hardWorkers.size());

        // ---------------------------
        // Task 4: Sort hard workers, pick 10, reward with new course
        // ---------------------------
        Comparator<Student> longTermStudent = Comparator.comparing(Student::getYearEnrolled);

        List<Student> rewardedStudents = students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
                .toList();

        rewardedStudents.forEach(s -> {
            s.addCourse(jgames);
            System.out.println(s);
        });

        // ---------------------------
        // Variations on collecting
        // ---------------------------

        // 1) .toList() -> unmodifiable list
        System.out.println("____ toList() __");
        students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
                .toList()
                .forEach(s -> {
                    s.addCourse(jgames);
                    System.out.print(s.getStudentId() + " ");
                });

        // 2) .collect(Collectors.toList()) -> modifiable list
        System.out.println("\n_____ collect(Collectors.toList()) ____");
        students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
                .collect(Collectors.toList())  // difference: gives back ArrayList (modifiable)
                .forEach(s -> {
                    s.addCourse(jgames);
                    System.out.print(s.getStudentId() + " ");
                });

        // 3) .collect(Collectors.toSet()) -> HashSet (no order!)
        System.out.println("\n_____ collect(Collectors.toSet()) ____");
        students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
                .collect(Collectors.toSet()) // throws away sorting, result unordered
                .forEach(s -> {
                    s.addCourse(jgames);
                    System.out.print(s.getStudentId() + " ");
                });

        // 4) .collect(Supplier, Accumulator, Combiner) with TreeSet
        System.out.println("\n_____ collect(Supplier,Accumulator,Combiner) - TreeSet ____");
        students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
                .collect(() -> new TreeSet<>(longTermStudent), TreeSet::add, TreeSet::addAll)
                .forEach(s -> {
                    s.addCourse(jgames);
                    System.out.print(s.getStudentId() + " ");
                });
        // ⚠️ Only one element may appear here!
        // Because TreeSet uses comparator BOTH for sorting AND uniqueness.
        // Students may not be unique by just yearEnrolled -> it discards duplicates.

        // ✅ Fix: Chain comparators (enrolled year, then id)
        Comparator<Student> uniqueSorted = longTermStudent.thenComparing(Student::getStudentId);
        System.out.println("\n_____ collect(Supplier,Accumulator,Combiner) - TreeSet w/ unique comparator ____");
        students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
                .collect(() -> new TreeSet<>(uniqueSorted), TreeSet::add, TreeSet::addAll)
                .forEach(s -> {
                    s.addCourse(jgames);
                    System.out.print(s.getStudentId() + " ");
                });

        // 5) No collection at all -> just act directly in forEach()
        System.out.println("\n_____ Using no collection at all ____");
        students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
                .forEach(s -> {
                    s.addCourse(jgames);
                    System.out.print(s.getStudentId() + " ");
                });
    }
}