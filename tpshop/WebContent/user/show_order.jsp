<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="show_order_main">
		<div class="show_order_show">
			<h1>订单号：${order.getOrderNumber() }</h1>
			<table>
				<tbody>
					<tr style="background-color: #8E8E8E; height: 30px;">
						<td style="width: 150px">产品</td>
						<td style="width: 500px">商品名称</td>
						<td style="width: 150px">商品数量</td>
						<td style="width: 300px">Cdkey</td>
					</tr>
					<c:set var="sum" value="0"></c:set>
					<c:forEach items="${order_goods}" var="order_good">
						<tr class="hang">
							<td>
								<div class="good_image">
									<img src="${order_good.getGood().getImage_path() }">
								</div>
							</td>

							<td >
								<div class="good_name">
									<p>${order_good.getGood().getName() }</p>
								</div>
								<p>平台:${order_good.getGood().getPlatform() }</p>
								<p>地区:${order_good.getGood().getRegion() }</p>
							</td>
							<td class="good_count">${order_good.getCdkeys().size()}</td>
							<td class="good_cdkey" vertical-align="middle">
								<c:forEach items="${order_good.getCdkeys() }" var="cdkey" varStatus="Cdkey">
									<p>${cdkey.getCdkey() }</p>
								</c:forEach>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>

<style type="text/css">

.hang {
	mrgin-top: 20px;
	vertical-align: middle;
	background: #EEEEEE;
}

.good_image img {
	width: 120px;
	height: 120px;
}

.good_name {
	height: 40px;
	overflow: hidden;
}

</style>
</html>