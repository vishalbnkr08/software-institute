<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm | Jspider pune </title>
</head>
<style>
body{
 background: Lavender ;
}
.cpswd{
	background:White;
	margin: 200px 500px ;
	padding: 10px 20px ;
	width: 300px ;
	height: 130px ;
	box-shadow: 1px 1px 5px grey ;
	border-radius: 5px;
}
.cpswd form label{
	font-size: 18px ;
	font-family: sans-serif;
}
.cpswd form label span{
	color: Red ;
}
#input{
	
    width:100%;
    height: 5vh;
}
#confirm{
	align-content: center ;
	border-radius: 5px ;
	padding: 5px 20px ;
	font-size: 20px;
}
#confirm:hover {
	background: Orange ;
	color: white;
	transition: 0.5s;
}
</style>
<body>
	<div class="cpswd">
		<form action="confirmservlet" method="post">
		
		<label> <span><%=session.getAttribute("email")%></span> ,enter password for confirmation :</label> <br>
		<input type="password" name="confirm_pswd" id="input"> <br><br> 
		<input type="submit" id="confirm" value="Confirm">
	</form>
	</div>
</body>
</html>