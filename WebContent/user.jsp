<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new User</title>
</head>
<body>
 <form method="POST" action='UserController' name="frmAddUser">  
  
        User ID : <input type="text" readonly="readonly" name="userid"  
  
            value="<c:out value="${user.userid}" />" />   
  
  
        User Name : <input  
  
            type="text" name="username"  
  
            value="<c:out value="${user.username}" />" />   
  
  
       password : <input  
  
            type="text" name="password"  
  
            value="<c:out value="${user.password}" />" />   
  
    
 <input  
  
            type="submit" value="Submit" />  
  
    </form>  


</body>
</html>