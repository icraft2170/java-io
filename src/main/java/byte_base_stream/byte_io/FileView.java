package byte_base_stream.byte_io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileView {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("사용법 : java FileView 파일명");
            System.exit(0);
        }

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(args[0]);
            int i = 0;
            while ((i = fis.read()) != -1) {
                System.out.write(i);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                fis.close();
            } catch (IOException e) {}
        }

    }
}
