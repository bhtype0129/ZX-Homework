import cn.hyy.learn.SpringTest;
import cn.hyy.learn.domain.BookDO;
import cn.hyy.learn.domain.condition.BookCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

@Slf4j
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Spring去读取 .xml配置文件
        SpringTest springTest = (SpringTest) context.getBean("springTest");

        System.out.println("请输入选择的功能：1.显示，2查找，3插入,4更新，5删除 ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                log.info("请显示所有书籍信息");
                log.info("查找的书籍为：");

                break;
            case 2:

                System.out.println("请输入要查询书的编号或者范围：");
                //System.out.println(springTest.selectByPrimaryKey(scanner.nextLong()));
                BookCondition example = new BookCondition() ;
                BookCondition.Criteria criteria = example.createCriteria();
                criteria.andNameEqualTo("活着");
                //criteria.andNameIsNull();
                //example.setOrderByClause("书名，作者，分类，简介");
                List<BookDO> bookDOList = springTest.selectByExample(example);
                for (int i = 0; i < bookDOList.size(); i++) {
                    System.out.println(bookDOList.get(i));

                }

                break;
            case 3:
                BookDO bookDO = new BookDO();
                System.out.println("请输入书名，作者，分类，简介");

                if (scanner.next().equals("书名")) {
                    String name = scanner.next();
                    bookDO.setName(name);
                }
                if (scanner.next().equals("作者")) {
                    String author = scanner.next();
                    bookDO.setAuthor(author);
                }
                if (scanner.next().equals("分类")) {
                    String catalogue = scanner.next();
                    bookDO.setCatalogue(catalogue);
                }
                if (scanner.next().equals("简介")) {
                    String brief = scanner.next();
                    bookDO.setBrief(brief);
                }

                if (bookDO.getName() == null | bookDO.getAuthor() == null | bookDO.getCatalogue() == null | bookDO.getBrief() == null) {
                    springTest.insertSelective(bookDO);
                } else {
                    springTest.insert(bookDO);
                }
                break;
            case 4:
                BookDO bookDO1 = new BookDO();
                System.out.println("请输入更新的内容：");
                springTest.updateByPrimaryKey(bookDO1);
                break;
            case 5:
                System.out.println("请输入要删除书的编号：");
                springTest.deleteByPrimaryKey(scanner.nextLong());
                break;
        }







        //SpringTest springTest = (SpringTest) context.getBean("123");
        //springTest.show();

      /*  BookDO bookDO = new BookDO();
        bookDO.setName("name");
        bookDO.setAuthor("author");
        //System.out.println(bookDO);
        log.info("12355555");
        log.error("这是我的第一条日志");
        log.debug("ERROR");
        log.info("\nbook={} \nbook1={}", bookDO, bookDO);//用于调试*/





    }
}
