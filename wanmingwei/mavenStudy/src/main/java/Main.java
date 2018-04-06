import cn.wmw.learn.SpringTest;
import cn.wmw.learn.domain.BookDO;
import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {
    public static void main(String[] args) {
//      Spring去读取.xml配置文件，生成一个配置文件实例 context  ClassPath...传classpath进去
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//      生成实例 通过getBean来初始化springTest
        SpringTest springTest = (SpringTest) context.getBean("springTest");

//        增
//        BookDO bookDO = new BookDO();
//        bookDO.setName("name");
//        bookDO.setAuthor("author");
//        bookDO.setCatalogue("catalogue");
//        bookDO.setIntro("intro");
//        springTest.insert(bookDO);

//        删
//        springTest.delete(10004);

//        改
//        BookDO bookDO = new BookDO();
//        bookDO.setNumber(10002);
//        bookDO.setName("活着");
//        bookDO.setAuthor("余华");
//        bookDO.setCatalogue("小说");
//        bookDO.setIntro("悲剧");
//        springTest.update(bookDO);

//        查
//        log.info(springTest.get(10002).toString());

    }
}
