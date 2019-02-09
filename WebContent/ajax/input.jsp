<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
 <script type="text/javascript">
 function getRequest(){
     try{
         var request=new XMLHttpRequest();
     }
     catch(e1){
         try{
            request=new ActiveXObject("Msxml2.XMLHTTP");
         }
         catch(e2){
            try{
               request=new ActiveXObject("Microsoft.XMLHTTP");
            }
            catch(e3){
               request=false;
            }
         }
     }
     return request;
  }
  function $(elementId){
    return document.getElementById(elementId);
  }
  function getHostPath(){  
	    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp  
	    var curWwwPath=window.document.location.href;  
	    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp  
	    var pathName=window.document.location.pathname;  
	    var pos=curWwwPath.indexOf(pathName);
	    //获取主机地址，如： http://localhost:8083  
	    var localhostPath=curWwwPath.substring(0,pos);
	    if(curWwwPath.indexOf("springmvc")!=-1)
	    	localhostPath +="/springmvc";
	    return localhostPath;  
	}  
 </script>
</head>
<body>
 <table>
  <tr>
   <td>username:</td><td><input type="text" id="username" name="username"/></td>
  </tr>
  <tr><td>password:</td><td><input type="text" id="password" name="password"/></td></tr>
  <tr><td><input type="button" id="btn" value="submit" ></td></tr>
 </table>
 <script type="text/javascript">
  $("btn").onclick=function(){
        var request=getRequest();
        request.open("POST",getHostPath()+"/ajax/test",true);
        request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        request.onreadystatechange=function(){
            if(this.readyState==4&&this.status==200){
                alert(this.responseText);
            }
        }
        request.send();
	  }
 </script>
 <script type="text/javascript">
 var JSONObject={
		  "username":"li",
		  "password":"123"
 };
 $("username").value=JSONObject.username;
 $("password").value=JSONObject.password;
 </script>
</body>
</html>