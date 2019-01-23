function $(str){
	return new myquery(str);
}

function myquery(str){
	if(str instanceof Function){
		window.onload=str;
	}else if(str.startsWith(".")){
		this.obj=document.getElementsByClassName(str.substring(1));
	}else if(str.startsWith("#")){
		this.obj=document.getElementById(str.substring(1));
	}else{
		this.obj=document.getElementsByTagName(str.substring(1));
	}
}


myquery.prototype.focus=function(handler){
	this.obj.addEventListener("focus",handler);
}

myquery.prototype.click=function(handler){
	this.obj.addEventListener("click",handler);
}

$.post=function myqueryAjax(url,data,handler){
	var xmlhttp;
	if(window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("POST",url,true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			handler(xmlhttp.responseText);
		}
	}
	var s=parseData(data);
	xmlhttp.send(s);
}

function parseData(data){
	var i=0;
	var dd="";
	
	 for(var item in data){
        dd+=item+"="+data[item];
		if(i>=0){
			dd+="&";
		}
		i++;
    } 
	
	return dd.substring(0,dd.length-1);
}


