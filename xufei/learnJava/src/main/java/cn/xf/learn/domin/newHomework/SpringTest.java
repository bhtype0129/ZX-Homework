package cn.xf.learn.domin.newHomework;

import cn.xf.learn.domin.BookDO;
import cn.xf.learn.mapper.BookMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Scanner;


@Component
public class SpringTest {
    @Resource
    BookMapper bookMapper;

    public void insert(BookDO bookDO) {
        bookMapper.insert(bookDO);
    }

    public BookDO select(Integer bookIdSelect) {
        BookDO bookDOSelect = bookMapper.selectByPrimaryKey(bookIdSelect);
        return bookDOSelect;
    }

    public BookDO preInsert(String insertLine) {
        String[] arr = insertLine.split(",");
        BookDO booksDOpreInsert = new BookDO();
        booksDOpreInsert.setName(arr[0]);
        booksDOpreInsert.setId(Integer.parseInt(arr[1]));
        booksDOpreInsert.setAuthor(arr[2]);
        booksDOpreInsert.setCatalogue(arr[3]);
        booksDOpreInsert.setIntroduction(arr[4]);
        return booksDOpreInsert;
    }


    public void update(Integer bookIdUpdate) {
        BookDO bookDOUpdate = select(bookIdUpdate);
        bookMapper.updateByPrimaryKey(updateMethod(bookDOUpdate));

    }

    public void delete(Integer bookIdDelete) {
        bookMapper.deleteByPrimaryKey(bookIdDelete);
    }

    /*public void show(){
         for(int i=10001;i<bookMapper.+10002);i++){
             BookDO booksDO4=bookMapper.selectByPrimaryKey(i);
             System.out.println(booksDO4.toString());

         }*/
    public BookDO updateMethod(BookDO booksDOUpdate) {
        Scanner scanner = new Scanner(System.in);
        Boolean flag = true;
        while (flag) {
            System.out.println("请输入要修改的内容部分：" + "1.书名  " + "\t" +
                    " 2.作者  " + "\t" + "  3.分类  " + "\t" + "4.简介" + "\t" + "其他.退出");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    System.out.println("请输入要修改的1.书名内容:");
                    booksDOUpdate.setName(scanner.nextLine());

                    break;
                case 2:
                    System.out.println("请输入要修改的2.作者内容:");
                    booksDOUpdate.setAuthor(scanner.nextLine());

                    break;
                case 3:
                    System.out.println("请输入要修改的3.分类内容:");
                    booksDOUpdate.setCatalogue(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("请输入要修改的4.简介内容:");
                    booksDOUpdate.setIntroduction(scanner.nextLine());
                default:
                    flag = false;
                    break;
            }
        }
        return booksDOUpdate;
    }

    public void show() {
       /* System.out.println(bookMapper.selectByExample());*/
    }
}
