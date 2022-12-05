package mysqldriver;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DealRegister {
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
    public DealRegister(){};
    public int deal(String account,String upassword,String username,String phone,String sex,String address,String age) {
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
            String sql = "select UserAccount from userinfo where UserAccount="+account;
            // 5、处理查询结果
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                rs.close();
                stmt.close();
                connection.close();
                return 2;//用户已存在
            }
            username = "'"+username+"'";
            sex = "'"+sex+"'";
            address = "'"+address+"'";
            sql = "insert into userinfo(UserAccount,UserName,UserPWD,Sex,UserPhone,UserAge,Address,IsActive)" +
                    " values("+account+','+username+','+upassword+','+sex+','+phone+','+age+','+address+",'1'"+')';
            int re=stmt.executeUpdate(sql);
            sql = "insert into carinfo(UserAccount) values ("+account+')';
            re=stmt.executeUpdate(sql);
            if(re>0){
                state = 1;
            }
            ;//注册成功
            // 5、增删改操作
            //int i = stmt.executeUpdate(sql);
            // 6、释放资源
            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return state;//返回注册状态
    }
}