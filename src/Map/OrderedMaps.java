package Map;
import java.util.*;

public class OrderedMaps {
    public static void main(String[] args) {
        // LinkedHashMap → remembers insertion order
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Charlie", 95);
        linkedHashMap.put("Alice", 90);
        linkedHashMap.put("Bob", 85);

        System.out.println("LinkedHashMap (insertion order):");
        linkedHashMap.forEach((k, v) -> System.out.println(k + " => " + v));
        System.out.println("--------------------------------");

        // TreeMap → sorts keys automatically
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Charlie", 95);
        treeMap.put("Alice", 90);
        treeMap.put("Bob", 85);

        System.out.println("TreeMap (sorted by keys):");
        treeMap.forEach((k, v) -> System.out.println(k + " => " + v));
        System.out.println("--------------------------------");

        // TreeMap with custom Comparator (reverse order)
        Map<String, Integer> reverseTreeMap = new TreeMap<>(Comparator.reverseOrder());
        reverseTreeMap.put("Charlie", 95);
        reverseTreeMap.put("Alice", 90);
        reverseTreeMap.put("Bob", 85);

        System.out.println("TreeMap (reverse order):");
        reverseTreeMap.forEach((k, v) -> System.out.println(k + " => " + v));
        System.out.println("--------------------------------");

        // Bonus: LinkedHashMap with access order (like an LRU cache)
        Map<String, Integer> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
        accessOrderMap.put("Charlie", 95);
        accessOrderMap.put("Alice", 90);
        accessOrderMap.put("Bob", 85);

        // Access some elements
        accessOrderMap.get("Alice"); // moves Alice to the end
        accessOrderMap.get("Charlie"); // moves Charlie to the end

        System.out.println("LinkedHashMap (access order):");
        accessOrderMap.forEach((k, v) -> System.out.println(k + " => " + v));
    }
}

