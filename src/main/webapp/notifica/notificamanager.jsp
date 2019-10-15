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
		List<NotificaDTO> list = (List<NotificaDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>notificato</th>
			<th>notifica_tempo</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (NotificaDTO u : list) {
		%>
		<tr>
			<td><a href=NotificaServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getNotificato()%>
			</a></td>
			<td><%=u.getNotifica_tempo()%></td>
			<td><a href=NotificaServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=NotificaServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="NotificaServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">Notificato</label>
    </div>
    <div class="col-75">
      <input type="checkbox" name="notificatosi" value="True"> E' stata notificata<br>
      <input type="checkbox" name="notificatono" value="False"> Non è stata notificata<br>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Notifica_tempo</label>
    </div>
    <div class="col-75">
      <input type="text" id="Notifica_tempo" name="NotificaTempo" placeholder="inserisci descrizione"> 
    </div>
  </div>
  
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>