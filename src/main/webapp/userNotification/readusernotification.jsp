<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserNotificationDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>UserNotification List</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../functions/navbar.jsp" %>

<div class="main">
	<%
		List<UserNotificationDTO> list = (List<UserNotificationDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>id</th>
			<th>Id User</th>
			<th>Id Notification</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (UserNotificationDTO u : list) {
		%>
		<tr>
			<td><a href=UserNotificationServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getId()%>
			</a></td>
			<td><%=u.getIdUser()%></td>
			<td><%=u.getIdNotification()%></td>
			<td><a href=UserNotificationServlet?mode=usernotificationlist=true&id=<%=u.getId()%>>Edit</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>