package lambda.chaining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    record Person(String firstName, String lastName) {}

    public static void main(String[] args) {
        String name = "Tim";

        // ---------------------------
        // FUNCTION BASICS: andThen vs compose
        // ---------------------------
        Function<String, String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));  // TIM

        Function<String, String> lastName = s -> s.concat(" Buchalka");

        // andThen: uCase -> then lastName
        Function<String, String> uCaseLastName = uCase.andThen(lastName);
        System.out.println(uCaseLastName.apply(name));  // TIM Buchalka

        // compose: lastName -> then uCase
        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));  // TIM BUCHALKA


        // ---------------------------
        // FUNCTION CHAINING EXAMPLES
        // ---------------------------

        // f0: Uppercase -> Add last name -> Split into String[]
        Function<String, String[]> f0 = uCase
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.split(" "));
        System.out.println(Arrays.toString(f0.apply(name))); // [TIM, BUCHALKA]

        // f1: Uppercase -> Add last name -> Split -> Rearrange (LAST, FIRST)
        Function<String, String> f1 = uCase
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.split(" "))
                .andThen(s -> s[1].toLowerCase() + ", " + s[0]);
        System.out.println(f1.apply(name)); // buchalka, TIM

        // f2: Uppercase -> Add last name -> Split -> Join -> Get length
        Function<String, Integer> f2 = uCase
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.split(" "))
                .andThen(s -> String.join(", ", s))
                .andThen(String::length);
        System.out.println(f2.apply(name)); // e.g. 12


        // ---------------------------
        // CONSUMERS
        // ---------------------------
        String[] names = {"Ann", "Bob", "Carol"};

        // s0: prints first letter
        Consumer<String> s0 = s -> System.out.print(s.charAt(0));

        // s1: prints whole string with newline
        Consumer<String> s1 = System.out::println;

        // Chain: first char -> then " - " -> then full string on new line
        Arrays.asList(names).forEach(s0
                .andThen(s -> System.out.print(" - "))
                .andThen(s1)
        );
        // Output:
        // A - Ann
        // B - Bob
        // C - Carol


        // ---------------------------
        // PREDICATES
        // ---------------------------
        Predicate<String> p1 = s -> s.equals("TIM");              // exact match
        Predicate<String> p2 = s -> s.equalsIgnoreCase("Tim");    // ignore case
        Predicate<String> p3 = s -> s.startsWith("T");            // starts with T
        Predicate<String> p4 = s -> s.endsWith("e");              // ends with e

        // p1 OR p2 -> true if s == "TIM" OR "Tim" (ignores case for second)
        Predicate<String> combined1 = p1.or(p2);
        System.out.println("combined1 = " + combined1.test(name));

        // p3 AND p4 -> true if starts with T AND ends with e
        Predicate<String> combined2 = p3.and(p4);
        System.out.println("combined2 = " + combined2.test(name));

        // Negation: NOT(p3 AND p4)
        Predicate<String> combined3 = p3.and(p4).negate();
        System.out.println("combined3 = " + combined3.test(name));


        // Create a list of Person objects
        List<Person> list = new ArrayList<>(Arrays.asList(
                new Person("Peter", "Pan"),
                new Person("Peter", "PumpkinEater"),
                new Person("Minnie", "Mouse"),
                new Person("Mickey", "Mouse")
        ));

// -----------------------------------
        // Manual lambda sort by lastName
        // -----------------------------------
        list.sort((o1, o2) -> o1.lastName().compareTo(o2.lastName()));
        list.forEach(System.out::println);

        System.out.println("---------------------------");

        // -----------------------------------
        // Comparator.comparing (by lastName only)
        // -----------------------------------
        list.sort(Comparator.comparing(Person::lastName));
        list.forEach(System.out::println);

        System.out.println("---------------------------");

        // -----------------------------------
        // Comparator.comparing with thenComparing
        // Sort by lastName first, then firstName
        // -----------------------------------
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName).reversed());
        list.forEach(System.out::println);
    }
}