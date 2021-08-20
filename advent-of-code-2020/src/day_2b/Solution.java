package day_2b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
	static int totalCount;

	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("src/day_2b/input.txt");
		BufferedReader reader = new BufferedReader(file);

		ArrayList<String> data = new ArrayList<String>();

		String line;
		while ((line = reader.readLine()) != null) {
			data.add(line);
		}
		reader.close();

		for (int i = 0; i < data.size(); i++) {
			String[] str = data.get(i).split(":");
			String password = str[1].trim();
			String[] policy = str[0].split(" ");
			char ch = policy[1].charAt(0);
			String[] pos = policy[0].split("-");

			if (password.contains(String.valueOf(ch))) {
				boolean isAtMin = ch == password.charAt(Integer.parseInt(pos[0]) - 1);
				boolean isAtMax = ch == password.charAt(Integer.parseInt(pos[1]) - 1);

				if (isAtMin && isAtMax) continue;
				if (isAtMin || isAtMax) totalCount += 1;
			}

		}

		System.out.println("Total valid passwords according policies are: " + totalCount);
	}
}
