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
    Self content from this page is this.

<br><br> Below is content included from a.jsp:<br>
    <jsp:include page="tag-a.jsp"></jsp:include>
  
  <hr>
    
<br><br> Below is content included from a.txt: <br>
    <jsp:include page="tag-a.txt"></jsp:include>
</body>
</html>