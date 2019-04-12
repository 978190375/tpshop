<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/update_user">
		<table>
			<tbody>
				<tr>
					<td>旧密码</td>
					<td><input type="text" name="oldPassWord"></td>
				</tr>
				<tr>
					<td>新密码</td>
					<td><input type="text" name="newPassWord"></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input type="text" name="confirmPassWord"></td>
				</tr>
				<tr>
					<td><input type="submit" value="确认更改"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>