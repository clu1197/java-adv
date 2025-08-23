package Generic.challenge;

import java.util.ArrayList;
import java.util.List;

public class Layer <T extends Mappable>{

    // Store all elements as a List (more flexible than arrays)
    private List<T> layerElements;

    // Constructor that accepts an array
    // Arrays are fixed-size, so we must convert them into a List
    public Layer(T[] layerElements) {
        // List.of(layerElements) creates an immutable List from the array (cannot add/remove)
        // new ArrayList<>(...) wraps it into a mutable ArrayList so we can add/remove later
        this.layerElements = new ArrayList<T>(List.of(layerElements));
    }

    public void addElements(T... elements){
        layerElements.addAll(List.of(elements));
    }

    public void renderLayer() {
        for(T element : layerElements){
            element.render();
        }
    }
}
