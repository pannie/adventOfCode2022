package day1;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("src/main/resources/inputday1.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String string;
        ArrayList<Integer> elfnumbers = new ArrayList<>();

        int total = 0;

        while ((string = bufferedReader.readLine()) != null) {
            if (string.equals("")) {
                elfnumbers.add(total);
                total = 0;
            } else {
                int i = Integer.parseInt(string);
                total += i;
            }
        }

        int first = 0;
        int second = 0;
        int third = 0;

        for (int i = 0; i < elfnumbers.toArray().length; i++) { if (elfnumbers.get(i) > first) {
            third = second;
            second = first;
            first = elfnumbers.get(i);
            } else if (elfnumbers.get(i) > second) {
                third = second;
                second = elfnumbers.get(i);
            } else if (elfnumbers.get(i) > third) {
                third = elfnumbers.get(i);
            }
        }

        int answer = first + second + third;
        System.out.println(answer);
    }
}
