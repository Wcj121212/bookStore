package mysqldriver;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/AdminServe")
public class AdminServe extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取提交上来的账号密码
        request.setCharacterEncoding("UTF-8");
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        System.out.println(account+password);
        DealLogin check=new DealLogin();
        String state=check.admin(account,password);
        System.out.println(state);
        if(state.equals("登录成功")){
            HttpSession session=request.getSession();
            session.setAttribute("account",account);
            SearchType type=new SearchType();
            String username=type.user(account);
            session.setAttribute("username",username);
            request.getRequestDispatcher("/htgl.jsp").forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
