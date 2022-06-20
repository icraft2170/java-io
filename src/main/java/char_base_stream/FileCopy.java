package char_base_stream;

import java.io.FileReader;
import java.io.FileWriter;

public class FileCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.exit(0);
        }

        try(
                FileReader fr = new FileReader(args[0]);
                FileWriter fw =  new FileWriter(args[1]);
            ) {
            char[] buffer = new char[512];
            int readCount = 0;
            while ((readCount = fr.read(buffer)) != -1) {
                fw.write(buffer, 0, readCount);
            }
            System.out.println("파일을 복사했습니다.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
