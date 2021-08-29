package day02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day02 {
	static List<String> lines = new ArrayList<>();
	public String password;
	public char letter;
	public int min;
	public int max;
	public int totalCount;

	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/day02/input.txt")));) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}

			Day02.partOne();
			Day02.partTwo();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void partOne() {
		Day02 d = new Day02();
		for (String line : lines) {
			d.formatToParts(line);
			int count = (int) d.password.chars().filter(ch -> ch == d.letter).count();
			if (count >= d.min && count <= d.max) {
				d.totalCount++;
			}
		}
		System.out.println("Total valid passwords according policies is: " + d.totalCount);
	}

	private static void partTwo() {
		Day02 d = new Day02();
		for (String line : lines) {
			d.formatToParts(line);
			if (d.password.contains(String.valueOf(d.letter))) {
				boolean isAtMin = d.letter == d.password.charAt(d.min - 1);
				boolean isAtMax = d.letter == d.password.charAt(d.max - 1);
				if (isAtMin && isAtMax)
					continue;
				if (isAtMin || isAtMax)
					d.totalCount++;
			}
		}
		System.out.println("Total valid passwords according policie interpretations is: " + d.totalCount);
	}

	private void formatToParts(String line) {
		List<String> parts = Arrays.asList(line.split("-|\\s|:"));
		min = Integer.parseInt(parts.get(0));
		max = Integer.parseInt(parts.get(1));
		letter = parts.get(2).trim().charAt(0);
		password = parts.get(4).trim();
	}
}
