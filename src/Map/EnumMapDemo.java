package Map;
import java.util.*;

//A specialized Map implementation where keys must be enum constants.
//Backed by an array, so it’s faster and smaller than HashMap<Enum, V>.
//Keys are always in the natural order of the enum.

enum Status {
    NEW, IN_PROGRESS, COMPLETED, FAILED
}

public class EnumMapDemo {
    public static void main(String[] args) {
        // Create EnumMap with Status as keys
        EnumMap<Status, String> taskStatus = new EnumMap<>(Status.class);

        taskStatus.put(Status.NEW, "Task created");
        taskStatus.put(Status.IN_PROGRESS, "Task is ongoing");
        taskStatus.put(Status.COMPLETED, "Task done");
        taskStatus.put(Status.FAILED, "Task failed");

        System.out.println("EnumMap: " + taskStatus);

        // Access by key
        System.out.println("Message for COMPLETED: " + taskStatus.get(Status.COMPLETED));

        // Iterating (kept in enum order)
        for (Map.Entry<Status, String> entry : taskStatus.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}
