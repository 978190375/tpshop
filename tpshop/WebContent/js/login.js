// JavaScript Document

function accountOnBlur(){
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
function passOnBlur(){	
	var id=document.getElementById("password");
	var tp=document.getElementById("password_tips");
	if(id.value.length<8||id.value.length>16){
		id.style.border='1px'+' '+'solid';
		id.style.borderColor="red";
		tp.innerHTML="请输入6-16位密码";
		tp.style.color="red";
	}
	else{
			tp.style.display="none";
			id.style.border='1px'+' '+'solid';
			id.style.borderColor="#438cfa"
		}
	
}