
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax demo</title>
</head>
<body style="text-align: center">
   <h1>loading a web page into a dic</h1>
   <div id='info'>this sentence will be replaced</div>
   <script type="text/javascript">
     params="url=ajax/aw";
     request=new ajaxRequest();
     request.open("post","aw",true);
     request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
     request.setRequestHeader("Content-length",params.length);
     request.setRequestHeader("Connection","close");
     request.onreadystatechange=function(){
         if(this.readyState==4){
            if(this.status==200){
               if(this.responseText!=null){
                   document.getElementById('info').innerHTML=this.responseText;
               }
               else alert("ajax error:no data received");
            }
            else alert("ajax error:"+this.statusText);
         }
     }
     request.send(params);
     function ajaxRequest(){
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
   </script>
</body>
</html>