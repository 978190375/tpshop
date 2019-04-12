function update(num){
    var cdkey=document.getElementById(num);
    var operator=document.getElementById(num+"operator");
    if(operator.value.includes("修改")){
    	cdkey.disabled="";
        operator.value="保存";
    }else{
    	operator.type="submit";
    }
}