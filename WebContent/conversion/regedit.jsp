<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
  <h2>注册界面</h2>
  <form action="register" method="post">
  <table>
   <tr>
    <td>姓名</td><td><input type="text" name="name" id="name" value="li"/></td>
    </tr>
    <tr>
     <td>生日</td><td><input type="text" name="birthday" id="birthday" value="2017-08-13"/></td>
    </tr>
    <tr>
     <td>地址</td><td><input type="text" name="address" id="address" value="中国,沈阳"/></td>
    </tr>
    <tr>
     <td>汽车</td><td><input type="text" name="car" id="car" value="123,123"/></td>
    </tr>
    <tr><td><input type="submit" value="提交"></td></tr> 
  </table>
  </form>
</body>
</html>