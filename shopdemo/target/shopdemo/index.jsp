
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/5/27
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <script src="/js/html5.js"></script>
    <script src="/js/jquery.js"></script>
    <script>
        $(document).ready(function () {
            $("nav .indexAsideNav").hide();
            $("nav .category").mouseover(function () {
                $(".asideNav").slideDown();
            });
            $("nav .asideNav").mouseleave(function () {
                $(".asideNav").slideUp();
            });
        });
    </script>

</head>
<body>

<div>
    <jsp:include page="/commen/web/top.jsp"/>
</div>
<div align="center">
    <jsp:include page="/commen/web/navigation.jsp"/>
</div>

<section class="wrap shop_goods_li">


    <h2>类目信息：</h2>
    <ul class="favorite_list">
        <c:forEach items="${autionInfoDoList}" var="autionInfo">

            <li style="height: 215px;width: 285px">
                <a  href="${pageContext.servletContext.contextPath}/autionInfo?autionId=${autionInfo.autionId}">
                    <img style="height: 200px;width: 250px" src="image/002.jpg"/>
                    <h3 style="font-size: 20px">${autionInfo.autionName}</h3>
                    <p class="price" style="font-size: 20px"><span class="rmb_icon" style="font-size: 20px">${autionInfo.autionPrice}</span></p>
                    <p class="shop_collect_goods" title="加入购物车" style="font-size: 20px">
                        <span>
                            <a href="${pageContext.servletContext.contextPath}/cart/addCart?autionId=${autionInfo.autionId}">加入购物车</a>
                        </span>
                    </p>
                </a>
            </li>

        </c:forEach>
    </ul>
</section>
</body>
</html>
