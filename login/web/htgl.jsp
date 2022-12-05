<%@ page import="mysqldriver.Dealht" %><%--
  Created by IntelliJ IDEA.
  User: w'c'j
  Date: 2022/6/17
  Time: 23:10
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
        margin-top: 50px;
        color: black;
        padding-left: 20px;
        border-bottom: 2px solid orange;
    }
    .menu a:hover {
        background-color: skyblue;
    }
    .box .gl {
        float: left;
        height: 40px;
        width: 190px;
        border: 0px;
        border-left: 1px dotted black;
        /*border-bottom: 1px solid black;*/
    }
    .gl:hover {
        background-color: orange;
    }
</style>
<body>
<h1>管理中心</h1>
<div class="menu">
    <a href="htgl.jsp?way=管理用户">管理用户</a>
    <a href="htgl.jsp?way=管理类型">管理类型</a>
    <a href="htgl.jsp?way=管理评论">管理评论</a>
    <a href="htgl.jsp?way=管理图书">管理图书</a>
    <a href="htgl.jsp?way=管理订单">管理订单</a>
</div>
<div class="box">
    <%
        char[] sc= new char[2];
        sc[0] = '是';
        sc[1] = '否';
        request.setCharacterEncoding("UTF-8");
        HttpSession session1=request.getSession();
        String account=(String)session1.getAttribute("account");
        String menu="";
        menu=request.getParameter("way");
        Dealht ad=new Dealht();
        String avgprice=ad.avgprice();
        String[] info;
        int i=0;
        //判断用户是否登录
        if (account==null) {
            request.getRequestDispatcher("/adminlogin.html").forward(request,response);
            //根据菜单选项提供功能
        }else if(menu==null || menu.equals("管理用户")){

    %>
    <div class="gl">账号</div>
    <div class="gl">密码</div>
    <div class="gl">昵称</div>
    <div class="gl">是否删除(0为删除)</div>
    <div class="gl">修改</div>

    <%
            info=ad.alluser();
            while (info[i]!=null) {

    %>
    <form method="get" action="HtServlet">
        <input type="text" value="<%=info[i++]%>" name="account" class="gl" readonly="true">
        <input type="text" value="<%=info[i++]%>" name="password" class="gl">
        <input type="text" value="<%=info[i++]%>" name="name" class="gl">
        <input type="text" value="<%=info[i++]%>" name="state" class="gl">
        </select>
        <input type="submit" value="修改用户" name="xg" class="gl">

    </form>

    <%
            }

        }else if(menu.equals("管理类型")){
    %>
<%--    //管理类型--%>



    <div class="gl">类型号</div>
    <div class="gl">类型名</div>
    <div class="gl"></div>
    <div class="gl"></div>
    <div class="gl">修改</div>

    <%
        info=ad.alltype();
        while (info[i]!=null) {

    %>
    <form method="get" action="HtServlet">
        <input type="text" value="<%=info[i++]%>" name="typeid" class="gl" readonly="true">
        <input type="text" value="<%=info[i++]%>" name="typename" class="gl">
        <div class="gl"></div>
        <div class="gl"></div>
        <input type="submit" value="修改类型" name="xg" class="gl">

    </form>

    <%
            }
    %>
    <form method="get" action="HtServlet">
        <div class="gl"></div>
        <input type="text" value="" name="typename" class="gl">
        <div class="gl"></div>
        <div class="gl"></div>
        <input type="submit" value="增加类型" name="xg" class="gl">

    </form>
    <form method="get" action="HtServlet">
        <input type="text" value="" name="typeid" class="gl" >
        <input type="text" value="" name="bookid" class="gl" placeholder="请输入图书号">
        <div class="gl"></div>
        <div class="gl"></div>
        <input type="submit" value="绑定图书" name="xg" class="gl">

    </form>
    <%
        }else if(menu.equals("管理评论")){
    %>
    <%--    //管理评论--%>



    <div class="gl">评论号</div>
    <div class="gl">评论内容</div>
    <div class="gl">书号</div>
    <div class="gl">评论时间</div>
    <div class="gl">修改</div>

    <%
        info=ad.allcomment();
        while (info[i]!=null) {

    %>
    <form method="get" action="HtServlet">
        <input type="text" value="<%=info[i++]%>" name="commid" class="gl" readonly="true">
        <input type="text" value="<%=info[i++]%>" name="content" class="gl">
        <input type="text" value="<%=info[i++]%>" name="bookid" class="gl">
        <input type="text" value="<%=info[i++]%>" name="comtime" class="gl">
        <input type="submit" value="删除评论" name="xg" class="gl">

    </form>

    <%
            }
        }else if(menu.equals("管理图书")){
    %>
    <%--    //管理图书--%>



    <div class="gl">图书号</div>
    <div class="gl">图书名</div>
    <div class="gl">价格</div>
    <div class="gl">数量</div>
    <div class="gl">修改</div>

    <%
        info=ad.allbook();
        while (info[i]!=null) {

    %>
    <form method="get" action="HtServlet">
        <input type="text" value="<%=info[i++]%>" name="bookid" class="gl" readonly="true">
        <input type="text" value="<%=info[i++]%>" name="bookname" class="gl">
        <input type="text" value="<%=info[i++]%>" name="price" class="gl">
        <input type="text" value="<%=info[i++]%>" name="number" class="gl">
        <input type="submit" value="修改图书" name="xg" class="gl">

    </form>

    <%
            }
    %>
    <form method="get" action="HtServlet">
        <input type="text" value="<%=account%>" name="adminid" class="gl" readonly="true">
        <input type="text" value="" name="bookname" class="gl">
        <input type="text" value="" name="price" class="gl">
        <input type="text" value="" name="number" class="gl">
        <input type="submit" value="增加图书" name="xg" class="gl">

    </form>
    <input type="text" value="平均价格：" name="" class="gl" readonly="true">
    <input type="text" value="<%=avgprice%>" name="avgprice" class="gl" readonly="true">
    <%
        }else if(menu.equals("管理订单")){
    %>
    <%--    //管理图书--%>



    <div class="gl">订单号</div>
    <div class="gl">用户号</div>
    <div class="gl">价格</div>
    <div class="gl">创建时间</div>
    <div class="gl">修改</div>

    <%
        info=ad.allorder();
        while (info[i]!=null) {

    %>
    <form method="get" action="HtServlet">
        <input type="text" value="<%=info[i++]%>" name="orderid" class="gl" readonly="true">
        <input type="text" value="<%=info[i++]%>" name="useraccount" class="gl">
        <input type="text" value="<%=info[i++]%>" name="price" class="gl">
        <input type="text" value="<%=info[i++]%>" name="time" class="gl">
        <input type="submit" value="删除订单" name="xg" class="gl">

    </form>

    <%
            }
        }
    %>



</div>
</body>
</html>
