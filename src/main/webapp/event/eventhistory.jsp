<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page import="it.contrader.dto.EventHistoryDTO" import="java.util.*"%>
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
	<%@include file="../functions/navbaruser.jsp"%>
	<%@	include file="../functions/Categories.html"%>
	<div class="main">
		<%
			List<EventHistoryDTO> historyList = (List<EventHistoryDTO>) request.getSession().getAttribute("historylist");
		%>

		<br>

		<table>
			<tr>
				<th>Category</th>
				<th>Agent's name</th>
				<th>Agent's surname</th>
				<th>Company</th>
				<th>Results</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (EventHistoryDTO e : historyList) {
			%>
			<tr>
				<td><%=e.getCategory()%></td>
				<td><%=e.getAgentName()%></td>
				<td><%=e.getAgentSurname()%></td>
				<td><%=e.getCompany()%></td>
				<td><%=e.getResult()%></td>
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