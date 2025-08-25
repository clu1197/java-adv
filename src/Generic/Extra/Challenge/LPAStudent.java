package Generic.Extra.Challenge;

import Generic.Extra.Challenge.utils.QueryItem;

public class LPAStudent extends Student implements QueryItem {

    private double percentComplete;

    public LPAStudent() {
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        if (fieldName.equalsIgnoreCase("percentComplete")){
            return percentComplete <= Integer.valueOf(value);
        }
        return super.matchFieldValue(fieldName, value);
    }
}
