package Streams.StreamChallenge;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

    static int counter = 0;
    public static void main(String[] args) {
        int seed = 1;

        // Stream B
        var streamB = Stream.iterate(seed, i -> i <= 15, i -> i + 1)
                .map(i -> "B" + i);
        streamB.forEach(System.out::println);
        System.out.println("-----------------------------------------------");

        // Stream I
        seed += 15;
        var streamI = Stream.iterate(seed, i -> i + 1)
                .limit(15).map(i -> "I" + i);
        streamI.forEach(System.out::println);
        System.out.println("-----------------------------------------------");

        // Stream N
        seed += 15;
        int nSeed = seed;
        String[] oLabels = new String[15];
        Arrays.setAll(oLabels, i -> "N" + (nSeed + i));
        var streamN = Arrays.stream(oLabels);
        streamN.forEach(System.out::println);
        System.out.println("-----------------------------------------------");

        // Stream G
        seed += 15;
        int finalSeed = seed;
        var streamG = Stream.generate(Main::getCounter)
                .limit(15)
                .map(i -> "G" + (finalSeed + i));

        // Stream O
        seed += 15;
        int rSeed = seed;
        var streamO = Stream.generate(Main::getCounter)
                .limit(15)
                .map(i -> "O" + (rSeed + i));

        // Concatenation and consumption
        Stream.concat(
                Stream.concat(
                        Stream.concat(
                                Stream.iterate(1, i -> i <= 15, i -> i + 1).map(i -> "B" + i),
                                Stream.iterate(16, i -> i < 31, i -> i + 1).map(i -> "I" + i)
                        ),
                        Arrays.stream(oLabels)
                ),
                Stream.concat(streamG, streamO)
        ).forEach(System.out::println);

        System.out.println("-----------------------------------------------");

        Stream.generate(() -> new Random().nextInt(rSeed, rSeed + 15))
                .distinct()
                .limit(15)
                .map(i -> "O" + i)
                .sorted()
                .forEach(System.out::println);
    }

    public static int getCounter() {
        return counter++;
    }

}