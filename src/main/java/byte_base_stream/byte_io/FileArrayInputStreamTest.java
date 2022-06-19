package byte_base_stream.byte_io;

import java.io.*;

public class FileArrayInputStreamTest {

    public static void print(InputStream in) {
        byte[] buffer = new byte[512];
        int readCount = 0;

        try {
            while ((readCount = in.read(buffer)) != -1) {
                System.out.write(buffer, 0, readCount);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("사용법 : java FileArrayInputStreamTest file/array");
            System.exit(0);
        }

        if (args[0].equals("file")) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream("/Users/sonhyeonho/study/java-io/src/main/resources/file/bytebasestream/filearray/file.dat");
                print(fis);
            } catch (FileNotFoundException e) {
                System.out.println(e);
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {}
            }
        } else if (args[0].equals("array")) {
                byte[] abc = new byte[26];
                for (int i = 0; i < 26; i++) {
                    abc[i] = (byte) ('a' + i);
                }
                ByteArrayInputStream bais = null;
            try {
                bais = new ByteArrayInputStream(abc);
                print(bais);
            } catch (Exception ex) {
                System.out.println(ex);
            } finally {
                try {
                    bais.close();
                } catch (IOException e) {}
            }
        } else {
            System.out.println("사용법 : java FileArrayInputStreamTest file/array);");
            System.exit(0);
        }
    }
}

