package ReadAndDisplayFileContent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("src/ReadAndDisplayFileContent/input.txt");
             BufferedReader reader = new BufferedReader(fileReader)) {

            String s = "";
            while ((s = reader.readLine()) != null)
                System.out.println(s);

        } catch (FileNotFoundException e) {
            System.out.println("FileNotException " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }
}
