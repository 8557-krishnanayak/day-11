package CountWordsInAFile;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("src/CountWordsInAFile/text_input.txt");
             BufferedReader reader = new BufferedReader(fileReader)) {


            String lines = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                lines = lines + line;
            }

            System.out.println(lines);

            String str = "qwertyuiopasdfghjklzxcvbnm1234567890";

            Map<String, Long> collect = Arrays.stream(lines.split(""))
                    .filter(i -> str.contains(i))
                    .collect(Collectors.groupingBy(t -> t, Collectors.counting()));

            System.out.println(collect);
//                    .forEach(System.out::println);

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Exception " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
    }
}
