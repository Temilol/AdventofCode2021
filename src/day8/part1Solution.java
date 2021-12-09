package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Math.abs;

public class part1Solution {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/day8/data/input.txt");
        Scanner sc = new Scanner(file);
        List<String> words;
        int counter = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            words = Arrays.asList(Arrays.asList(line.split("\\|")).get(1).trim().split(" "));
            for (String word: words) {
                int size = word.length();
                if (size == 2 || size == 3 || size == 4 || size == 7) {
                   counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
