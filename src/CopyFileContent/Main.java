package CopyFileContent;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        try (FileReader reader = new FileReader("src/CopyFileContent/input.txt");
             FileWriter writer = new FileWriter("src/CopyFileContent/reversed.txt")) {

            String s = "";
            int character;
            while ((character = reader.read()) != -1) {
                s = s + (char) character;
            }

            System.out.println(s);

            writer.write(s);

        } catch (FileNotFoundException e) {
            System.out.println("File not Found " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }
}
