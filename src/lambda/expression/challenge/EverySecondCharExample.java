package lambda.expression.challenge;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class EverySecondCharExample {
    // you cannot declare a public static method inside the main method
    // challenge 2
    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static void main(String[] args) {
        // Lambda version of everySecondChar

        Function<String, String> everySecondCharLambdaFunction = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        UnaryOperator<String> everySecondCharLambdaUnary = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };


        // Testing the lambda
        System.out.println(everySecondCharLambdaFunction.apply("123456789")); // output: 2468
        System.out.println(everySecondCharLambdaUnary.apply("123456789")); // output: 2468
        String res = everySecondCharAsParam(everySecondCharLambdaFunction, "123456789");
        System.out.println(res);
    }


    /**
     * Mini Challenge 4
     *
     * Instead of executing this function directly, suppose we want to pass it to a method.
     * Write another method on your class, called everySecondCharacter.
     *
     * This method should accept a Function, or UnaryOperator, as a parameter, as well as a second parameter that lets us pass, "1234567890".
     *
     * In other words, don’t hard code that String in your method code.
     *
     * The method code should execute the functional method on the first argument, passing it the value of the String passed, from the enclosing method.
     *
     * It should return the result of the call to the functional method.
     */


    public static String everySecondCharAsParam (Function<String, String> func,
                                                 String source) {
        return func.apply(source);
    }



}