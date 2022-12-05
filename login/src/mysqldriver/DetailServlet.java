//package mysqldriver;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet("/DetailServlet")
//public class DetailServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String ways=request.getParameter("way");
////        int booknumber=Integer.getInteger(request.getParameter("number"));
//        int booknumber=1;
//        HttpSession session1=request.getSession();
//        String booid=(String) session1.getAttribute("booid");
//        String useraccount=(String) session1.getAttribute("account");
//        System.out.println(booid);
//        System.out.println(useraccount);
//
//        DealDetail detail=new DealDetail();
//        int state=0;
//        if(ways.equals("购买")){
//            state=detail.buy(useraccount,booid,booknumber);
//            if(state==1){
//                System.out.println("购买成功");
//            }
//        }else if(ways.equals("加入购物车")){
//            state=detail.car(useraccount,booid,booknumber);
//        }else {
//            System.out.println("pppppppp");
//        }
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request,response);
//    }
//}
