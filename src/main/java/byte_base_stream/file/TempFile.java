package byte_base_stream.file;

import java.io.File;
import java.io.IOException;

public class TempFile {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("사용법 : java FileList 디렉토리명");
            System.exit(0);
        }
        File directory = new File(args[0]);
        if(!directory.isDirectory()) {
            System.out.println("디렉터리가 아닙니다.");
            System.exit(0);
        }

        try {
            File springLog = File.createTempFile("spring_log_", ".dat", directory);
            System.out.println("20초 간 멈춰있습니다.");

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e1) {
                System.out.println(e1);
            }
            springLog.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
