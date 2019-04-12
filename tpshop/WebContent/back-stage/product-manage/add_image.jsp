<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>上传商品图片</h1>
<form action="${pageContext.request.contextPath}/Add_image?good_id=${good.id }" method="post" enctype="multipart/form-data">
	<input type="file" name="image" >
	<input type="submit" value="上传">
</form>
</body>
</html>