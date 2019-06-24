<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/5/27
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/index.jsp">简易网上商城</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <form class="navbar-form navbar-left" role="search" action="" method="">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </li>
            <li><a href="/jsp/web/shoppingcart/cartList.jsp"><span class="glyphicon glyphicon-calendar"></span>
                我的购物车</a></li>

            <c:choose>
                <c:when test="${user==null}">
                    <li><a href="/register.jsp"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
                    <li>
                        <a href="/jsp/login.jsp"><span class="glyphicon glyphicon-log-in"></span>&nbsp;登录</a>
                    </li>
                </c:when>

                <c:otherwise>
                    <li>
                        <a href="/jsp/login.jsp"><span class="glyphicon glyphicon-log-in"><c:out value="${user.userName}"></c:out></span></a>
                    </li>
                </c:otherwise>

            </c:choose>


        </ul>
    </div>
</nav>


