package com.kvvssut.interviews.java.serialisation.javaserialisation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class JavaSerialisationDeserialisationMain {

	public static void main(String[] args) {

		Manager director = new Manager("director", null, "ALL"); // manager of
																	// emp2,
																	// emp3
		Manager manager = new Manager("manager", director, "ECS");

		Employee employee1 = new Employee("employee1", manager);

		Employee employee2 = new Employee("employee2", manager);

		serialiseJavaObject(employee1);

		Employee employeeObj = deserialiseJavaObject(Employee.class);

		System.out.println(employeeObj.getName());
		System.out.println(employeeObj.getManager().getName() + "\t- dept is "
				+ employeeObj.getManager().getDept());
		System.out.println(employeeObj.getManager().getManager().getName()
				+ "\t- dept is "
				+ employeeObj.getManager().getManager().getDept() + "\n");

		serialiseJavaObject(manager);
		Manager managerObj = deserialiseJavaObject(Manager.class);

		System.out.println(managerObj.getName() + "\t- dept is "
				+ manager.getDept());
		System.out.println(managerObj.getManager().getName() + "\t- dept is "
				+ managerObj.getManager().getDept() + "\n");

		List<Employee> reportersOfManagerList = new ArrayList<Employee>();
		reportersOfManagerList.add(employee1);
		reportersOfManagerList.add(employee2);
		ManagerReporters managerReporters = new ManagerReporters(manager,
				reportersOfManagerList);

		serialiseJavaObject(managerReporters);
		ManagerReporters managerReportersObj = deserialiseJavaObject(ManagerReporters.class);

		System.out.println(managerReportersObj.getManager().getName()
				+ "\t- dept is " + managerReportersObj.getManager().getDept());
		System.out.println("Size of reporters is : "
				+ managerReportersObj.getReporters().size());
		for (Employee employee : managerReportersObj.getReporters()) {
			System.out.println(employee.getName());
		}
		System.out.println();

	}

	public static <T> void serialiseJavaObject(T obj) {
		try {
			FileOutputStream fileOut = new FileOutputStream(
					"D:\\Tech_Workspace\\Workspace_Old\\Workspace_Interview\\Interview\\src\\com\\interview\\impl\\programs\\javaserialisation\\serialised.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(obj);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public static <T> T deserialiseJavaObject(Class<T> klass) {
		T obj = null;
		try {
			FileInputStream fileIn = new FileInputStream(
					"D:\\Tech_Workspace\\Workspace_Old\\Workspace_Interview\\Interview\\src\\com\\interview\\impl\\programs\\javaserialisation\\serialised.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			obj = (T) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		return obj;
	}
}
