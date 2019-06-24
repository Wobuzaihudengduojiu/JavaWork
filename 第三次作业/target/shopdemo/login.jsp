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
    <title>Login</title>
</head>
<body>

<div id="container">
    <form action="/completeInfoServlet" method="post">
        擅长技术:
        <input type="checkbox" name="technology" value="Java">Java<br/>
        <input type="checkbox" name="technology" value="C#">C#<br/>
        <input type=checkbox" name="technology" value="android">android<br/>
        <input type="submit" value="下一步">
    </form>
</div>

</body>
</html>
