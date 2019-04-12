<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
			<tbody>
				<tr>
					<td>用户名</td>
					<td>${user.getUsername() }</td>
				</tr>
				<tr>
					<td>邮箱:</td>
					<td>${user.getEmail() }</td>
				</tr>
			</tbody>
		</table>


<form action="${pageContext.request.contextPath}/user/Update_user.jsp">
	<input type="submit" value="修改密码">
</form>
</body>
</html>