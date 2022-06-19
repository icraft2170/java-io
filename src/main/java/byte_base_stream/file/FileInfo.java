package byte_base_stream.file;

import java.io.File;
import java.io.IOException;

/**
 * IDE를 사용하고 있다면 args 에 test.txt 파일의 경로를 입력해 주어야 함.
 * 아니라면 java FileInfo ..../test.txt
 */
public class FileInfo {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("사용법 : java FileInfo 파일명");
            System.exit(0);
        }

        File f = new File(args[0]);
        if (f.exists()) {
            System.out.println("f.length() = " + f.length());
            System.out.println("f.canRead() = " + f.canRead());
            System.out.println("f.canWrite() = " + f.canWrite());
            System.out.println("f.getAbsolutePath() = " + f.getAbsolutePath());
            try {
                System.out.println("f.getCanonicalPath() = " + f.getCanonicalPath());
            } catch (IOException e) {
                System.out.println(e);
            }
            System.out.println("f.getName() = " + f.getName());
            System.out.println("f.getParent() = " + f.getParent());
            System.out.println("f.getPath() = " + f.getPath());
        } else {
            System.out.println("파일이 존재하지 않습니다.");
        }
    }
}
