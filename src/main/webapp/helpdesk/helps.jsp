<%@ page import="it.contrader.dto.HelpDeskDTO" import="it.contrader.service.UserService" import="it.contrader.dto.UserDTO"  import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<style>
		table {
			border-collapse: collapse;
			float:none;
			margin-left:auto; 
			margin-right:auto;
			border-radius:4px;
		    -moz-border-radius:4px;
			}
</style>
<title>HelpDesk Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@include file="../functions/navbar.jsp" %>

<div class="main">
	<%
		List<HelpDeskDTO> list = (List<HelpDeskDTO>) request.getSession().getAttribute("list");
		UserService us = (UserService) request.getSession().getAttribute("service");
	%>
<br>
	<table>
		<tr>
			<th>Title Ticket</th>
			<th>Response</th>
			<th>Managed from</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for(HelpDeskDTO hd : list){
		%>
		<tr>
			<td><a href=/helpdesk/prereply?id=<%=hd.getId() %>><%=hd.getTitle() %></a></td>
			<td><%=hd.getReply() %></td>
			<td>
			<% 
			String show = "None";
			if(hd.getGestorDTO() != null){
				show = "Admin: "+us.read(hd.getGestorDTO()).getUsername();
			} 
			%>
			<%=show %>
			</td>
			<td>Edit</td>
			<td>Delete</td>
		</tr>
		<%
			}
		%>
	</table>


</div>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>