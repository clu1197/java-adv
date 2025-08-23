package OOP;

public class Burger extends Item {
    private Item extra1;
    private Item extra2;
    private Item extra3;

    public Burger(String name, double price) {
        super("BURGER", name, price);
    }

    @Override
    public String getName() {
        return super.getName() + " BURGER";
    }

    @Override
    public double getAdjustedPrice() {
        return getBasePrice() +
                ((extra1 == null) ? 0 : extra1.getAdjustedPrice()) +
                ((extra2 == null) ? 0 : extra2.getAdjustedPrice()) +
                ((extra3 == null) ? 0 : extra3.getAdjustedPrice());
    }

    public double getExtraPrice(String toppingName) {
        return switch (toppingName.toUpperCase()) {
            case "AVOCADO", "CHEESE" -> 1.0;
            case "BACON", "HAM", "SALAMI" -> 1.5;
            default -> 0.0;
        };
    }

    public void addToppings(String extra1Name, String extra2Name, String extra3Name) {
        this.extra1 = new Item("TOPPING", extra1Name, getExtraPrice(extra1Name));
        this.extra2 = new Item("TOPPING", extra2Name, getExtraPrice(extra2Name));
        this.extra3 = new Item("TOPPING", extra3Name, getExtraPrice(extra3Name));
    }

    public void addToppings(String extra1Name, String extra2Name) {
        this.extra1 = new Item("TOPPING", extra1Name, getExtraPrice(extra1Name));
        this.extra2 = new Item("TOPPING", extra2Name, getExtraPrice(extra2Name));
    }

    public void addToppings(String extra1Name) {
        this.extra1 = new Item("TOPPING", extra1Name, getExtraPrice(extra1Name));
    }

    protected void printItemizedList() {
        Item.printItem("BASE BURGER", getBasePrice());
        if (extra1 != null) {
            extra1.printItem();
        }
        if (extra2 != null) {
            extra2.printItem();
        }
        if (extra3 != null) {
            extra3.printItem();
        }
    }

    @Override
    public void printItem() {
        printItemizedList();
        System.out.println("-".repeat(30));
        super.printItem();
    }
}