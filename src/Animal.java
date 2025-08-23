public class Animal {
    private String type;
    protected String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public Animal() {
    }

    public String getType() { // getter
        return type;
    }
    public String toString(){
        return "Animal: type = " + type + " , size = " + size + ", weight = " + weight;
    }
    public void makeNoise(){
        System.out.println(type + " is making noise!");
    }
    public void move(String speed){
        System.out.println(type + " is moving at "+speed+" m/s!");
    }
}
