<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page import="it.contrader.dto.EventDTO" import="it.contrader.dto.UserDTO" import="java.util.*" import="java.time.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Event Management">
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
<title>Event Manager</title>
		
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@include file="../functions/navbar.jsp" %>
	<%@	include file="../functions/Categories.html" %>
	
	
	<div class="main">
		<% 
		List<EventDTO> eventList = (List<EventDTO>) request.getSession().getAttribute("eventlist");
		List<UserDTO> userList = (List<UserDTO>) request.getSession().getAttribute("userlist");
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
			<th>User</th>
			<th></th>
			<th></th>
		</tr>
		
		<%
			for(EventDTO e : eventList){	
		%>
		<tr>
			<td><a href=/event/read?id=<%=e.getId()%>>
					<%=e.getName()%>		
			</a></td>
			<td><%=e.getDescription() %></td>
			<td><%=e.getCategory() %></td>
			<td><%=e.getStartDate().format((DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm"))) %></td>
			<td><%=e.getEndDate().format((DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm"))) %></td>
			<td><%=e.getArguments() %></td>
			<td><a href=/notification/read?id=<%=e.getId() %>><%=e.getUserDTO().getUsername() %></a>
			 <input type="checkbox" name="listusers" form="myform" value=<%=e.getId() %>>
			</td>
			<td><a href=#>Edit</a></td>
			<td><a href=#>Delete</a></td>
			
			
			
		</tr>
		
		<% } %>	
	</table>
	

	
	
	
	<form id="floatright" action="/event/insert" method="post">
	<div class="row">
		<div class="col-25">
		 <label for="name">Name</label>
		</div>
		<div class="col-75">
		 <input type="text" id="name" name="name" placeholder="Event name here !">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
		 <label for="description">Description</label>
		</div>
		<div class="col-75">
		 <input type="text" id="description" name="description" placeholder="Description here !">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
		 <label for="category">Category</label>
		</div>
		<div class="col-75">
		 <input list="category" name="category" placeholder="Category here !">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
		 <label for="arguments">Arguments</label>
		</div>
		<div class="col-75">
		 <input type="text" id="arguments" name="arguments">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
		 <label for="startDate">Start Date</label>
		</div>
		<div class="col-75">
		 <input type="datetime-local" id="startDate" name="startDate">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
		 <label for="endDate">End Date</label>
		</div>
		<div class="col-75">
		 <input type="datetime-local" id="endDate" name="endDate">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="userid">User</label>
		</div>
		<div class="col-75">
			<select id="userid" name="userid">
			<%
			for(UserDTO u: userList){ 
			%>
			<option value=<%=u.getId()%>><%=u.getUsername()%></option>
			<%	
			}
			%>
			</select>
		</div>
	</div>
	
	<button type="submit">Insert</button>
</form>

<form id="myform" style=float:left action=/notification/insert method="post">
		<div class="col-25">
		 <label for="description">Description</label>
		</div>
		<div class="col-75">
		 <input type="text" id="description" name="description" placeholder="Description here !">
		</div>
	
	<button type="submit">Send Notify</button>
	</form>	
	
	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>