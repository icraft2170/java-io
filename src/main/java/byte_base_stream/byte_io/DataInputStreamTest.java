package byte_base_stream.byte_io;

import java.io.*;

public class DataInputStreamTest {

    public static void main(String[] args) {
        FileInputStream fis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream("/Users/sonhyeonho/study/java-io/src/main/resources/file/bytebasestream/primitive-data-in-out/data.bin");
            dis = new DataInputStream(fis);
            boolean b = dis.readBoolean();
            byte b2 = dis.readByte();
            int i = dis.readInt();
            double d = dis.readDouble();
            String s = dis.readUTF();
            System.out.println("boolean = " + b);
            System.out.println("byte = " + b2);
            System.out.println("int = " + i);
            System.out.println("double = " + d);
            System.out.println("string = " + s);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
