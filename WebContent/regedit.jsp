<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 <form:form  modelAttribute="person" method="post" action="regedit">
   <table>
     <tr>
      <td>姓名:</td><td><form:input path="name"/></td>
      <td><font color="red"><form:errors path="name"/></font></td>
     </tr>
     <tr>
      <td><input type="submit" value="提交"/></td>
     </tr>
   </table>
 </form:form>
</body>
</html>