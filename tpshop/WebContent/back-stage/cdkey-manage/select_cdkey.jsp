<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看激活码</title>
</head>
<body>
    <table width="100%" border="1" id="showGood">
  <tbody>
    <tr bgcolor="#717171">
      <td width="5%">商品序号</td>
      <td>商品名称</td>
      <td width="5%">激活码数量</td>
      <td width="15%">激活码管理</td>
      <td width="15%">添加</td>
    </tr>
    <c:forEach items="${goods }" var="good" varStatus="goodStatus">
    	
    	
    <tr>
      <td> ${(page-1)*10 +goodStatus.index+1} </td>
      <td>${good.name}</td>
      
      <td>${good.count}</td>
      <td><a href="${pageContext.request.contextPath}/Show_cdkey?good_id=${good.id}&cdkey_page=1">查看激活码</a></td>
      <td><a href="back-stage/cdkey-manage/add_cdkey.jsp?good_id=${good.id}">添加激活码</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<div align="center">
  <a href="${pageContext.request.contextPath}/Select_cdkey?page=${page-1}">上一页</a> 
  <strong font-size="30">${page}</strong>/ ${pageCount }
  <a href="${pageContext.request.contextPath}/Select_cdkey?page=${page+1}">下一页</a>
  </div>
</body>
<style type="text/css">
    #showGood tbody tr{
        height: 40px;
    }
    
    
    </style>
</html>