package Streams.TerminalOperations;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Tom", "Tim", "Tina", "Sam", "Bob");

        // allMatch – check if all names start with 'T'
        boolean allStartWithT = names.stream()
                .allMatch(name -> name.startsWith("T"));
        System.out.println("All start with T? " + allStartWithT); // false

        // anyMatch – check if any name starts with 'S'
        boolean anyStartWithS = names.stream()
                .anyMatch(name -> name.startsWith("S"));
        System.out.println("Any start with S? " + anyStartWithS); // true

        // noneMatch – check if no name is longer than 10 characters
        boolean noneLongerThan10 = names.stream()
                .noneMatch(name -> name.length() > 10);
        System.out.println("No name longer than 10? " + noneLongerThan10); // true
    }
}
