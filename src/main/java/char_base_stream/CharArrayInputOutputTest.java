package char_base_stream;

import java.io.*;

public class CharArrayInputOutputTest {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.exit(0);
        }

        CharArrayReader bais = null;
        try (
                FileReader fi = new FileReader(args[0]);
                CharArrayWriter baos = new CharArrayWriter();
        ) {
            char[] buffer = new char[512];
            int readCount = 0;
            while ((readCount = fi.read(buffer)) != -1) {
                baos.write(buffer, 0, readCount);
            }

            char[] fileArray = baos.toCharArray();
            System.out.println("읽어들인 수 : " + fileArray.length);
            bais = new CharArrayReader(fileArray);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            while ((readCount = bais.read(buffer)) != -1) {
                bw.write(buffer, 0, readCount);
                bw.flush();
            }
            System.out.println("\n\n");
            System.out.println("읽은 내용은 모두 출력했습니다.");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bais.close();
            } catch (Exception e){}
        }
    }
}
