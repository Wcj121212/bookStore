package mysqldriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//将数据库中的类型导入到首页的类型中
public class DealUser {
    // 加载数据库驱动
    private static String driveName = "com.mysql.cj.jdbc.Driver";
    // 数据库连接地址
    private static String url = "jdbc:mysql://localhost:3306/buybook?useUnicode=yes&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    // 数据库名称
    private static String name = "root";
    // 数据库密码
    private static String password = "123456";
    // 存储连接数据库
    private static Connection connection = null;

    public DealUser() {};

    //找出用户信息
    public String[] user(String account) {
        String user[] = new String[30];
        // 1、加载驱动
        try {
            System.out.println("开始加载驱动");
            Class.forName(driveName);
            System.out.println("加载成功");
        } catch (Exception e) {
            System.out.println(e);
        }

        // 2、连接数据库
        try {
            System.out.println("开始连接！！");
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("连接成功！！");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("开始执行！！");
            // 3、获取数据库语句操作对象
            Statement stmt = connection.createStatement();
            // 4、执行SQL语句
            String sql = "select * from userinfo where UserAccount="+account;
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i = 0;
            while (rs.next()) {
                user[i++] = "账号："+rs.getString("UserAccount");
//                user[i++] = "密码："+rs.getString("UserPWD");
                user[i++] = "昵称："+rs.getString("UserName");
                user[i++] = "手机号："+rs.getString("UserPhone");
                user[i++] = "性别："+rs.getString("Sex");
                user[i++] = "年龄："+rs.getString("UserAge");
                user[i++] = "收货地址："+rs.getString("Address");


            }
            // 5、增删改操作
            //int i = stmt.executeUpdate(sql);
            // 6、释放资源
            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }
    //订单
    public String[] dd(String account) {
        String user[] = new String[1000];
        // 1、加载驱动
        try {
            System.out.println("开始加载驱动");
            Class.forName(driveName);
            System.out.println("加载成功");
        } catch (Exception e) {
            System.out.println(e);
        }

        // 2、连接数据库
        try {
            System.out.println("开始连接！！");
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("连接成功！！");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("开始执行！！");
            // 3、获取数据库语句操作对象
            Statement stmt = connection.createStatement();
            // 4、执行SQL语句
            String sql = "select BookName,Price,Creat_Time from orderinfo,bookinfo " +
                    "where orderinfo.BookID=bookinfo.BookID and UserAccount="+account;
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i = 0;
            while (rs.next()) {
                user[i++] = rs.getString("BookName");
                user[i++] = rs.getString("Price");
                user[i++] = rs.getString("Creat_Time");



            }
            // 5、增删改操作
            //int i = stmt.executeUpdate(sql);
            // 6、释放资源
            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }
    //购物车
    public String[] gwc(String account) {
        String user[] = new String[1000];
        // 1、加载驱动
        try {
            System.out.println("开始加载驱动");
            Class.forName(driveName);
            System.out.println("加载成功");
        } catch (Exception e) {
            System.out.println(e);
        }

        // 2、连接数据库
        try {
            System.out.println("开始连接！！");
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("连接成功！！");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("开始执行！！");
            // 3、获取数据库语句操作对象
            Statement stmt = connection.createStatement();
            // 4、执行SQL语句
            String sql = "select Book_CarID,BookName,bc.BookNumber from book_car_relation as bc,carinfo as c,bookinfo as b " +
                    "where bc.CarID=c.CarID and bc.BookID=b.BookID and UserAccount="+account;
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i = 0;
            while (rs.next()) {
                user[i++] = rs.getString("Book_CarID");
                user[i++] = rs.getString("BookName");
                user[i++] = rs.getString("BookNumber");



            }
            // 5、增删改操作
            //int i = stmt.executeUpdate(sql);
            // 6、释放资源
            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

}
