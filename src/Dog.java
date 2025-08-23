public class Dog extends Animal{
    private String earShape = "Default";
    private String tailShape;

    public Dog(){
        super("Mutt", "Big", 50);
    }

    public Dog(String type, double weight, String earShape, String tailShape) {
//        String size = weight < 15 ? "small" : (weight < 35 ? "medium" : "large");
        super(type, weight < 15 ? "small" : (weight < 35 ? "medium" : "large"), weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    public Dog(String type, double weight) {
        // it calls the above constructor has 4 params
        this(type, weight, "Perky", "Curled");
    }
    @Override
    public String toString(){
        return "Dog: ear shape = " + earShape + " , tail shape = " + tailShape;
    }
    @Override
    public void move(String speed){
        super.move(speed);
        System.out.println("Overriding method for " + getType());

        if (speed == "slow") {
            walk();
            tailWagging();
        } else {
            run();
            bark();
        }
        System.out.println();
    }
    public void makeNoise(){
        bark();
    }
    public void bark(){
        System.out.println("Woof!");
    }
    public void run(){
        System.out.println("Dog is running!");
    }
    public void walk(){
        System.out.println("Dog is walking!");
    }
    public void tailWagging(){
        System.out.println("Dog is tail wagging!");
    }
}
