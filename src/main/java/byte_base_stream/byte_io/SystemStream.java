package byte_base_stream.byte_io;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class SystemStream {
    public static void main(String[] args) {
        try {
            int ch;
            while (true) {
                PipedInputStream writeIn = new PipedInputStream();
                PipedOutputStream readOut = new PipedOutputStream(writeIn);

                ReadThread rt = new ReadThread(System.in, readOut);
                ReadThread wt = new ReadThread(writeIn, System.out);

                rt.start();
                wt.start();
                // System.in -> PipedOutput -> PipedInput -> System.out
            }
        } catch (Exception exception) { }
    }
}

class ReadThread extends Thread implements Runnable {
    InputStream pi = null;
    OutputStream po = null;

    public ReadThread(InputStream pi, OutputStream po) {
        this.pi = pi;
        this.po = po;
    }

    public void run() {
        int ch;
        byte[] buffer = new byte[512];
        int bytes_read;
        try {
            for (; ; ) {
                bytes_read = pi.read(buffer);
                if (bytes_read == -1) { return; }
                po.write(buffer, 0, bytes_read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally { }
    }
}
