package byte_base_stream.file;

import java.io.File;

public class FileDelete {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("사용법 : java FileDelete 파일명");
            System.exit(0);
        }

        File file = new File(args[0]);
        if (file.exists()) {
            boolean deleteFlag = file.delete();
            if (deleteFlag) {
                System.out.println("파일 삭제를 성공했습니다.");
            } else {
                System.out.println("파일 삭제를 실패했습니다.");
            }
        } else {
            System.out.println("파일이 존재하지 않습니다.");
        }
    }
}
