package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of the story file (e.g., goldilocks.txt): ");
        String fileName = input.nextLine();

        File storyFile = new File(fileName);

        try (Scanner fileReader = new Scanner(storyFile)) {
            int lineNumber = 1;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, the file " + fileName + " was not found.");
        }

        input.close();
    }
}
