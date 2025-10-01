package Streams.StreamMap;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        // 1. Sample student data
        List<Student> students = List.of(
                new Student("Alice", "US", "Female", 22, true, 0),
                new Student("Bob", "US", "Male", 24, false, 1),
                new Student("Charlie", "CA", "Male", 23, true, 0),
                new Student("Diana", "CA", "Female", 25, true, 2),
                new Student("Evan", "UK", "Male", 21, false, 0),
                new Student("Fiona", "UK", "Female", 26, true, 0),
                new Student("Gaurav", "IN", "Male", 20, true, 0),
                new Student("Hema", "IN", "Female", 22, false, 3)
        );

        // 2. Grouping by country
        var groupedByCountry = students.stream()
                .collect(groupingBy(Student::getCountryCode));

        System.out.println("=== Grouped by Country ===");
        groupedByCountry.forEach((country, list) ->
                System.out.println(country + " -> " + list));

        // 3. Filtering within groups (age <= 22)
        var youngStudents = students.stream()
                .collect(groupingBy(Student::getCountryCode,
                        filtering(s -> s.getAge() <= 22, toList())));

        System.out.println("\n=== Young Students (<=22) by Country ===");
        youngStudents.forEach((country, list) ->
                System.out.println(country + " -> " + list));

        // 4. Partitioning by programming experience
        var experienced = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience));

        System.out.println("\n=== Partitioned by Programming Experience ===");
        System.out.println(experienced);
        System.out.println("Experienced: " + experienced.get(true));
        System.out.println("No Experience: " + experienced.get(false));

        // 5. Partitioning with counting
        var expCount = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience, counting()));

        System.out.println("\n=== Count of Experienced vs Not Experienced ===");
        System.out.println(expCount);

        // 6. Nested grouping (Country -> Gender)
//        Map<String, Map<String, List<Student>>> studentsByCountryAndGender
//                = students.stream()
//                .collect(groupingBy(Student::getCountryCode,
//                        groupingBy(Student::getGender)));
        var nestedGrouping = students.stream()
                .collect(groupingBy(Student::getCountryCode,
                        groupingBy(Student::getGender)));

        System.out.println("\n=== Nested Grouping (Country -> Gender) ===");
        System.out.println(nestedGrouping);
        nestedGrouping.forEach((country, genders) -> {
            System.out.println(country + ":");
            genders.forEach((gender, list) ->
                    System.out.println("  " + gender + " -> " + list));
        });

        // 7. Joining names
        var joinedNames = students.stream()
                .map(Student::getName)
                .collect(joining(", "));

        System.out.println("\n=== Joined Names ===");
        System.out.println(joinedNames);


        System.out.println("\n=== activeExperienced ===");
        Map<Boolean, Long> activeExperienced
                = students.stream()
                .collect(Collectors.partitioningBy(
                        s -> s.hasProgrammingExperience() && s.getMonthsSinceActive() == 0,
                        Collectors.counting()
                ));
        System.out.println(activeExperienced);




    }
}



class Student {
    private String name;
    private String countryCode;
    private String gender;
    private int age;
    private boolean hasProgrammingExperience;
    private int monthsSinceActive;

    // Constructor
    public Student(String name, String countryCode, String gender,
                   int age, boolean hasProgrammingExperience, int monthsSinceActive) {
        this.name = name;
        this.countryCode = countryCode;
        this.gender = gender;
        this.age = age;
        this.hasProgrammingExperience = hasProgrammingExperience;
        this.monthsSinceActive = monthsSinceActive;
    }

    // Getters
    public String getName() { return name; }
    public String getCountryCode() { return countryCode; }
    public String getGender() { return gender; }
    public int getAge() { return age; }
    public boolean hasProgrammingExperience() { return hasProgrammingExperience; }
    public int getMonthsSinceActive() { return monthsSinceActive; }

    @Override
    public String toString() {
        return name + "(" + countryCode + ", " + gender + ", " + age + ")";
    }
}
