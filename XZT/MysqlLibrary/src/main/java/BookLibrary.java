import cn.xzt.learn.Out;
import cn.xzt.learn.domain.BookDO;
import cn.xzt.learn.domain.condition.BookCondition;
import cn.xzt.learn.mapper.BookMapper;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * --Create by xzt-- on 18-1-25
 */
@Component
public class BookLibrary  {
    @Resource
    BookMapper bookMapper;
    //List<BookDO> bookList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public int selectByPrimaryKey(int i) {
        bookMapper.selectByPrimaryKey(i);
        System.out.println(bookMapper.selectByPrimaryKey(i));
        return i;
    }

    public void updateByExample(BookDO book , BookCondition bookCondition) {
        BookDO bookDO = new BookDO();
        BookCondition bookCondition1 = new BookCondition();
        bookCondition.createCriteria().andIdEqualTo(scanner.nextInt());
        bookMapper.updateByExample(book,bookCondition1);
    }

    public void deleteByExample(BookCondition bookCondition) {
        BookCondition condition = new BookCondition();
        bookCondition.createCriteria().andIdEqualTo(scanner.nextInt());
        bookMapper.deleteByExample(condition);
    }

    public void insert(BookDO bookDO) {


        BookDO bookDO1 = new BookDO();
        bookDO1.setId(scanner.nextInt());
        bookDO1.setName(scanner.nextLine());
        bookDO1.setAuthor(scanner.nextLine());
        bookDO1.setClassify(scanner.next());
        bookDO1.setIntro(scanner.next());
        bookMapper.insert(bookDO);
    }
}

