<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <jsp:include page="tag-header.jsp"></jsp:include>
    
    Self content from this page is this WONT be seen, because this page is forward it to a.jsp.

<br><br> Below is content included from tag-a.jsp:<br>
    <jsp:forward page="tag-a.jsp"></jsp:forward>
</body>
</html>