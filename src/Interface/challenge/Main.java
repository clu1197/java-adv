package Interface.challenge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main interface page");

        List<Mappable> mappableList = new ArrayList<>();

        mappableList.add(new Building( "Sydney Town Hall", UsageType.GOVERNMENT));
        mappableList.add(new Building( "Sydney Opera House", UsageType.ENTERTAINMENT));
        mappableList.add(new Building("Stadium Australia", UsageType.SPORTS));

        mappableList.add(new UtilityLine( "College St", UtilityType.FIBER_OPTIC));
        mappableList.add(new UtilityLine("Olympic Blvd", UtilityType.WATER));

        for (var m : mappableList) {
            Mappable.mapIt(m);
        }
    }
}