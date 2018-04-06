import cn.xzt.learn.Out;
import cn.xzt.learn.SpringTest;
import cn.xzt.learn.domain.BookDO;
import cn.xzt.learn.domain.condition.BookCondition;
import cn.xzt.learn.mapper.BookMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * --Create by xzt-- on 18-1-24
 */

/*
@Slf4jpublic class Main {
    public static void main(String[] args) {
        //ApplicationContext context1 = new FileSystemXmlApplicationContext();
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookLibrary bookLibrary = (BookLibrary) context.getBean("BookLibrary");
        Scanner input = new Scanner(System.in);
        BookCondition bookCondition = new BookCondition();
        bookCondition.createCriteria();
        bookLibrary.selectByPrimaryKey(10001);
    }
}*/




























        /*while (true) {
            Out out = new Out();
            out.main();
            int num = input.nextInt();
            switch (num) {
                case 1:
                    log.info("请输入书籍编号：");
                    int strs = input.nextInt();
                    int book1 = bookLibrary.bookMapper.selectByPrimaryKey();
                    if (book1 < bookLibrary.bookList.size() && book1 >= 0) {
                        System.out.println("所查找书籍信息：" + bookLibrary.bookList.get(book1));
                    } else {
                        System.out.println("书籍不存在");
                    }

                    break;
                case 2:
                    System.out.println("请输入要删除书籍编号：");
                    String strs2 = input.next();
                    int book2 = bookLibrary.search(Long.valueOf(strs2));
                    bookLibrary.remove(book2);
                    bookLibrary.writeBooklist();
                    break;
                case 3:
                    System.out.println("请输入需要更新的书籍编号");
                    long bookID3 = input.nextLong();
                    int i = bookLibrary.search(bookID3);
                    if (i < 0) {
                        System.out.println("无此书");
                    } else
                        bookLibrary.update(i, bookLibrary.preUpdate());
                    bookLibrary.writeBooklist();
                    break;
                case 4:
                    Book book3 = new Book();
                    bookLibrary.insert(book3);
                    bookLibrary.writeBooklist();
                    break;
                case 5:
                    bookLibrary.look();
                    break;

            }

        }

    }*/
