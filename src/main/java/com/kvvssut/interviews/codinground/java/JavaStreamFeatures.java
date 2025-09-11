package com.kvvssut.interviews.codinground.java;

import java.util.*;
import java.util.stream.*;

public class JavaStreamFeatures {

    // Record to represent Employee
    public record Employee(String name, String department, int salary) {
    }

    // Sample employee data
    private static List<Employee> getEmployees() {
        return List.of(
                new Employee("Alice", "HR", 3000),
                new Employee("Bob", "IT", 5000),
                new Employee("Charlie", "IT", 7000),
                new Employee("David", "Finance", 6000),
                new Employee("Eve", "HR", 4000)
        );
    }

    public static void main(String[] args) {
        List<Employee> employees = getEmployees();

        // 1. Names of all employees
        System.out.println("1. Employee Names:");
        List<String> names = employees.stream()
                .map(Employee::name)
                .toList();
        System.out.println(names);
        System.out.println();


        // 2. Total salary using reduce
        System.out.println("2. Total Salary:");
        int totalSalary = employees.stream()
                .map(Employee::salary)
                .reduce(0, Integer::sum);
        System.out.println("Total Salary: " + totalSalary);
        System.out.println();


        // 3. Group employees by department
        System.out.println("3. Grouped by Department:");
        Map<String, List<Employee>> groupedByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::department));
        groupedByDept.forEach((dept, emps) ->
                System.out.println(dept + ": " + emps));
        System.out.println();


        // 4. Count employees per department
        System.out.println("4. Employee Count per Department:");
        Map<String, Long> countPerDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));
        System.out.println(countPerDept);
        System.out.println();


        // 5. Total salary per department
        System.out.println("5. Total Salary per Department:");
        Map<String, Integer> salaryPerDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.summingInt(Employee::salary)));
        System.out.println(salaryPerDept);
        System.out.println();


        // 6. Employee names per department
        System.out.println("6. Names per Department:");
        Map<String, List<String>> namesPerDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::department,
                        Collectors.mapping(Employee::name, Collectors.toList())));
        System.out.println(namesPerDept);
        System.out.println();


        // 7. Highest paid employee per department
        System.out.println("7. Highest Paid per Department:");
        Map<String, Optional<Employee>> topEarners = employees.stream()
                .collect(Collectors.groupingBy(Employee::department,
                        Collectors.maxBy(Comparator.comparing(Employee::salary))));
        topEarners.forEach((dept, emp) ->
                System.out.println(dept + ": " + emp.orElse(null)));
        System.out.println();


        // 8. Nested grouping: Department -> Salary Range
        System.out.println("8. Nested Grouping (Dept -> Salary Range):");
        Map<String, Map<String, List<Employee>>> nestedGrouping = employees.stream()
                .collect(Collectors.groupingBy(Employee::department,
                        Collectors.groupingBy(e -> {
                            if (e.salary() >= 6000) return "High";
                            else if (e.salary() >= 4000) return "Medium";
                            else return "Low";
                        })
                ));
        nestedGrouping.forEach((dept, salaryMap) -> {
            System.out.println(dept + ":");
            salaryMap.forEach((range, emps) ->
                    System.out.println("  " + range + " -> " + emps));
        });
        System.out.println();


        // 9. FlatMap example: flattening nested lists
        System.out.println("9. FlatMap: Flatten Nested Lists:");
        List<List<String>> nested = List.of(List.of("A", "B"), List.of("C", "D"));
        List<String> flat = nested.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println(flat);
    }
}
