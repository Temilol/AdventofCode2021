package day1.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class puzzleSolution {
    public static void main(String []args) throws FileNotFoundException {
        File file = new File("src/day1/data/input1.txt");
        Scanner sc = new Scanner(file);
        Integer prev = stoi(sc.nextLine());
        Integer increase = 0;

        while (sc.hasNextLine()){
            Integer input = stoi(sc.nextLine());
            if(input > prev){
                increase = increase + 1;
            }
            prev = input;
        }

        System.out.println(increase);
    }

    private static Integer stoi(String str) {
        return Integer.parseInt(str);
    }
}
