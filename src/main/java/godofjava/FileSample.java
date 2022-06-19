package godofjava;

import java.io.File;
import java.util.Date;

public class FileSample {
    public static void main(String[] args) {
        FileSample sample = new FileSample();
        String pathName = "Users/sonhyeonho/study/java-io/src/main/resources/file/godofjava/text";
        sample.checkPath(pathName);
        sample.checkPath(pathName + "2");
        sample.fileSeparator();
        sample.makeDir(pathName + "/abc");
        sample.checkFileMethods(pathName);
        sample.canFileMethods(pathName);
        sample.lastModified(pathName);
    }

    public void fileSeparator() {
        String separator = File.separator;
        System.out.println("separator = " + separator);
    }

    public void checkPath(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + " is exists? :" + file.exists());
    }

    public void makeDir(String pathName) {
        File file = new File(pathName);
        System.out.println("Make " + pathName+ " result :" + file.mkdir() );
    }

    public void checkFileMethods(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + " is directory? : " + file.isDirectory()); // 해당 Path가 Directory 인가?
        System.out.println(pathName + " is file? : " + file.isFile()); // 해당 Path가 file 인가?
        System.out.println(pathName + " is hidden? : " + file.isHidden()); // 해당 Path가 hidden 인가?
    }

    public void canFileMethods(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + " can read? : " + file.canRead()); // 해당 path의 파일을 읽을 수 있는가?
        System.out.println(pathName + " can write? : " + file.canWrite()); // 해당 path의 파일을 쓸 수 있는가?
        System.out.println(pathName + " can execute? : " + file.canExecute()); // 해당 path의 파일을 실행 할 수 있는가?
    }

    public void  lastModified(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + " last modified :" + new Date(file.lastModified()));
    }
}
