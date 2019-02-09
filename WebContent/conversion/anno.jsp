<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
  <form action="dataTrans" method="post">
    <table>
     <tr>
      <td><label>日期类型：</label></td>
      <td><input type="text"  name="birthday" id="birthday" value="2017-8-13"/></td>
     </tr>
     <tr>
      <td><label>整数类型：</label></td>
      <td><input type="text" name="total" id="total" value="13"/></td>
     </tr>
     <tr>
      <td><label>百分数类型：</label></td>
      <td><input type="text" name="discount" id="discount" value="0.69"/></td>  
     </tr>
     <tr>
      <td><label>货币类型：</label></td>
      <td><input type="text" name="money" id="money" value="13.13"/></td>
     </tr>
     <tr> 
      <td><input type="submit" value="提交"/></td>
     </tr>
    </table>
  </form>
</body>
</html>