
import java.io.File;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {

        HashMap<String, String> majors = new HashMap<>();
        HashMap<String, Double> gpas = new HashMap<>();

        Scanner file = new Scanner(new File("students.csv"));

        // Skip the header
        file.nextLine();

        // Read the CSV file
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] data = line.split(",");

            String name = data[0];
            String major = data[1];
            double gpa = Double.parseDouble(data[2]);

            if (gpa >= 0.0 && gpa <= 4.0) {
                majors.put(name, major);
                gpas.put(name, gpa);
            }
        }

        file.close();

        // Calculate average GPA
        double total = 0;

        for (String name : gpas.keySet()) {
            total = total + gpas.get(name);
        }

        double average = total / gpas.size();

        System.out.printf("Average GPA: %.2f%n", average);

        // Print above average students
        System.out.println();
        System.out.println("Above Average Students:");

        for (String name : gpas.keySet()) {
            double gpa = gpas.get(name);
            String major = majors.get(name);

            if (gpa > average) {
                System.out.printf(
                    "%s %.2f %s%n", name, gpa, major
                );
            }
        }

        // Predict scholarships
        System.out.println();
        System.out.println("Scholarship Students:");

        for (String name : gpas.keySet()) {
            double gpa = gpas.get(name);
            String major = majors.get(name);

            String scholarship;

            if (major.equals("Biology") && gpa >= 2.75) {
                scholarship = "earned a scholarship.";
            } else if (major.equals("Math") && gpa >= 3.50) {
                scholarship = "earned a scholarship.";
            } else {
                scholarship = "did not earn a scholarship.";
            }

            System.out.printf(
                "%s %.2f %s %s%n",
                name, gpa, major, scholarship
            );
        }
    }
}
