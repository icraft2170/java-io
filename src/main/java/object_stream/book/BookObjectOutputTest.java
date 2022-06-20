package object_stream.book;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookObjectOutputTest {
    public static void main(String[] args) {

        ArrayList<Book> bookList = new ArrayList<>();
        Book bookA = new Book("a0001", "자바의 신", "이상민", 15000);
        Book bookB = new Book("a0002", "토비의 스프링", "이일민", 25000);
        Book bookC = new Book("a0003", "JPA", "김영한", 35000);
        Book bookD = new Book("a0004", "똑똑하게 생존하기", "미상", 48000);
        bookList.add(bookA);
        bookList.add(bookB);
        bookList.add(bookC);
        bookList.add(bookD);


        try (
                FileOutputStream fout = new FileOutputStream("/Users/sonhyeonho/study/java-io/src/main/resources/file/object-stream/booklist.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fout);
        ) {
            oos.writeObject(bookList);
            oos.reset();
            System.out.println("저장되었습니다.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
