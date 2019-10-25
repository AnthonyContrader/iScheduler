	<%@ page import="it.contrader.dto.UserDTO" %>
	<div class="navbar">
		<a href="/homeuser.jsp">Home</a> 
		<a href=/event/getallbyid>Events</a>
		<a href="/history/listbyid">History List</a>
		<a href=/helpdesk/getallbyid>Help Desk</a>
		<a href="/user/logout" id="logout">Logout</a>
		<a id="logout">User: <%=((UserDTO) session.getAttribute("user")).getUsername()%></a>
		
	</div>