import java.io.File;
public class Main {
    public static void main(String[] args) {

        // getting the current directory
        File currentDir = new File(".");

        //make an array and get all the files inside it
        File[] files = currentDir.listFiles();

        //safety check in case listFiles() returns null
        if (files == null){
            System.out.println("Directory is empty or inaccessible.");
            return;
        }

        //iterate over each item
        for (File file : files){
            //only checking files not folders
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}