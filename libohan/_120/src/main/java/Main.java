

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Library library = new Library();
        library.CreateList();
        boolean a = true;
        Scanner scanner = new Scanner(System.in);
        while (a) {
            System.out.println("请输入选择的功能：1显示，2查找，3插入,4更新，5删除 ,6保存退出");
            switch (scanner.nextInt()) {
                case 1:
                    library.show();
                    break;

                case 2:
                    System.out.println("请输入书籍编号");
                    int index = library.search(scanner.nextInt());
                    if (index == -1) {
                        System.out.println("无此书");
                    } else {
                        System.out.println(library.getBookList().get(index));
                    }

                    break;

                case 3:
                    System.out.println("请输入插入书籍的：1.书名，2.编号，3.作者，4.类别，5.简介,请用空格隔开");

                    Book book = new Book();
                    book.setBookName(scanner.next());
                    book.setBookID(Integer.valueOf(scanner.next()));
                    book.setWriter(scanner.next());
                    book.setClassify(scanner.next());
                    book.setBrief(scanner.next());

                    library.insert(book);
                    System.out.println("插入成功");

                    break;

                case 4:
                    Book book1 = new Book();
                    boolean temp1 = true;
                    while (temp1) {
                        System.out.println("请输入要更新的书的编号");
                        int index1 = library.search(scanner.nextInt());
                        if (index1 == -1) {
                            System.out.println("无此书");
                        } else {
                            temp1 = false;
                            boolean temp = true;
                            while (temp) {
                                System.out.println("请输入要修改的内容:1.书名，2.编号，3.作者，4.类别，5.简介，6.退出更新");
                                switch (scanner.nextInt()) {
                                    case 1:
                                        System.out.println("请输入修改内容");
                                        book1.setBookName(scanner.next());
                                        break;
                                    case 2:
                                        System.out.println("请输入修改内容");
                                        book1.setBookID(scanner.nextInt());
                                        break;
                                    case 3:
                                        System.out.println("请输入修改内容");
                                        book1.setWriter(scanner.next());
                                        break;
                                    case 4:
                                        System.out.println("请输入修改内容");
                                        book1.setClassify(scanner.next());
                                        break;
                                    case 5:
                                        System.out.println("请输入修改内容");
                                        book1.setBrief(scanner.next());
                                        break;
                                    case 6:
                                        temp = false;
                                }
                            }
                            library.update(index1, book1);
                            System.out.println(library.getBookList());
                            System.out.println("更新完成");
                        }
                    }
                    break;

                case 5:
                    System.out.println("请输入要删除的书的编号");
                    int index2 = library.search(scanner.nextInt());
                    library.remove(index2);
                    System.out.println("删除完成");
                    break;

                case 6:
                    library.save();
                    a = false;
                    break;

            }
        }

    }
}












