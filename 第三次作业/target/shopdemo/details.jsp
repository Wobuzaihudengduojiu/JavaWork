<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Index</title>
</head>
<body>

<%--若没有登陆，则返回首页--%>
<p style="font-size: 30px">
    <strong>
        欢迎<c:out value="${user.name}"/>
    </strong>
</p>

<div id="container">

    <c:out value="${name}"/>

    学校名称:<input type="input" name="schoolName"><br/>

    <input type="submit" value="下一步">
</div>


</form>
</body>
</html>