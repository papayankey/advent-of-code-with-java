package day_2a;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
	static int totalCount;

	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("src/day_2a/input.txt");
		BufferedReader reader = new BufferedReader(file);

		ArrayList<String> data = new ArrayList<String>();

		String line;
		while ((line = reader.readLine()) != null) {
			data.add(line);
		}
		reader.close();

		for (int i = 0; i < data.size(); i++) {
			String[] str = data.get(i).split(":");
			String password = str[1];
			String[] policy = str[0].split(" ");
			String letter = policy[1];
			String[] range = policy[0].split("-");
			int min = Integer.parseInt(range[0]);
			int max = Integer.parseInt(range[1]);

			int count = (int) password.chars().filter(ch -> ch == letter.charAt(0)).count();
			if (count >= min && count <= max) {
				totalCount += 1;
			}

		}

		System.out.println("Total valid passwords according policies are: " + totalCount);
	}
}
