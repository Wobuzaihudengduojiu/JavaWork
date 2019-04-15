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


    <c:choose>
    <c:when test="${userdetails!=null}">

        <c:out value="${userdetails.name}"/>
        <c:out value="${userdetails.id}"/>
        <c:out value="${userdetails.schoolName}"/>
        <c:out value="${userdetails.professior}"/>

        <c:forTokens items="${userdetails.technology}" delims="," var="name">
            <c:out value="${name}"/><p>
        </c:forTokens>


    </c:when>
    <c:otherwise>
    <a href="/details.jsp">完善个人信息</a>
    </c:otherwise>
    </c:choose>


</div>

</form>
</body>
</html>