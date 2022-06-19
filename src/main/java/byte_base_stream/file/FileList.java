package byte_base_stream.file;

import java.io.File;

public class FileList {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("사용법 : java FileList 디렉토리명");
            System.exit(0);
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("디렉토리가 존재하지 않습니다.");
            System.exit(0);
        }

        if (file.isDirectory()) {
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                System.out.print(fileList[i].getName() + " : ");
                if (fileList[i].isDirectory()) {
                    System.out.println("디렉토리");
                } else {
                    System.out.print("파일");
                    System.out.print("(");
                    System.out.print(fileList[i].length());
                    System.out.print(") \t");
                }
            }
        } else {
            System.out.println("디렉토리가 아닙니다.");
        }
    }
}
