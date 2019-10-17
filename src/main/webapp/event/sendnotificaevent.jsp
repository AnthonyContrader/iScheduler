<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.EventDTO" import="it.contrader.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Event Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../functions/navbar.jsp" %>

<div class="main">
	<%
		List<UserDTO> list = (List<UserDTO>) request.getAttribute("list");
	
	%>
<br>
	<table>
		<tr>
			<th>Lista Utenti</th>
			<th></th>
		</tr>
		
		<%
			int id=Integer.parseInt(request.getParameter("id"));
			for(UserDTO n : list){	
		%>
		<tr>
			<td><a><%=n.getUsername() %></a></td>
			<td><a href="UserNotificationServlet?mode=insert&notifica=<%=id%>&user=<%=n.getId()%>">Send it</a></td>
		</tr>
		<%} %>
	</table>
</div>
</body>
</html>