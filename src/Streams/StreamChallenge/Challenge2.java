package Streams.StreamChallenge;

import Streams.StreamOperationChallenge.Course;
import Streams.StreamOperationChallenge.CourseEngagement;
import Streams.StreamOperationChallenge.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Challenge2 {
    public static void main(String[] args) {
        // 1. Define Courses
        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);
        Course jgames = new Course("JGAME", "Creating games in Java"); // default lectures

        // 2. Get the current year
        int currentYear = LocalDate.now().getYear();

        // 3. Generate 1000 random students enrolled in the last 4 years
        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(jmc, pymc, jgames)) // generate students with random courses
                .filter(s -> s.getYearEnrolled() >= (currentYear - 4))       // filter for recent students
                .limit(1000)                                                 // limit to 1000 students
                .toList();

        // 4. Quick check: print first 10 students to verify randomization
        students.subList(0, 10).forEach(System.out::println);

        // 5. Summary statistics for enrollment years
        System.out.println(students
                .stream()
                .mapToInt(Student::getYearEnrolled)
                .summaryStatistics());

        // 6. Number of courses per student
        System.out.println(students
                .stream()
                .mapToInt(s -> s.getEngagementMap().size()) // engagementMap size = number of courses
                .summaryStatistics());

        // 7. Number of students per course
        var mappedActivity = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream()) // flatten all course engagements
                .collect(Collectors.groupingBy(
                        CourseEngagement::getCourseCode,   // group by course code
                        Collectors.counting()));           // count students per course
        mappedActivity.forEach((k, v) -> System.out.println(k + " " + v));

        // 8. Number of students taking 1, 2, or 3 courses
        var classCounts = students.stream()
                .collect(Collectors.groupingBy(
                        s -> s.getEngagementMap().size(),   // group by number of courses
                        Collectors.counting()));           // count students in each group
        classCounts.forEach((k, v) -> System.out.println(k + " " + v));

        // 9. Average percentage complete per course
        var percentages = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream()) // flatten course engagements
                .collect(Collectors.groupingBy(
                        CourseEngagement::getCourseCode,                  // group by course code
                        Collectors.summarizingDouble(CourseEngagement::getPercentComplete))); // summary statistics
        percentages.forEach((k, v) -> System.out.println(k + " " + v));

        // 10. Nested Map: students grouped by course code then last activity year
        var yearMap = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(
                        CourseEngagement::getCourseCode,                 // top-level key
                        Collectors.groupingBy(
                                CourseEngagement::getLastActivityYear,  // nested key
                                Collectors.counting())));                // count per nested group
        yearMap.forEach((k, v) -> System.out.println(k + " " + v));

        // 11. Nested Map: students grouped by enrollment year then course code
        students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(
                        CourseEngagement::getEnrollmentYear,             // top-level key
                        Collectors.groupingBy(
                                CourseEngagement::getCourseCode,       // nested key
                                Collectors.counting())))                // count per nested group
                .forEach((k, v) -> System.out.println(k + ": " + v));

        // Notes:
        // - flatMap() flattens nested lists into a single stream for processing
        // - groupingBy() organizes data by a key, optionally with a downstream collecto  r
        // - counting() counts elements per group
        // - summarizingDouble() calculates min, max, sum, average for numeric values
        // - Nested groupingBy enables multi-level aggregation (e.g., course -> year -> count)
    }
}
