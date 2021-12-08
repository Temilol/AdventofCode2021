package day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class part2Solution {
    public static void main(String[] args) {
        List<Integer> inputs = readFileIntoList();
        int days = 256;
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < inputs.size(); j++) {
                int d = inputs.get(j);
                inputs.set(j, d>0 ? d-1 : 6);
                if (d <= 0) {
                    inputs.add(9);
                }
            }
        }
        System.out.println(inputs.size());
    }

    private static List<Integer> readFileIntoList() {
        List<Integer> lines = Collections.emptyList();
        try {
            lines = Files.lines(Paths.get("src/day6/data/practice.txt"))
                    .map(line -> line.split(",")).flatMap(Arrays::stream)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
