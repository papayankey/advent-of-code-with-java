package com.aoc2020.day_1a;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
	static final int SUM = 2020;
	static boolean isFound = false;

	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("src/com/aoc2020/day_1a/input.txt");
		BufferedReader reader = new BufferedReader(file);

		ArrayList<Integer> data = new ArrayList<Integer>();

		String line;
		while ((line = reader.readLine()) != null) {
			data.add(Integer.parseInt(line));
		}
		reader.close();

		int first = 0;
		int second = 0;
		for (int i = 0; i < data.size(); i++) {
			first = data.get(i);
			for (int j = ++i; j < data.size(); j++) {
				int temp = data.get(j);
				if (SUM == (temp + first)) {
					second = temp;
					isFound = true;
					break;
				}
			}
			if (isFound) {
				break;
			}
		}

		System.out.println("The sum of " + first + " and " + second + " = " + (first + second));
		System.out.println("The multiplication of " + first + " and " + second + " = " + (first * second));
	}
}
