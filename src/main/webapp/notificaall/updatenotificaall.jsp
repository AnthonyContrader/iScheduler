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
<%@ include file="../functions/navbarall.jsp" %>

<div class="main">
	<%
		NotificaDTO n = (NotificaDTO) request.getAttribute("dto");
	%>
	
	<form id="floatleft" action="NotificaServlet?type=all&mode=update&id=<%=n.getId()%>" method="post">
		<div class="row">
			<div class="col-25">
			 <label for="notificato">Notifica inviata</label>
			</div>
			<div class="col-75">
			 <input type="text" id="notificato" name="notificato" value=<%=n.getNotificato()%>>
			</div>
		</div>
		<div class="row">
			<div class="col-25">
			 <label for="descrizione">Descrizione</label>
			</div>
			<div class="col-75">
			 <input type="text" id="notifica_tempo" name="notifica_tempo" value=<%=n.getNotifica_tempo()%>>
			 <input type="hidden" id="idEvent" name="id_event" value=<%=n.getId_event() %>>
			</div>
		</div>
		<button type="submit">Edit</button>
	</form>
</div>
</body>
</html>