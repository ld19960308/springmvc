<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3>欢迎${sessionScope.user.username }</h3>
  <table border="1">
    <tr>
     <th>书名</th><th>作者</th><th>售价</th>
    </tr>
    <tr>
     <c:forEach items="${requestScope.book_list }" var="book">
       <tr>
        <td>${book.name }</td><td>${book.author }</td><td>${book.money }</td>
       </tr>
     </c:forEach>
  </table>
</body>
</html>