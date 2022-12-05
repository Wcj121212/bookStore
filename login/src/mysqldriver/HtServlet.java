package mysqldriver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/HtServlet")
public class HtServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String account=request.getParameter("account");
//        String password=request.getParameter("password");
//        String username=request.getParameter("name");
//        String state=request.getParameter("state");
        response.setHeader("content-type","text/html;charset=utf-8");
        Dealht ht=new Dealht();
        String xg=request.getParameter("xg");
        if(xg.equals("修改用户")){
            String account=request.getParameter("account");
            String password=request.getParameter("password");
            String username=request.getParameter("name");
            String state=request.getParameter("state");
            int pd=ht.xguser(account,password,username,state);
            if(pd==1){
                System.out.println("修改用户成功");
                response.getWriter().write("修改用户成功");
            }else {
                System.out.println("修改用户失败");
                response.getWriter().write("修改用户失败");
            }
        }else if (xg.equals("修改类型")){
            String typeid=request.getParameter("typeid");
            String typename=request.getParameter("typename");
            int pd=ht.xgtype(typeid,typename);
            if(pd==1){
                System.out.println("修改类型成功");
                response.getWriter().write("修改类型成功");
            }else {
                System.out.println("修改类型失败");
                response.getWriter().write("修改类型失败");
            }
        }else if (xg.equals("修改图书")){
            String bookid=request.getParameter("bookid");
            String bookname=request.getParameter("bookname");
            int pd=ht.xgbook(bookid,bookname);
            if(pd==1){
                System.out.println("修改图书成功");
                response.getWriter().write("修改图书成功");
            }else {
                System.out.println("修改图书失败");
                response.getWriter().write("修改图书失败");
            }
        }else if (xg.equals("删除评论")){
            String commid=request.getParameter("commid");
            int pd=ht.sccomment(commid);
            if(pd==1){
                System.out.println("删除评论成功");
                response.getWriter().write("删除评论成功");
            }else {
                System.out.println("删除评论失败");
                response.getWriter().write("删除评论失败");
            }
        }else if (xg.equals("删除订单")){
            String orderid=request.getParameter("orderid");
            int pd=ht.scorder(orderid);
            if(pd==1){
                System.out.println("删除订单成功");
                response.getWriter().write("删除订单成功");

            }else {
                System.out.println("删除订单失败");
                response.getWriter().write("删除订单失败");

            }
        }else if (xg.equals("增加图书")){
            String adminid=request.getParameter("adminid");
            String price=request.getParameter("price");
            String bookname=request.getParameter("bookname");
            String number=request.getParameter("number");

            int pd=ht.addbook(adminid,bookname,price,number);
            if(pd==1){
                System.out.println("增加图书成功");
                response.getWriter().write("增加图书成功");

            }else {
                System.out.println("增加图书失败");
                response.getWriter().write("增加图书失败");

            }
        }else if (xg.equals("增加类型")){
            String typename=request.getParameter("typename");

            int pd=ht.addtype(typename);
            if(pd==1){
                System.out.println("增加类型成功");
                response.getWriter().write("增加类型成功");

            }else {
                System.out.println("增加类型失败");
                response.getWriter().write("增加类型失败");

            }
        }else if (xg.equals("绑定图书")){
            String typeid=request.getParameter("typeid");
            String bookid=request.getParameter("bookid");
            int pd=ht.addbt(typeid,bookid);
            if(pd==1){
                System.out.println("绑定成功");
                response.getWriter().write("绑定成功");

            }else {
                System.out.println("绑定失败");
                response.getWriter().write("绑定失败");

            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
