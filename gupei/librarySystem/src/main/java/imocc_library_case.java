import java.util.Scanner;

/**
 * 这是自己学习慕课网第三季的时候写的图书管理案例。
 */

public class imocc_library_case {
    Scanner input = new Scanner(System.in);
    int count;

    public static void main(String[] args) {
        String a = "1024";
        Integer X = Integer.valueOf(a);
        System.out.println(X);
        String[] books = {"数据结构", "高数", "红楼梦", "西游记"};
        imocc_library_case getbookSystem = new imocc_library_case(0);

        while (true) {
            try {
                getbookSystem.bookSystem(books);
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;

            }

        }

    }

    public imocc_library_case(int a) {
        count = a;

    }

    public void bookSystem(String[] books) throws Exception {
        int a;
        System.out.println("请输入命令：1按照名称查找书籍。2按照序号查找书籍");
        int catchUser = input.nextInt();
        if (catchUser != 1 && catchUser != 2) {
            System.out.println("输入错误，请输入1和2数字命令");
            throw new Exception();
        }
        switch (catchUser) {
            case 1:
                bookSystem1(books);
                break;
            case 2:
                bookSystem2(books);
                break;
        }


    }


    public void bookSystem1(String[] books) throws Exception {
        int judge = 0;
        System.out.println("请输入图书名称:");
        String a = input.next();
        for (int i = 0; i < books.length; i++) {
            if (a.equals(books[i])) {
                count = i + 1;
                judge = 1;
                break;
            }
        }
        if (judge == 1) {
            System.out.println("书的序号为：" + count);
            System.out.println("书的名称为：" + a);
        }
        if (judge == 0) {
            System.out.println("找不到该书");
            throw new Exception("本图书馆列表中没有这本书");
        }
    }

    public void bookSystem2(String[] books) throws Exception {
        System.out.println("请输入序号");
        int xuhao = input.nextInt();
        if (xuhao <= 0 || xuhao >= 5) {
            System.out.println("找不到该书");
            throw new Exception("您的输入超过输入范围");

        } else {
            System.out.println("书的序号为：" + xuhao);
            System.out.println("book:" + books[xuhao - 1]);
        }
    }


}



