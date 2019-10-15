<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.EventDTO" import="it.contrader.dto.NotificaDTO" %>
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
		List<NotificaDTO> list = (List<NotificaDTO>) request.getAttribute("list");
	%>
<br>
	<table>
		<tr>
			<th>Notifica Inviata</th>
			<th>Descrizione</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for(NotificaDTO n : list){	
		%>
		<tr>
			<td><a><%=n.getNotificato() %></a></td>
			<td><a><%=n.getNotifica_tempo() %></a></td>
			<td><a href=NotificaServlet?mode=read&update=true&id=<%=n.getId()%>>Edit</a></td>
			<td><a href=NotificaServlet?mode=delete&id=<%=n.getId() %>>Delete</a></td>
		</tr>
		<%} %>
	</table>	
</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>