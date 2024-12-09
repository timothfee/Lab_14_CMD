import javax.swing.*;
import java.io.*;
import java.util.*;

public class FileScan {
    public static void main(String[] args) {
        File file = null;

        if (args.length > 0) {
            file = new File(args[0]);
            if (!file.exists()) {
                System.out.println("File does not exist.");
                return;
            }
        } else {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
            }
        }

        if (file != null) {
            scanFile(file);
        }
    }

    private static void scanFile(File file) {
        int charCount = 0, wordCount = 0, lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File: " + file.getName());
        System.out.println("Lines: " + lineCount);
        System.out.println("Words: " + wordCount);
        System.out.println("Characters: " + charCount);
    }
}
