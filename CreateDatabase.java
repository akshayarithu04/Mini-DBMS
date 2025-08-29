import java.io.File;
import java.io.IOException;

public class CreateDatabase {
    public static void createDatabase(File nfile,String part) throws IOException {
        File[] file = nfile.listFiles();
        boolean found = false;
        if (file != null) {
            for (File f : file) {
                if (f.isDirectory() && f.getName().equals(part)) {
                    found = true;
                    break;
                }
            }
        }
        if (found == true) {
            System.out.println("Folder in name of " + part + " already exists!!");
        } else {
            File make = new File(nfile,part);
            make.mkdir();
            System.out.println("Database named " + part + " created Successfully!!");
        }
    }
}
