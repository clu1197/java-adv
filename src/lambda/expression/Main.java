package lambda.expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        // Regular enhanced for loop
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("-------");

        // forEach method using lambda
        list.forEach(s -> System.out.println(s));

        // Add more elements and print again
        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(System.out::println);

        System.out.println("-------");

        // Lambda with multiple statements
        String prefix = "nato";
        list.forEach(myString -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + first);
        });

        System.out.println("-------");

        // Remove elements starting with "ea"
        list.removeIf(s -> s.startsWith("ea"));

        // Replace all elements with formatted version
        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        list.forEach(System.out::println);

        System.out.println("-------");

        // Arrays manipulation
        String[] emptyString = new String[10];
        Arrays.fill(emptyString, "");
        Arrays.setAll(emptyString, i -> (i + 1) + ". ");
        Arrays.setAll(emptyString, i -> (i + 1) + ". " + switch (i) {
            case 0 -> "one";
            case 1 -> "two";
            case 2 -> "three";
            default -> "";
        });
        System.out.println(Arrays.toString(emptyString));

        // Random selection example
        String[] names = {"Ann", "Bob", "Carol", "David", "Ed", "Fred"};
        String[] randomList = randomlySelectedValues(15, names, () -> new Random().nextInt(names.length));
        System.out.println(Arrays.toString(randomList));

        // Calculator examples
        calculator((a, b) -> a * b, 4, 5);
        calculator(Integer::sum, 5, 2);
        calculator((a, b) -> a + b, 5, 2);
        calculator((a, b) -> a + b, "Hello ", "World!");
        calculator((a, b) -> a / b, 10.0, 2.5);

        System.out.println("-------");

        // BiConsumer example
        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1566, -90.0659}
        );

        // Print coordinates
        coords.forEach(c -> System.out.println(Arrays.toString(c)));

        // Lambda assigned to a variable
        BiConsumer<Double, Double> p1 = (lat, lng) ->
                System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);

        // Process single point
        double[] firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);

        System.out.println("-------");

        // Process all points
        coords.forEach(c -> processPoint(c[0], c[1], p1));
    }

    // Generic calculator using BinaryOperator
    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }

    // Process two values using BiConsumer
    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }

    // Generate random values from array
    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s) {
        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++) {
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }
}

