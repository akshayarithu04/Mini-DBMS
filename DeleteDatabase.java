import java.io.File;
public class DeleteDatabase{
    public static void deleteDataBase(File path, String name) {
        if (path.exists()) {
            File[] files = path.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory() && f.getName().equals(name)) {
                        deleteDataBase(f, f.getName()); // delete inside first
                    }
                    f.delete(); // delete file or now-empty folder
                }
            }
            System.out.println("Database " + name + " deleted successfully!");
        } else {
            System.out.println("Database " + name + " does not exist!");
        }
    }
}
