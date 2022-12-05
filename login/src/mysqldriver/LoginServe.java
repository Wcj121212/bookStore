package mysqldriver;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/LoginServe")
public class LoginServe extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取提交上来的账号密码
        response.setHeader("content-type","text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        String jc=request.getParameter("qq");
        System.out.println(account+password);
        DealLogin check=new DealLogin();
        String state=check.deal(account,password);
        System.out.println(state);
        response.getWriter().write(state);
        if(state.equals("登录成功")){
            HttpSession session=request.getSession();
            session.setAttribute("account",account);
            SearchType type=new SearchType();
            String username=type.user(account);
            session.setAttribute("username",username);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
                    
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
