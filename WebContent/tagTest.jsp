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
  <form:form modelAttribute="person" method="post" action="tagTest">
     <table>
      <tr>
        <td>姓名:</td><td><form:input path="name"/></td>
      </tr>
      <tr>
       <td>密码:</td><td><form:password path="password"/></td>
      </tr>
      <tr>
       <td>性别:</td><td><form:radiobutton path="sex" value="男"/>男<form:radiobutton path="sex" value="女"/>女</td>
      </tr>
      <tr>
       <td>性别:</td><td><form:radiobuttons path="sex" items="${sexList}"/>
      <tr>
       <td>爱好:</td><td><form:checkbox path="hobby" value="篮球"/>篮球<form:checkbox path="hobby" value="唱歌"/>唱歌<form:checkbox path="hobby" value="足球"/>足球<form:checkbox path="hobby" value="排球"/>排球</td>
      </tr>
      <tr>
       <td>年级:</td>
       <td>
           <form:select path="classid">
             <form:option value="1" >大一</form:option>
             <form:option value="2" >大二</form:option>
             <form:option value="3" >大三</form:option>
           </form:select>
       </td>
      </tr>
      <tr>
       <td>描述:</td><td><form:textarea path="desc" rows="5" cols="10"/>
      </td>
     </tr>
     </table>
  </form:form>
</body>
</html>