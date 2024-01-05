<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1> Add User</h1><br><br><br>
<form action="adduser" method="POST">
    First Name: <input type="text" name="fname"><br>
    Last Name: <input type="text" name="lname"><br>
    Age: <input type="text" name="age"><br>
    Phone Number: <input type="text" name="phone"><br>
    <input type="submit" value="Add User">
</form>
</div>
</body>
</html>