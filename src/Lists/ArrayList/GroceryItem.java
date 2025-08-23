package Lists.ArrayList;

record GroceryItem(String name, String type, int count) {
    GroceryItem(String name) {
        this(name, "DAIRY", 1);
    }
}
