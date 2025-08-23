package Lists.Enums;

import java.util.Random;

public class Main {
    // Main method to demonstrate enum usage
    public static void main(String[] args) {
        DayOfTheWeek weekDay = DayOfTheWeek.TUES;
        System.out.println(weekDay);

        System.out.printf(
                "Name is %s, Ordinal Value = %d%n",
                weekDay.name(),
                weekDay.ordinal()
        );

        for (int i = 0; i < 10; i++) {
            weekDay = getRandomDay();
            switchDayOfWeek(weekDay);
        }

        // use of ENUMS
        for (Topping topping: Topping.values()){
            System.out.println(topping.name() + " : " + topping.getPrice());
        }


    }

    public static void switchDayOfWeek(DayOfTheWeek weekDay) {
        int weekDayInteger = weekDay.ordinal() + 1;
        switch (weekDay) {
            case WED -> System.out.println("Wednesday is Day " + weekDayInteger);
            case SAT -> System.out.println("Saturday is Day " + weekDayInteger);
            default -> System.out.println(weekDay.name().charAt(0) +
                    weekDay.name().substring(1).toLowerCase() +
                    "day is Day.. " + weekDayInteger);
        }
    }

    public static DayOfTheWeek getRandomDay() {
        int randomInteger = new Random().nextInt(7);
        DayOfTheWeek[] allDays = DayOfTheWeek.values();
        return allDays[randomInteger];
    }
}


