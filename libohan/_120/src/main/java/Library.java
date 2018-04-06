import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library implements BookListOperate {
    private List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList() {
        return bookList;
    }

    void CreateList() throws FileNotFoundException {
        File file = new File("/home/bh-type0129/Desktop/图书列表.csv");
        Scanner scanner = new Scanner(new FileInputStream(file));
        Book book = new Book();
        if (scanner.hasNext()) {
            scanner.nextLine();
        } else {
            System.out.println("列表为空");
        }
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] str = line.split(",");
            book.setBookName(str[0]);
            book.setBookID(Integer.valueOf(str[1]));
            book.setWriter(str[2]);
            book.setClassify(str[3]);
            book.setBrief(str[4]);
            bookList.add(book);
        }
        scanner.close();
    }

    @Override
    public int search(int bookId) throws FileNotFoundException {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getBookID() == bookId) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public void insert(Book book) throws IOException {
        bookList.add(book);
    }

    @Override
    public void update(int index, Book newBook) throws IOException {
        Book book = bookList.get(index);
        if (newBook.getBookName() != null) {
            book.setBookName(newBook.getBookName());
        }
        if (newBook.getBookID() != null) {
            book.setBookID(newBook.getBookID());
        }
        if (newBook.getWriter() != null) {
            book.setWriter(newBook.getWriter());
        }
        if (newBook.getBrief() != null) {
            book.setBrief(newBook.getBrief());
        }
        if (newBook.getClassify() != null) {
            book.setClassify(newBook.getClassify());
        }
    }

    @Override
    public void remove(int index) throws IOException {
        bookList.remove(index);
    }

    public void save() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("//home/bh-type0129/Desktop/图书列表.csv");
        printWriter.println("书名,编号,作者,分类,简介");
        for (Book book : bookList) {
            String str = book.getBookName() + "," + book.getBookID() + "," + book.getWriter() + "," + book.getBrief() + "," + book.getClassify();
            printWriter.println(str);
        }
        printWriter.close();

    }


    @Override
    public void show() throws FileNotFoundException {
        for (Book aBookList : bookList) {
            System.out.println(aBookList);
        }
    }
}