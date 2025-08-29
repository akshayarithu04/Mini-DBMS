import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static File currentDatabase=null;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.print(">>");
            String input = scan.nextLine();
            String[] parts = input.split(" ");
            String nfile = "C:\\Users\\Admin\\Pictures\\Saved Pictures\\MYDB";
            if (parts[0].equals("create") && parts[1].equals("database")) {
                File file = new File(nfile);
                CreateDatabase.createDatabase(file, parts[2]);
            }
            if (parts[0].equals("show") && parts[1].equals("database")) {
                File file = new File(nfile);
                ShowDatabase.showDatabase(file);
            }
            if (parts[0].equals("drop") && parts[1].equals("database")) {
                File files = new File(nfile);
//                System.out.println(files);
                DeleteDatabase.deleteDataBase(files,parts[2]);
            }
            if (parts[0].equals("use")) {
                File file = new File(nfile);
                currentDatabase = UseDatabase.useDatabase(file, parts[1], currentDatabase);
            }
            if (parts[0].equals("create") && parts[1].equals("table")) {
                String Schema = String.join(" ", java.util.Arrays.copyOfRange(parts, 3, parts.length));
                String schema=Schema.replace("(", "").replace(")", "");
                CreateTables.createTable(currentDatabase, parts[2],schema);
            }
            if(parts[0].equals("insert") && parts[1].equals("into") && parts[3].equals("values")){
                String Value=String.join(" ",java.util.Arrays.copyOfRange(parts,4,parts.length));
                String value=Value.replace("(","").replace(")"," ");
                InsertIntoTable.insertIntoTable(currentDatabase,parts[2],value);
            }
            if (parts[0].equals("show") && parts[1].equals("table")) {
                File file = new File(nfile);
                ShowTable.showTable(currentDatabase);
            }
            if (parts[0].equals("drop") && parts[1].equals("table")) {
                File files = new File(nfile);
//                System.out.println(files);
                DeleteTable.deleteTable(currentDatabase,parts[2]);
            }

        }
    }
}
