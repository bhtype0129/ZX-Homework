package cn.xf.learn.domin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by xufei on 18-1-24
 */
public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc?" +
            "useUnicode=true&amp;characterEncoding=utf-8";
    private static final String USER = "root";
    private static final String PASSWORD = "1";

    private static Connection connection = null;

    static {
        try {
            //加载驱动器
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 将获取的数据库与java的连接返回（返回类型为Connection）
    public static Connection getConnection() {
        return connection;
    }
}
