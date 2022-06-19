package char_base_stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamReaderTest {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.exit(0);
        }

        try(
                FileInputStream fis = new FileInputStream(args[0]);
                InputStreamReader isr = new InputStreamReader(fis);
                OutputStreamWriter osw = new OutputStreamWriter(System.out)
        )
        {
            char[] buffer = new char[512];
            int readCount = 0;
            while ((readCount = isr.read(buffer)) != -1) {
                osw.write(buffer, 0, readCount);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
