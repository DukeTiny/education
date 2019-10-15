package com.woniuxy.m_annotation;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Car implements Serializable {
	@Value("奥利奥")
	private String brand;
	@Value("黑白")
	private String color;
	
	public Car() {
		System.out.println("Car.Car()");
	}
	
	public Car(String brand, String color) {
		this.brand = brand;
		this.color = color;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + "]";
	}
}
