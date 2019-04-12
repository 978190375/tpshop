<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>添加激活码</h1>
<form action="${pageContext.request.contextPath}/Add_cdkey" method="get">
	<input type="hidden" name="good_id" value="<%=request.getParameter("good_id") %>"  />
	<textarea name="cdkeys" rows="200" id="cdkeys"></textarea>
	<input type="submit" value="保存" id="submit">
</form>

<p>*每行对应一条激活码</p>
<p>*可同时添加多行</p>
<p>*回车换行</p>

</body>

<style type="text/css">
	#cdkeys{
		width: 90%;
		height: 200px;
		resize: none;
	}	
	#submit{
		width:40px;
		height:30px;
	}
</style>
</html>