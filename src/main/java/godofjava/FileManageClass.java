package godofjava;

import java.io.File;
import java.io.IOException;

public class FileManageClass {

    public static void main(String[] args) {
        FileManageClass sample = new FileManageClass();
        String pathName = "/Users/sonhyeonho/study/java-io/src/main/resources/file/godofjava" + File.separator;
        String fileName = "test.txt";

        sample.checkFile(pathName, fileName);
    }

    public void checkFile(String pathName, String fileName) {
        File file = new File(pathName, fileName);
        try {
            System.out.println("Create result : " + file.createNewFile());
            getFileInfo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void getFileInfo(File file) throws IOException {
        System.out.println("Absolute path = " + file.getAbsolutePath());
        System.out.println("file.getAbsoluteFile() = " + file.getAbsoluteFile());
        System.out.println("file.getCanonicalPath() = " + file.getCanonicalPath());
        System.out.println("file.getCanonicalFile() = " + file.getCanonicalFile());

        System.out.println("file.getName() = " + file.getName());
        System.out.println("file.getPath() = " + file.getPath());

    }
}
