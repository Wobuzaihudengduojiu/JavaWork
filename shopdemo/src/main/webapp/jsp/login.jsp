<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/8
  Time: 7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>登陆</title>
<body>





<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title" >登录</h3>
    </div>
    <div class="panel-body">
        <form action="/login" method="post">
            <table border="0">
                <tr>
                    <td>账号：</td>
                    <td><input type="text" name="username"></td>
                </tr>

                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="password"></td>
                </tr>
            </table>
            <br>
            <input type="submit" value="登录" style="color:#BC8F8F">
        </form>

        <div class="panel-body">
            <form action="register.jsp">
                <input type="submit" value="注册" style="color:#BC8F8F">
            </form>
        </div>

    </div>
</div>

</body>
</html>
