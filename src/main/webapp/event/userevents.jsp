<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="it.contrader.dto.EventDTO"
	import="it.contrader.dto.UserDTO" import="java.util.*"
	import="java.time.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="with=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Event Management">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>User Events List</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../functions/navbaruser.jsp"%>
	<div class="main">
		<%
			List<EventDTO> usereventList = (List<EventDTO>) request.getSession().getAttribute("list");
		%>

		<br>
		<table>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Category</th>
				<th>StartDate</th>
				<th>EndDate</th>
				<th>Arguments</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (EventDTO e : usereventList) {
			%>
			<tr>
				<td><a href=/event/read?id= <%=e.getId()%>> <%=e.getName()%>
				</a></td>
				<td><%=e.getDescription()%></td>
				<td><%=e.getCategory()%></td>
				<td><%=e.getStartDate().format((DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm")))%></td>
				<td><%=e.getEndDate().format((DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm")))%></td>
				<td><%=e.getArguments()%></td>
				<td><a href=/notification/read?id=<%=e.getId() %>>View Not.</a></td>
			</tr>
			<%
				}
			%>

		</table>
	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>




















</div>
</body>
</html>