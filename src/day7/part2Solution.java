package day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.abs;

public class part2Solution {
    public static void main(String[] args) {
        List<String> inputs = readFileIntoList();
        List<Integer> totals = new ArrayList<>();
        for (int i = 0; i < inputs.size(); i++) {
            int total = 0;
            for (String input: inputs) {
                int d = stoi(input);
                int n = abs(d-i);
                int fuel = (n*(n+1))/2;
                total += fuel;
            }
            totals.add(total);
        }
//        System.out.println(totals);
        int minFuel = Collections.min(totals);
        System.out.println(minFuel);
    }

    private static Integer stoi(String str) {
        return Integer.parseInt(str);
    }

    private static List<String> readFileIntoList() {
        List<String> lines = Collections.emptyList();
        try {
            lines = Arrays.asList(Files.readAllLines(Paths.get("src/day7/data/input.txt")).get(0).split(","));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
