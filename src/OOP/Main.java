package OOP;

public class Main {
    public static void main(String[] args) {
//        OOP.Item coke = new OOP.Item("drink", "coke", 1.5);
//        coke.printItem();
//        coke.setSize("LARGE");
//        coke.printItem();

//        OOP.Burger burger = new OOP.Burger("regular", 4.00);
//        burger.addToppings("BACON", "CHEESE", "MAYO");
//        burger.printItem();

//        OOP.MealOrder regularMeal = new OOP.MealOrder();
//        regularMeal.addBurgerToppings("BACON", "CHEESE", "MAYO");
//        regularMeal.setDrinkSize("Large");
//        regularMeal.setSideSize("Small");
//        regularMeal.printItemizedList();

        MealOrder deluxeMeal = new MealOrder("deluxe", "7-up", "chili");
        deluxeMeal.addBurgerToppings("AVOCADO", "BACON", "LETTUCE", "CHEESE", "MAYO");
        deluxeMeal.setDrinkSize("Small");
        deluxeMeal.printItemizedList();

    }
}
