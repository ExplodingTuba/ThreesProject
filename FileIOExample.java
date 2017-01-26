import java.io.*;
import java.nio.file.*;

/**
* This is a simple example of writing to and reading from a text file.
**/

public class FileIOExample {

    public static void main(String[] args) {
            writeHighScore(42);
            System.out.println(getHighScore());

    }

    public static void writeFile() {

        String s = "This is a string!";

        Path file = FileSystems.getDefault().getPath("MyFile.txt");

        // This is a try-with-resources statement.  It is available in Java 7
        // and later.  It will automatically close the Writer, so there is no
        // need for a finally clause, which would need additional Exception
        // handling
        try (BufferedWriter write = Files.newBufferedWriter(file)) {

            write.write(s);

        } catch (IOException e) {
            // Some type of error message
        }
    }

    public static void readFile() {

        Path file = FileSystems.getDefault().getPath("MyFile.txt");

        try (BufferedReader reader = Files.newBufferedReader(file)) {

            String line = null;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            // Some type of error message
        }
    }

    public static void writeHighScore(int score) {

        Path file = FileSystems.getDefault().getPath("MyFile.txt");
        String str = Integer.toString(score);

        try (BufferedWriter write = Files.newBufferedWriter(file)) {
            write.write(str);
        } catch (IOException e) {}
    }

    public static int getHighScore() {
        Path file = FileSystems.getDefault().getPath("MyFile.txt");
        int highScore = 0;
        try (BufferedReader reader = Files.newBufferedReader(file)) {

            highScore = Integer.parseInt(reader.readLine());

        } catch (IOException e) {
            // Some type of error message
        }

        return highScore;
    }

}
