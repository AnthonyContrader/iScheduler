<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EventDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../functions/navbar.jsp" %>
<br>

<div class="main">
	<% EventDTO e = (EventDTO) request.getAttribute("dto"); %>
	
	<table>
		<tr>
			<th>Nome</th>
			<th>Descrizione</th>
			<th>Categoria</th>
			<th>Posizione</th>
			<th>Scadenza</th>
		</tr>
		<tr>
			<td><%=e.getNome() %></td>
			<td><%=e.getDescrizione() %></td>
			<td><%=e.getCategoria() %></td>
			<td><%=e.getPosizioneX()+","+e.getPosizioneY() %></td>
			<td><%=e.getScadenza() %></td>
		</tr>
	</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

</div>
<%@ include file="../css/footer.jsp" %>
</body>
</html>