package com.kvvssut.interviews.java.serialisation.jsonserialisation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONSerialisationDeserialisationMain {

    public static void main(String[] args) {

        Manager director = new Manager("director", null, "ALL"); // manager of
        // emp2,
        // emp3
        Manager manager = new Manager("manager", director, "ECS");

        Employee employee1 = new Employee("employee1", manager);

        Employee employee2 = new Employee("employee2", manager);

        String employeeJsonString = convertJavaObjectToJackson(employee1);
        System.out.println(employeeJsonString); // JSON representation of
        // employee -
        // {"name":"employee1","manager":{"name":"manager","manager":{"name":"director","manager":null,"dept":"ALL"},"dept":"ECS"}}

        Employee employeeObj = convertJacksonToJavaObject(Employee.class,
                employeeJsonString);

        System.out.println(employeeObj.getName());
        System.out.println(employeeObj.getManager().getName() + "\t- dept is "
                + employeeObj.getManager().getDept());
        System.out.println(employeeObj.getManager().getManager().getName()
                + "\t- dept is "
                + employeeObj.getManager().getManager().getDept());

        System.out.println(convertJavaObjectToJackson(manager)); // JSON
        // representation
        // of
        // manager -
        // {"name":"manager","manager":{"name":"director","manager":null,"dept":"ALL"},"dept":"ECS"}

        List<Employee> reportersOfManagerList = new ArrayList<Employee>();
        reportersOfManagerList.add(employee1);
        reportersOfManagerList.add(employee2);
        ManagerReporters managerReporters = new ManagerReporters(manager,
                reportersOfManagerList);

        System.out.println(convertJavaObjectToJackson(managerReporters)); // JSON
        // representation
        // of
        // managerReporters
        // -
        // {"manager":{"name":"manager","manager":{"name":"director","manager":null,"dept":"ALL"},"dept":"ECS"},"reporters":[{"name":"employee1","manager":{"name":"manager","manager":{"name":"director","manager":null,"dept":"ALL"},"dept":"ECS"}},{"name":"employee2","manager":{"name":"manager","manager":{"name":"director","manager":null,"dept":"ALL"},"dept":"ECS"}}]}

    }

    public static <T> String convertJavaObjectToJackson(T obj) {
        ObjectMapper mapper = new ObjectMapper();

        // Object to JSON in file
        try {
            mapper.writeValue(
                    new File(
                            "D:\\Tech_Workspace\\Workspace_Old\\Workspace_Interview\\Interview\\src\\com\\interview\\impl\\programs\\jsonserialisation\\serialised.json"),
                    obj);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Object to JSON in String
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return jsonInString;
    }

    public static <T> T convertJacksonToJavaObject(Class<T> klass,
                                                   String jsonInString) {
        ObjectMapper mapper = new ObjectMapper();

        // JSON from file to Object
        try {
            @SuppressWarnings("unused")
            T tFromFile = mapper
                    .readValue(
                            new File(
                                    "D:\\Tech_Workspace\\Workspace_Old\\Workspace_Interview\\Interview\\src\\com\\interview\\impl\\programs\\jsonserialisation\\serialised.json"),
                            klass);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // JSON from String to Object
        T tFromString = null;
        try {
            tFromString = mapper.readValue(jsonInString, klass);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return tFromString;
    }
}
