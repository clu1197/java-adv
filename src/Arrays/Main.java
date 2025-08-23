package Arrays;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("MAIN Array FILE");
        int[] list = readIntegers();

//        int[] randomArray = getRandomArray(10);
        for (int num :list){
            System.out.printf(num + " ");
        }


    }


    private static int findMin(int[] array){
        int min = Integer.MAX_VALUE;

        for (int el : array){
            if (el < min){
                min = el;
            }
        }
        return min;
    }

    private static int[] readIntegers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of integers, separated by commas:");
        String  input = scanner.nextLine();

        String[] splits = input.split(",");
        int[] values = new int[splits.length];

        for (int i = 0; i < splits.length; i++){
            values[i] = Integer.parseInt(splits[i].trim());

        }
        return values;
    }

    private static int[] getRandomArray(int len) {
        Random random = new Random();
        int[] newInt = new int[len];
        for (int i = 0; i < len; i ++){
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }
}

