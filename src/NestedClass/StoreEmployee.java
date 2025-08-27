package NestedClass;

import java.util.Comparator;

public class StoreEmployee extends Employee{
    public static class StoreEmployeeComparator <T extends StoreEmployee> implements Comparator<StoreEmployee> {

        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2) {
            int result = o1.store.compareTo(o2.store);
            // if result == 0 meaning they are same
            if (result == 0) {
                return new Employee.EmployeeComparator<>("yearStarted").compare(o1, o2);
            }
            return result;
        }

    }

    private String store;

    public StoreEmployee() {
    }

    public StoreEmployee(int yearStarted, String name, int employeeId, String store) {
        super(yearStarted, name, employeeId);
        this.store = store;
    }

    @Override
    public String toString() {
        // – %-8s means “a string (s), left-justified (-), padded to at least 8 characters.
        return "%-8s%s".formatted(store, super.toString());
    }

}
