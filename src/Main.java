import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Main {
    public static void main(String[] args) {

        // getting the current directory
        File currentDir = new File(".");

        //make an array and get all the files inside it
        File[] files = currentDir.listFiles();

        //safety check in case listFiles() returns null
        if (files == null) {
            System.out.println("Directory is empty or inaccessible.");
            return;
        }

        //iterate over each item
        for (File file : files) {
            //only checking files not folders
            if (file.isFile()) {
                processFile(file);
            }
        }
    }
    public static void processFile(File file){
        String fileName = file.getName();

        //get index of last dot to get the extension
        int dotIndex = fileName.lastIndexOf('.');

        /*ignore files with a starting dot and ending dot
        only want files that have extensions like .jpg .jpeg
         */
        if (dotIndex > 0 && dotIndex < fileName.length()-1){
            //add the extension to a string and remove dot
            String extension = fileName.substring(dotIndex +1).toLowerCase();

            //categorize the files based on their extension
            String category = getCategory(extension);

            //make folder category wise if folder doesn't exist already
            File categoryFolder = new File(category);
            if (!categoryFolder.exists()){
                boolean created = categoryFolder.mkdir();
                if (created){
                    System.out.println("Created folder: " + category);
                }
                else {
                    System.out.println("Failed to create folder: " + category);
                }
            }
            try {
                Path sourcePath = file.toPath(); //convert original file to a path object
                Path uniqueTarget = new File(categoryFolder,fileName).toPath(); //intended target path

                //handling duplicate filenames by appending _1,_2...
                int count = 1;

                while (Files.exists(uniqueTarget)){
                    String baseName = fileName.contains(".")
                            ? fileName.substring(0,fileName.lastIndexOf('.'))
                            : fileName;

                    String ext = fileName.contains(".")
                            ? fileName.substring(fileName.lastIndexOf('.'))
                            : "";

                    String newFileName = baseName + "_" + count + ext;
                    uniqueTarget = categoryFolder.toPath().resolve(newFileName);
                    count++;
                }

                Files.move(sourcePath,uniqueTarget);
                System.out.println("Moved: " + fileName + " → " + uniqueTarget);
            }
            catch (IOException e){
                System.out.println("Error moving file: " + fileName);
            }
        }
    }
    public static String getCategory(String extension){
        //categorize the files based on their extension
        return switch (extension){
            case "jpg","jpeg","png","gif","bmp"   -> "Images";
            case "mp4","avi","mkv","mov","flv"    -> "Videos";
            case "mp3","wav","ogg","flac"         -> "Audio";
            case "pdf","docx","txt","pptx","xlsx" -> "Documents";
            default                               -> "Others";
        };
    }
}