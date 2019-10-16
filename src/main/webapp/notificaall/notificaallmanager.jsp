<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.NotificaDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Notifica Manager(Admin)</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../functions/navbarall.jsp" %>

<div class="main">
	<%
		List<NotificaDTO> list = (List<NotificaDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Notifica Visualizzata</th>
			<th>Descrizione</th>
			<th>Evento</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (NotificaDTO u : list) {
		%>
		<tr>
			<td><a><%=u.getNotificato()%></a></td>
			<td><a><%=u.getNotifica_tempo()%></a></td>
			<td><a><%=u.getId_event() %></a></td>
			<td><a href=NotificaServlet?mode=read&update=true&type=all&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=NotificaServlet?mode=delete&type=all&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>

<form id="floatright" action="NotificaServlet?mode=insert&type=all" method="post">
	<div class="row">
		<div class="col-25">
		 <label for="notificato">Notifica Visualizzato</label>
		</div>
		<div class="col-75">
		 <input type="text" id="notificato" name="notificato" placeholder="Inserisci notificato">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
		 <label for="descrizione">Descrizione</label>
		</div>
		<div class="col-75">
		 <input type="text" id="descrizione" name="notifica_tempo" placeholder="Inserisci descrizione">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
		 <label for="id_event">Id evento</label>
		</div>
		<div class="col-75">
		 <input type="text" id="id_event" name="id" placeholder="Inserisci l'id dell'evento">
		</div>
	</div>
	<button type="submit">Insert</button>
</form>


</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>