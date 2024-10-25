import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class GolZipReader {
    public static void main(String[] args) {
        String zipFilePath = "gol_2023_11_09-07_19_51.zip"; // Update with your zip file path
        
        // try (ZipInputStream zipStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
        //     ZipEntry entry;
            
        //     // Iterate through each entry in the .zip file
        //     while ((entry = zipStream.getNextEntry()) != null) {
        //         // Check if the entry is a .gol file
        //         if (entry.getName().endsWith(".gol")) {
        //             System.out.println("Reading file: " + entry.getName());
        //             readGolFile(zipStream);
        //         }
        //         zipStream.closeEntry(); // Close the current entry to move to the next
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        try (FileInputStream is = new FileInputStream(zipFilePath)) {
            ZipInputStream zipStream = new ZipInputStream(is);
            ZipEntry entry;
            while ((entry = zipStream.getNextEntry())!= null) {
                if (entry.getName().endsWith(".gol")) {
                    System.out.println("Reading file: " + entry.getName());
                    readGolFile(zipStream);
                }
                zipStream.closeEntry();
            }


        } catch (IOException e) {
            
            e.printStackTrace();
        }
        

        
    }

    private static void readGolFile(ZipInputStream zipStream) throws IOException {
        InputStreamReader isr = new InputStreamReader(zipStream);
        BufferedReader reader = new BufferedReader(isr);
        
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line); // Process each line as needed
        }
        // Do not close the reader here, as it would close zipStream
    }
}

