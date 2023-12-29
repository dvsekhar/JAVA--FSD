<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Users List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Age</th><th>Phone Number</th><th>Edit</th></tr>  
   <c:forEach var="user" items="${userlist}">   
   <tr>  
   <td>${user.id}</td>  
   <td>${user.fname}</td>  
   <td>${user.lname}</td>  
   <td>${user.age}</td> 
    <td>${user.phone}</td> 
   <td><a href="edituser/${user.id}">Edit</a></td>
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
 
</body>
</html>