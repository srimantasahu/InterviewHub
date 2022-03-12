package com.kvvssut.interviews.java.serialisation.jsonserialisation;

public class Manager extends Employee {

    private String dept;

    public Manager(String name, Manager manager, /* List<Employee> reporters */
                   String dept) {
        super(name, manager);
        this.dept = dept;
        // this.reporters = reporters;
    }

    public Manager() {
        // Dummy constructor needed for Jackson mapping from json string to
        // manager object
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    /*
     * Not to keep this, as we can get the list of reporters by querying the
     * table. If kept, it creates an infinite looping of objects.
     *
     * private List<Employee> reporters;
     *
     * public List<Employee> getReporters() { return reporters; }
     *
     * public void setReporters(List<Employee> reporters) { this.reporters =
     * reporters; }
     */

}
