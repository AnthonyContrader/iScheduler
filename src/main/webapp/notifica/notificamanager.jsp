<%@page import="it.contrader.dto.UserNotificationDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.NotificaDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Notifica Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../functions/navbar.jsp" %>

<div class="main">
	<%
		List<UserNotificationDTO> list = (List<UserNotificationDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Visualizza Notifica</th>
			<th>Descrizione</th>
			<th>Evento</th>
			<th></th>
		</tr>
		<%
			for (UserNotificationDTO u : list) {
		%>
		<tr>
			<td><a><%=u.isNotificato()%></a></td>
			<td><a><%=u.getNotifica_tempo()%></a></td>
			<td><a><%=u.getNome() %></a></td>
			<td><a href="NotificaServlet?type=none&dest=receiver&mode=deleteit&id=<%=u.getId()%>">Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>