package object_stream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class ObjectStreamTest1 {
    public static void main(String[] args) {
        Vector v = new Vector();
        Vector v1 = new Vector();
        Vector v2 = new Vector();
        Vector v3 = new Vector();

        v1.addElement(new String("dataA"));
        v1.addElement(new String("dataB"));
        v1.addElement(new String("dataC"));
        v2.addElement(new String("dataD"));
        v3.addElement(v2);
        v.addElement(v1);
        v.addElement(v3);

        try (
                FileOutputStream fout = new FileOutputStream("/Users/sonhyeonho/study/java-io/src/main/resources/file/object-stream/object.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fout);
            ){
            oos.writeObject(v);
            oos.reset();
            System.out.println("저장되었습니다.");


        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
