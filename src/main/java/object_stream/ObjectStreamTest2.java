package object_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class ObjectStreamTest2 {
    public static void main(String[] args) {
        try (
                FileInputStream fin = new FileInputStream("/Users/sonhyeonho/study/java-io/src/main/resources/file/object-stream/object.dat");
                ObjectInputStream ois = new ObjectInputStream(fin);
            ){
            Vector v = (Vector) ois.readObject();
            Vector v1 = (Vector) v.get(0);
            String d1 = (String) v1.get(0);
            String d2 = (String) v1.get(1);
            String d3 = (String) v1.get(2);
            Vector v3 = (Vector) v.get(1);
            Vector v2 = (Vector) v3.get(0);
            String d4 = (String) v2.get(0);

            System.out.println("d1 = " + d1);
            System.out.println("d2 = " + d2);
            System.out.println("d3 = " + d3);
            System.out.println("d4 = " + d4);
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
