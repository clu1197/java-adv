package Lists.AutoBoxing;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main auto boxing");

//        Integer boxedInt = Integer.valueOf(15); // preferred but unnecessary
//        Integer deprecatedBoxing = new Integer(15);
//        int unboxedInt = boxedInt.intValue(); // unnecessary

        // automatic
        Integer autoBoxed = 15;
        int autoUnboxed = autoBoxed; // primitive type
        System.out.println(autoBoxed.getClass().getName());
//        System.out.println(autoUnboxed.getClass().getName()); // invalid, because its a primitive type

//        Double resultBoxed = getLiteralDoublePrimitive();
//        double resultUnboxed = getDoubleObject();

        Integer[] wrapperArray = new Integer[5];
        wrapperArray[0] = 50;
        System.out.println(Arrays.toString(wrapperArray));
        System.out.println(wrapperArray[0].getClass().getName());

        Character[] characterArray = {'a', 'b', 'c', 'd' };
        System.out.println(Arrays.toString(characterArray));

        var ourList = getList(1, 2, 3, 4, 5);
        System.out.println(ourList);


    }


    /**
     * Creates a list of Integers from the given int varargs.
     * Demonstrates varargs usage and auto-boxing of int → Integer.
     */
    private static ArrayList<Integer> getList(int... varargs) {
        ArrayList<Integer> aList = new ArrayList<>();
        for (int i : varargs) {
            aList.add(i);         // auto-boxes int to Integer
        }
        return aList;
    }

    /**
     * Takes an Integer object and returns its primitive int value.
     * Demonstrates auto-unboxing Integer → int.
     */
    private static int returnAnInt(Integer i) {
        return i;                // unboxes Integer to int
    }

    /**
     * Takes a primitive int and returns an Integer object.
     * Demonstrates auto-boxing int → Integer.
     */
    private static Integer returnAnInteger(int i) {
        return i;                // boxes int to Integer
    }

    /**
     * Returns a Double object via Double.valueOf().
     */
    private static Double getDoubleObject() {
        return Double.valueOf(100.00);
    }

    /**
     * Returns a primitive double literal.
     */
    private static double getLiteralDoublePrimitive() {
        return 100.00;
    }
}
