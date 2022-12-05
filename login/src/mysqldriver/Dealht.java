package mysqldriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//将数据库中的类型导入到首页的类型中
public class Dealht {
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

    public Dealht() {};

    //找出所有用户
    public String[] alluser() {
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
            String sql = "select * from userinfo ";
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i = 0;
            while (rs.next()) {
                user[i++] = rs.getString("UserAccount");
                user[i++] = rs.getString("UserPWD");
                user[i++] = rs.getString("UserName");
                user[i++] = rs.getString("IsActive");


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
    //修改用户信息
    public int xguser(String account,String upassword, String username,String userstate) {
        username="'"+username+"'";
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
            String sql = "update userinfo set UserPWD="+upassword+','+
                    "Username="+username+','+"IsActive="+userstate+" where UserAccount="+account;
            // 5、处理查询结果
            int rs = stmt.executeUpdate(sql);
            if(rs>0){
                state=1;
            }
            // 5.1、遍历输出查询结果
            int i = 0;
            // 5、增删改操作
            //int i = stmt.executeUpdate(sql);
            // 6、释放资源
//            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return state;
    }
    //找出所有类型
    public String[] alltype() {
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
            String sql = "select TypeID,TypeName from booktype";
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i=0;
            while (rs.next()) {
                typename[i++] = rs.getString("TypeID");
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
    //修改类型名
    public int xgtype(String typeid,String typename) {
        typename="'"+typename+"'";
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
            String sql = "update booktype set TypeName="+typename+
                    " where TypeID="+typeid;
            // 5、处理查询结果
            int rs = stmt.executeUpdate(sql);
            if(rs>0){
                state=1;
            }
            // 5.1、遍历输出查询结果
            int i = 0;
            // 5、增删改操作
            //int i = stmt.executeUpdate(sql);
            // 6、释放资源
//            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return state;
    }
    //找出所有图书
    public String[] allbook() {
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
            String sql = "select * from bookinfo ";
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i = 0;
            while (rs.next()) {
                user[i++] = rs.getString("BookID");
                user[i++] = rs.getString("BookName");
                user[i++] = rs.getString("BookPrice");
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
    //修改图书信息
    public int xgbook(String bookid,String bookname) {
        bookname="'"+bookname+"'";
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
            String sql = "update bookinfo set BookName="+bookname+
                    " where BookID="+bookid;
            // 5、处理查询结果
            int rs = stmt.executeUpdate(sql);
            if(rs>0){
                state=1;
            }
            // 5.1、遍历输出查询结果
            int i = 0;
            // 5、增删改操作
            //int i = stmt.executeUpdate(sql);
            // 6、释放资源
//            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return state;
    }
    //所有评论
    public String[] allcomment() {
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
            String sql = "select * from comment ";
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i = 0;
            while (rs.next()) {
                user[i++] = rs.getString("CommID");
                user[i++] = rs.getString("CommContent");
                user[i++] = rs.getString("BookID");
                user[i++] = rs.getString("CommTime");

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
    //删除评论
    public int sccomment(String commid) {
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
            String sql = "delete from comment where CommID="+commid;
            // 5、处理查询结果
            int rs = stmt.executeUpdate(sql);
            if(rs>0){
                state=1;
            }
            // 5.1、遍历输出查询结果
            int i = 0;
            // 5、增删改操作
            //int i = stmt.executeUpdate(sql);
            // 6、释放资源
//            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return state;
    }
    //所有订单
    public String[] allorder() {
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
            String sql = "select * from orderinfo ";
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i = 0;
            while (rs.next()) {
                user[i++] = rs.getString("OrderID");
                user[i++] = rs.getString("UserAccount");
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
    //删除订单
    public int scorder(String orderid) {
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
            String sql = "delete from orderinfo where OrderID="+orderid;
            // 5、处理查询结果
            int rs = stmt.executeUpdate(sql);
            if(rs>0){
                state=1;
            }
            // 5.1、遍历输出查询结果
            int i = 0;
            // 5、增删改操作
            //int i = stmt.executeUpdate(sql);
            // 6、释放资源
//            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return state;
    }
    //增加图书
    public int addbook(String adminid,String bookname,String price,String number) {
        bookname="'"+bookname+"'";
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
            String sql = "insert into bookinfo(AdminID,BookName,BookPrice,BookNumber)" +
                    " values ("+adminid+','+bookname+','+price+','+number+')';
            // 5、处理查询结果
            int rs = stmt.executeUpdate(sql);
            if(rs>0){
                state=1;
            }
            // 5.1、遍历输出查询结果
            int i = 0;
            // 5、增删改操作
            //int i = stmt.executeUpdate(sql);
            // 6、释放资源
//            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return state;
    }
    //增加类型
    public int addtype(String typename) {
        typename="'"+typename+"'";
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
            String sql = "insert into booktype(TypeName) values ("+typename+')';
            // 5、处理查询结果
            int rs = stmt.executeUpdate(sql);
            if(rs>0){
                state=1;
            }
            // 5.1、遍历输出查询结果
            int i = 0;
            // 5、增删改操作
            //int i = stmt.executeUpdate(sql);
            // 6、释放资源
//            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return state;
    }
    //类型绑定图书
    public int addbt(String typeid,String bookid) {
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
            String sql = "insert into book_type_relation(TypeID,BookID) values (" +
                    typeid+','+bookid+')';
            // 5、处理查询结果
            int rs = stmt.executeUpdate(sql);
            if(rs>0){
                state=1;
            }
            // 5.1、遍历输出查询结果
            int i = 0;
            // 5、增删改操作
            //int i = stmt.executeUpdate(sql);
            // 6、释放资源
//            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return state;
    }
    public String avgprice() {
        String avgprice="";
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
            String sql = "select avg(BookPrice) as avgprice from bookinfo ";
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i=0;
            while (rs.next()) {
                avgprice = rs.getString("avgprice");

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
        return avgprice;
    }
}
