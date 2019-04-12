<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>左侧导航</title>
</head>

<!--图标样式-->
<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/back-stage/css/daohang.css" />

<body>

<div class="s-side">
	<ul>
		<!--这部分是导航栏信息。-->
		<li class="s-firstItem first">
			<a href="#">
				<i class="fa fa-home"></i>
				<span>首页</span>
			</a>
		</li>
		
		<li class="first">
			<div class="d-firstNav s-firstNav clearfix">
				<i class="fa fa-bars"></i>
				<span>商品管理</span>
				<i class="fa fa-caret-right fr "></i>
			</div>
			<ul class="d-firstDrop s-firstDrop">
				<li>
					<div class="d-secondNav s-secondNav">
						<i class="fa fa-minus-square-o"></i>
						<a href="product-manage/add_goods.jsp" target="main">发布商品</a>
					<!--	<i class="fa fa-caret-right fr"></i>--> 
					</div>
				<!-- <ul class="d-secondDrop s-secondDrop">
						<li class="s-thirdItem">
							<a href="#">三级导航</a>
						</li>
						<li class="s-thirdItem">
							<a href="#">三级导航</a>
						</li>
					</ul> //添加三级导航--> 
				</li>
				<li>
					<div class="d-secondNav s-secondNav">
						<i class="fa fa-minus-square-o"></i>
						<a href="${pageContext.request.contextPath}/Select_good?good_page=1" target="main">查看商品</a>
					<!--	<i class="fa fa-caret-right fr "></i>--> 
					</div>
				</li>
			</ul>
		</li><li class="first">
			<div class="d-firstNav s-firstNav clearfix">
				<i class="fa fa-bars"></i>
				<span>激活码管理</span>
				<i class="fa fa-caret-right fr "></i>
			</div>
			<ul class="d-firstDrop s-firstDrop">
				<li>
					<div class="d-secondNav s-secondNav">
						<i class="fa fa-minus-square-o"></i>
						<a href="${pageContext.request.contextPath}/Select_cdkey?page=1" target="main">查看激活码</a>
					<!--	<i class="fa fa-caret-right fr"></i>--> 
					</div>
				<!-- <ul class="d-secondDrop s-secondDrop">
						<li class="s-thirdItem">
							<a href="#">三级导航</a>
						</li>
						<li class="s-thirdItem">
							<a href="#">三级导航</a>
						</li>
					</ul> //添加三级导航--> 
				</li>
				
			</ul>
		</li>
		<li class="first">
			<div class="d-firstNav s-firstNav">
				<i class="fa fa-bars"></i>	                    
				<span>一级菜单</span>
				<i class="fa fa-caret-right fr" ></i>
			</div>
			<ul class="d-firstDrop s-firstDrop">
				<li class="s-secondItem">
					<i class="fa fa-minus-square-o"></i>
					<a href="#">二级导航</a>
				</li>
				<li class="s-secondItem">
					<i class="fa fa-minus-square-o"></i>
					<a href="#">二级导航</a>
				</li>
			</ul>
		</li>
	</ul>
</div>
	
<script type="text/javascript" src="${pageContext.request.contextPath}/back-stage/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back-stage/js/daohang.js" ></script>

</body>	
</html>