<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>Spring 3.0 MVC demo</title>
</head>
<body>
 <form action="findUser" method="post">
 <table align="center">
  <tr>
   <td>用户名:</td>
   <td><input type="text" name="username"></td>
  </tr>
  <tr>
   <td>密码:</td>
   <td><input type="password" name="password"></td>
  </tr>
  <tr>
    <td><input type="submit" value="登录" >
 </table>
 </form>
</body>
</html>