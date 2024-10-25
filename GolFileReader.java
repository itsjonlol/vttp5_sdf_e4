import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GolFileReader {
    public static void main(String[] args) {
        String filePath = "gol/blinker.gol"; // Specify your .gol file path
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // Process each line as needed
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions
        }
    }
}
