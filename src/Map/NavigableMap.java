package Map;
import java.util.*;

public class NavigableMap {
    public static void main(String[] args) {
        // Create TreeMap (keys auto-sorted)
        java.util.NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(10, "Alice");
        map.put(20, "Bob");
        map.put(30, "Charlie");
        map.put(40, "Daisy");
        map.put(50, "Eve");

        System.out.println("Original TreeMap: " + map);
        System.out.println("--------------------------------");

        // 1. firstKey / lastKey → smallest & largest key
        System.out.println("First key: " + map.firstKey()); // 10
        System.out.println("Last key: " + map.lastKey());   // 50

        // 2. lowerKey / higherKey → closest smaller/greater key (exclusive)
        System.out.println("Lower than 30: " + map.lowerKey(30));   // 20
        System.out.println("Higher than 30: " + map.higherKey(30)); // 40

        // 3. floorKey / ceilingKey → closest smaller/greater key (inclusive)
        System.out.println("Floor of 30: " + map.floorKey(30));   // 30
        System.out.println("Ceiling of 25: " + map.ceilingKey(25)); // 30

        // 4. headMap / tailMap / subMap → range views
        System.out.println("HeadMap (<30): " + map.headMap(30)); // {10=Alice, 20=Bob}
        System.out.println("TailMap (>=30): " + map.tailMap(30)); // {30=Charlie, 40=Daisy, 50=Eve}
        System.out.println("SubMap (20..40): " + map.subMap(20, true, 40, false));
        // {20=Bob, 30=Charlie}

        // 5. pollFirstEntry / pollLastEntry → remove smallest/largest entry
        Map.Entry<Integer, String> first = map.pollFirstEntry();
        System.out.println("Polled first: " + first);
        Map.Entry<Integer, String> last = map.pollLastEntry();
        System.out.println("Polled last: " + last);
        System.out.println("After polling: " + map);

        // 6. descendingMap → reverse order view
        java.util.NavigableMap<Integer, String> descending = map.descendingMap();
        System.out.println("Descending order: " + descending);
    }
}
