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

	<table width="100%" border="1" id="showGood">
		<tbody>
			<tr bgcolor="#717171">
				<td width="50px">订单序号</td>
				<td width="850px">订单号</td>
				<td width="200px">日期</td>
			</tr>
			<c:forEach items="${orders }" var="order" varStatus="Order">
					<tr>
						<td>${(order_page-1)*10 +Order.index+1}</td>
						<td><a href="${pageContext.request.contextPath}/Show_user_order?order_id=${order.getId()}">${order.getOrderNumber() }</a></td>
						<td>${order.getTime() }</td>
					</tr>
			</c:forEach>
		</tbody>

	</table>
	<div align="center">
		<a id="pageUp" href="${pageContext.request.contextPath}/Select_order_info?order_page=${order_page-1}">上一页</a>
		<span id="pageDisplay"><strong  font-size="30">${order_page}</strong>/ ${order_pageCount } </span>
		<a id="pageDown" href="${pageContext.request.contextPath}/Select_order_info?order_page=${order_page+1}">下一页</a>
	</div>
	<script type="text/javascript">
					var order_page='${order_page}';
					var order_pageCount='${order_pageCount}';
					if(order_pageCount==0){
						document.getElementById("pageDisplay").style.display="none";
				    	document.getElementById("pageDown").style.display="none";
				    	document.getElementById("pageUp").style.display="none";
					}
				    if(order_page == pageCount )
					{
				    	document.getElementById("pageDown").style.display="none";
					}
				    if(order_page==1){
				    	document.getElementById("pageUp").style.display="none";
				    }
				</script>
</body>
</html>