<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page import="it.contrader.dto.EventDTO" import="it.contrader.dto.NotificationDTO" import="java.util.*" import="java.time.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Event Management">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Event Manager</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@include file="../functions/navbar.jsp" %>
	
	<div class="main">
		<%
			List<NotificationDTO> notificationList = (List<NotificationDTO>) request.getSession().getAttribute("notificationlist");
		%>
	</div>
	<br>
	
	<table>
	 <tr>
	 	<th>Event</th>
	 	<th>Description</th>
	 	<th>Start Date</th>
	 	<th>End Date</th>
	 </tr>
	 
	 <%
	 	for(NotificationDTO n: notificationList){
	 %>
	 	<tr>
	 		<td><%=n.getEventDTO().getName() %></td>
	 		<td><%=n.getDescription()%></td>
	 		<td><%=n.getEventDTO().getStartDate() %>
	 		<td><%=n.getEventDTO().getEndDate() %>
	 	</tr>
	 <%
	 	}
	 %>
	</table>
	
</body>
</html>