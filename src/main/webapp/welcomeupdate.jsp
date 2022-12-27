<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="welcome.css">
<title>My Profile | Jspider pune </title>
</head>
<body>
<div class="nav">
	<div class="navleft">
		<span>J</span>spider
	</div>
	<div class="navright">
		<a href="Home.html" id="main">Home</a>
		<a href="confirmation.jsp" id="edit">Edit</a>
		<a href="./logoutservlet" id="logout" >Log Out</a>
	</div>
</div>
	
<div >
	<% session.removeAttribute("userdetails"); %>
	<% ResultSet rs = (ResultSet) session.getAttribute("update_data") ; %>
	<center><h2>Student Profile</h2>
	<table cellpadding="20px" >
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>YOP</th>
		<th>Stream</th>
		<th>Password</th> 
		
		<% while(rs.next()){ %>
		<tr align="center">
			<td> <%= rs.getInt(1) %> </td>
			<td> <%= rs.getString(2) %></td>
			<td> <%= rs.getString(3) %></td>
			<td> <%= rs.getString(4) %></td>
			<td> <%= rs.getString(5) %></td>
			<td> <%= rs.getString(6) %></td>
		</tr>
		<% } %>
	</table>
	</center>
</div>
</body>
</html>