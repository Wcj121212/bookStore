package mysqldriver;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DealDetail {
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
    public DealDetail(){};
    public int buy(String useraccount,String bookid,String n,String p) {
//        float price = Float.parseFloat(p);
        int booknumber = Integer.valueOf(n).intValue();
        float price = Float.parseFloat(p)*booknumber;
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
            String sql = "select BookNumber from bookinfo where BookID="+bookid;
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("jjjjjjjjjj");
            // 5.1、遍历输出查询结果
            int i=0;
            int number=0;
            while (rs.next()) {
                 number = Integer.parseInt(rs.getString("BookNumber"));

            }
            System.out.println(number);
            System.out.println(booknumber);
            System.out.println(bookid);
            int r = (number-booknumber);


            if(booknumber<=number){
                System.out.println("bbbbbb");
                sql = "update bookinfo set BookNumber="+r+" "+"where BookID="+bookid;
//                sql = "update bookinfo set BookNumber=776 where BookID=6";
                System.out.println(sql);
                int re = stmt.executeUpdate(sql);
                if(re>0){
                    System.out.println("jjjjjjjjjj");
                    sql = "insert into orderinfo(BookID,UserAccount,Price) values("+bookid+','+useraccount+','
                    +price+')';
                    re = stmt.executeUpdate(sql);
                    if(re>0){
                        state = 1;
                    }
                }
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
        return state;
    }
    public int car(String useraccount,String bookid,String n) {
        int booknumber = Integer.valueOf(n).intValue();
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
            String sql = "select CarID from carinfo where UserAccount="+useraccount;
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            // 5.1、遍历输出查询结果
            int i=0;
            int number=0;
            String carid="";
            while (rs.next()) {
                carid = rs.getString("CarID");

            }
            sql = "insert into book_car_relation(BookID,CarID,BookNumber) values("
                    +bookid+','+carid+','+booknumber+")";
            System.out.println(sql);
            int re = stmt.executeUpdate(sql);
            if(re>0){
                state = 1;
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
        return state;
    }




}
