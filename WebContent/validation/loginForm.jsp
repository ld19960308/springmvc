<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form:form modelAttribute="login" method="post" action="login">
      <table>
        <tr>
         <td><label>用户名:</label></td>
         <td><form:input path="username"/></td>
         <td><form:errors path="username" cssStyle="color:blue"></form:errors></td>
         <td>${error }</td>
        </tr>
        <tr>
         <td><label>密码:</label></td>
         <td><form:password path="password"/></td>
         <td><form:errors path="password" cssStyle="color:red"></form:errors></td>
        </tr>
        <tr>
         <td><input type="submit" value="登录"/></td>
        </tr>
      </table>
   </form:form>
   <h5>${username }</h5>
   <h5>${password }</h5>
</body>
</html>