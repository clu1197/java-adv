package Interface.challenge;

enum Geometry {LINE, POINT, POLYGON};
enum PointMarker {CIRCLE, PUSH_PIN, STAR, SQUARE, TRIANGLE};
enum LineMarker {DASHED, DOTTED, SOLID};
enum Color{GREEN, RED, BLUE, ORANGE, BLACK};

public interface Mappable {
    String JSON_PROPERTY = """
           properties: {%s}""";
    String getLabel();
    Geometry getShape();
    String getMarker();

    default  String toJSON(){
        return """
               "type": "%s", "label": "%s", "marker": "%s" """
                .formatted(getShape(), getLabel(), getMarker());
    }
    static void mapIt(Mappable mappable){
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }


}
