package Lists.ArrayList;

import java.util.ArrayList;


public class RawVsGenericList {
    public static void main(String[] args) {
        // 1. Raw ArrayList (no generics) – can hold any Object.
        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt");

        // 2. Generic ArrayList<GroceryItem> – type-safe.
        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
        groceryList.add(new GroceryItem("Milk"));
        groceryList.add(new GroceryItem("Oranges", "PRODUCE", 5));
        groceryList.add(0, new GroceryItem("Apple", "PRODUCE", 2));

        System.out.println("objectList  : " + objectList);
        System.out.println("groceryList : " + groceryList);
    }
}
