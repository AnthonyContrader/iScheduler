<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
<link href="css/vittoriostyle.css" rel="stylesheet">

<title>iScheduler Login</title>
</head>
<body>
		<br>
		<br>
		<br>
		<br>
			<p style="text-align:center"><h1>LOGIN</h1></p>
		<%
			if(null!=request.getAttribute("error")){
				out.println("<p style='text-align:center;'><h1 style='color:red'>errore login riprova.</h1></p>");
			}
		%>
		<form class="login" action="LoginServlet" method="post">

				<label for="user">Username: </label>
			
				<input type="text" id="user" name="username" placeholder="Insert username">
		
				<label for="pass">Password: </label>
			
				 <input type="password" id="pass" name="password" placeholder="Insert password">
		
			<button type="submit" value="Login" name="pulsante">Login</button>
		</form>

	
</body>
</html>