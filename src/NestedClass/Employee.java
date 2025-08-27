package NestedClass;

import java.util.Comparator;

public class Employee {
    // able to access all private member of the outer class and wise versa
    public static class EmployeeComparator <T extends Employee> implements Comparator<Employee> {
        private String sortType;

        public EmployeeComparator() {
            this("name"); // passing name as a default sort type
        }
        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Employee o1, Employee o2) {
            if (sortType.equalsIgnoreCase("yearStarted")) {
                return o1.yearStarted - o2.yearStarted;
            }
            return o1.name.compareTo(o2.name);
        }
    }

    private int employeeId;
    private String name;
    private int yearStarted;

    public Employee() {
    }

    public Employee(int yearStarted, String name, int employeeId) {
        this.yearStarted = yearStarted;
        this.name = name;
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }
}
