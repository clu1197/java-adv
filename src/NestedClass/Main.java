package NestedClass;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // build the list of employees
        List<Employee> employees = new ArrayList<>(
                List.of(
                        new Employee(10001, "Ralph", 2015),
                        new Employee(10005, "Carole", 2021),
                        new Employee(10022, "Jane", 2013),
                        new Employee(13151, "Laura", 2020),
                        new Employee(10050, "Jim",   2018)
                )
        );

//        var comparator = new EmployeeComparator<>();
//        employees.sort(comparator);

        // EmployeeComparator is now a nested class
        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());

        for (Employee e : employees) {
            System.out.println(e);
        }

        System.out.println("Store Members");

        List<StoreEmployee> storeEmployees = new ArrayList<>(
                List.of(
                        new StoreEmployee(10015, "Joe",   2019, "Target"),
                        new StoreEmployee(10515, "Jorden",   2021, "Walmart"),
                        new StoreEmployee(10105, "Lee",   2020, "Macys"),
                        new StoreEmployee(10215, "Jlo", 2018, "Walmart"),
                        new StoreEmployee(10233, "Alice", 2023, "T&T")
                )
        );


        var comparator = new StoreEmployee.StoreEmployeeComparator<>();
        storeEmployees.sort(comparator);

        for (StoreEmployee e : storeEmployees) {
            System.out.println(e);
        }

    }
}
