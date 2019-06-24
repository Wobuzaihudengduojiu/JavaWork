<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/5/29
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>物品详情</title>
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

        //detail tab
        $(".product_detail_btm .item_tab a").click(function(){
            var liindex = $(".product_detail_btm .item_tab a").index(this);
            $(this).addClass("curr_li").parent().siblings().find("a").removeClass("curr_li");
            $(".cont_wrap").eq(liindex).fadeIn(150).siblings(".cont_wrap").hide();
        });

        //radio
        $(".horizontal_attr label").click(function(){
            $(this).addClass("isTrue").siblings().removeClass("isTrue");
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
<section class="wrap product_detail">

    <div class="gallery">
        <div>
            <div id="preview" class="spec-preview"> <span class="jqzoom"><img jqimg="/image/002.jpg" src="/image/002.jpg" style="height: 420px ;width:420px" /></span> </div>
            <!--缩图开始-->
            <div class="spec-scroll"> <a class="prev">&lt;</a> <a class="next">&gt;</a>
                <div class="items">
                    <ul>
                        <li><img bimg="/image/002.jpg" src="/image/006.jpg" onmousemove="preview(this);"></li>
                        <li><img bimg="/image/002.jpg" src="/image/006.jpg" onmousemove="preview(this);"></li>
                        <li><img bimg="/image/002.jpg" src="/image/006.jpg" onmousemove="preview(this);"></li>
                        <li><img bimg="/image/002.jpg" src="/image/006.jpg" onmousemove="preview(this);"></li>
                        <li><img bimg="/image/002.jpg" src="/image/006.jpg" onmousemove="preview(this);"></li>
                        <li><img bimg="/image/002.jpg" src="/image/006.jpg" onmousemove="preview(this);"></li>
                        <li><img bimg="/image/002.jpg" src="/image/006.jpg" onmousemove="preview(this);"></li>
                        <li><img bimg="/image/002.jpg" src="/image/006.jpg" onmousemove="preview(this);"></li>
                        <li><img bimg="/image/002.jpg" src="/image/006.jpg" onmousemove="preview(this);"></li>
                        <li><img bimg="/image/002.jpg" src="/image/006.jpg" onmousemove="preview(this);"></li>
                        <li><img bimg="/image/002.jpg" src="/image/006.jpg" onmousemove="preview(this);"></li>
                        <li><img bimg="/image/002.jpg" src="/image/006.jpg" onmousemove="preview(this);"></li>
                    </ul>
                </div>
            </div>
            <!--缩图结束-->
        </div>
    </div>


    <div class="rt_infor">
        <ul>
            <li>
                <dl class="horizontal">
                    <dt>商品名称</dt>
                    <dd>${autionInfo.autionName}</dd>
                </dl>
            </li>
            <li>
                <dl class="horizontal">
                    <dt>价格：</dt>
                    <dd><strong class="rmb_icon univalent">${autionInfo.autionPrice}</strong>元</dd>
                </dl>
            </li>
            <li>
                <dl class="horizontal">
                    <dt>库存：</dt>
                    <dd>${autionInfo.autionNum}</dd>
                </dl>
            </li>
            <li class="last_li">
                <input type="button" value="立即购买" class="buy_btn" onClick="javascript:location.href=''"/>
                <span>
                    <a href="${pageContext.servletContext.contextPath}/cart/addCart?autionId=${autionInfo.autionId}">加入购物车</a>
                </span>
            </li>
        </ul>
    </div>
</section>
<!--商品详情-->
<div class="cont_wrap active">

    <p>${autionInfo.autionInfo}</p>

</div>


</body>
</html>
