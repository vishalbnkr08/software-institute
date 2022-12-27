<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="reg.css">
<title>Edit Profile | Jspider pune </title>
</head>
<body>
<% ResultSet rs1 = (ResultSet) session.getAttribute("user") ;

%>
<% rs1.next() ;  %>


	 <center><h2><span>J</span>spiders </h2>
	<p>Training & Developement Center, Pune</p></center>
   <div class="reg">
    
	<form action="edituser" method="post">
		
	<label>Name :</label><br>
	<input type="text" name="name" id="input" value= "<%= rs1.getString(2)%>"> <br><br>
	
	<label>Email ID :</label> <br>
	<input type="email" name="email" id="input" value="<%= rs1.getString(3)  %>"> <br><br>
	
	
	<label>YOP :</label><br>
	<input type="text" name="yop" id="input" value="<%= rs1.getString(4) %>"> <br><br>
	
	<label>Stream :</label><br>
	<input type="text" name="stream" id="input" value="<%= rs1.getString(5) %>"> <br><br>
	
	<label>Password : </label><br>
	<input type="password" name="password" id="input" value= "<%= rs1.getString(6) %>"> <br><br>
	
	<input type="submit" value="Update" id="submit">
	
	</form> 
	
  </div>
</body>
</html>