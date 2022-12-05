package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        var file = new File("src/main/resources/inputday3.txt");
        var bufferedReader = new BufferedReader(new FileReader(file));
        var input = new ArrayList<String>();
        var line = bufferedReader.readLine();

        while (line != null) {
            input.add(line);
            line = bufferedReader.readLine();
        }

        var result = input.stream()
                .map(backpack ->  {
                    var parts = new ArrayList<String>();
                    parts.add(backpack.substring(0, backpack.length()/2));
                    parts.add(backpack.substring(backpack.length()/2));
                    return parts;
                })
                .map(parts -> {
                    for (int i = 0; i < parts.get(0).length(); i++){
                        if (parts.get(1).contains(parts.get(0).substring(i, i + 1))) {
                            return parts.get(0).charAt(i);
                        }
                    }
                    throw new RuntimeException();
                })
                .mapToInt(number -> {
                    int priority = 0;

                    if (number >= 'a' && number <= 'z') {
                        priority = number - 'a' + 1;
                    } else if (number >= 'A' && number <= 'Z') {
                        priority = number - 'A' + 27;
                    }
                    return priority;
                })
                .peek(System.out::println)
                .sum();

        System.out.println(result);


    }
}
