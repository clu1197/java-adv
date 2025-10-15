package IO.PathListing;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Path path = Path.of("files/subfolder/testFile.txt");

        printPathInfo(path);
        logStatement(path);
        extraInfo(path);
        probeType(path);
    }

    // Print detailed path info
    private static void printPathInfo(Path path) {
        System.out.println("Path: " + path);
        System.out.println("File name: " + path.getFileName());
        System.out.println("Parent: " + path.getParent());
        Path absPath = path.toAbsolutePath();
        System.out.println("Absolute path: " + absPath);
        System.out.println("Root from absolute path: " + absPath.getRoot());
        System.out.println("Root from current path: " + path.getRoot());
        System.out.println("Is absolute: " + path.isAbsolute());

        // Show directory depth and each level
        System.out.println("\nDirectory structure:");
        Path abs = path.toAbsolutePath();
        for (int i = 0; i < abs.getNameCount(); i++) {
            System.out.println("  Level " + i + ": " + abs.getName(i));
        }
        System.out.println("--------------------------------------------------\n");
    }

    // Write log statement to file (creates folders and file if missing)
    private static void logStatement(Path path) {
        try {
            // Create all missing directories
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }

            String message = Instant.now() + " - Hello File World!\n";
            Files.writeString(
                    path,
                    message,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            System.out.println("✅ Wrote to log file: " + path.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("⚠️ Error writing file: " + e.getMessage());
        }
    }

    // Read and print file attributes
    private static void extraInfo(Path path) {
        try {
            System.out.println("\nFile attributes:");
            Map<String, Object> attrs = Files.readAttributes(path, "*");
            attrs.forEach((k, v) -> System.out.println("  " + k + " : " + v));
        } catch (IOException e) {
            System.out.println("⚠️ Error reading attributes: " + e.getMessage());
        }
    }

    // 4️⃣ Detect file content type
    private static void probeType(Path path) {
        try {
            String type = Files.probeContentType(path);
            System.out.println("\nDetected content type: " + type);
        } catch (IOException e) {
            System.out.println("⚠️ Error detecting type: " + e.getMessage());
        }
    }
}