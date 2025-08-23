package Lists.ArrayList;

import java.util.*;

public class SortingAndToArray {
    public static void main(String[] args) {
        ArrayList<String> groceries = new ArrayList<>();
        groceries.addAll(List.of("apples", "milk", "mustard", "cheese"));
        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));

        // Sort
        groceries.sort(Comparator.naturalOrder());
        System.out.println("Sorted list: " + groceries);

        // Convert to array
        String[] groceryArray = groceries.toArray(new String[0]);
        System.out.println("Array: " + Arrays.toString(groceryArray));
    }
}
