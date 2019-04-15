<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Index</title>
</head>
<body>

    <%--若没有登陆，则返回首页--%>
    <c:if test="${user==null}">
        <c:redirect url="login.jsp"/>
    </c:if>

    <p style="font-size: 30px">
        <strong>
            欢迎<c:out value="${user.name}"/>
        </strong>
    </p>

    <a href="/index.jsp" name="首页">首页</a>
    <a href="/userinfo.jsp" name="个人中心">个人中心</a>


</form>
</body>
</html>