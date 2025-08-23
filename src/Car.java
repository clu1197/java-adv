public class Car {
    private String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        System.out.println("startEngine");
    }

    protected void runEngine() {
        System.out.println("runEngine");
    }

    public void drive() {
        System.out.println("Car -> driving, type: " + getClass().getSimpleName());
        runEngine();
    }

    // ===== Factory Method =====
    public static Car getCar(String type, String description,
                             double efficiency, int cylindersOrBattery) {
        return switch (type.toLowerCase()) {
            case "gas" -> new GasPoweredCar(description, efficiency, cylindersOrBattery);
            case "hybrid" -> new HybridCar(description, efficiency, cylindersOrBattery, cylindersOrBattery);
            case "electric" -> new ElectricCar(description, efficiency, cylindersOrBattery);
            default -> new Car(description); // fallback if unknown type
        };
    }
}


class GasPoweredCar extends Car{
    private double avgKmPeriLiter;
    private int cylinders = 6;

    public GasPoweredCar(String description) {
        super(description);
    }

    public GasPoweredCar(String description, double avgKmPeriLiter, int cylinders) {
        super(description);
        this.avgKmPeriLiter = avgKmPeriLiter;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.printf("Gas -> All %d cylinders are fired up, Ready!%n", cylinders);
    }

    @Override
    protected void runEngine() {
        System.out.printf("Gas -> usage exceeds the average %.2f %n", avgKmPeriLiter);
    }
}

class HybridCar extends Car{
    private double avgKmPeriLiter;
    private int cylinders = 6;
    private int battery = 6;

    public HybridCar(String description) {
        super(description);
    }

    public HybridCar(String description, double avgKmPeriLiter, int cylinders,  int battery) {
        super(description);
        this.avgKmPeriLiter = avgKmPeriLiter;
        this.cylinders = cylinders;
        this.battery = battery;
    }

    @Override
    public void startEngine() {
        System.out.printf("""
        Hyb -> All %d cylinders are fired up, Ready!
        Hyb -> switch %d kWh battery on, Ready!
        """, cylinders, battery);
    }


    @Override
    protected void runEngine() {
        System.out.printf("Hyb -> usage exceeds the average %.2f %n", avgKmPeriLiter);
    }
}


class ElectricCar extends Car{
    private double avgKmPerCharge;
    private int battery = 6;

    public ElectricCar(String description) {
        super(description);
    }

    public ElectricCar(String description, double avgKmPerCharge, int cylinders) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.battery = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.printf("Bev -> All %d kWh battery on, Ready!%n", battery);
    }

    @Override
    protected void runEngine() {
        System.out.printf("Bev -> usage under the average %.2f %n", avgKmPerCharge);
    }
}