<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>无标题文档</title>
<script src="js/login.js"></script>
<link rel="stylesheet"  href="css/login2.css">
</head>

<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="login_m">
		<div class="login_s">
            <div id="login_show">
                <div id="tips" >登陆</div>
                <div id="login_form">
                    <form action="Login" method="post">
                        <div id="input_text"><input type="text" name="email" id="email" placeholder="Email Address*" onBlur="accountOnBlur()"><p id="email_tips"></p> </div>
                        <div id="password_text"><input type="password" name="password" id="password" placeholder="Password*" onBlur="passOnBlur()"><p id="password_tips"></p>  </div>
                        <div class="input_button"><input type="submit" id="submit" title="登陆" value="登陆"></div>
                    </form>
                    
                </div>
                <div id="register_tips">
                    <div id="r_tips">
                        <hr/>
                        <br>
                        <p id="re_tips"><strong>注册新用户</strong></p>
                        <br>
                        <hr/>
                        <p>通过在我们的商店中创建帐户，您可以更快地完成结帐流程，查看和跟踪您帐户中的订单等。</p>
                        <div class="input_button">
                        <form action="register.jsp" method="post">
                        	<input type="submit" id="register" title="注册新用户" value="注册新用户">
                        </form>
                        </div>
                    </div>

                </div>
            </div>
	    </div>
	</div>
	
	<jsp:include page="floor.jsp"></jsp:include>
</body>
<style type="text/css">
    
    #login_show{
    	padding-top:50px;
    	padding-bottom:50px;
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
    
    #register_tips{
        width: 100%;
    }
    #re_tips{
        font-size: 20px;
    }
    #register{
        width: 370px;
        height: 48px;
        font-size: 20px;
        border: 0px;
        color: #FFF;
        font-weight: bolder;
        background-color: #7BBFEA;
        
    }
    #register:hover{
        color: #C5C5C5;
        background-color: #737373;      
    }
    #r_tips hr{
        color: #D5D5D5;
    }
    #tips{
        width: 100%;
        text-align: center;
    }
    #login_form{    
        width: 100%;
        text-align: center;
        
    }
    #password_text{
        margin-top: 15px;
    }
    #input_text{
        margin-top: 30px;
        
    }
    .input_button{
        margin-top: 30px;
        
    }
    #email{
        width: 370px;
        height: 48px;
        text-align: center;
        font-size: 18px;
        border: 2px #CCCCCC double;
    }
    #password{
        
        width: 370px;
        height: 48px;
        text-align: center;
        font-size: 18px;
        border: 2px #CCCCCC double;
    }
    #submit{
        width: 370px;
        height: 48px;
        font-size: 20px;
        border: 0px;
        color: #FFF;
        font-weight: bolder;
        background-color: #7BBFEA;
        
    }
    #submit:hover{
        color: #C5C5C5;
        background-color: #737373;        
    }
    #forgotPassword{
        margin: 20px 0px;
        
    }
    </style>
</html>