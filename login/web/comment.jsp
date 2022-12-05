<%@ page import="mysqldriver.DealComment" %><%--
  Created by IntelliJ IDEA.
  User: w'c'j
  Date: 2022/6/17
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
    h4 {
        display: inline-block;
    }
    .xxx {
        border: 0px;
        color: transparent;
        width: 20px;
        height: 10px;
    }
</style>

<body>
<div>
    <h1>图书评论信息</h1>
    <%
        //获取账号和图书号
        HttpSession session1=request.getSession();
        String bookid=(String)session1.getAttribute("bookid");
        String account=(String)session1.getAttribute("account");
        //获取评论号和评论内容
        DealComment com=new DealComment();
        String[] iac = com.searchcomment(bookid);
        //将评论号和评论内容展示到页面上
        int i=0;
        while (iac[i]!=null){
    %>
        <form action="dealcomment.jsp" method="get">
            <input type="text" name="fatherid" value="<%=iac[i++]%>" class="xxx" readonly="true">
            <h4><%=iac[i++]%></h4><input type="text" name="comment"><input type="submit" value="回复" name="pl">
        </form>
    <%
        }
    %>
    <form action="dealcomment.jsp" method="get">
        <textarea name="comment" id="" cols="30" rows="10" placeholder="请输入您的评论" ></textarea><br>
        <input type="submit" value="发表评论" name="pl">
    </form>
</div>
</body>

</html>
