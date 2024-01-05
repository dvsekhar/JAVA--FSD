<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="updateuser" method="post">

<input type="hidden" name="id" value="${user.id}" />
        First Name:
        <input type="text" name="fname" value="${user.fname}" /><br/>
        
        Last Name:
        <input type="text" name="lname" value="${user.lname}" /><br/>
        
        Age:
        <input type="text" name="age" value="${user.age}" /><br/>
        
        Phone Number:
        <input type="text" name="phone" value="${user.phone}" /><br/>
        
        <input type="submit">
</form>

</body>
</html>