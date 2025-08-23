package Lists.Enums;

public enum Topping {
    MUSTARD, PICKLES, BACON, TOMATO, CHEDDAR;

    public double getPrice() {
        return switch (this) {
            case BACON -> 1.5;
            case CHEDDAR -> 1.0;
            default -> 0.0;
        };
    }
}
