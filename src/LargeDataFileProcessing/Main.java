package LargeDataFileProcessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (FileReader file = new FileReader("src/LargeDataFileProcessing/transactions.txt");
             BufferedReader reader = new BufferedReader(file);
             FileWriter fileWriter = new FileWriter("src/LargeDataFileProcessing/filtered_transactions.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter);
        ) {

            List<String> list_line = new ArrayList<>();
            String line = "";
            while ((line = reader.readLine()) != null) {
                list_line.add(line);
            }

            double threshold_amount = 2000d;

            List<String> threshold_amount_tnx = list_line.stream().filter(t -> {
                String amount_tnx = t.split(",")[2];
                double amount = Double.parseDouble(amount_tnx);
                return amount >= threshold_amount;
            }).collect(Collectors.toList());

            System.out.println(threshold_amount_tnx);

            for (String s : threshold_amount_tnx) {
                writer.write(s);
                writer.newLine();
            }

//            System.out.println(list_line);
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }
}
