package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class MapView {
    public static void main(String[] args) {
        // Create a sample HashMap
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Charlie", 95);

        System.out.println("Original Map: " + scores);
        System.out.println("--------------------------------");

        // 1. keySet() → returns a Set of keys
        Set<String> keys = scores.keySet();
        System.out.println("Keys: " + keys);

        // Iterate over keys
        for (String key : keys) {
            System.out.println("Key = " + key + ", Value = " + scores.get(key));
        }
        System.out.println("--------------------------------");

        // 2. values() → returns a Collection of values
        Collection<Integer> values = scores.values();
        System.out.println("Values: " + values);

        // Iterate over values
        for (Integer value : values) {
            System.out.println("Score = " + value);
        }
        System.out.println("--------------------------------");

        // 3. entrySet() → returns a Set of Map.Entry objects (key-value pairs)
        Set<Map.Entry<String, Integer>> entries = scores.entrySet();
        System.out.println("Entries: " + entries);

        // Iterate over entries
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        System.out.println("--------------------------------");

        // Bonus: modifying via entrySet
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getKey().equals("Alice")) {
                entry.setValue(100); // update Alice's score
            }
        }
        System.out.println("After modifying via entrySet: " + scores);
    }
}
