package mysqldriver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        String username=request.getParameter("username");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        String sex=request.getParameter("sex");
        System.out.println(sex);
        String age=request.getParameter("age");
        DealRegister se=new DealRegister();
        int state=se.deal(account,password,username,phone,sex,address,age);
        if(state==1){
            System.out.println("注册成功");
            request.getRequestDispatcher("/login.html").forward(request,response);
        }else if(state==2){
            System.out.println("用户已存在");
        }else{
            System.out.println("注册失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
