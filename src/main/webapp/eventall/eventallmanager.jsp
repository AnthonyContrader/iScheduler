<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.EventDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>EVENT Manager</title>
</head>

<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../functions/navbarall.jsp" %>
<div class="main">
	
	<% List<EventDTO> list = (List<EventDTO>) request.getAttribute("list"); %>
	
		<br>
			<table>
					<tr>
						<th>Nome</th>
						<th>Categoria</th>
						<th>Descrizione</th>
						<th>Posizione X</th>
						<th>Posizione Y</th>
						<th>Data</th>
						</tr>
						<%for(EventDTO e : list){ %>
						<tr>
							<td><a href=EventServelet?type=all&mode=read&id=<%=e.getId()%>>
							<%=e.getNome()%></a></td>
							<td><%=e.getCategoria()%></td>
							<td><%=e.getDescrizione()%></td>
							<td><%=e.getPosizioneX() %></td>
							<td><%=e.getPosizioneY() %></td>
							<td><%=e.getScadenza() %></td>
							
							<td><a href=EventServlet?type=all&mode=read&update=true&id=<%=e.getId() %>>Modifica</a></td>
							<td><a href=EventServlet?type=all&mode=delete&id=<%=e.getId() %>>Elimina</a></td>
							</tr>
							<% } %>
					</table>

<form id="floatright" action="EventServlet?type=all&mode=insert" method="post">
	<div class="row">
		<div class="col-25">
			<label for="nome"> NOME</label>
		</div>
		<div class="col-75">
			<input type="text" id="nome" name="nome" placeholder="inserisci nome evento">
		</div>
		</div>
		
	<div class="row">
		<div class="col-25">
			<label for="categoria">CATEGORIA</label>
		</div>
		<div class="col-75">
			<input type="text" id="categoria" name="categoria" placeholder="Inserisci categoria evento">
		</div>
	</div>
	
	<div class="row">
		<div class="col-25">
			<label for="descrizione"> DESCRIZIONE</label>
		</div>
		<div class="col-75">
			<input type="text" id="descrizione" name="descrizione" placeholder="Inderisci descrizione evento">
		</div>
	</div>
	
	<div class="row">
		<div class="col-25">
			<label for="posizioneX"> Posizione X </label>
		</div>
		<div class="col-75">
			<input type="text" id="posizioneX" name="posizioneX" placeholder="Cordinata X">
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
		<button type="submit"> INSERISCI</button>
</form>
</div>
<%@ include file="../css/footer.jsp" %>
	</body>
	</html>