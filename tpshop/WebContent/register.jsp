<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tpshop注册</title>
<script src="${pageContext.request.contextPath}/js/register.js"></script>
<link rel="stylesheet"  href="${pageContext.request.contextPath}/css/login2.css">
</head>

<body>
	<jsp:include page="top.jsp"></jsp:include>
    <div class="main">
		<div class="show">
            <div id="register_show">
                <div id="tips" >注册新用户</div>
                <div id="register_form">
                    <form action="register" method="post">
                        <hr/>
                        <br>
                        <h4>用户信息</h4>
                        <div class="input_text"><input type="text" name="username" id="userName" placeholder="用户名" onBlur="usernameOnBlur()"></div>
                        <div class="input_text"><input type="text" name="email" id="email" placeholder="邮箱*" onBlur="emailOnBlur()"><p id="email_tips"></p> </div>
                        <div class="input_text"><input type="text" name="confirmEmail" id="confirmEmail" placeholder="确认邮箱*" onBlur="confirmEmailOnBlur()"><p id="confirm_email_tips"></p> </div>
                        
                        <div class="input_text"><input type="text" name="phone" id="phone" placeholder="手机号" onBlur="phoneOnBlur()"><p id="phone_tips"></p> </div>
                        <br>
                        <h4>登陆信息</h4>
                        <div class="input_text"><input type="password" name="password" id="password" placeholder="密码*" onFocus="passwordOnFocus()" onBlur="passwordOnBlur()"><p id="password_tips"></p> </div>
                        <div class="input_text"><input type="password" name="confirmPassword" id="confirmPassword" placeholder="确认密码*" onBlur="confirmPasswordOnBlur()"><p id="confirm_password_tips"></p> </div>
                        
                        <div class="input_button"><input type="submit" id="submit" title="注册" value="注册" onClick="submit()"></div>
                        
                        
                    </form>
                    <div  id="back"><a href="login.jsp">⬅返回登陆</a></div>
                </div>
	    </div>
	</div>
	
	<jsp:include page="floor.jsp"></jsp:include>
</body>
<style type="text/css">
    #back{
        margin-top: 20px;
    }
        #register_show{
        padding-top: 50px;
        padding-bottom: 50px;
        position: relative;
        margin-left: 50%;
        left: -200px;
        width: 400px;
        text-align: center;
    }
        #tips{
        font-size: 20px;
        font-weight: bolder;
    }
        #register_form{    
        width: 100%;
        text-align: center;
        
    }
    
    .input_text{
        margin-top: 15px;
        
    }
    .input_text input{
        padding-left: 10px;
        width: 370px;
        height: 48px;
        text-align: left;
        font-size: 18px;
        border: 1px #CCCCCC double;
    }
    .input_button {
        margin-top: 30px;
    }
     .input_button input{
        
        width: 370px;
        height: 48px;
        font-size: 20px;
        border: 0px;
        color: #FFF;
        font-weight: bolder;
        background-color: #7BBFEA;
    }
     .input_button input:hover{
         
        color: #C5C5C5;
        background-color: #737373;  
    }
    </style>
</html>