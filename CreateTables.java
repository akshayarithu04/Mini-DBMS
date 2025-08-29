import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateTables {
    public static void createTable(File currentData,String name,String schema) throws IOException {
        if(currentData!=null){
            File newFile=new File(currentData,name+".txt");
            File metaFile=new File(currentData,name+".meta");
            if(newFile.exists()|| metaFile.exists()) {
                System.out.println("Table Already Exist in the name of " + name);
            } else {
                newFile.createNewFile();
                metaFile.createNewFile();
                try (FileWriter fw = new FileWriter(metaFile)) {
                    fw.write(schema);
                    fw.close();
                }
                System.out.println("File created");
            }
        }else{
            System.out.println("Choose a Database to be Used");
        }
    }
}



