package char_base_stream;

import java.io.*;

public class LineWriter {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.exit(0);
        }

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter pw = new PrintWriter(new BufferedWriter(
                        new FileWriter(args[0])));
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println("읽어들인 문자열 : " + line);
                pw.println(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
