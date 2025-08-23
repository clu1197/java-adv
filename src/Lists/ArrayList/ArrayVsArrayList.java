package Lists.ArrayList;

import java.util.*;

public class ArrayVsArrayList {
    public static void main(String[] args) {
        // Array
        String[] items = {"apple", "eggs", "banana", "milk"};
        // Immutable List from array
        List<String> list = List.of(items);
        // Fully mutable ArrayList, not fixed-size.
        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("tea");

        System.out.println("Immutable list: " + list);
        System.out.println("Mutable ArrayList: " + groceries);
    }
}
