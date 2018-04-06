import cn.wmw.learn.SpringTest;
import cn.wmw.learn.domain.BookDO;
import cn.wmw.learn.domain.condition.BookCondition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

/**
 * Created by mingwei on 18-1-26
 */
public class MainLibraryOperate {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringTest springTest = (SpringTest) context.getBean("springTest");
        boolean needContinue = true;
        Scanner scanner = new Scanner(System.in);
        while (needContinue) {
            System.out.println("请选择所需要的操作：1.显示. 2.查找. 3.插入. 4.删除. 5.更新. 6.退出.");
            switch (scanner.nextInt()) {
                case 1:
                    BookCondition bookCondition = new BookCondition();
                    System.out.println(springTest.getByCondition(bookCondition));
                    break;
                case 2:
                    BookCondition bookCondition2 = new BookCondition();
                    //添加where条件
                    System.out.println("请输入书籍的名称：");
                    bookCondition2.createCriteria().andNameEqualTo(scanner.next());
                    System.out.println(springTest.getByCondition(bookCondition2));
                    break;
                case 3:
                    BookDO bookDO3 = new BookDO();
                    System.out.println("请依次输入书名，作者，分类，简介：");
                    bookDO3.setName(scanner.next());
                    bookDO3.setAuthor(scanner.next());
                    bookDO3.setCatalogue(scanner.next());
                    bookDO3.setIntro(scanner.next());
                    springTest.insert(bookDO3);
                    System.out.println("成功写入一本书籍。");
                    break;
                case 4:
                    System.out.println("请输入要删除书籍的编号：");
                    //这里应该判断是否有此书籍
                    springTest.delete(scanner.nextInt());
                    break;
                case 5:
                    BookDO bookDO5 = new BookDO();
                    System.out.println("请输入要更新书籍的编号：");
                    // 这里应该判断是否有此书籍
                    bookDO5.setNumber(scanner.nextInt());
                    System.out.println("请输入要更新的主题以及内容：");
                    String key = scanner.next();
                    String newContent = scanner.next();
                    if(key.equals("书名")) {
                        bookDO5.setName(newContent);
                    }
                    if(key.equals("作者")) {
                        bookDO5.setAuthor(newContent);
                    }
                    if(key.equals("分类")) {
                        bookDO5.setCatalogue(newContent);
                    }
                    if(key.equals("简介")) {
                        bookDO5.setIntro(newContent);
                    }
                    springTest.update(bookDO5);
                    break;
                case 6:
                    needContinue = false;
                    break;
                default:
                    System.out.println("无效操作！");
                    needContinue = false;
                    break;
            }
        }
    }
}
