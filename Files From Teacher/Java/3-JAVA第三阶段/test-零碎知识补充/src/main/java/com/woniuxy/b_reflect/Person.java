package com.woniuxy.b_reflect;

import java.util.Date;

public class Person {
	private Integer id;
	private String name;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static final String ss = "∑…—©";
	
	static {
//		System.out.println("static Person.Person()");
	}
	
	Person() {
		System.out.println("Person()");
	}

	public Person(Integer id, String name) {
		super();
		System.out.println("Person(Integer, String)");
		this.id = id;
		this.name = name;
	}
	
	public void eat() {
		System.out.println("Person.eat()");
	}
	
	public void eat(String food) {
		System.out.println("≥‘" + food);
	}
	
	public static void run() {
		System.out.println("Œ“≈‹£°");
	}
	
	public int add(int a, int b) {
		System.out.println("Person.add():" + a + "," + b);
		return a + b;
	}
	
	public Class[] f1(Date[][][][][] dates, String str, Person p) {
		System.out.println("Person.f1()");
		return null;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
}
