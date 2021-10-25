package com.kvvssut.interviews.java.java8.lambdas;

public class PersonInfo implements PersonInterface {

	private String name;
	private int age;

	public PersonInfo(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getAge() {
		return this.age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

}