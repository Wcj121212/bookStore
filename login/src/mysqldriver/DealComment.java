package mysqldriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//将数据库中的类型导入到首页的类型中
public class DealComment {
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

    public DealComment() {};

    public String[] searchcomment(String bookid) {
        String idandcoment[] = new String[100];
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
            String sql = "select CommID,CommContent from comment where BookID="+bookid;
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i = 0;
            while (rs.next()) {
                idandcoment[i++] = rs.getString("CommID");
                idandcoment[i++] = rs.getString("CommContent");
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
        return idandcoment;
    }
    public int addcomment(String bookid,String useraccount,String fatherid,String comment) {
        comment = "'"+comment+"'";
        int state=0;
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
            String sql = "insert into comment(BookID,UserAccount,FatherCommID,CommContent) values("+
                    bookid+','+useraccount+','+fatherid+','+comment+')';
            // 5、处理查询结果
            int rs = stmt.executeUpdate(sql);
            // 5.1、遍历输出查询结果
            if (rs>0) {
                state = 1;
            }
            // 5、增删改操作
            //int i = stmt.executeUpdate(sql);
            // 6、释放资源
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return state;
    }
    public int addfcomment(String bookid,String useraccount,String comment) {
        comment = "'"+comment+"'";
        int state=0;
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
            String sql = "insert into comment(BookID,UserAccount,CommContent) values("+
                    bookid+','+useraccount+','+comment+')';
            // 5、处理查询结果
            int rs = stmt.executeUpdate(sql);
            // 5.1、遍历输出查询结果
            if (rs>0) {
                state = 1;
            }
            // 5、增删改操作
            //int i = stmt.executeUpdate(sql);
            // 6、释放资源
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return state;
    }
}
