<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/cart.css">
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="cart_main">
		<div class="cart_show">
			<table>
				<tbody>
					<tr style="background-color: #8E8E8E; height: 30px;">
						<td style="width: 150px">产品</td>
						<td style="width: 600px">商品名称</td>
						<td style="width: 100px">商品单价</td>
						<td style="width: 150px">商品数量</td>
						<td style="width: 100px">价格</td>
					</tr>
					<c:set var="sum" value="0"></c:set>
					<c:forEach items="${carts}" var="cart">
						<tr class="hang">
							<td>
								<div class="good_image">
									<a href="show_good?good_id=${cart.getGood().getId()}"><img src="${cart.getGood().getImage_path() }"></a>
								</div>
							</td>

							<td style="vertical-align: top">
								<div class="good_name">
									<a href="show_good?good_id=${cart.getGood().getId() }"><h2>${cart.getGood().getName() }</h2></a>
								</div>
								<p>平台:${cart.getGood().getPlatform() }</p>
								<p>地区:${cart.getGood().getRegion() }</p>
							</td>
							<td class="good_unitPrice">￥${cart.getGood().getPrice() }</td>
							<td class="good_count" vertical-align="middle"><p>${cart.getGood_count() }</p>
								<a href="Delete_cart?cart_id=${cart.getId() }">删除</a></td>
							<td class="good_price" vertical-align="middle"><strong>￥${cart.getGood().getPrice()*cart.getGood_count()}</strong></td>

							<c:set var="sum"
								value="${sum+cart.getGood().getPrice()*cart.getGood_count() }"></c:set>
						</tr>
					</c:forEach>
					<tr align="center" style="background: #EEEEEE; height: 150px;">
						<td colspan="3" id="Price">总金额: ￥ ${sum }</td>
						<td colspan="2" id="payment">
						<form action="Add_order" method="post">
						<input type="submit" id="payment_button" value="点击支付"></form></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="floor.jsp"></jsp:include>
</body>
<style type="text/css">
.hang {
	width: 150px;
	mrgin-top: 20px;
	vertical-align: middle;
	background: #EEEEEE;
}

.good_image img {
	width: 120px;
	height: 120px;
}

.good_name {
	height: 30px;
	width: 600px;
	overflow: hidden;
}

#Price {
	align: center;
	align: right;
	color: red;
	font-size: 20px;
}

#payment {
	align: center;
}

#payment_button {
	width: 200px;
	height: 50px;
	background-color: #65B449;
	color: #FFF;
	font-size: 20px;
}

#payment_button:hover {
	background-color: #4D8A38;
}
.hang a{
	
    text-decoration: none;
}
.hang a:link {
    color:#000000;
    text-decoration: none;
}
.hang a:visited {
    text-decoration: none;
    color: #000000;
}
.hang a:hover {
    text-decoration: underline;
}
.hang a:active {
    text-decoration: none;
    color: #000000;
}
</style>
</html>