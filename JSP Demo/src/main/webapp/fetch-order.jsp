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
    
    <jsp:useBean id="order1" class="actiontag.order" scope="session"></jsp:useBean>
    
    Order Details: <br>
     Order Id:<jsp:getProperty property="orderId" name="order1" /> <br>
     Amount: <jsp:getProperty property="amount"  name="order1" /> <br>
     Customer : <jsp:getProperty property="customerName" name="order1" /><br>
     
     
</body>
</html>