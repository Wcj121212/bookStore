<%@ page import="mysqldriver.DealComment" %><%--
  Created by IntelliJ IDEA.
  User: w'c'j
  Date: 2022/6/17
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //将评论信息存入数据库
        HttpSession session1=request.getSession();
        String bookid=(String) session1.getAttribute("bookid");
        String account=(String) session1.getAttribute("account");
        String fatherid=request.getParameter("fatherid");
        String comment=request.getParameter("comment");
        String ways=request.getParameter("pl");
        DealComment com=new DealComment();
        if(ways.equals("回复")) {
            int state=com.addcomment(bookid,account,fatherid,comment);
            if (state==1){
                System.out.println("回复成功");
                out.write("回复成功");
            }
        }else if(ways.equals("发表评论")){
            int state=com.addfcomment(bookid,account,comment);
            if (state==1){
                System.out.println("评论成功");
                out.write("评论成功");
            }
        }
    %>
</body>
</html>
