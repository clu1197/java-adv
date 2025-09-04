package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaIntro {

    // Record to hold person data
    record Person(String firstName, String lastName) {
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Lucy", "Van Pelt"),
                new Person("Sally", "Brown"),
                new Person("Pepper", "Brown"),
                new Person("Alice", "Luke")
        ));

        // Example 1: Using an anonymous Comparator class
        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName().compareTo(o2.lastName());
            }
        });
        System.out.println("Sorted by last name (anonymous class): " + people);

        // Example 2: Using a lambda expression (shorter)
        people.sort((o1, o2) -> o1.lastName().compareTo(o2.lastName()));
        System.out.println("Sorted by last name (lambda): " + people);

        // Example 3: Multi-level comparator with an inner interface
        interface EnhancedComparator<T> extends Comparator<T> {
            int secondLevel(T o1, T o2);
        }

        var comparatorMixed = new EnhancedComparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName().compareTo(o2.lastName());
                return (result == 0 ? secondLevel(o1, o2) : result);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName().compareTo(o2.firstName());
            }
        };

        people.sort(comparatorMixed);
        System.out.println("Sorted by last name, then first name: " + people);
    }
}
