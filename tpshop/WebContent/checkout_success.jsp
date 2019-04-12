<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/checkout_success.css">
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="checkout_success_main">
		<div class="checkout_success_show">
			<h1>订单号：${order.getOrderNumber() }</h1>
			<table>
				<tbody>
					<tr style="background-color: #8E8E8E; height: 30px;">
						<td style="width: 150px">产品</td>
						<td style="width: 600px">商品名称</td>
						<td style="width: 150px">商品数量</td>
						<td style="width: 200px">Cdkey</td>
					</tr>
					<c:set var="sum" value="0"></c:set>
					<c:forEach items="${order_goods}" var="order_good">
						<tr class="hang">
							<td>
								<div class="good_image">
									<img src="${order_good.getGood().getImage_path() }">
								</div>
							</td>

							<td style="vertical-align: top">
								<div class="good_name">
									<h2>${order_good.getGood().getName() }</h2>
								</div>
								<p>平台:${order_good.getGood().getPlatform() }</p>
								<p>地区:${order_good.getGood().getRegion() }</p>
							</td>
							<td class="good_count">${order_good.getCdkeys().size()}</td>
							<td class="good_cdkey" vertical-align="middle">
								<c:forEach items="${order_good.getCdkeys() }" var="cdkey" varStatus="Cdkey">
									${cdkey.getCdkey() }
								</c:forEach>
							</td>
						</tr>
					</c:forEach>
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

</style>
</html>