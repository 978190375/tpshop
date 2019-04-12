<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
	border: 0px;
	margin: 0px;
	padding: 0px;
}
.user_main{
	position:relative;
	margin-left:50%;
	left:-550px;
}

.user_show{
	position: relative;
	width: 1100px;
	min-width:1100px;
}

</style>
</head>
<body>
	<jsp:include page="/top.jsp"></jsp:include>
	<div class="user_main">
		<div class="user_show">
			<table height="400px">
				<tbody>
					<tr >
						<td id="daohang">
							<div id="daohang_main">
								<ul style="list-style: none;text-align: center;">
									<a href="${pageContext.request.contextPath}/Select_user_info" target="main"><li>个人信息</li></a>
									<a href="${pageContext.request.contextPath}/Select_order_info?order_page=1" target="main"><li>订单信息</li></a>
								</ul>
							</div>
						</td>
						<td style="width: 950px">
							<iframe src="welcome.jsp" name="main" height="600px" width="950px"></iframe>
						</td>
						
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="/floor.jsp"></jsp:include>
</body>

<style type="text/css">
#daohang{
padding-top:10px;
	width: 150px;
	border: 1px dotted #C6C6C6;
	vertical-align: top;
}
#daohang_main{
	margin-top:0px;
}
#daohang_main li{
	padding-top:5px;
	vertical-align: middle;
	width:148px;
	height:30px;
	background:#9D9D9D;
	margin-bottom:2px;
	font-size:20px;
}
#daohang_main li:hover{
	width:148px;
	height:30px;
	background:#C6C6C6;
	margin-bottom:2px;
}
#daohang_main a:link {
    color:#000000;
    text-decoration: none;
}
#daohang_main a:visited {
    text-decoration: none;
    color: #000000;
}
#daohang_main a:hover {
    text-decoration: none;
}
#daohang_main a:active {
    text-decoration: none;
    color: #000000;
}
</style>
</html>