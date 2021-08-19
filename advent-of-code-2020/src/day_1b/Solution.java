package day_1b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
	static final int SUM = 2020;
	static boolean isFound = false;

	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("src/day_1b/input.txt");
		BufferedReader reader = new BufferedReader(file);

		ArrayList<Integer> data = new ArrayList<Integer>();

		String line;
		while ((line = reader.readLine()) != null) {
			data.add(Integer.parseInt(line));
		}
		reader.close();

		int first = 0;
		int second = 0;
		int third = 0;
		for (int i = 0; i < data.size(); i++) {
			first = data.get(i);
			for (int j = ++i; j < data.size(); j++) {
				second = data.get(j);
				for (int k = ++j; k < data.size(); k++) {
					int temp = data.get(k);
					if (SUM == (temp + first + second)) {
						third = temp;
						isFound = true;
						break;
					}
				}
				if (isFound) {
					break;
				}
			}
			if (isFound) {
				break;
			}
		}

		System.out.println("The sum of " + first + ", " + second + " and " + third + " = " + (first + second + third));
		System.out.println(
				"The multiplication of " + first + ", " + second + " and " + third + " = " + (first * second * third));
	}
}
