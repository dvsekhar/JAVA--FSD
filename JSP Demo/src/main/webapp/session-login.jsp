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
	if (request.getParameter("error") != null && request.getParameter("error").equals("1")){
		out.println("<b>Your session has expired or is invalid userid or password.</b><br>");
    	out.println("<b><a href=\"login.html\" >Login again   </a> <br>");
	}
	else if (request.getParameter("error") != null && request.getParameter("error").equals("2")){
		out.println("<b>CREATE ORDER is available only for logged users</b><br>");
    	out.println("<b><a href=\"login.html\" >Login Here   </a> <br>");
	}	
	else{
		
	
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("password");
		
		if (userId == null || userId.equals("") || pwd == null || pwd.equals("")) {
			response.sendRedirect("login.jsp?error=1");
		} 
		else{
			session.setAttribute("userId", userId);
			session.setAttribute("loggedIn", "true");
			response.sendRedirect("index.jsp");
		}
	
	}
	    
    %>
</body>
</html>