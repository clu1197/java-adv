package collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main collections page");

        Collection<String> list = new TreeSet<>();
        String[] names = {"Anna", "Bob", "Carol", "David", "Emma"};
        list.addAll(Arrays.asList(names));
        System.out.println(list);

        list.add("Fred");
        list.addAll(Arrays.asList("Geroge", "Gary"));
        System.out.println(list);
        System.out.println("Gary is in the list?\n " + list.contains("Gary"));

        list.removeIf(s-> s.charAt(0) == 'G'); // cant use "" -> is a String literal
        System.out.println(list);
        System.out.println("Gary is in the list?\n " + list.contains("Gary"));
    }
}