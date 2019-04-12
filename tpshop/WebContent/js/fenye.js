// JavaScript Document
function fenye(){
		if(pageCount==0){
			document.getElementById("pageDisplay").style.display="none";
	    	document.getElementById("pageDown").style.display="none";
	    	document.getElementById("pageUp").style.display="none";
		}
	    if(good_page == pageCount )
		{
	    	document.getElementById("pageDown").style.display="none";
		}
	    if(good_page==1){
	    	document.getElementById("pageUp").style.display="none";
	    }
	}