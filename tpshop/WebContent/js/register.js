// JavaScript Document
	function submit(){
	var user=document.getElementById("email").style.borderColor;
	var pass=document.getElementById("confirmEmail").style.borderColor;
	var que=document.getElementById("password").style.borderColor;
	var email=document.getElementById("ConfirmPassword").style.borderColor;
	if(user==pass&&pass==que&&que==email&&email=="rgb(67, 140, 250)"){
		alert("注册成功！")
		window.location.href="login.html";
	}
	else {
		alert("请重新检查注册信息！")
	}
    }

function usernameOnBlur(){
    var user=document.getElementById("userName");
		user.style.border='1px'+' '+'solid';
		user.style.borderColor="#438cfa";
}
function emailOnBlur(){
    var email=document.getElementById("email");
    var email_tips=document.getElementById("email_tips");
    var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(!myreg.test(email.value)){
		email.style.border='1px'+' '+'solid';
		email.style.borderColor="red";
		email_tips.innerHTML="邮箱格式不正确，请检查！";
		email_tips.style.color="red";
	}
	else {
		email_tips.style.display="none";
		email.style.border='1px'+' '+'solid';
		email.style.borderColor="#438cfa"
	}
}
function confirmEmailOnBlur(){	
	var id=document.getElementById("email");
	var pa=document.getElementById("confirmEmail");
	var tp=document.getElementById("confirm_email_tips");
	if(id.value!=pa.value){
		pa.style.border='1px'+' '+'solid';
		pa.style.borderColor="red";
		tp.innerHTML="邮箱不一致";
		tp.style.color="red";
	}
	else {
		tp.style.display="none";
		pa.style.border='1px'+' '+'solid';
		pa.style.borderColor="#438cfa"
	}
}

function phoneOnBlur(){
    var phone=document.getElementById("phone");
    var phone_tips=document.getElementById("phone_tips");
    var myreg = /^1[34578]\d{9}$/;
	if(!myreg.test(phone.value)){
		phone.style.border='1px'+' '+'solid';
		phone.style.borderColor="red";
		phone_tips.innerHTML="手机号码不正确，请检查！";
		phone_tips.style.color="red";
	}
	else {
		phone_tips.style.display="none";
		phone.style.border='1px'+' '+'solid';
		phone.style.borderColor="#438cfa"
	}
}
function passwordOnFocus(){
	var id=document.getElementById("password");
	var tp=document.getElementById("password_tips");
	tp.style.display="block";
	tp.style.color="blue";
	tp.innerHTML="请输入8-12位的数字、小写字母和大写字母";
	id.style.border='1px'+' '+'solid';
	id.style.borderColor="blue";
}
function passwordOnBlur(){	
	var id=document.getElementById("password");
	var tp=document.getElementById("password_tips");
	if(id.value.length<8||id.value.length>12){
		id.style.border='1px'+' '+'solid';
		id.style.borderColor="red";
		tp.innerHTML="请输入8-12位密码";
		tp.style.color="red";
	}
	else{
			tp.style.display="none";
			id.style.border='1px'+' '+'solid';
			id.style.borderColor="#438cfa"
		}
	
}
function confirmPasswordOnBlur(){	
	var id=document.getElementById("password");
	var pa=document.getElementById("confirmPassword");
	var tp=document.getElementById("confirm_password_tips");
	if(id.value!=pa.value){
		pa.style.border='1px'+' '+'solid';
		pa.style.borderColor="red";
		tp.innerHTML="密码不一致";
		tp.style.color="red";
	}
	else {
		tp.style.display="none";
		pa.style.border='1px'+' '+'solid';
		pa.style.borderColor="#438cfa"
	}
}