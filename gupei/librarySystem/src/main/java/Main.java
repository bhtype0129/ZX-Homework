import cn.cooper.uestc.SpringTest;

import cn.cooper.uestc.domain.BookDo;
import cn.cooper.uestc.domain.condition.BookCondition;
import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.nio.file.FileSystemAlreadyExistsException;
import java.util.Scanner;

@Slf4j
public class Main {
    Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

//
//         Menu menu = new Menu();
//         menu.menuShow();
//
//
//         //在类路径中寻找applicationContext.xml配置文件作为参数传入
//         ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//         SpringTest springTest = new SpringTest();
//         SpringTest springTest1 = (SpringTest) context.getBean("SpringTest");
//         springTest1.show();
//         BookDO book = new BookDO();
//         log.info("class1={} class2={}", book, book);//打日志的模板写法


        //applicationContext是一个接口，相当于spring的入口，建立context这个对象引用，通过
        // “classpath这个实现类具有构造方法”里读取applicationContext.xml配置文件，完成相应的初始化，如对
        //component的组件建立实例。
        /**
         ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         SpringTest springTest = (SpringTest) context.getBean("springTest");//获取到这个实例
         BookDo bookDO = new BookDo();
         bookDO.setName("name");
         bookDO.setAuthor("author");
         bookDO.setCatalogue("catalogue");
         bookDO.setIntro("intro");
         springTest.insert(bookDO);
         //对BookConditiond对象进行了条件设置，第二行createCriteria就是对BookCondition进行条件方面的设置
         //如id的条件，或者说number的条件设置或者是其他设置。
         BookCondition bookCondition = new BookCondition();
         bookCondition.createCriteria().andIdEqualTo(4L);
         */


    }


}
