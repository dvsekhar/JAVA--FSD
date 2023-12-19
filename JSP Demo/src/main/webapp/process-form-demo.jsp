<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

String amtStr = request.getParameter("amount");
float amount = Float.parseFloat(amtStr);

String custName = request.getParameter("customer");

out.println("You order with amount="+amount+" and customer="+custName);

%>
</body>
</html>