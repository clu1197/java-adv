package Generic.Extra.utils;

import java.util.ArrayList;
import java.util.List;

public class QueryList <T extends QueryItem>{
    private List<T> items;

    public QueryList(List<T> items) {
        this.items = items;
    }

    public List<T> getMatches(String field, String value) {
        List<T> matches = new ArrayList<>();
        for (var item : items){
            if (item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }

    // I WANT TO USE THE METHOD without initializing a QueryList object
    // For a static method, we must declare <T> before the return type
    // Otherwise, Java does not know what T refers to in List<T>
    public static <T extends QueryItem> List<T> getMatches(List<T> items, String field, String value) {
        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }

}

