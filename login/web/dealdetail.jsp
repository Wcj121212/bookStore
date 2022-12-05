<%@ page import="mysqldriver.DealDetail" %><%--
  Created by IntelliJ IDEA.
  User: w'c'j
  Date: 2022/6/16
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String ways=request.getParameter("way");
//        int booknumber=Integer.getInteger(request.getParameter("number"));
    String booknumber=request.getParameter("number");
//    int n=Integer.valueOf(booknumber).intValue();
    HttpSession session1=request.getSession();
    String bookid=(String) session1.getAttribute("bookid");
    String useraccount=(String) session1.getAttribute("account");
    System.out.println("/''''"+bookid);
    System.out.println("....."+useraccount);
    String price=request.getParameter("price");
//    System.out.println("....."+price);

    DealDetail detail=new DealDetail();
    int state=0;
    if(ways.equals("购买")){
        state=detail.buy(useraccount,bookid,booknumber,price);
        if(state==1){
            System.out.println("购买成功");
            out.write("购买成功");
        }
    }else if(ways.equals("加入购物车")){
        state=detail.car(useraccount,bookid,booknumber);
        if(state==1) {
            out.write("成功添加购物车");
        }
    }else if (ways.equals("评论")){
        System.out.println("pppppppp");
        request.getRequestDispatcher("/comment.jsp").forward(request,response);
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
