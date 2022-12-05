package day2;

import lombok.val;

import java.awt.print.Paper;
import java.io.*;
import java.sql.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) throws Exception {
        var file = new File("src/main/resources/inputday2.txt");
        var bufferedReader = new BufferedReader(new FileReader(file));
        var input = new ArrayList<String>();
        var line = bufferedReader.readLine();

        while (line != null) {
            input.add(line);
            line = bufferedReader.readLine();
        }

        var result1 = input.stream()
                .map (game -> game.split(" "))
                .peek(p -> System.out.print(Arrays.asList(p)))
                .mapToInt(game -> switch(game[1]) {
                        case "X" -> 1 + switch (game[0]) {
                            case "A" -> 3;
                            case "B" -> 0;
                            case "C" -> 6;
                            default -> throw new RuntimeException();
                        };
                        case "Y" -> 2 + switch (game[0]) {
                            case "A" -> 6;
                            case "B" -> 3;
                            case "C" -> 0;
                            default -> throw new RuntimeException();
                        };
                        case "Z" -> 3 + switch (game[0]) {
                            case "A" -> 0;
                            case "B" -> 6;
                            case "C" -> 3;
                            default -> throw new RuntimeException();
                        };
                    default -> throw new RuntimeException();

                })
                .sum();

        System.out.println("sum star1: " + result1);


        var result2 = input.stream()
                .map (game -> game.split(" "))
                .peek(p -> System.out.print(Arrays.asList(p)))
                .mapToInt(game -> switch(game[1]) {
                    case "X" -> switch (game[0]) {
                        case "A" -> 3;
                        case "B" -> 1;
                        case "C" -> 2;
                        default -> throw new RuntimeException();
                    };
                    case "Y" -> 3 + switch (game[0]) {
                        case "A" -> 1;
                        case "B" -> 2;
                        case "C" -> 3;
                        default -> throw new RuntimeException();
                    };
                    case "Z" -> 6 + switch (game[0]) {
                        case "A" -> 2;
                        case "B" -> 3;
                        case "C" -> 1;
                        default -> throw new RuntimeException();
                    };
                    default -> throw new RuntimeException();

                })
                .sum();

        System.out.println("sum star2: " + result2);


    }
}
