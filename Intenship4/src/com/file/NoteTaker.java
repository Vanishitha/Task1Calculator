package com.file;
import java.io.*;

public class NoteTaker {

    public static void main(String[] args) {
        String filename = "notes.txt";
        String notes = "This is a note.\nYou can persist data in files using FileWriter.\n";

        // Write notes to file
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(notes);
            System.out.println("✅ Notes written to file: " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }

        // Read notes from file
        System.out.println("\n📖 Reading notes from file:");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("📄 " + line);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading from file: " + e.getMessage());
        }
    }
}
