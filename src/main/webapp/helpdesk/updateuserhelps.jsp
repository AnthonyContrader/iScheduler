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
		HelpDeskDTO hdDTO = (HelpDeskDTO) request.getSession().getAttribute("hdDTO");
	%>
	
	<table>
		<tr>
			<th>############ CHAT ###########</th>
		</tr>
		<%
		ArrayList<String> chat = hdDTO.getChatDTO();
		for(String mess : chat){
		%>
		<tr>
			<td><%=mess %></td>
		</tr>
		<%
		}
		%>
		
			
	</table>
	
	<form id="floatright" action="/helpdesk/replybyuser" method="post">
	<div class="col-25">
		 <label for="message">Description</label>
	</div>
	<div class="col-75">
		<textarea id="message" name="message">Insert problem description here ...</textarea>
	</div>
	<input type="hidden" name="id" value=<%=hdDTO.getId() %>>
	<input type="hidden" name="idGestor" value=<%=hdDTO.getGestorDTO() %>>
	<input type="hidden" name="title" value=<%=hdDTO.getTitle() %>>
	<button type="submit">Reply</button>
	</form>
<br>
</div>
</body>
</html>
