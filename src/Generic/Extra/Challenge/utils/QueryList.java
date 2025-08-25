package Generic.Extra.Challenge.utils;

import Generic.Extra.Challenge.Student;

import java.util.ArrayList;
import java.util.List;

public class QueryList <T extends Student & QueryItem> extends ArrayList<T>{

    public QueryList(){

    }
    public QueryList(List<T> items) {
        super(items);
    }

    public QueryList<T> getMatches(String field, String value) {
        QueryList<T> matches = new QueryList<>();
        for (var item : this){
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

