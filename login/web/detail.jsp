<%@ page import="mysqldriver.SearchType" %><%--
  Created by IntelliJ IDEA.
  User: w'c'j
  Date: 2022/6/16
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
    HttpSession session1=request.getSession();
    String username=(String)session1.getAttribute("username");
    String account=(String)session1.getAttribute("account");
    System.out.println("#"+account);
    SearchType type=new SearchType();
    String bookid = request.getParameter("bookid");
    session1.setAttribute("bookid",bookid);
    String bookms=type.bookms(request.getParameter("bookid"));
    String bookname=request.getParameter("bookname");
    String bookprice=request.getParameter("bookprice");
    SearchType se=new SearchType();
    String booknumber=se.booknumber(bookid);
%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
    .box {
        height: 400px;
        width: 1000px;
        background-color: pink;
        margin: 200px 200px;
    }

    .bookimg {
        float: left;
        height: 400px;
        width: 300px;
    }
    .detail .xxx {
        border: 0px;
        background-color: transparent;
    }
    h1 .xxx {
        font-size: 30px;
        width: 100px;
    }
</style>

<body>
<div class="box">
    <img src="影.png" class="bookimg">
    <div class="detail">
        <form method="get" action="dealdetail.jsp">
            <h1><input type="text" name="name" readonly="true" class="xxx"  value="<%=username%>"> 欢迎你</h1>
            图书名字：<input type="text" name="name" readonly="true" class="xxx"  value="<%=bookname%>">
            <p>图书描述：<%=bookms%></p>
            图书价格：<input name="price" readonly="true" class="xxx" value="<%=bookprice%>"><br>
            <p>剩余数量:<%=booknumber%></p>
            购买数量：<select name="number">
            <option>1</option>
            <option>2</option>
            <option>3</option>
        </select><br>
            <input type="submit" value="购买" name="way">
            <input type="submit" value="加入购物车" name="way">
            <input type="submit" value="评论" name="way">
        </form>
    </div>
</div>
</body>

</html>
