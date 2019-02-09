<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JSR</title>
</head>
<body>
  <form:form action="login" modelAttribute="jsr">
    <table>
     <tr>
      <td><label>用户名</label></td>
      <td><form:input path="loginname"/></td>
      <td><form:errors path="loginname" cssStyle="color:blue"/></td>
     </tr>
     <tr>
      <td><label>密码</label></td>
      <td><form:password path="password"/></td>
      <td><form:errors path="password" cssStyle="color:red"/></td>
     </tr>
     <tr>
      <td><label>年龄</label></td>
      <td><form:input path="age"/></td>
      <td><form:errors path="age" cssStyle="color:red"/></td>
     </tr>
     <tr>
      <td><label>邮箱</label></td>
      <td><form:input path="email"/></td>
      <td><form:errors path="email" cssStyle="color:red"/></td>
     </tr>
     <tr>
      <td><label>生日</label></td>
      <td><form:input path="birthday"/></td>
      <td><form:errors path="birthday" cssStyle="color:red"/></td>
     </tr>
     <tr>
       <td><label>电话</label></td>
       <td><form:input path="phone"/></td>
       <td><form:errors path="phone" cssStyle="color:red"/></td>
      </tr>
      <tr>
       <td><input type="submit" value="注册"/></td>
      </tr>
    </table>
  </form:form>
</body>
</html>