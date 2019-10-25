<%@ page import="it.contrader.dto.HelpDeskDTO" import="it.contrader.service.UserService" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<style>
			
		textarea {
		  width: 100%;
		  height: 150px;
		  padding: 12px 20px;
		  box-sizing: border-box;
		  border: 2px solid #ccc;
		  border-radius: 4px;
		  background-color: #f8f8f8;
		  font-size: 16px;
		  resize: none;
		}
</style>
<title>HelpDesk Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@include file="../functions/navbaruser.jsp" %>


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
			<td><a href=/helpdesk/prereplybyuser?id=<%=hd.getId() %>><%=hd.getTitle() %></a></td>
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
	<form id="floatright" action="/helpdesk/insertbyuser" method="post">
	<div class="row">
		<div class="col-25">
		 <label for="name">Title</label>
		</div>
		<div class="col-75">
		 <input type="text" id="title" name="title" placeholder="Title here !">
		</div>
	</div>
	<div class="col-25">
		 <label for="message">Description</label>
	</div>
	<div class="col-75">
		<textarea id="message" name="message">Insert problem description here ...</textarea>
	</div>
	<button type="submit">Send Ticket</button>
	</form>
</div>
</body>

</html>