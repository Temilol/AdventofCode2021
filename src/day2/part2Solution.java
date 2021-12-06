package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part2Solution {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/day2/data/input.txt");
        Scanner sc = new Scanner(file);
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] splitted = line.split("\\s+");
            String direction = splitted[0];
            int input = stoi(splitted[1]);
            switch (direction){
                case "down":
                    aim+=input;
                    break;
                case "up":
                    aim-=input;
                    break;
                case "forward":
                    horizontal+=input;
                    depth+=aim*input;
                    break;
                default:
                    break;
            }
        }
        int plannedCourse = horizontal * depth;
        System.out.println(plannedCourse);
    }

    private static Integer stoi(String str) {
        return Integer.parseInt(str);
    }
}
