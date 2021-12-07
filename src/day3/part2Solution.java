package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class part2Solution {
    public static void main(String[] args) {
        List<String> inputs = readFileIntoList();
        List<String> gammaList = new ArrayList<>(inputs);
        List<String> epsilonList = new ArrayList<>(inputs);
        int size = inputs.get(0).length();
        int position = 0;
        int ones;
        int zeros;
        char bit;

        while (position < size) {
            if (gammaList.size() > 1) {
                zeros = 0;
                ones = 0;
                for (String gamma: gammaList) {
                    if (gamma.charAt(position) == '0') {
                        zeros++;
                    } else {
                        ones++;
                    }
                }

                bit = zeros > ones ? '0' : '1';

                int finalPosition = position;
                char finalBit = bit;
                gammaList.removeIf(g -> g.charAt(finalPosition) != finalBit);
            }

            if (epsilonList.size() > 1) {
                zeros = 0;
                ones = 0;
                for (String epsilon: epsilonList) {
                    if (epsilon.charAt(position) == '0') {
                        zeros++;
                    } else {
                        ones++;
                    }
                }

                bit = zeros > ones ? '1' : '0';

                int finalPosition = position;
                char finalBit = bit;
                epsilonList.removeIf(g -> g.charAt(finalPosition) != finalBit);
            }

            if(epsilonList.size() <=1 && gammaList.size() <= 1) {
                break;
            }
            position++;
        }

        int consumptionPower = convert2decimal(epsilonList.get(0)) * convert2decimal(gammaList.get(0));
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
