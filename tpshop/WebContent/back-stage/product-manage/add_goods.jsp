<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加商品</title>
</head>

<body>
	<div id="main">
		<form action="${pageContext.request.contextPath}/Add_goods" method="post" >
			<table width="100%" border="1">
			  <tbody>
				<tr style="background-color: #909090">
				  <td width="10%">游戏名称:</td>
				  <td width="90%"><input type="text" name="game_name" style="width: 500px; height: 30px;"></td>
				</tr>
				<tr>
				  <td height="120">游戏属性:</td>
				  <td>
					  <div id="shuxing">
					  	<table width="100%" border="1">
						  <tbody>
							<tr>
							  <td width="11%" height="72" >游戏类型：</td>
							  <td width="89%">
								<table width="100%" border="0">
								  <tr>
								    <td><label>
								      <input type="checkbox" name="game_tips" value="1" id="game_tips_0"  >
								      休闲</label></td>
									  
								    <td><label>
								      <input type="checkbox" name="game_tips" value="2" id="game_tips_1">
								      体育</label></td>
									  
								    <td><label>
								      <input type="checkbox" name="game_tips" value="3" id="game_tips_2">
								      冒险</label></td>
									  
								    <td><label>
								      <input type="checkbox" name="game_tips" value="4" id="game_tips_3">
								      动作</label></td>
									  
								    <td><label>
								      <input type="checkbox" name="game_tips" value="5" id="game_tips_4">
								      大型多人在线</label></td>
								</tr>
								<tr>  
								    <td><label>
								      <input type="checkbox" name="game_tips" value="6" id="game_tips_5">
								      模拟</label></td>
								    <td><label>
								      <input type="checkbox" name="game_tips" value="7" id="game_tips_6">
								      独立</label></td>
								    <td><label>
								      <input type="checkbox" name="game_tips" value="8" id="game_tips_7">
								      竞速</label></td>
								    <td><label>
								      <input type="checkbox" name="game_tips" value="9" id="game_tips_8">
								      策略</label></td>
								    <td><label>
								      <input type="checkbox" name="game_tips" value="10" id="game_tips_9">
								      角色扮演</label></td>
									
								</tr>
							</table>
							  </td>
							</tr>
							<tr>
							  <td height="175">游戏平台：</td>
							  <td>
							    <table width="100%">
									<tr>
									  <td height="75"><label>
										<input type="radio" name="platform" value="1" id="platform_1">
										ArenaNet</label></td>
									  <td><label>
										<input type="radio" name="platform" value="2" id="platform_2">
										Battle.net</label></td>
									  <td><label>
										<input type="radio" name="platform" value="3" id="platform_3">
										Bethesda Launcher</label></td>
									  <td><label>
										<input type="radio" name="platform" value="4" id="platform_4">
										Developer Website</label></td>
									  <td><label>
										<input type="radio" name="platform" value="5" id="platform_5">
										Epic Games Launcher</label></td>
									  <td><label>
										<input type="radio" name="platform" value="6" id="platform_6">
										GOG.com</label></td>
									</tr>
									<tr>
									  <td height="73"><label>
										<input type="radio" name="platform" value="7" id="platform_7">
										Mog Station</label></td>
									  <td><label>
										<input type="radio" name="platform" value="8" id="platform_8">
										Origin</label></td>
									  <td><label>
										<input type="radio" name="platform" value="9" id="platform_9">
										Rockstar Social Club</label></td>
									  <td><label>
										<input type="radio" name="platform" value="10" id="platform_10">
										Steam</label></td>
									  <td><label>
										<input type="radio" name="platform" value="11" id="platform_11">
										The Elder Scrolls Online</label></td>
									  <td><label>
										<input type="radio" name="platform" value="12" id="platform_12">
										uPlay</label></td>
									</tr>
								 </table></td>
							</tr>
							<tr>
							  <td>游戏地区：</td>
							  <td>
								  <select name="region" style="width: 150px; height: 50px;"> 
									<option value="1">全球</option> 
									<option value="2">亚洲</option>
									<option value="3">亚太</option>
									<option value="4">欧洲</option>
									<option value="5">美国</option>
								  </select>
							  </td>
							</tr>
							<tr>
							  <td>游戏语言：</td>
							  <td><table width="100%">
							    <tr>
							      <td><label>
							        <input type="checkbox" name="language" value="1" id="language_0">
							        中文</label></td>
							      <td><label>
							        <input type="checkbox" name="language" value="2" id="language_1">
							        英语</label></td>
							      <td><label>
							        <input type="checkbox" name="language" value="3" id="language_2">
							        日语</label></td>
						        </tr>
						      </table></td>
							</tr>
							<tr>
							  <td>上市时间：</td>
							  <td>
                              <input type="text" name="product-time-year" id="product-time-year" class="product-time"><span>-</span>
                              <input type="text" name="product-time-month" id="product-time-month" class="product-time"><span>-</span>
                              <input type="text" name="product-time-day" id="product-time-day" class="product-time">
								
								</td>
							</tr>
							<tr>
							  <td>游戏版本：</td>
							  <td><table width="100%">
							    <tr>
							      <td><label>
							        <input type="radio" name="edition" value="1" id="edition_0">
							        标准版</label></td>
							      <td><label>
							        <input type="radio" name="edition" value="2" id="edition_1">
							        普通版</label></td>
							      <td><label>
							        <input type="radio" name="edition" value="3" id="edition_2">
							        首发版</label></td>
							      <td><label>
							        <input type="radio" name="edition" value="4" id="edition_3">
							        特典版</label></td>
						        </tr>
							    <tr>
							      <td><label>
							        <input type="radio" name="edition" value="5" id="edition_4">
							        豪华版</label></td>
							      <td><label>
							        <input type="radio" name="edition" value="6" id="edition_5">
							        典藏版</label></td>
							      <td><label>
							        <input type="radio" name="edition" value="7" id="edition_6">
							        黄金版</label></td>
							      <td><label>
							        <input type="radio" name="edition" value="8" id="edition_7">
							        季票</label></td>
						        </tr>
							    <tr>
							      <td><label>
							        <input type="radio" name="edition" value="9" id="edition_8">
							        DLC 1</label></td>
							      <td><label>
							        <input type="radio" name="edition" value="10" id="edition_9">
							        DLC 2</label></td>
							      <td><label>
							        <input type="radio" name="edition" value="11" id="edition_10">
							        DLC 3</label></td>
							      <td><label>
							        <input type="radio" name="edition" value="12" id="edition_11">
							        DLC 4</label></td>
						        </tr>
						      </table></td>
							</tr>
						  </tbody>
						</table>


					  
					  </div></td>
				</tr>
				<tr>
				  <td>商品属性：</td>
				  <td>
					  <table width="100%" border="1">
						  <tbody>
							<tr>
							  <td width="11%">游戏图片：</td>
							  <td width="89%"></td>
							</tr>
							<tr>
							  <td>游戏原价：</td>
							  <td>
                              <input type="text" name="game_price" id="textfield">&nbsp;元</td>
							</tr>
							<tr>
							  <td>商品价格：</td>
							  <td>
                              <input type="text" name="price" id="price">&nbsp;元</td>
							</tr>
							<tr>
							  <td>商品数量：</td>
							  <td>
                              <input type="text" name="count" id="count">&nbsp;个</td>
                              <input type="hidden" name="ucount" value="0">
							</tr>
							<tr>
							  <td>商品描述：</td>
							  <td>
                              <textarea name="discription" id="discription" style="width: 80%; height: 600px;"></textarea></td>
							</tr>
						  </tbody>
						</table>
				  </td>
				</tr>
			  </tbody>
			</table>
			<table width="100%" border="0">
			  <tbody>
				<tr style="text-align: center">
				  <td><input type="submit" value="发布" style="width: 100px; height: 30px;"></td>
				  <td><input type="button" value="放入购物车" style="width: 100px; height: 30px;"></td>
				</tr>
			  </tbody>
			</table>

		</form>
</div>
</body>
</html>