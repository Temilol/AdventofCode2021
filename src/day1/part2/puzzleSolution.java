package day1.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class puzzleSolution {
    public static void main(String []args)  {
        List<String> inputs = readFileIntoList();
        final int window = 3;
        int prevTotal = stoi(inputs.get(0)) + stoi(inputs.get(1)) + stoi(inputs.get(2));
        int total = 0;
        int counter = 0;
        int index = 1;
        Integer increased = 0;

        while (index <= inputs.size() - window) {
            while (counter < window){
                total += stoi(inputs.get(index + counter));
                counter++;
            }
            if(total > prevTotal){
                increased++;
            }
            prevTotal = total;
            total =0;
            counter=0;
            index++;
        }
        System.out.println(increased);
    }

    private static List<String> readFileIntoList() {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get("src/day1/data/input1.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static Integer stoi(String str) {
        return Integer.parseInt(str);
    }
}
