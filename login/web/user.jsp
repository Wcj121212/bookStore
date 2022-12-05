<%@ page import="mysqldriver.DealUser" %><%--
  Created by IntelliJ IDEA.
  User: w'c'j
  Date: 2022/6/17
  Time: 19:37
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
    * {
        margin: 0px;
        padding: 0px;
    }
    .box {
        float: left;
        height: 800px;
        width: 1000px;
        overflow: auto;
        background-color: yellow;
    }
    h1 {
        background-color: pink;
        padding-left: 700px;
    }
    .menu {
        float: left;
        width: 250px;
        height: 800px;
        margin-left: 130px;
        background-color: aquamarine;
    }
    .menu a {
        text-decoration: none;
        display: inline-block;
        height: 50px;
        width: 100%;
        font-size: 30px;
        margin-top: 100px;
        color: black;
        padding-left: 20px;
        border-bottom: 2px solid orange;
    }
    .menu a:hover {
        background-color: skyblue;
    }
    .yh {
        height: 40px;
        font-size: 30px;
        padding-left: 300px;
        margin-top: 50px;
        border-bottom: 2px solid ;
    }
    .dd {
        float: left;
        height: 40px;
        width: 300px;
    }
</style>
<body>
<h1>用户中心</h1>
<div class="menu">
    <a href="?ways=用户信息">用户信息</a>
    <a href="?ways=购物车">购物车</a>
    <a href="?ways=订单">订单</a>
</div>
<div class="box">
    <%
        String way="";
        way=request.getParameter("ways");
        HttpSession session1=request.getSession();
        String account=(String)session1.getAttribute("account");
        DealUser u=new DealUser();
        String[] info;
        int i=0;
        if(way==null || way.equals("用户信息")) {
            info=u.user(account);
            while (info[i]!=null){

    %>
    <p class="yh"><%=info[i++]%></p>
    <%
            }
        }else if (way.equals("订单")){
    %>
    <div class="dd">书名</div>
    <div class="dd">总价</div>
    <div class="dd">购买时间</div>
    <%
            info=u.dd(account);
            while (info[i]!=null){

    %>
    <div class="dd"><%=info[i++]%></div>
    <div class="dd"><%=info[i++]%></div>
    <div class="dd"><%=info[i++]%></div>
    <%
            }
        }else if (way.equals("购物车")){


    %>
    <div class="dd">单号</div>
    <div class="dd">书名</div>
    <div class="dd">数量</div>
    <%
            info=u.gwc(account);
            while (info[i]!=null) {

    %>
    <div class="dd"><%=info[i++]%></div>
    <div class="dd"><%=info[i++]%></div>
    <div class="dd"><%=info[i++]%></div>
    <%

            }
        }
    %>
</div>
</body>
</html>
