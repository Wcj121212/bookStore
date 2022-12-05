package mysqldriver;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//将数据库中的类型导入到首页的类型中
public class SearchType {
    // 加载数据库驱动
    private static String driveName = "com.mysql.cj.jdbc.Driver";
    // 数据库连接地址
    private static String url = "jdbc:mysql://localhost/buybook?useUnicode=yes&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    // 数据库名称
    private static String name = "root";
    // 数据库密码
    private static String password = "123456";
    // 存储连接数据库
    private static Connection connection = null;
    public SearchType(){};
    //找图书类型名
    public String[] deal() {
        String typename[]=new String[30];
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
            String sql = "select TypeName from booktype";
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i=0;
            while (rs.next()) {
                typename[i++] = rs.getString("Typename");
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
        return typename;
    }
    //找图书价格和名字
    public String[] type(String typename) {
        String namePrice[]=new String[200];
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
            String sql = "select b.BookID,BookName,BookPrice from bookinfo as b,booktype as t,book_type_relation as bt " +
                    "where b.BookID=bt.BookID and bt.TypeID=t.TypeID and TypeName='"+typename+"'";
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i=0;
            while (rs.next()) {
                namePrice[i++] = rs.getString("BookID");
                namePrice[i++] = rs.getString("BookName");
                namePrice[i++] = rs.getString("BookPrice");

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
        return namePrice;
    }
    //模糊匹配
    public String[] search(String s) {
//        s = "'"+s+"'";
        String namePrice[]=new String[100];
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
            String sql = "select BookID,BookName,BookPrice from bookinfo where BookName like '%"+s+"%'";
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i=0;
            while (rs.next()) {
                namePrice[i++] = rs.getString("BookID");
                namePrice[i++] = rs.getString("BookName");
                namePrice[i++] = rs.getString("BookPrice");

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
        return namePrice;
    }
    //找出所有的图书
    public String[] all() {
        String namePrice[]=new String[200];
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
            String sql = "select BookID,BookName,BookPrice from bookinfo";
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i=0;
            while (rs.next()) {
                namePrice[i++] = rs.getString("BookID");
                namePrice[i++] = rs.getString("BookName");
                namePrice[i++] = rs.getString("BookPrice");

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
        return namePrice;
    }
    public String user(String account) {
        String username="";
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
            String sql = "select UserName from userinfo where UserAccount="+account;
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i=0;
            while (rs.next()) {
                username = rs.getString("UserName");

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
        return username;
    }
    //查找图书描述
    public String bookms(String bookid) {
        String bookms="";
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
            String sql = "select BookMS from bookinfo where BookID="+bookid;
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i=0;
            while (rs.next()) {
                bookms = rs.getString("BookMS");

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
        return bookms;
    }
    public String booknumber(String bookid) {
        String booknumber="";
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
            String sql = "select BookNumber from bookinfo where BookID="+bookid;
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i=0;
            while (rs.next()) {
               booknumber  = rs.getString("BookNumber");

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
        return booknumber;
    }


}