import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public interface BookListOperate {


    int search(int bookId) throws FileNotFoundException;

    void insert(Book book) throws IOException;

    void update(int index, Book book) throws IOException;

    void remove(int index) throws IOException;

    void save() throws FileNotFoundException;

    void show() throws FileNotFoundException;

}
