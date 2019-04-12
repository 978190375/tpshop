<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>TP_SHOP</title>
<script src="${pageContext.request.contextPath}/js/fenye.js"></script>
<link rel="stylesheet"  href="css/main2.css">
</head>

<body onload="fenye()">
	
	<jsp:include page="top.jsp"></jsp:include>
	<div class="main">
		<div class="show">
			<table width="100%" border="1">
			  <tbody >
				<tr>				  
				  <c:forEach items="${goods }" var="good" varStatus="goodStatus">
				  	  <td>
					  	<div class="good_image"><a href="show_good?good_id=${good.id }"><img src="${good.image_path}" alt="${good.name}"/></a></div>
					  	<div class="good_name"><a href="show_good?good_id=${good.id }"><p>${good.name}</p></a></div>
					  	<div class="good_price"><span>￥</span>${good.price}</div>
					  	</td>
				    </c:forEach>
				</tr>
			  </tbody>
			</table>
			<div align="center">
				<a  href="${pageContext.request.contextPath}/index?good_page=${good_page-1}"><span id="pageUp" >上一页</span></a> 
			  <span id="pageDisplay"><strong  font-size="30">${good_page}</strong>/ ${pageCount }</span>
			  <a id="pageDown" href="${pageContext.request.contextPath}/index?good_page=${good_page+1}">下一页</a>
			</div>

				<script type="text/javascript">
					var good_page='${good_page}';
					var pageCount='${pageCount}';
					if(pageCount==0){
						document.getElementById("pageDisplay").style.display="none";
				    	document.getElementById("pageDown").style.display="none";
				    	document.getElementById("pageUp").style.display="none";
					}
				    if(good_page == pageCount )
					{
				    	document.getElementById("pageDown").style.display="none";
					}
				    if(good_page==1){
				    	document.getElementById("pageUp").style.display="none";
				    }
				</script>
		</div>
	
	</div>
	<jsp:include page="floor.jsp"></jsp:include>
</body>

	<script type="text/javascript">
		window.onload = function() {
			if (window.XMLHttpRequest)
			  {
			    // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			    xmlhttp=new XMLHttpRequest();
			  }
			  else
			  {
			    // IE6, IE5 浏览器执行代码
			    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			  }
			  xmlhttp.open("GET","${pageContext.request.contextPath}/Index?good_page=1"+str,true);
			  xmlhttp.send();
		}
	</script>
</html>