package lambda.expression.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Demonstrates various array and list operations using lambda expressions
 * to transform names through different operations.
 */
public class ArrayListChallenge {
    private static final Random random = new Random();

    public static void main(String[] args) {
        // Initialize array with sample names
        String[] names = {"Anna", "Bob", "Carol", "David", "Ed", "Fred"};

        // Transform all names to uppercase
        transformToUppercase(names);

        // Add random middle initials to each name
        addRandomMiddleInitials(names);

        // Add reversed first name as last name
        addReversedLastNames(names);

        // Remove names where first name equals last name
        removeNamesWithMatchingFirstAndLast(names);
    }

    /**
     * Transforms all names in the array to uppercase
     */
    private static void transformToUppercase(String[] names) {
        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println("--> Transform to Uppercase");
        System.out.println(Arrays.toString(names));
        System.out.println();
    }

    /**
     * Adds random middle initials (A-D) to each name
     */
    private static void addRandomMiddleInitials(String[] names) {
        List<String> backedByArray = Arrays.asList(names);
        backedByArray.replaceAll(name -> name + " " + getRandomChar('A', 'D') + ".");

        System.out.println("--> Add random middle initial");
        System.out.println(Arrays.toString(names));
        System.out.println();
    }

    /**
     * Adds the reversed first name as the last name to each entry
     */
    private static void addReversedLastNames(String[] names) {
        List<String> backedByArray = Arrays.asList(names);
        backedByArray.replaceAll(name -> name + " " + getReversedName(name.split(" ")[0]));

        System.out.println("--> Add reversed name as last name");
        Arrays.asList(names).forEach(System.out::println);
        System.out.println();
    }

    /**
     * Creates a new list and removes names where the first name equals the last name
     */
    private static void removeNamesWithMatchingFirstAndLast(String[] names) {
        List<String> filteredList = new ArrayList<>(List.of(names));

        // Remove entries where first name equals last name
        filteredList.removeIf(name -> {
            String firstName = name.substring(0, name.indexOf(" "));
            String lastName = name.substring(name.lastIndexOf(" ") + 1);
            return firstName.equals(lastName);
        });

        System.out.println("--> Remove names where first = last");
        filteredList.forEach(System.out::println);
    }

    /**
     * Generates a random character between the specified start and end characters (inclusive)
     *
     * @param startChar the starting character of the range
     * @param endChar   the ending character of the range
     * @return a random character within the specified range
     */
    private static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt(startChar, endChar + 1);
    }

    /**
     * Returns the reversed version of the given string
     *
     * @param firstName the string to reverse
     * @return the reversed string
     */
    private static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }
}