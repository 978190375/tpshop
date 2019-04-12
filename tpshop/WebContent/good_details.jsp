<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="css/good_details.css">
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
	<div class="good_main">
		<div class="good_show">
		<form action="Add_cart" method="post">
			<table >
			  <tbody>
			    <tr style="vertical-align: top;" >
			      <td id="image"><img src="${good.image_path }" alt="" /></td>
			      <td id="good_details" >
			      	<div id="good_details_top">
				      	<div id="good_name"><h2>${good.name }</h2><input type="hidden" name="good_id" value="${good.id }"></div>
				      	<div><p>平台:${good.platform }</p></div>
				      	<div><p>地区:${good.region}</p></div>
			      	</div>
			      	<br>
			      	<div id="good_details_bottom">
					    <div id="price">
					      	<p style="text-decoration:line-through;">原价格:${good.good_price }</p>
					      	<h2 style="color:red;">价格:￥${good.price }</h2>
				      	</div>
					    <div id="checkout"> 
					    	<input type="submit" id="checkout_button" value="加入购物车">
				      	</div>
			      	</div>
			      </td>
			      <td id="good_details_2">语言： ${good.language }</td>
			    </tr>
			    <tr>
			      <td id="good_discription" colspan="2"> ${good.discription }</td>
			      <td id="advertisement">This is a advertisement</td>
			    </tr>
			  </tbody>
			</table>
		</form>
		</div>
	
	</div>
	<jsp:include page="floor.jsp"></jsp:include>
</body>
<style type="text/css" >
	#image{
	width:275px;
	height:375px;
	}
	#image img{
		padding:10px;
		width:255px;
		height:355px;
		
	}
	#good_details{
		align:left;
		padding:10px 0px 10px 0px;
		width:500px;
	}
	#good_details_2{
		width:325px;
	}
	#good_discription{
	}
	#advertisement{
		
	}
	#good_details_top{
		position:relative;
		width:460px;
		height:90px;
		background-color: #ECFEFD;
		padding:20px;
	}
	
	
	#good_details_bottom{
		position:relative;
		width:500px;
		height:90px;
		background-color: #ECFEFD;
	}
	#price{
		position:absolute;
		float:right;
		top:20px;
		left:20px;
	}
	#checkout{
		position:absolute;
		float:right;
		top:20px;
		right:20px;
	}
	#checkout_button{
		width:200px;
		color:red;
		font-size:20px;
		height:50px;
		background-color:#FFF;
	}
	
	#checkout_button:hover{
		width:200px;
		color:#FFF;
		font-size:20px;
		height:50px;
		background-color:red;
	}
</style>
</html>