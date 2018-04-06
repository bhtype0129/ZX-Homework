import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem implements BookListOperate {
    List<Book> bookList = new ArrayList<Book>();
    Scanner input = new Scanner(System.in);

    //读取本地文件的方法
    public void readFile() throws IOException {
        Scanner scanner = new Scanner(new File("/home/sunday/qq下载/liebiao.csv"));
        scanner.nextLine();
        while (scanner.hasNext()) {
            bookListAdd(scanner.nextLine());

        }
        scanner.close();
    }

    //保存一本书到本地文件
    public void savaBook(String getUser) throws IOException {
        File file = new File("/home/sunday/qq下载/liebiao.csv");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.write(getUser + "\n");
        printWriter.flush();

    }

    //把从外面(包括用户和本机本文件)得到的字符串拆分掉，并创建一个book对象，其属性进行赋值，并将这本book添加到list集合中。
    public void bookListAdd(String a) {
        String[] bookArray = a.split(" ");
        Book bookTest = new Book();
        bookTest.setNumber(Long.valueOf(bookArray[0]));
        bookTest.setName(bookArray[1]);
        bookTest.setAuthor(bookArray[2]);
        bookTest.setCatalogue(bookArray[3]);
        bookTest.setIntro(bookArray[4]);
        bookList.add(bookTest);

    }

    //遍历书的集合
    public void traverse() {
        for (Book element : bookList) {
            System.out.println(element.toString());

        }
    }


    //以名字找一本书的方法
    public Book search(String name) {

        for (Book element : bookList) {
            if (element.getName().equals(name)) {
                System.out.println(element);
                return element;
            }

        }
        System.out.println("没有这本书");
        return null;

    }

    //以id找一本书的方法
    public Book search(int id) {

        for (Book element : bookList) {
            if (element.getNumber() == id) {
                System.out.println(element);
                return element;
            }

        }
        System.out.println("没有这本书");
        return null;

    }

    //插入一本书的方法
    public void insert(String name) {
        bookListAdd(name);
        traverse();

    }



    //更改一本书的信息的方法
    public Book update(Book bookGet) {

        int catchUser = input.nextInt();
        if (catchUser == 1) {
            System.out.println("请输入新的id:");
            bookGet.setNumber(input.nextInt());
            System.out.println(bookGet);
        }
        if (catchUser == 2) {
            System.out.println("请输入新的书名");
            bookGet.setName(input.next());
            System.out.println(bookGet);
        }
        if (catchUser == 3) {
            System.out.println("请输入新的目录");
            bookGet.setCatalogue(input.next());
            System.out.println(bookGet);
        }
        if (catchUser == 4) {
            System.out.println("请输入新的简介");
            bookGet.setIntro(input.next());
            System.out.println(bookGet);
        }
        return bookGet;
    }

    //删除一本书的方法
    public void remove(String name) {
        for (Book element : bookList) {
            if (element.getName().equals(name)) {
                System.out.println(element);
                System.out.println("确认要删除这本书么：按下y表示是，n表示不是");
                if (input.next().equals("y")) {
                    bookList.remove(element);
                    traverse();
                }
                break;
            }
        }

    }


}
