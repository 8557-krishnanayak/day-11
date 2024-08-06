package WriteUserInputToAFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("User Input:\t");
        String str = scanner.nextLine();


        try (
                FileWriter fileWriter = new FileWriter("src/WriteUserInputToAFile/user_input.txt");
                BufferedWriter writer = new BufferedWriter(fileWriter);
        ) {
            writer.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
