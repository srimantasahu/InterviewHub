package com.kvvssut.interviews.problemsolving.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee {

    private final String firstname;
    private final String lastname;

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}

public class Java8SortingUsingComparator {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Srimanta", "Sahu"));
        employeeList.add(new Employee("Srimanta", "Kapoor"));
        employeeList.add(new Employee("Srimanta", "Arora"));

        Comparator<Employee> lambdaComparator = Comparator.comparing((Employee e) -> e.getFirstname())
                                                          .thenComparing(e -> e.getLastname());

        Comparator<Employee> methodReferenceComparator = Comparator.comparing(Employee::getFirstname)
                                                                   .thenComparing(Employee::getLastname);

        List<Employee> sortedEmployeeList = employeeList.stream()
                                                        .sorted(lambdaComparator) // or methodReferenceComparator
                                                        .collect(Collectors.toList());

        sortedEmployeeList.forEach(e -> System.out.println(e.getFirstname() + " " + e.getLastname()));
    }

}
