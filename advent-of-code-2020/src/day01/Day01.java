package day01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day01 {
    static List<Integer> lines = new ArrayList<>();
    static int sum = 2020;
    public boolean isFound = false;
    public int x, y, z;

    public static void main(String[] args) {
        Day01.partOne();
        Day01.partTwo();
    }

    public Day01(File f) {
        try (BufferedReader reader = new BufferedReader(new FileReader(f));) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                lines.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void partOne() {
        Day01 d = new Day01(new File("src/day01/input1.txt"));
        for (int i = 0; i < lines.size(); i++) {
            d.x = lines.get(i);
            for (int j = ++i; j < lines.size(); j++) {
                int temp = lines.get(j);
                if (sum == (temp + d.x)) {
                    d.y = temp;
                    d.isFound = true;
                    break;
                }
            }
            if (d.isFound) {
                break;
            }
        }
        System.out.println("The sum of " + d.x + " and " + d.y + " = " + (d.x + d.y));
        System.out.println("The multiplication of " + d.x + " and " + d.y + " = " + (d.x * d.y));
    }

    private static void partTwo() {
        Day01 d = new Day01(new File("src/day01/input2.txt"));
        for (int i = 0; i < lines.size(); i++) {
            d.x = lines.get(i);
            for (int j = ++i; j < lines.size(); j++) {
                d.y = lines.get(j);
                for (int k = ++j; k < lines.size(); k++) {
                    int temp = lines.get(k);
                    if (sum == (temp + d.x + d.y)) {
                        d.z = temp;
                        d.isFound = true;
                        break;
                    }
                }
                if (d.isFound) {
                    break;
                }
            }
            if (d.isFound) {
                break;
            }
        }
        System.out.println("The sum of " + d.x + ", " + d.y + " and " + d.z + " = " + (d.x + d.y + d.z));
        System.out.println("The multiplication of " + d.x + ", " + d.y + " and " + d.z + " = " + (d.x * d.y * d.z));
    }
}
