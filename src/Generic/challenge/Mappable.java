package Generic.challenge;

import java.util.Arrays;

public interface Mappable  {
    void render();

    // interface allows static / default methods
    static double[] stringToLatLon(String location){
        var splits = location.split(",");
        double lat = Double.valueOf(splits[0]);
        double lng = Double.valueOf(splits[1]);

        return new double[]{lat, lng};
    }
}

abstract class Point implements Mappable {
    // because this class is abstract, i dont have to implement the abstract method in Mappable
    private double[] location = new double[2];

    public Point(String location) {
        this.location = Mappable.stringToLatLon(location);
    }

    @Override
    public void render() {
        // this is the toString method of the subclass of your subclass
        System.out.println("Render " + this + " as POINT (" + location() + ")");

    }

    private String location() {
        return Arrays.toString(location);
    }

    public abstract String toString();
}

abstract class Line implements Mappable{

    private double[][] locations;

    public Line(String... locations){
        this.locations = new double[locations.length][];
        int index = 0;
        for (var l : locations){
            this.locations[index++] = Mappable.stringToLatLon(l);
        }
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as LINE (" + locations() + ")");
    }

    private String locations(){
        return Arrays.deepToString(locations);
    }
}