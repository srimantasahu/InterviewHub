package com.kvvssut.interviews.java.serialisation.javaserialisation;

import java.io.Serializable;
import java.util.List;

public class ManagerReporters implements Serializable {

	private static final long serialVersionUID = -4255541102097859318L;

	private Manager manager;
	private List<Employee> reporters;

	public ManagerReporters(Manager manager, List<Employee> reporters) {
		this.manager = manager;
		this.reporters = reporters;
	}

	public ManagerReporters() {
		// Dummy constructor needed for Jackson mapping from json string to
		// ManagerReporters object
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Employee> getReporters() {
		return reporters;
	}

	public void setReporters(List<Employee> reporters) {
		this.reporters = reporters;
	}

}
