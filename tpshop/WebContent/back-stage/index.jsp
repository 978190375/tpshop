<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<title>无标题文档</title>
</head>

<frameset rows="*" cols="200px,*">

  <frame src="${pageContext.request.contextPath}/back-stage/daohang.jsp" name="daohang" frameborder="0">
  <frame src="${pageContext.request.contextPath}/back-stage/welcome.jsp" name="main" frameborder="0">

</frameset><noframes></noframes>
</html>