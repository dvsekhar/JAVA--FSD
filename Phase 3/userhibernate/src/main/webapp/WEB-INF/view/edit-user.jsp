<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h1>Edit User</h1>
    <form action="updateuser" method="POST">
        <input type="hidden" name="id" value="${user.id}" />
        <label for="fname">First Name:</label>
        <input type="text" id="fname" name="fname" value="${user.fname}" /><br/>
        
        <label for="lname">Last Name:</label>
        <input type="text" id="lname" name="lname" value="${user.lname}" /><br/>
        
        <label for="lname">Age:</label>
        <input type="text" id="age" name="age" value="${user.age}" /><br/>
        
        <label for="lname">Phone Number:</label>
        <input type="text" id="phone" name="phone" value="${user.phone}" /><br/>
        
        
        <input type="submit" value="Update" />
    </form>
</body>
</html>