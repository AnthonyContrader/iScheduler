<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.EventDTO"%>
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
<%@	include file="../functions/Categories.html" %>

<div class="main">

	<%
		List<EventDTO> list = (List<EventDTO>) request.getAttribute("list");
	%>

<br>
	<table>
		<tr>
			<th>Nome</th>
			<th>Descrizione</th>
			<th>Categoria</th>
			<th>Posizione</th>
			<th>Scadenza</th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<%
			for(EventDTO e : list){	
		%>
		<tr>
			<td><a href=EventServlet?type=none&mode=read&id=<%=e.getId()%>>
					<%=e.getNome()%>		
			</a></td>
			<td><%=e.getDescrizione() %></td>
			<td><%=e.getCategoria() %></td>
			<td><%=e.getPosizioneX()+","+e.getPosizioneY() %></td>
			<td><%=e.getScadenza()%></td>
			<td><a href=EventServlet?type=none&mode=read&update=true&id=<%=e.getId()%>>Edit</a></td>
			<td><a href=EventServlet?type=none&mode=delete&id=<%=e.getId() %>>Delete</a></td>
			<td><a href=EventServlet?type=none&mode=readevent&id=<%=e.getId() %>>View Not.</a></td>
		</tr>
		
		<% } %>
	</table>
<form id="floatright" action="EventServlet?type=none&mode=insert" method="post">
	<div class="row">
		<div class="col-25">
		 <label for="name">Name</label>
		</div>
		<div class="col-75">
		 <input type="text" id="name" name="nome" placeholder="Inserisci nome">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
		 <label for="descrizione">Description</label>
		</div>
		<div class="col-75">
		 <input type="text" id="descrizione" name="descrizione" placeholder="Inserisci descrizione">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
		 <label for="categoria">Category</label>
		</div>
		<div class="col-75">
		 <input list="category" name="categoria" placeholder="Inserisci categoria">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
		 <label for="posizioneX">Position X</label>
		</div>
		<div class="col-75">
		 <input type="text" id="positionX" name="posizioneX" placeholder="Cordinata X">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
		 <label for="posizioneY">Position Y</label>
		</div>
		<div class="col-75">
		 <input type="text" id="positionY" name="posizioneY" placeholder="Cordinata Y">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
		 <label for="scadenza">Deadline</label>
		</div>
		<div class="col-75">
		 <input type="date" id="scadenza" name="scadenza">
		</div>
	</div>
	<button type="submit">Insert</button>
</form>

</div>
<%@ include file="../css/footer.jsp" %>
</body>
</html>