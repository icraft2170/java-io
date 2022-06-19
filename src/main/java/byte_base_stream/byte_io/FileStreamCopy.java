package byte_base_stream.byte_io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamCopy {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("사용법 : java FileStreamCopy 파일1 파일2");
            System.exit(0);
        }

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(args[0]);
            fos = new FileOutputStream(args[1]);
            byte[] buffer = new byte[512];
            int readCount = 0;

            while ((readCount = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, readCount);
            }
            System.out.println("복사가 완료되었습니다.");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
