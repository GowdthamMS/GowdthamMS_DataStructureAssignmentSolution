package com.greatlearning.dsaq1.driver;

import java.util.Scanner;
import com.greatlearning.dsaq1.skyscraper.Building_Skyscaper;

public class Main {
	public static void main(String[] args) {
		System.out.println("Enter the total no of floors in the building");
		try (Scanner sc = new Scanner(System.in)) {
			int numberOfFloors = sc.nextInt();
			int[] listOfFloors = new int[numberOfFloors];
			for (int i = 0; i < numberOfFloors; i++) {
				System.out.println("Enter the floor size given on day : " + (i + 1));
				int floorSize = sc.nextInt();
				listOfFloors[i] = floorSize;
			}
			System.out.println();
			System.out.println("The order of construction is as follows");
			Building_Skyscaper.calculateFloors(listOfFloors);
		}
	}

}
