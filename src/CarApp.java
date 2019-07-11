import java.util.ArrayList;
import java.util.Scanner;

/**
 * Copyright (c) 2019. This program and the accompanying materials are made
 * available under my granted permission provided that this note is kept intact,
 * unmodified and unchanged. @ Author: Baraa Ali - API and implementation. All
 * rights reserved.
 */

public class CarApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		ArrayList<Car> cars = new ArrayList<Car>();
		int numOfCars = getNumOfCars(scnr);
		cars = getCarsData(numOfCars, scnr);
		displayCars(cars, scnr);

	}

	public static int getNumOfCars(Scanner scnr) {
		System.out.println("Welcome to Grand Circus Motors admin console!");
		int numOfCars = Validator.getInt(scnr, "How many cars are you entering?");
		return numOfCars;
	}

	public static ArrayList<Car> getCarsData(int numOfCars, Scanner scnr) {
		ArrayList<Car> cars = new ArrayList<Car>();
		String localMake;
		String localModel;
		int localYear;
		double localPrice;

		for (int i = 1; i <= numOfCars; i++) {
			Car car1 = new Car();
			String makePrompt = "Enter car #" + i + " Make: ";
			localMake = Validator.getString(scnr, makePrompt);
			car1.setMake(localMake);

			String modelPrompt = "Enter car #" + i + " Model: ";
			localModel = Validator.getString(scnr, modelPrompt);
			car1.setModel(localModel);

			String yearPrompt = "Enter car #" + i + " Year: ";
			localYear = Validator.getInt(scnr, yearPrompt);
			car1.setYear(localYear);

			String pricePrompt = "Enter car #" + i + " Price: ";
			localPrice = Validator.getDouble(scnr, pricePrompt);
			car1.setPrice(localPrice);

			cars.add(car1);
		}
		return cars;
	}

	public static void displayCars(ArrayList<Car> cars, Scanner scnr) {
		System.out.println("\nCurrent Inventory:");
		for (Car car : cars) {
			System.out.printf("%-7s  %7s %7d %7s%.2f %n", car.getMake(), car.getModel(), car.getYear(), "$",
					car.getPrice());
		}
	}
}
