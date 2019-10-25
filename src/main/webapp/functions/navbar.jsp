<%@ page import="it.contrader.dto.UserDTO" %>
<div class="navbar">
	<a href="/homeadmin.jsp">Home</a>
	<a href=/user/getall>Users</a> 
	<a href=/event/getall>Events</a>
	<a href=/helpdesk/getall>Help Desk</a>
	<a href="/user/logout" id="logout">Logout</a>
	<a id="logout">Admin: <%=((UserDTO) session.getAttribute("user")).getUsername()%></a>
	
</div>