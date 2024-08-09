package AggregatingReportData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        try (FileReader file = new FileReader("src/AggregatingReportData/log.txt");
             BufferedReader reader = new BufferedReader(file);
             FileWriter fileWriter = new FileWriter("src/AggregatingReportData/log_summary.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {


            List<String> log_list = new ArrayList<>();
            String line = "";
            while ((line = reader.readLine()) != null) {
                log_list.add(line);
            }

            Map<String, Long> log_summary = log_list.stream().collect(Collectors.groupingBy(t -> t.split(",")[1], Collectors.counting()));

            System.out.println(log_summary);

            writer.write(log_summary.toString());
        } catch (IOException e) {
            System.out.println("IOException:\t" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception:\t" + e.getMessage());
        }
    }
}
