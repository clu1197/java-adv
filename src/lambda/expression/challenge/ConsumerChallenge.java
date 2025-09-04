package lambda.expression.challenge;

import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerChallenge {
    public static void main(String[] args) {

        // Anonymous class version of Consumer<String>
        Consumer<String> printWords = new Consumer<>() {
            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        // Equivalent lambda expression (multi-line)
        Consumer<String> printWordsLambda = sentence -> {
            String[] parts = sentence.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        // Lambda expression using forEach with a method reference
        Consumer<String> printWordsForEach = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };

        Consumer<String> printWordsConcise = sentence ->
                Arrays.asList(sentence.split(" "))
                        .forEach(System.out::println);

        // Test executions
        printWords.accept("Lets split this up into an array\n---\n");
        printWordsLambda.accept("Lets split this up into an array\n---\n");
        printWordsForEach.accept("Lets split this up into an array\n---\n");

    }
}
