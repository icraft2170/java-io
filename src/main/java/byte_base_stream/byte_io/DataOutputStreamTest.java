package byte_base_stream.byte_io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamTest {

    public static void main(String[] args) {
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            fos = new FileOutputStream("/Users/sonhyeonho/study/java-io/src/main/resources/file/bytebasestream/primitive-data-in-out/data.bin");
            dos = new DataOutputStream(fos);
            dos.writeBoolean(true);
            dos.writeByte((byte)5);
            dos.writeInt(100);
            dos.writeDouble(200.5);
            dos.writeUTF("hello world");
            System.out.println("저장했습니다.");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
