package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class part1Solution {
    public static void main(String[] args) {
        List<String> inputs = readFileIntoList();
        int size = inputs.get(0).length();
        int position = 0;
        int ones = 0;
        int zeros = 0;
        String gamma = "";
        String epsilon = "";

        while (position < size) {
            for (String input:inputs) {
                if (input.charAt(position) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            if (zeros > ones) {
                gamma = gamma.concat("0");
                epsilon = epsilon.concat("1");
            } else {
                gamma = gamma.concat("1");
                epsilon = epsilon.concat("0");
            }

            zeros = 0;
            ones = 0;
            position++;
        }

        int consumptionPower = convert2decimal(gamma) * convert2decimal(epsilon);
        System.out.println("consumption power: "+consumptionPower);
    }

    private static List<String> readFileIntoList() {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get("src/day3/data/input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static Integer convert2decimal(String binaryString) {
        return Integer.parseInt(binaryString,2);
    }
}
