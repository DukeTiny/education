package com.woniu.demo3.d1;

public class CarTest {

	public static void main(String[] args) {
		Car c1 = new Car();
		c1.setColor("红色");
		c1.setName("法拉利");
		c1.setPrice(500);
		
		System.out.println(c1.getColor()+":"+c1.getName()+":"+c1.getPrice());
	}

}
