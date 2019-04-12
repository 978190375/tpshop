<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="${pageContext.request.contextPath}/back-stage/js/show_cdkey.js"></script>
</head>
<body>

	<table width="100%" border="1" id="showGood">
		<tbody>
			<tr bgcolor="#717171">
				<td width="5%">激活码序号</td>
				<td>激活码</td>
				<td width="5%">修改</td>
				<td width="15%">删除</td>
			</tr>
			<c:forEach items="${cdkeyList }" var="te" varStatus="cdkeyStatus">

				<form action="UpdateCdkey" method="get">
					<tr>
						<td>${(cdkey_page-1)*10 +cdkeyStatus.index+1}</td>
						<td><input type="text" name="cdkey" id="${te.id }"
							value="${te.cdkey}" disabled="disabled"></input></td>
						<input type="hidden" name="cdkey_id" value="${te.id }">


						<td><input type="button" id="${te.id }operator"
							onClick="update(${te.id })" value="修改"></td>
						<td><a href="#">删除</a></td>
					</tr>

				</form>
			</c:forEach>
		</tbody>

	</table>
	<div align="center">
		<a
			href="${pageContext.request.contextPath}/Show_cdkey?good_id=${good_id }&cdkey_page=${cdkey_page-1}">上一页</a>
		<strong font-size="30">${cdkey_page}</strong>/ ${cdkey_pageCount } <a
			href="${pageContext.request.contextPath}/Show_cdkey?good_id=${good_id }&cdkey_page=${cdkey_page+1}">下一页</a>
	</div>
</body>
</html>