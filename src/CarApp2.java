import java.util.ArrayList;
import java.util.Scanner;

/**
 * Copyright (c) 2019. This program and the accompanying materials are made
 * available under my granted permission provided that this note is kept intact,
 * unmodified and unchanged. @ Author: Baraa Ali - API and implementation. All
 * rights reserved.
 */

public class CarApp2 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int numOfCars = 3;
		ArrayList<Car> carsList = new ArrayList<Car>();
		carsList = getDisplyCarsData(numOfCars);
		processUserSelection(getUserPreferredCar(carsList.size(), scnr), carsList, scnr);
	}

	public static ArrayList<Car> getDisplyCarsData(int numOfCars) {

		ArrayList<Car> usedCars = new ArrayList<Car>();
		int count = 0;
		/* adding new cars without mileage */
		usedCars.add(new Car("BMW", "X5", 2001, 7700.99));
		usedCars.add(new Car("Kia", "Forte", 2003, 9559.99));
		usedCars.add(new Car("Chrysler", "TownAndCountry", 2019, 19000.99));

		/* adding used cars with mileage */
		usedCars.add(new UsedCar("Kia", "Sorento", 2011, 9900.99, 110.01));
		usedCars.add(new UsedCar("Ford", "Fusion", 2012, 9800.99, 190.09));
		usedCars.add(new UsedCar("Toyota", "Corolla", 2013, 9700.99, 180.08));

		for (Car car : usedCars) {
			count++;
			System.out.printf("%d. %-7s  %-8s %10d $%.2f ", count, car.getMake(), car.getModel(), car.getYear(),
					car.getPrice());
			if (car instanceof UsedCar) {
				System.out.printf("%7.1f %n", ((UsedCar) car).getMileage());
			} else {
				System.out.println("");
			}
		}
		System.out.printf("%d. %-7s", count + 1, "Quit");
		return usedCars;
	}

	public static int getUserPreferredCar(int carsListSize, Scanner scnr) {
		System.out.println();
		int userPreferredCar = Validator.getInt(scnr, "Which car would you like?");
		if (userPreferredCar == (carsListSize + 1)) {
			System.out.println("\nHave a great day!");
			System.exit(-1);
		}

		return userPreferredCar - 1;
	}

	public static void processUserSelection(int userPreferredCar, ArrayList<Car> carsList, Scanner scnr) {

		int count = 0;
		int quit;
		String userWantsToBuy;
		Car car = carsList.get(userPreferredCar);
		do {
			System.out.printf("%-7s  %-8s %10d $%.2f ", car.getMake(), car.getModel(), car.getYear(), car.getPrice());
			if (car instanceof UsedCar) {
				System.out.printf("%7.1f %n", ((UsedCar) car).getMileage());
			} else {
				System.out.println("");
			}
			userWantsToBuy = Validator.getString(scnr, "Would you like to buy this car?");
			if (userWantsToBuy.equalsIgnoreCase("y")) {
				System.out.println("Excellent! Our finance department will be in touch shortly.\n");
				carsList.remove(userPreferredCar);
				for (Car remainingCar : carsList) {
					count++;
					System.out.printf("%d. %-7s  %-8s %10d $%.2f ", count, remainingCar.getMake(),
							remainingCar.getModel(), remainingCar.getYear(), remainingCar.getPrice());
					if (remainingCar instanceof UsedCar) {
						System.out.printf("%7.1f %n", ((UsedCar) remainingCar).getMileage());
					} else {
						System.out.println("");
					}
				}
				System.out.printf("%d. %-7s", count + 1, "Quit");
			} else {
				for (Car remainingCar : carsList) {
					count++;
					System.out.printf("%d. %-7s  %-8s %10d $%.2f ", count, remainingCar.getMake(),
							remainingCar.getModel(), remainingCar.getYear(), remainingCar.getPrice());
					if (remainingCar instanceof UsedCar) {
						System.out.printf("%7.1f %n", ((UsedCar) remainingCar).getMileage());
					} else {
						System.out.println("");
					}
				}
				System.out.printf("%d. %-7s %n", count + 1, "Quit");

			}

			quit = getUserPreferredCar(carsList.size(), scnr);
		} while (!userWantsToBuy.equalsIgnoreCase("y") || quit != count + 1);
		System.out.println("\nHave a great day!");
	}
}
