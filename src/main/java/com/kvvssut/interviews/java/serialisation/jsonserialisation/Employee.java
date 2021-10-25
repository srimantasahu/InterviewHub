package com.kvvssut.interviews.java.serialisation.jsonserialisation;

public class Employee {

	private String name;
	private Manager manager;

	public Employee(String name, Manager manager) {
		this.name = name;
		this.manager = manager;
	}

	public Employee() {
		// Dummy constructor needed for Jackson mapping from json string to
		// Employee object
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
