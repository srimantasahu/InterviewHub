package com.kvvssut.interviews.java.comparable;

import java.util.Arrays;
import java.util.Comparator;

public class EmployeeComparable implements Comparable<EmployeeComparable> {

    /**
     * Comparator to sort employees list or array in order of Salary
     */
    public static Comparator<EmployeeComparable> SalaryComparator = new Comparator<EmployeeComparable>() {

        @Override
        public int compare(EmployeeComparable e1, EmployeeComparable e2) {
            return (int) (e1.getSalary() - e2.getSalary());
        }
    };
    /**
     * Comparator to sort employees list or array in order of Age
     */
    public static Comparator<EmployeeComparable> AgeComparator = new Comparator<EmployeeComparable>() {

        @Override
        public int compare(EmployeeComparable e1, EmployeeComparable e2) {
            return e1.getAge() - e2.getAge();
        }
    };
    /**
     * Comparator to sort employees list or array in order of Name
     */
    public static Comparator<EmployeeComparable> NameComparator = new Comparator<EmployeeComparable>() {

        @Override
        public int compare(EmployeeComparable e1, EmployeeComparable e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };
    private int id;
    private String name;
    private int age;
    private long salary;

    public EmployeeComparable(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public static void main(String[] args) {

        //sorting custom object array
        EmployeeComparable[] empArr = new EmployeeComparable[4];
        empArr[0] = new EmployeeComparable(10, "Mikey", 25, 10000);
        empArr[1] = new EmployeeComparable(20, "Arun", 29, 20000);
        empArr[2] = new EmployeeComparable(5, "Lisa", 35, 5000);
        empArr[3] = new EmployeeComparable(1, "Pankaj", 32, 50000);

        //sorting employees array using Comparable interface implementation
        Arrays.sort(empArr);
        System.out.println("Default Sorting of Employees list:\n" + Arrays.toString(empArr));

        //sort employees array using Comparator by Salary
        Arrays.sort(empArr, EmployeeComparable.SalaryComparator);
        System.out.println("Employees list sorted by Salary:\n" + Arrays.toString(empArr));

        //sort employees array using Comparator by Age
        Arrays.sort(empArr, EmployeeComparable.AgeComparator);
        System.out.println("Employees list sorted by Age:\n" + Arrays.toString(empArr));

        //sort employees array using Comparator by Name
        Arrays.sort(empArr, EmployeeComparable.NameComparator);
        System.out.println("Employees list sorted by Name:\n" + Arrays.toString(empArr));

        //Employees list sorted by ID and then name using Comparator class
        empArr[0] = new EmployeeComparable(1, "Mikey", 25, 10000);
        Arrays.sort(empArr, new EmployeeComparatorByIdAndName());
        System.out.println("Employees list sorted by ID and Name:\n" + Arrays.toString(empArr));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    @Override
    public int compareTo(EmployeeComparable emp) {
        //let's sort the employee based on id in ascending order
        //returns a negative integer, zero, or a positive integer as this employee id
        //is less than, equal to, or greater than the specified object.
        return (this.id - emp.id);
    }

    @Override
    //this is required to print the user friendly information about the Employee
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" +
                this.salary + "]";
    }

}