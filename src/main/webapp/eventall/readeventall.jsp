<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EventDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Event</title>
</head>
<body>

<%@include file="../css/header.jsp" %>
<%@include file="../functions/navbarall.jsp" %>
<br>

<div class="main">

<%EventDTO e = (EventDTO) request.getAttribute("dto"); %>

	<table>
	
		<tr>
						<th>Nome</th>
						<th>Categoria</th>
						<th>Descrizione</th>
						<th>Posizione X</th>
						<th>Posizione Y</th>
						<th>Data</th>
		
		</tr>
							<tr><td> <%=e.getNome()%></td>
							<td><%=e.getCategoria()%></td>
							<td><%=e.getDescrizione()%></td>
							<td><%=e.getPosizioneX() %></td>
							<td><%=e.getPosizioneY() %></td>
							<td><%=e.getScadenza() %></td> </tr>
	
	</table>
</div>

<%@include file="../css/footer.jsp" %>

</body>
</html>