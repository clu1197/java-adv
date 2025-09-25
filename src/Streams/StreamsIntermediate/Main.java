package Streams.StreamsIntermediate;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        IntStream.iterate('A', i -> i <= 'z', i -> i + 1)
                .filter(Character::isAlphabetic)
                .dropWhile(i -> i <= 'E') // drop char that satisfy the condition
                .takeWhile(i -> i < 'a')
//                .skip(5)
//                .filter(i -> Character.toUpperCase(i) > 'E') // Compare with character 'E', not string "E"
                .forEach(i -> System.out.printf("%C ", i));


        System.out.println();
        Random random = new Random();
        Stream.generate(()-> random.nextInt('A', 'Z' + 1))
                .limit(50)
                .distinct()
                .sorted()
                .forEach(d -> System.out.printf("%c ", d));


        System.out.println();
        int maxSeats = 100;
        int seatsInRow = 10;
//        var stream = Stream.iterate(0, i -> i < maxSeats, i -> i+1)
//                .map(i -> new Seat((char) ('A' + i/ seatsInRow), i% seatsInRow + 1))
//                .mapToDouble(Seat::price)
//                .mapToObj("%.2f" :: formatted);
        var stream = Stream.iterate(0, i -> i < maxSeats, i -> i+1)
                        .map(i -> new Seat((char) ('A' + i/ seatsInRow), i% seatsInRow + 1))
                        .skip(5)
                        .limit(10)
                        .sorted(Comparator.comparing(Seat::price).thenComparing(Seat::toString));

        stream.forEach(System.out::println);

        List<String> names = List.of("Alice", "Bob", "Charlie");

        names.stream()
                .filter(name -> name.length() > 3)
                .peek(name -> System.out.println("Filtered name: " + name))
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }
}