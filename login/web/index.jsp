<%@ page import="mysqldriver.SearchType" %>
<%@ page import="javax.servlet.annotation.WebServlet" %>
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
        padding: 0;
        margin: 0;
        list-style: none;
    }
    a {
        text-decoration: none;
    }

    .demohead {
        /* padding-top: 30px; */
        height: 80px;
        /* background: pink; */
        border-bottom: 3px solid orange;
    }

    .userimg {
        border-radius: 15px;
        height: 30px;
        width: 30px;
    }

    .shou {
        /*float: left;*/
        height: 80px;
        width: 300px;
        margin-left: 600px;
        /* background-color: skyblue; */
    }

    .booktype {
        margin-left: 150px;
        float: left;
        background-color: rgb(45, 40, 40);
        height: 1000px;
        width: 220px;
    }

    .showimg {
        float: left;
        height: 1000px;
        width: 1000px;
        /* background-color: blue; */
        /*background-image: url(images/bg.jpg);*/
        background-color: whitesmoke;
    }

    /* .booktype li {
        height: 40px;
        /* background-color: pink; */
    /* padding-left: 40px;
} */

    .booktype .setp {
        display: inline-block;
        height: 40px;
        width: 100%;
        line-height: 40px;
        color: white;
        border-bottom: 2px solid orange;
        padding-left: 40px;
    }
    .booktype .setp:hover {
        background-color: orange;
    }

    .booktype div {
        height: 60px;
        font-size: 30px;
        padding-left: 30px;
        padding-top: 20px;
        color: white;

    }

    .demohead .user {
        float: right;
        height: 80px;
        width: 300px;
        /* background-color: skyblue; */
        /* padding-top: 20px; */
        /* line-height: 30px; */
        margin-right: 400px;
    }
    .user a {
        display: inline-block;
        height: 80px;
        /* background-color: skyblue; */
        margin-left: 20px;
        color: rgb(122, 114, 114);
    }
    .showimg .book {
        float: left;
        background-color: pink;
        height: 220px;
        width: 160px;
        margin-top: 20px;
        margin-left: 30px;
    }
    .showimg .book:hover {
        box-shadow: 2px 2px 2px black;
    }
    .book .bookimg {
        height: 160px;
        background-color: skyblue;
        color: black;
    }
</style>

<body>
<!-- 头部 -->
<%
    SearchType type=new SearchType();
    HttpSession session1=request.getSession();
    Object a=session1.getAttribute("username");
    String username="请登录";
    if(a!=null){
        username=(String)a;
    }
%>
<div class="demohead">
    <div class="user">
        <a href="user.jsp"><img src="影.png" class="userimg"><%=username%></a>
        <a href="login.html">登录</a>
        <a href="register.html">注册</a>
    </div>
    <div class="shou">
        <form method="get" action="index.jsp">
            <input type="text" name="search">
            <input type="submit" value="搜索">
        </form>
    </div>
</div>
<!-- 类型框 -->
<div class="booktype">
    <div>
        <p>图书类型</p>
    </div>
    <ul>
        <li>
<%--            <a href="#" class="setp">撞击</a>--%>
            <%
                if(username.equals("请登录")){
                    username=null;
                }
                request.setCharacterEncoding("UTF-8");
                String[] typename=type.deal();
                int i=0;
                while(typename[i++]!=null){


            %>
            <a href="index.jsp?typename=<%=typename[i-1]%> " class="setp"><%=typename[i-1]%></a>
            <%
                }
            %>
        </li>
    </ul>
</div>
<!-- 图片展示区 -->
<div class="showimg">
    <%
        String[] namePrice;
        String clickType=request.getParameter("typename");
        String clickSearch=request.getParameter("search");
        if(clickType!=null){
            namePrice = type.type(clickType);
        }else if(clickSearch!=null){
            namePrice = type.search(clickSearch);
        }else {
            namePrice = type.all();
        }
        int j=0;
        while(namePrice[j++]!=null){

    %>
        <a class="book" href="detail.jsp?bookid=<%=namePrice[j-1]%>&bookname=<%=namePrice[j]%>&bookprice=<%=namePrice[j+1]%>">
            <div class="bookimg"></div>
            <p>书名：<%=namePrice[j++]%></p>
            <p>价格：<%=namePrice[j++]%></p>
        </a>
    <%
        }
    %>

</div>
</body>

</html>
