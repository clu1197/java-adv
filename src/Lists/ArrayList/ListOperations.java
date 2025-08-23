package Lists.ArrayList;

import java.util.*;

public class ListOperations {
    public static void main(String[] args) {
        ArrayList<String> groceries = new ArrayList<>();

        // Add immutable and fixed-size lists
        groceries.addAll(List.of("apples", "milk", "mustard", "cheese"));
        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));

        System.out.println("Merged list: " + groceries);

        // Access elements
        System.out.println("Third item: " + groceries.get(2));
        groceries.add("yogurt");
        System.out.println("First yogurt index: " + groceries.indexOf("yogurt"));
        System.out.println("Last yogurt index: " + groceries.lastIndexOf("yogurt"));

        // Clear list
        groceries.clear();
        System.out.println("Cleared list: " + groceries);
        System.out.println("Is empty? " + groceries.isEmpty());
    }
}
