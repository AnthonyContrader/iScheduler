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
	<% EventDTO e = (EventDTO) request.getAttribute("dto"); %>
	
	<form id="floatleft" action="EventServlet?type=none&mode=update&id=<%=e.getId()%>" method="post">
		<div class="row">
			<div class="col-25">
			 <label for="event">Event Name</label>
			</div>
			<div class="col-75">
			 <input type="text" id="nome" name="nome" value=<%=e.getNome()%>>
			</div>
		</div>
		<div class="row">	
			<div class="col-25">
     	 	 <label for="category">Category</label>
    		</div>
			<div class="col-75">
			 <input list="category" name="categoria" value=<%=e.getCategoria()%>>
			</div>
		</div>
		<div class="row">
			<div class="col-25">
     	 	 <label for="description">Description</label>
    		</div>
			<div class="col-75">
			 <input type="text" id="descrizione" name="descrizione" value=<%=e.getDescrizione()%>>
			</div>
		</div>
		<div class="row">
			<div class="col-25">
     	 	 <label for="deadline">Deadline</label>
    		</div>
			<div class="col-75">
			 <input type="text" id="scadenza" name="scadenza" value=<%=e.getScadenza()%>>
			</div>
		</div>
		<div class="row">
			<div class="col-25">
     	 	 <label for="positionX">Position X</label>
    		</div>
			<div class="col-75">
			 <input type="text" id="positionX" name="posizioneX" value=<%=e.getPosizioneX()%>>
			</div>
		</div>
		<div class="row">
			<div class="col-25">
     	 	 <label for="posizioneY">Position Y</label>
    		</div>
			<div class="col-75">
			 <input type="text" id="positionY" name="posizioneY" value=<%=e.getPosizioneY()%>>
			 <input type="hidden" id="idUser" name="idUser" value=<%=e.getIdUser()%>>
			 
			</div>
		</div>
		<button type="submit" >Edit</button>
	</form>
</div>
</body>
</html>