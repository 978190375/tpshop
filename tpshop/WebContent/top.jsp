<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>top</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/top.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css">
</head>
<style type="text/css">
#logo {
	position: relative;
	float: left;
	top: 5px;
	width: 150px;
	height: 60px;
}

#right_top_menu {
	position: relative;
	padding: 0px;
	margin: 0px;
	top: 10px;
}

#right_top_menu ul {
	margin: 0px;
	float: right;
	list-style: none;
}

#right_top_menu ul li {
	position: relative;
	float: left;
	text-align:center;
	width:80px;
}

#right_top_menu ul li p {
	margin: 0px;
	align:center;
}

#right_top_menu a:link {
    color:#000000;
    text-decoration: none;
}
#right_top_menu  a:visited {
    text-decoration: none;
    color: #000000;
}
#right_top_menu  a:hover {
    text-decoration: underline;
}
#right_top_menu  a:active {
    text-decoration: none;
    color: #000000;
}
#user {
	display: block;
}

#loginIn {
	display: block;
}

#logOut {
	display: none;
}

#find {
	position: relative;
	top: 18px;
	left: 200px;
	float: left;
	width: 324px;
	height: 42px;
}

#find form {
	height: 30px;
}

#find_shuru {
	padding-left: 10px;
	width: 260px;
	height: 30px;
	border: 2px solid #7BBFEA;
	background: #F9F0DA;
	float: left;
}

#find_submit {
	border: 2px solid #7BBFEA;
	width: 50px;
	height: 34px;
	background: #7BBFEA;
	color: #FFF;
	position: relative;
	float: right;
}
</style>
<body>

	<div class="top">
		<div class="top_main">
			<div id="logo">
				<a href="${pageContext.request.contextPath}/index.jsp"><img
					src="${pageContext.request.contextPath}/images/logo.png"
					width="100%" height="100%"></a>
			</div>
			<div id="find">
				<form action="${pageContext.request.contextPath}/Search_good">
					<input type="hidden" name="good_page" value="1" /> <input
						type="text" id="find_shuru" placeholder="请输入关键词" name="key">
					<input type="submit" id="find_submit" value="Search"></input>
				</form>
			</div>
			<div id="right_top_menu">
				<ul>
					<li id="loginIn"><a
						href="${pageContext.request.contextPath}/login.jsp">
						<div class="top_icon"><i class="fa fa-sign-in fa-2x" style="color: #000000" title="登陆"></i></div>
						<div class="top_word"><p>登陆</p></div></a></li>
					<li id="logOut"><a
						href="${pageContext.request.contextPath}/logOut"><i
							class="fa fa-sign-out fa-2x" style="color: #000000" title="退出"></i>
							<p>退出</p></a></li>
					<li id="user"><a
						href="${pageContext.request.contextPath}/user/user.jsp"><i
							class="fa fa-user-circle-o fa-2x" style="color: #000000"
							title="用户中心"></i>
							<p>用户中心</p></a></li>

					<li id="cart"><a
						href="${pageContext.request.contextPath}/Show_cart"><i
							class="fa fa-shopping-cart fa-2x" style="color: #000000"
							title="购物车"></i>
							<p>购物车</p></a></li>
				</ul>

			</div>
		</div>
		<%
			if (session.getAttribute("user_id") != null) {
		%>
		<script>
			document.getElementById("loginIn").style.display = "none";
		</script>
		<script>
			document.getElementById("logOut").style.display = "block";
		</script>
		<%
			}
		%>
	</div>
	<div class="top_menu_box">
		<div class="top_menu">
			<ul>
				<a href="${pageContext.request.contextPath}/index.jsp"><li>首页</li></a>

			</ul>
		</div>
	</div>
</body>

</html>