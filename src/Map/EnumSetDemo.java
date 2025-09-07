package Map;
import java.util.*;

//A specialized Set implementation for enum constants.
//Backed by a bit-vector, so it’s very fast and memory-efficient.
//Always sorted in the natural order of enum constants.

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumSetDemo {
    public static void main(String[] args) {
        // Create EnumSet with specific values
        EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        System.out.println("Weekend: " + weekend);

        // All days
        EnumSet<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println("All days: " + allDays);

        // Working days
        EnumSet<Day> weekdays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
        System.out.println("Weekdays: " + weekdays);

        // Empty and add
        EnumSet<Day> empty = EnumSet.noneOf(Day.class);
        empty.add(Day.MONDAY);
        System.out.println("Empty + Monday: " + empty);

        // Complement
        EnumSet<Day> notWeekend = EnumSet.complementOf(weekend);
        System.out.println("Not weekend: " + notWeekend);
    }
}
