import java.io.*;

public class Directory {
    private final File directory = new File(System.getProperty("user.home") + "/Documents/SMASABot");
    public void createDirectory() {
        if (directory.mkdirs()) {
            System.out.println("Created directory: " + directory);
        }
    }
}
