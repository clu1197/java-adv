package Streams.StreamFlatMap;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        // Multi-level map: country -> gender -> list of students
        Map<String, Map<String, List<String>>> multiLevel = Map.of(
                "US", Map.of(
                        "Male", List.of("Bob", "Tom"),
                        "Female", List.of("Alice")
                ),
                "CA", Map.of(
                        "Male", List.of("Charlie"),
                        "Female", List.of("Diana")
                ),
                "UK", Map.of(
                        "Male", List.of("Evan"),
                        "Female", List.of("Fiona")
                )
        );

        // Flatten all students into a single stream
        System.out.println("=== All Students ===");
        multiLevel.values().stream()
                .flatMap(innerMap -> innerMap.values().stream()) // flatten gender maps to lists
                .flatMap(List::stream)                            // flatten lists to strings
                .forEach(System.out::println);

        // Count total students
        long totalStudents = multiLevel.values().stream()
                .flatMap(innerMap -> innerMap.values().stream())
                .flatMap(List::stream)
                .count();
        System.out.println("\nTotal Students: " + totalStudents);

        // Filter students whose names start with 'A'
        var countB = multiLevel.values().stream()
                .flatMap(im -> im.values().stream())
                .flatMap(List::stream)
                .filter(name -> name.startsWith("B"))
                .toList();
        System.out.println(countB);


        long countA = multiLevel.values().stream()
                .flatMap(innerMap -> innerMap.values().stream())
                .flatMap(List::stream)
                .filter(name -> name.startsWith("A"))
                .count();
        System.out.println("Students with names starting with 'A': " + countA);

        // Collect all names into a list
        List<String> allNames = multiLevel.values().stream()
                .flatMap(im -> im.values().stream())
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("All names list: " + allNames);
    }
}
