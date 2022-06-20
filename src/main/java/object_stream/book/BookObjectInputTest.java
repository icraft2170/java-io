package object_stream.book;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookObjectInputTest {
    public static void main(String[] args) {
        try (
                FileInputStream fin = new FileInputStream("/Users/sonhyeonho/study/java-io/src/main/resources/file/object-stream/booklist.dat");
                ObjectInputStream ois = new ObjectInputStream(fin);
        ) {
            ArrayList<Book> bookList = (ArrayList<Book>) ois.readObject();
            Book bookA = bookList.get(0);
            Book bookB = bookList.get(1);
            Book bookC = bookList.get(2);
            Book bookD = bookList.get(3);

            System.out.println(bookA);
            System.out.println(bookB);
            System.out.println(bookC);
            System.out.println(bookD);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
