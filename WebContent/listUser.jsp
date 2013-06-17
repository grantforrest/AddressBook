<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show all users</title>
</head>
<body>
<table border=1>  
  
        <thead>  
  
            <tr>  
  
                <th>User name</th>  
  
                <th>Password</th>  
  
                <th colspan=2>Action</th>  
  
            </tr>  
  
        </thead>  
  
        <tbody>  
  
            <c:forEach items="${users}" var="user">  
  
                <tr>  
  
                    <td><c:out value="${user.username}" /></td>  
  
                    <td><c:out value="${user.password}" /></td>  
  
                  
                    <td><a href="UserController?action=edit&userId=<c:out value="${user.userid}"/>">Update</a></td>  
  
                    <td><a href="UserController?action=delete&userId=<c:out value="${user.userid}"/>">Delete</a></td>  
  
                </tr>  
  
            </c:forEach>  
  
        </tbody>  
  
    </table>  
  
    <p><a href="UserController?action=insert">Add User</a></p>  
</body>
</html>