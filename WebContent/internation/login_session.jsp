<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 <a href="login_session?request_locale=zh_CN">中文|</a><a href="login_session?request_locale=en_US">English</a>
 <h3><spring:message code="title"/></h3>
 <form:form  modelAttribute="person" method="post" action="login_session">
   <table>
     <tr>
       <td><spring:message code="name"/></td>
       <td><form:input path="name"/></td>
     </tr>
     <tr>
       <td><spring:message code="password"/></td>
       <td><form:password path="password"/></td>
     </tr>
     <tr>
       <td><input type="submit" value="<spring:message code='submit'/>"/></td>
     </tr>
   </table>
 
 </form:form>
</body>
</html>