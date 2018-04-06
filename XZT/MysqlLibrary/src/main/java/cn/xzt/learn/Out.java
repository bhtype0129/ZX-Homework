package cn.xzt.learn;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * --Create by xzt-- on 18-1-26
 */
@Component
public class Out {
    public void preUpdate() {
        System.out.println("请选择需要修改的内容：1.书名；2.编号；3.作者；4.类别；5.简介;其他：退出");
    }

    public void writeBooklist() {
        System.out.println("是否对操作保存到文件？Y(保存) or N（不保存）");
    }

    public void insert() {
        System.out.println("请输入要插入书籍信息:(请按照书名，编号，作者，分类，简介的顺序)");
    }

    public void main() {
        System.out.println("请选择操作：1.查找书籍信息；2.删除书籍信息；3.更新书籍信息；4.添加书籍信息;5.查看当前列表");
    }
}
