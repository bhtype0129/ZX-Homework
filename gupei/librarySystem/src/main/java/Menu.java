import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);


    public void menuShow() {
        String getUser;
        LibraryManagementSystem test1 = new LibraryManagementSystem();
        try {
            test1.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("欢迎进入书籍管理系统：请按照以下提示进行操作");
        while (true) {
            System.out.println("按下0查看当前书籍列表，按下1增加一本书，按下2删除一本书，按下3更新一本书的信息，" +
                    "按下4搜索某本书的信息,按下5保存书到本地文件");
            int catchUser = 0;
            try {
                catchUser = input.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (catchUser == 0) {
                test1.traverse();
                continue;
            }
            if (catchUser == 1) {
                System.out.println("请您依次输入：书的id号 书名 书的作者名 书的目录 书的简介 "
                        + "\t" + "以空格分割，并在结束后按下回车键");
                input.nextLine();
                 getUser = input.nextLine();
                test1.insert(getUser);

            }
            if (catchUser == 2) {
                System.out.println("请输入您要删除的书名");
                getUser  = input.next();
                test1.remove(getUser);
            }
            if (catchUser == 3) {
                System.out.println("请输入您要更新书的id:");
                int getUser1 = input.nextInt();
                Book bookGet = test1.search(getUser1);
                if (bookGet == null) {
                    continue;
                }
                while (true) {
                    System.out.println("更新书相关信息将输入以下数字:");
                    System.out.println("1.表示更新id 2.表示更新name 3.表示更新作者 4.表示更新目录 5.表示更新简介");
                    test1.update(bookGet);
                    System.out.println("请问还需要修改该书的其他信息么：按下y表示继续，按下n表示退出");
                    getUser = input.next();
                    if (getUser.equals("y")) {
                        continue;
                    } else {
                        break;
                    }
                }

            }
            if (catchUser == 4) {
                test1.search(input.nextInt());
            }
            if (catchUser == 5) {
                while (true) {
                    System.out.println("请您依次输入：书的id号 书名 书的作者名 书的目录 书的简介 "
                            + "\t" + "以空格分割，并在结束后按下回车键");
                    input.nextLine();
                    getUser = input.nextLine();
                    try {
                        test1.savaBook(getUser);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("还需要继续写入书籍并保存么:1表示继续，2表示退出");
                    int getUser1 = input.nextInt();
                    if (getUser1==1) {
                        continue;
                    }
                    if (getUser1 == 2) {
                        break;
                    }

                }


            }
            System.out.println("您还要进行操作么，按下y表示继续，按下n表示退出程序");
             getUser = input.next();
            if (getUser.equals("y")) {
                continue;
            }
            if (getUser.equals("n")) {
                System.out.println("谢谢您使用");
                break;
            }
        }

    }

}
