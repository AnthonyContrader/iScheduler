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
<div class="main">
	<% EventDTO e = (EventDTO) request.getAttribute("dto"); %>
	
	<form id="floatleft" action="EventServlet?mode=update&id=<%=e.getId()%>" method="post">
		<div class="row">
			<div class="col-25">
			 <label for="event">Event Name</label>
			</div>
			<div class="col-75">
			 <input type="text" id="event" name="name" value=<%=e.getNome()%>>
			</div>
		</div>
		<div class="row">	
			<div class="col-25">
     	 	 <label for="user">Category</label>
    		</div>
			<div class="col-75">
			 <input type="text" id="event" name="name" value=<%=e.getCategoria()%>>
			</div>
		</div>
		<div class="row">
			<div class="col-25">
     	 	 <label for="user">Descrption</label>
    		</div>
			<div class="col-75">
			 <input type="text" id="event" name="name" value=<%=e.getDescrizione()%>>
			</div>
		</div>
		<div class="row">
			<div class="col-25">
     	 	 <label for="user">Deadline</label>
    		</div>
			<div class="col-75">
			 <input type="text" id="event" name="name" value=<%=e.getScadenza()%>>
			</div>
		</div>
		<div class="row">
			<div class="col-25">
     	 	 <label for="user">Position X</label>
    		</div>
			<div class="col-75">
			 <input type="text" id="event" name="name" value=<%=e.getPosizioneX()%>>
			</div>
		</div>
		<div class="row">
			<div class="col-25">
     	 	 <label for="user">Position Y</label>
    		</div>
			<div class="col-75">
			 <input type="text" id="event" name="name" value=<%=e.getPosizioneY()%>>
			</div>
		</div>
		<button type="submit" >Edit</button>
	</form>
</div>
</body>
</html>