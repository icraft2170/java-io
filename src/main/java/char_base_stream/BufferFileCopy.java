package char_base_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferFileCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.exit(0);
        }

        try(
                FileReader fr = new FileReader(args[0]);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw =  new FileWriter(args[1]);
                BufferedWriter bw = new BufferedWriter(fw);
            ) {
            char[] buffer = new char[512];
            int readCount = 0;
            while ((readCount = br.read(buffer)) != -1) {
                bw.write(buffer, 0, readCount);
            }
            System.out.println("파일을 복사했습니다.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
