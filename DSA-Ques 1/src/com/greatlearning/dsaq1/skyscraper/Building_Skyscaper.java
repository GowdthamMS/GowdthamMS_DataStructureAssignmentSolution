package com.greatlearning.dsaq1.skyscraper;

import java.util.Arrays;
import java.util.Stack;

public class Building_Skyscaper {
	static boolean largestNumber;
	static boolean addFlag;

	@SuppressWarnings("unchecked")
	public static void calculateFloors(int[] floorSize) {
		Stack<Integer> stacks = new Stack<Integer>();
		for (int i = 0; i < floorSize.length; i++) {
			largestNumber = true;
			int floorSize_i = floorSize[i];
			for (int j = i; j < floorSize.length; j++) {
				if (j == i) {
					continue;
				} else {
					int floorSize_j = floorSize[j];
					if (floorSize_i >= floorSize_j) {
						largestNumber = true;
						continue;
					} else {
						largestNumber = false;
						stacks.push(floorSize_i);
						break;
					}
				}
			}

			if (largestNumber == true) {
				try {
					@SuppressWarnings("rawtypes")
					Stack stacktemp = displayFloor(stacks, floorSize_i, i, floorSize);
					stacks.clear();
					stacks = (Stack<Integer>) stacktemp.clone();
					stacktemp.clear();
					System.out.println();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println();
				System.out.print("Day:"+(i + 1));
				System.out.println();
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public static Stack displayFloor(Stack stacks, int currentFloor, int iter, int[] arrayFloor) {

		int[] arrayOfPoppedItems = new int[arrayFloor.length];
		int count = 0;
		System.out.println();
		System.out.println("Day:" +(iter + 1));
		System.out.print(currentFloor);
		Stack<Integer> stacktemp = new Stack<Integer>();
		boolean largeststacks;
		if (iter == arrayFloor.length - 1) {
			while (!stacks.empty()) {
				int popFloor = (int) stacks.pop();
				arrayOfPoppedItems[count++] = popFloor;
			}
			if (arrayOfPoppedItems != null) {
				Arrays.sort(arrayOfPoppedItems);
				for (int i = arrayOfPoppedItems.length - 1; i > 0; i--) {
					if (arrayOfPoppedItems[i] != 0) {
						System.out.print(" "+arrayOfPoppedItems[i]);
					}

				}
			}

			return stacktemp;
		} else {
			if (!stacks.empty()) {
				while (!stacks.empty()) {
					largeststacks = true;
					int popFloor = (int) stacks.pop();
					for (int i = iter; i < arrayFloor.length; i++) {
						if (i == iter) {
							continue;
						}
						if (popFloor < arrayFloor[i]) {
							stacktemp.push(popFloor);
							largeststacks = false;
							break;
						} else {
							largeststacks = true;
						}
					}
					if (largeststacks == true) {
						arrayOfPoppedItems[count++] = popFloor;
					}
				}
			}
			if (arrayOfPoppedItems != null) {
				Arrays.sort(arrayOfPoppedItems);
				for (int i = arrayOfPoppedItems.length - 1; i > 0; i--) {
					if (arrayOfPoppedItems[i] != 0) {
						System.out.print(" "+arrayOfPoppedItems[i]);
					}
				}
			}

			return stacktemp;
		}
	}
}
