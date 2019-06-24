<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/5/29
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <title>购物车</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <script src="/js/html5.js"></script>
    <script src="/js/jquery.js"></script>
    <script>
        $(document).ready(function(){
            $("nav .indexAsideNav").hide();
            $("nav .category").mouseover(function(){
                $(".asideNav").slideDown();
            });
            $("nav .asideNav").mouseleave(function(){
                $(".asideNav").slideUp();
            });
        });
    </script>
</head>
<body>
<div>
    <jsp:include page="${pageContext.servletContext.contextPath}/commen/web/top.jsp"/>
</div>
<div align="center">
    <jsp:include page="${pageContext.servletContext.contextPath}/commen/web/navigation.jsp"/>
</div>

    <section  class="wrap" style="margin-top:20px;overflow:hidden;">

        <table class="order_table">
            <tr>
                <th>编号</th>
                <th>产品</th>
                <th>名称</th>
                <th>属性</th>
                <th>数量</th>
                <th>小计</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${cartlists}" var="cart">
                <tr>
                    <td class="center"><input type="checkbox"/></td>
                    <td class="center">
                        <a href="${pageContext.servletContext.contextPath}/jsp/web/shoppingcart/autionInfoController?autionId=${cart.autionId}">
                            <img src="${pageContext.servletContext.contextPath}/image/002.jpg" style="width:125px;height:125px;"/>
                        </a>
                    </td>
                    <td>
                        <a href="${pageContext.servletContext.contextPath}/jsp/web/shoppingcart/autionInfoController?autionId=${cart.autionId}" style="font-size: 15px">${cart.cartName}</a>
                    </td>
                    <td style="font-size: 15px">
                       ${cart.cartProperty}
                    </td>
                    <td class="center" class="rmb_icon" style="font-size: 15px">
                        ${cart.cartNum}
                    </td>
                    <td class="center"><strong class="rmb_icon" style="font-size: 15px">${cart.cartPrice*cart.cartNum}</strong></td>
                    <td class="center" style="font-size: 15px">
                        <a href="${pageContext.servletContext.contextPath}/cart/deleteCart?cartId=${cart.cartId}">删除</a>
                    </td>

                </tr>
            </c:forEach>

        </table>


        <div class="order_btm_btn">
            <a href="${pageContext.servletContext.contextPath}/index.jsp">继续购买</a>

            <c:if test="${!empty sessionScope.user}">

                <a href="${pageContext.servletContext.contextPath}/" class="link_btn_02 add_btn"/>共计金额<strong class="rmb_icon">0.00</strong>立即结算</a>

            </c:if>

        </div>

    </section>


</body>
</html>
