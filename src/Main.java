import java.io.File;
public class Main {
    public static void main(String[] args) {

        File currentDir = new File(".");
        File[] files = currentDir.listFiles();
        for (File file : files){
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }


    }
}