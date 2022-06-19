package byte_base_stream.byte_io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteArrayInputOutputTest {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("사용법 : java ByteArrayInputOutputTest 파일명");
            System.exit(0);
        }

        FileInputStream fis = null;
        ByteArrayInputStream bais = null;
        ByteArrayOutputStream baos = null;
        try {
            fis = new FileInputStream(args[0]);
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[512];
            int readCount = 0;
            while ((readCount = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, readCount);
            }


            byte[] fileArray = baos.toByteArray();
            System.out.println("파일의 내용을 모두 읽어 byte[]로 만들었습니다.");
            System.out.println("읽어 들인 byte 수 : " + fileArray.length);

            bais = new ByteArrayInputStream(fileArray);
            while ((readCount = bais.read(buffer)) != -1) {
                System.out.write(buffer, 0, readCount);
            }
            System.out.println("\n\n");
            System.out.println("읽어들인 내용을 모두 출력했습니다.");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                fis.close();
                bais.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
