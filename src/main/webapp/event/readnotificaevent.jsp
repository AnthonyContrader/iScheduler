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
			int id=Integer.parseInt(request.getParameter("id"));
			for(NotificaDTO n : list){	
		%>
		<tr>
			<td><a><%=n.getNotificato() %></a></td>
			<td><a><%=n.getNotifica_tempo() %></a></td>
			<td><a href=NotificaServlet?type=none&mode=read&update=true&id=<%=n.getId()%>>Edit</a></td>
			<td><a href="NotificaServlet?dest=receiver&type=none&mode=delete&id_e=<%=n.getId_event()%>&id=<%=n.getId()%>">Delete</a></td>
		</tr>
		<%} %>
	</table>

<form id="floatright" action="NotificaServlet?type=none&mode=insert&id=<%=id%>" method="post">
	<div class="row">
		<div class="col-25">
			<label for="notificato">Notifica Inviata</label>
		</div>
		<div class="col-75">
			<input type="text" id="notificato" name="notificato" placeholder="Inserisci notificato">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="descrizione">Description</label>
		</div>
		<div class="col-75">
			<input type="text" id="descrizione" name="notifica_tempo" placeholder="Inserisci descrizione">
		</div>
	</div>
	<button type="submit">Insert</button>
</form>	
</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>