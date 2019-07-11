/**
 * Copyright (c) 2019. This program and the accompanying materials are made
 * available under my granted permission provided that this note is kept intact,
 * unmodified and unchanged. @ Author: Baraa Ali - API and implementation. All
 * rights reserved.
 */

public class UsedCar extends Car {
	private double mileage;

	public UsedCar(String make, String model, int year, double price, double mileage) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.mileage = mileage;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return "Used [make=" + make + ", model=" + model + ", year=" + year + ", price=" + price + ", mileage="
				+ mileage + "]";
	}

}
